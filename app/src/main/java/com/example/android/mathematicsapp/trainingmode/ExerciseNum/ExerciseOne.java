package com.example.android.mathematicsapp.trainingmode.ExerciseNum;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.trainingmode.LevelSelectionExerciseNum.LevelSelectionExerciseOne;

import java.text.DecimalFormat;

public class ExerciseOne extends AppCompatActivity {

    final int totalSec = 60;
    private LinearLayout[] _sixtyOfALine = new LinearLayout[totalSec];

    boolean isAbig;
    Thread thread;

    boolean isBackButtonPressed = false;
    boolean isWrongAnswered = false;

    int questionsDone = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_one);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }

        buttonIntents();

        final int levelNum = getIntent().getIntExtra("levelnum", 1);
        TextView actionbarTitle = findViewById(R.id.action_bar_title_exercise_one);
        actionbarTitle.setText(getApplicationContext().getString(R.string.assigning_numbers_their_places) + ". Level: " + levelNum + " / " + 100);

        //line code
        LinearLayout line = findViewById(R.id.exercise_one_line);
        line.setWeightSum(totalSec);

        for (int i = 0; i < totalSec; i++) {
            _sixtyOfALine[i] = new LinearLayout(this);
            _sixtyOfALine[i].setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1));
            _sixtyOfALine[i].setOrientation(LinearLayout.HORIZONTAL);
            _sixtyOfALine[i].setBackgroundColor(getApplicationContext().getResources().getColor(R.color.locked_button));
            line.addView(_sixtyOfALine[i]);
        }

        final TextView tvTime = findViewById(R.id.question);
        final TextView tvCurQuestion = findViewById(R.id.current_question);
        tvTime.setText(mathematicsQuestions(levelNum));
        tvCurQuestion.setText("Current Question: " + questionsDone + "/" + 10);
        final boolean[] isTimerDone = {false};
        final int[] stop = {0};

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            long startTime = System.currentTimeMillis();
            public void run() {

                Button butA = findViewById(R.id.button_A);
                butA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!isAbig) {
                            isWrongAnswered = true;
                            Intent intent = new Intent(ExerciseOne.this, LevelSelectionExerciseOne.class);
                            startActivity(intent);
                        } else {
                            questionsDone++;
                            tvCurQuestion.setText("Current Question: " + questionsDone + "/" + 10);
                            if (questionsDone == 10) {
                                Intent intent = new Intent(ExerciseOne.this, LevelSelectionExerciseOne.class);
                                startActivity(intent);
                            } else {
                                tvTime.setText(mathematicsQuestions(levelNum));
                            }
                        }
                        startTime = System.currentTimeMillis() - 1000;
                        for (int i = 0; i < totalSec; i++) {
                            _sixtyOfALine[i].setVisibility(View.VISIBLE);
                        }
                    }
                });

                Button butB = findViewById(R.id.button_B);
                butB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (isAbig) {
                            isWrongAnswered = true;
                            Intent intent = new Intent(ExerciseOne.this, LevelSelectionExerciseOne.class);
                            startActivity(intent);
                        } else {
                            questionsDone++;
                            tvCurQuestion.setText("Current Question: " + questionsDone + "/" + 10);
                            if (questionsDone == 10) {
                                Intent intent = new Intent(ExerciseOne.this, LevelSelectionExerciseOne.class);
                                startActivity(intent);
                            } else {
                                tvTime.setText(mathematicsQuestions(levelNum));
                            }
                        }
                        startTime = System.currentTimeMillis() - 1000;
                        for (int i = 0; i < totalSec; i++) {
                            _sixtyOfALine[i].setVisibility(View.VISIBLE);
                        }
                    }
                });

                while (!isTimerDone[0]) {
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable(){
                        public void run() {
                            if ((int) (totalSec - ((System.currentTimeMillis() - startTime) / 1000)) >= 1) {
                                _sixtyOfALine[(int) (totalSec - ((System.currentTimeMillis() - startTime) / 1000))].setVisibility(View.INVISIBLE);
                            } else {
                                isTimerDone[0] = true;
                                if (isTimerDone[0]) {
                                    if (stop[0] == 0 && isBackButtonPressed == false && isWrongAnswered == false) {
                                        Intent intent = new Intent(ExerciseOne.this, LevelSelectionExerciseOne.class);
                                        startActivity(intent);
                                        stop[0]++;
                                    }
                                }
                            }
                        }
                    });
                }
            }
        };
        thread = new Thread(runnable);
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    // --------------------------------------------------------- <MAKE MATHEMATICAL QUESTIONS! (BEGINS) -------------------------------------------------------
    
    private String mathematicsQuestions(int levelNum) {
        String question = "Which is larger, ";
        double num1, num2;
        double min, max;
        int numerator1, numerator2;
        int denominator1,  denominator2;
        int minNumerator, maxNumerator;

        if (levelNum >= 1 && levelNum < 20) {
            // phase 1 (natural numbers)

            min = levelNum;
            max = levelNum * 2 + 1;
            num1 = (int) (Math.random() * (max - min + 1) + min);
            num2 = (int) (Math.random() * (max - min + 1) + min);
            if (num1 == num2) {
                num1 = (int) (Math.random() * (max - min + 1) + min);
                num2 = (int) (Math.random() * (max - min + 1) + min);
                if (num1 == num2) {
                    num2 -= min;
                    num1 += 1;
                }
            }

            checkAnswer(num1, num2);

            DecimalFormat df = new DecimalFormat("###.#");
            question += ("A = " + df.format(num1) + " or B = " + df.format(num2));

        } else if (levelNum >= 20 && levelNum < 40) {
            // phase 2 (integers)

            int ranNegPosNum1 = (int) (Math.random() * 2 + 1);
            int ranNegPosNum2 = (int) (Math.random() * 2 + 1);
            if (ranNegPosNum1 == 2) { ranNegPosNum1 = -1; }
            if (ranNegPosNum2 == 2) { ranNegPosNum2 = -1; }

            min = levelNum;
            max = levelNum * 2 + 2;
            num1 = (int) ((Math.random() * (max - min + 1) + min) * ranNegPosNum1);
            num2 = (int) ((Math.random() * (max - min + 1) + min) * ranNegPosNum2);
            if (num1 == num2) {
                num1 = (int) ((Math.random() * (max - min + 1) + min) * ranNegPosNum1);
                num2 = (int) ((Math.random() * (max - min + 1) + min) * ranNegPosNum2);
                if (num1 == num2) {
                    num2 -= min;
                    num1 += 2;
                }
            }

            checkAnswer(num1, num2);

            DecimalFormat df = new DecimalFormat("###.#");
            question += ("A = " + df.format(num1) + " or B = " + df.format(num2));

        } else if (levelNum >= 40 && levelNum < 60) {
            // phase 3 (decimals)

            int ranNegPosNum1 = (int) (Math.random() * 2 + 1);
            int ranNegPosNum2 = (int) (Math.random() * 2 + 1);
            if (ranNegPosNum1 == 2) { ranNegPosNum1 = -1; }
            if (ranNegPosNum2 == 2) { ranNegPosNum2 = -1; }

            min = levelNum;
            max = levelNum * 2 + 2;
            num1 = (Math.random() * (max - min + 1) + min) * ranNegPosNum1;
            num2 = (Math.random() * (max - min + 1) + min) * ranNegPosNum2;

            if (num1 == num2) {
                num1 = (Math.random() * (max - min + 1) + min) * ranNegPosNum1;
                num2 = (Math.random() * (max - min + 1) + min) * ranNegPosNum2;
                if (num1 == num2) {
                    num2 -= min;
                    num1 += 5;
                }
            }

            checkAnswer(num1, num2);
            question += ("A = " + num1 + " or B = " + num2);

        } else if (levelNum >= 60 && levelNum < 80) {
            // phase 4 (fractions) e.g. 3 1/4 = 3.25

            minNumerator = levelNum - 59;
            maxNumerator = levelNum - 59 + 5;

            numerator1 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
            numerator2 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
            denominator1 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
            denominator2 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
            if (denominator1 == 0) { denominator1++; }
            if (denominator2 == 0) { denominator2++; }
            double fraction1 = (double) (numerator1 / denominator1);
            double fraction2 = (double) (numerator2 / denominator2);

            while (fraction1 == fraction2) {
                numerator1 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                numerator2 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                denominator1 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                denominator2 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                if (denominator1 == 0) { denominator1++; }
                if (denominator2 == 0) { denominator2++; }
                fraction1 = (double) (numerator1 / denominator1);
                fraction2 = (double) (numerator2 / denominator2);
            }

            checkAnswer(fraction1, fraction2);
            question += ("A = " + numerator1 + "/" + denominator1 + " or B = " + numerator2 + "/" + denominator2);

        } else if (levelNum >= 80 && levelNum < 100) {
            // phase 5 (mix of all 4 phases)

            int choosePhase = (int) (Math.random() * 4 + 1);
            System.out.println(choosePhase);

            if (choosePhase == 1) {
                // phase 1 (natural numbers)

                min = levelNum;
                max = levelNum * 5 + 1;
                num1 = (int) (Math.random() * (max - min + 1) + min);
                num2 = (int) (Math.random() * (max - min + 1) + min);
                if (num1 == num2) {
                    num1 = (int) (Math.random() * (max - min + 1) + min);
                    num2 = (int) (Math.random() * (max - min + 1) + min);
                    if (num1 == num2) {
                        num2 -= min;
                        num1 += 1;
                    }
                }

                checkAnswer(num1, num2);

                DecimalFormat df = new DecimalFormat("###.#");
                question += ("A = " + df.format(num1) + " or B = " + df.format(num2));

            } else if (choosePhase == 2) {
                // phase 2 (integers)

                int ranNegPosNum1 = (int) (Math.random() * 2 + 1);
                int ranNegPosNum2 = (int) (Math.random() * 2 + 1);
                if (ranNegPosNum1 == 2) { ranNegPosNum1 = -1; }
                if (ranNegPosNum2 == 2) { ranNegPosNum2 = -1; }

                min = levelNum;
                max = levelNum * 5 + 2;
                num1 = (int) ((Math.random() * (max - min + 1) + min) * ranNegPosNum1);
                num2 = (int) ((Math.random() * (max - min + 1) + min) * ranNegPosNum2);
                if (num1 == num2) {
                    num1 = (int) ((Math.random() * (max - min + 1) + min) * ranNegPosNum1);
                    num2 = (int) ((Math.random() * (max - min + 1) + min) * ranNegPosNum2);
                    if (num1 == num2) {
                        num2 -= min;
                        num1 += 2;
                    }
                }

                checkAnswer(num1, num2);

                DecimalFormat df = new DecimalFormat("###.#");
                question += ("A = " + df.format(num1) + " or B = " + df.format(num2));

            } else if (choosePhase == 3) {
                // phase 3 (decimals)

                int ranNegPosNum1 = (int) (Math.random() * 2 + 1);
                int ranNegPosNum2 = (int) (Math.random() * 2 + 1);
                if (ranNegPosNum1 == 2) { ranNegPosNum1 = -1; }
                if (ranNegPosNum2 == 2) { ranNegPosNum2 = -1; }

                min = levelNum;
                max = levelNum * 5 + 2;
                num1 = (Math.random() * (max - min + 1) + min) * ranNegPosNum1;
                num2 = (Math.random() * (max - min + 1) + min) * ranNegPosNum2;

                if (num1 == num2) {
                    num1 = (Math.random() * (max - min + 1) + min) * ranNegPosNum1;
                    num2 = (Math.random() * (max - min + 1) + min) * ranNegPosNum2;
                    if (num1 == num2) {
                        num2 -= min;
                        num1 += 5;
                    }
                }

                checkAnswer(num1, num2);
                question += ("A = " + num1 + " or B = " + num2);

            } else {
                // phase 4 (fractions)

                minNumerator = levelNum - 79;
                maxNumerator = levelNum - 79 + 10;

                numerator1 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                numerator2 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                denominator1 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                denominator2 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                if (denominator1 == 0) { denominator1++; }
                if (denominator2 == 0) { denominator2++; }
                double fraction1 = (double) (numerator1 / denominator1);
                double fraction2 = (double) (numerator2 / denominator2);

                while (fraction1 == fraction2) {
                    numerator1 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                    numerator2 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                    denominator1 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                    denominator2 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                    if (denominator1 == 0) { denominator1++; }
                    if (denominator2 == 0) { denominator2++; }
                    fraction1 = (double) (numerator1 / denominator1);
                    fraction2 = (double) (numerator2 / denominator2);
                }

                checkAnswer(fraction1, fraction2);
                question += ("A = " + numerator1 + "/" + denominator1 + " or B = " + numerator2 + "/" + denominator2);

            }

        } else if (levelNum == 100) {
            // phase 6 (final phase - all phases but on max difficulty)

            int choosePhase = (int) (Math.random() * 4 + 1);
            System.out.println(choosePhase);

            if (choosePhase == 1) {
                // phase 1 (natural numbers)

                min = levelNum;
                max = levelNum * 10 + 1;
                num1 = (int) (Math.random() * (max - min + 1) + min);
                num2 = (int) (Math.random() * (max - min + 1) + min);
                if (num1 == num2) {
                    num1 = (int) (Math.random() * (max - min + 1) + min);
                    num2 = (int) (Math.random() * (max - min + 1) + min);
                    if (num1 == num2) {
                        num2 -= min;
                        num1 += 1;
                    }
                }

                checkAnswer(num1, num2);

                DecimalFormat df = new DecimalFormat("###.#");
                question += ("A = " + df.format(num1) + " or B = " + df.format(num2));

            } else if (choosePhase == 2) {
                // phase 2 (integers)

                int ranNegPosNum1 = (int) (Math.random() * 2 + 1);
                int ranNegPosNum2 = (int) (Math.random() * 2 + 1);
                if (ranNegPosNum1 == 2) { ranNegPosNum1 = -1; }
                if (ranNegPosNum2 == 2) { ranNegPosNum2 = -1; }

                min = levelNum;
                max = levelNum * 10 + 2;
                num1 = (int) ((Math.random() * (max - min + 1) + min) * ranNegPosNum1);
                num2 = (int) ((Math.random() * (max - min + 1) + min) * ranNegPosNum2);
                if (num1 == num2) {
                    num1 = (int) ((Math.random() * (max - min + 1) + min) * ranNegPosNum1);
                    num2 = (int) ((Math.random() * (max - min + 1) + min) * ranNegPosNum2);
                    if (num1 == num2) {
                        num2 -= min;
                        num1 += 2;
                    }
                }

                checkAnswer(num1, num2);

                DecimalFormat df = new DecimalFormat("###.#");
                question += ("A = " + df.format(num1) + " or B = " + df.format(num2));

            } else if (choosePhase == 3) {
                // phase 3 (decimals)

                int ranNegPosNum1 = (int) (Math.random() * 2 + 1);
                int ranNegPosNum2 = (int) (Math.random() * 2 + 1);
                if (ranNegPosNum1 == 2) { ranNegPosNum1 = -1; }
                if (ranNegPosNum2 == 2) { ranNegPosNum2 = -1; }

                min = levelNum;
                max = levelNum * 10 + 2;
                num1 = (Math.random() * (max - min + 1) + min) * ranNegPosNum1;
                num2 = (Math.random() * (max - min + 1) + min) * ranNegPosNum2;

                if (num1 == num2) {
                    num1 = (Math.random() * (max - min + 1) + min) * ranNegPosNum1;
                    num2 = (Math.random() * (max - min + 1) + min) * ranNegPosNum2;
                    if (num1 == num2) {
                        num2 -= min;
                        num1 += 5;
                    }
                }

                checkAnswer(num1, num2);
                question += ("A = " + num1 + " or B = " + num2);

            } else {
                // phase 4 (fractions)

                minNumerator = levelNum - 99;
                maxNumerator = levelNum - 99 + 15;

                numerator1 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                numerator2 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                denominator1 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                denominator2 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                if (denominator1 == 0) { denominator1++; }
                if (denominator2 == 0) { denominator2++; }
                double fraction1 = (double) (numerator1 / denominator1);
                double fraction2 = (double) (numerator2 / denominator2);

                while (fraction1 == fraction2) {
                    numerator1 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                    numerator2 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                    denominator1 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                    denominator2 = (int) (Math.random() * (maxNumerator - minNumerator + 1) + minNumerator);
                    if (denominator1 == 0) { denominator1++; }
                    if (denominator2 == 0) { denominator2++; }
                    fraction1 = (double) (numerator1 / denominator1);
                    fraction2 = (double) (numerator2 / denominator2);
                }

                checkAnswer(fraction1, fraction2);
                question += ("A = " + numerator1 + "/" + denominator1 + " or B = " + numerator2 + "/" + denominator2);

            }
        }
        return question;
    }

    private boolean checkAnswer(double num1, double num2) {
        if (num1 > num2) {
            isAbig = true;
            return true;
        } else {
            isAbig = false;
            return false;
        }
    }
    
    // --------------------------------------------------------- <<MAKE MATHEMATICAL QUESTIONS! (ENDS) -------------------------------------------------------
    
    private void buttonIntents() {
        findViewById(R.id.exercise_one_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isBackButtonPressed = true;
                Intent intent = new Intent(ExerciseOne.this, LevelSelectionExerciseOne.class);
                startActivity(intent);
            }
        });
    }
}