package com.example.android.mathematicsapp.cookiemode;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.homescreen.HomeScreenActivity;

public class CookieActivity extends AppCompatActivity {

    boolean isBackButtonPressed = false;
    String answer = "";
    String userInput = "";
    int questionsDone = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookie_mode);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }

        buttonIntents();

        final int levelNum = 200;
        final TextView actionbarTitle = findViewById(R.id.action_bar_title_exercise_one);
        actionbarTitle.setText(getApplicationContext().getString(R.string.cookie_mode));

        final RelativeLayout butOne = findViewById(R.id.one);
        final RelativeLayout butTwo = findViewById(R.id.two);
        final RelativeLayout butThree = findViewById(R.id.three);
        final RelativeLayout butFour = findViewById(R.id.four);
        final RelativeLayout butFive = findViewById(R.id.five);
        final RelativeLayout butSix = findViewById(R.id.six);
        final RelativeLayout butSeven = findViewById(R.id.seven);
        final RelativeLayout butEight = findViewById(R.id.eight);
        final RelativeLayout butNine = findViewById(R.id.nine);
        final RelativeLayout butZero = findViewById(R.id.zero);
        final RelativeLayout butMinus = findViewById(R.id.minus);
        final RelativeLayout butBackspace = findViewById(R.id.backspace);

        final TextView tvTime = (TextView) findViewById(R.id.question);
        tvTime.setText(mathematicsQuestions(levelNum));

        butOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput += "1";
                tvTime.setText(tvTime.getText() + "1");
                if (userInput.equals(answer)) {
                    questionsDone++;
                    actionbarTitle.setText(getApplicationContext().getString(R.string.cookie_mode) + ". questions done: " + questionsDone);
                    if (questionsDone == 10) {
                        Intent intent = new Intent(CookieActivity.this, HomeScreenActivity.class);
                        startActivity(intent);
                    } else {
                        tvTime.setText(mathematicsQuestions(levelNum));
                        userInput = "";
                    }
                }
            }
        });

        butTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput += "2";
                tvTime.setText(tvTime.getText() + "2");
                if (userInput.equals(answer)) {
                    questionsDone++;
                    actionbarTitle.setText(getApplicationContext().getString(R.string.cookie_mode) + ". questions done: " + questionsDone);
                    if (questionsDone == 10) {
                        Intent intent = new Intent(CookieActivity.this, HomeScreenActivity.class);
                        startActivity(intent);
                    } else {
                        tvTime.setText(mathematicsQuestions(levelNum));
                        userInput = "";
                    }
                }
            }
        });

        butThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput += "3";
                tvTime.setText(tvTime.getText() + "3");
                if (userInput.equals(answer)) {
                    questionsDone++;
                    actionbarTitle.setText(getApplicationContext().getString(R.string.cookie_mode) + ". questions done: " + questionsDone);
                    if (questionsDone == 10) {
                        Intent intent = new Intent(CookieActivity.this, HomeScreenActivity.class);
                        startActivity(intent);
                    } else {
                        tvTime.setText(mathematicsQuestions(levelNum));
                        userInput = "";
                    }
                }
            }
        });

        butFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput += "4";
                tvTime.setText(tvTime.getText() + "4");
                if (userInput.equals(answer)) {
                    questionsDone++;
                    actionbarTitle.setText(getApplicationContext().getString(R.string.cookie_mode) + ". questions done: " + questionsDone);
                    if (questionsDone == 10) {
                        Intent intent = new Intent(CookieActivity.this, HomeScreenActivity.class);
                        startActivity(intent);
                    } else {
                        tvTime.setText(mathematicsQuestions(levelNum));
                        userInput = "";
                    }
                }
            }
        });

        butFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput += "5";
                tvTime.setText(tvTime.getText() + "5");
                if (userInput.equals(answer)) {
                    questionsDone++;
                    actionbarTitle.setText(getApplicationContext().getString(R.string.cookie_mode) + ". questions done: " + questionsDone);
                    if (questionsDone == 10) {
                        Intent intent = new Intent(CookieActivity.this, HomeScreenActivity.class);
                        startActivity(intent);
                    } else {
                        tvTime.setText(mathematicsQuestions(levelNum));
                        userInput = "";
                    }
                }
            }
        });

        butSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput += "6";
                tvTime.setText(tvTime.getText() + "6");
                if (userInput.equals(answer)) {
                    questionsDone++;
                    actionbarTitle.setText(getApplicationContext().getString(R.string.cookie_mode) + ". questions done: " + questionsDone);
                    if (questionsDone == 10) {
                        Intent intent = new Intent(CookieActivity.this, HomeScreenActivity.class);
                        startActivity(intent);
                    } else {
                        tvTime.setText(mathematicsQuestions(levelNum));
                        userInput = "";
                    }
                }
            }
        });

        butSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput += "7";
                tvTime.setText(tvTime.getText() + "7");
                if (userInput.equals(answer)) {
                    questionsDone++;
                    actionbarTitle.setText(getApplicationContext().getString(R.string.cookie_mode) + ". questions done: " + questionsDone);
                    if (questionsDone == 10) {
                        Intent intent = new Intent(CookieActivity.this, HomeScreenActivity.class);
                        startActivity(intent);
                    } else {
                        tvTime.setText(mathematicsQuestions(levelNum));
                        userInput = "";
                    }
                }
            }
        });

        butEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput += "8";
                tvTime.setText(tvTime.getText() + "8");
                if (userInput.equals(answer)) {
                    questionsDone++;
                    actionbarTitle.setText(getApplicationContext().getString(R.string.cookie_mode) + ". questions done: " + questionsDone);
                    if (questionsDone == 10) {
                        Intent intent = new Intent(CookieActivity.this, HomeScreenActivity.class);
                        startActivity(intent);
                    } else {
                        tvTime.setText(mathematicsQuestions(levelNum));
                        userInput = "";
                    }
                }
            }
        });

        butNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput += "9";
                tvTime.setText(tvTime.getText() + "9");
                if (userInput.equals(answer)) {
                    questionsDone++;
                    actionbarTitle.setText(getApplicationContext().getString(R.string.cookie_mode) + ". questions done: " + questionsDone);
                    if (questionsDone == 10) {
                        Intent intent = new Intent(CookieActivity.this, HomeScreenActivity.class);
                        startActivity(intent);
                    } else {
                        tvTime.setText(mathematicsQuestions(levelNum));
                        userInput = "";
                    }
                }
            }
        });

        butZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput += "0";
                tvTime.setText(tvTime.getText() + "0");
                if (userInput.equals(answer)) {
                    questionsDone++;
                    actionbarTitle.setText(getApplicationContext().getString(R.string.cookie_mode) + ". questions done: " + questionsDone);
                    if (questionsDone == 10) {
                        Intent intent = new Intent(CookieActivity.this, HomeScreenActivity.class);
                        startActivity(intent);
                    } else {
                        tvTime.setText(mathematicsQuestions(levelNum));
                        userInput = "";
                    }
                }
            }
        });

        butMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput += "-";
                tvTime.setText(tvTime.getText() + "-");
                if (userInput.equals(answer)) {
                    questionsDone++;
                    actionbarTitle.setText(getApplicationContext().getString(R.string.cookie_mode) + ". questions done: " + questionsDone);
                    if (questionsDone == 10) {
                        Intent intent = new Intent(CookieActivity.this, HomeScreenActivity.class);
                        startActivity(intent);
                    } else {
                        tvTime.setText(mathematicsQuestions(levelNum));
                        userInput = "";
                    }
                }
            }
        });

        butBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userInput.length() > 0) {
                    userInput = userInput.substring(0, userInput.length() - 1);
                    tvTime.setText(tvTime.getText().toString().substring(0, tvTime.getText().length() - 1));
                }
            }
        });
    }

    // --------------------------------------------------------- <MAKE MATHEMATICAL QUESTIONS! (BEGINS) -------------------------------------------------------

    private String mathematicsQuestions(int levelNum) {

        int questionType = (int) (Math.random() * (6 - 1) + 2);
        String question = "";

        if (questionType == 2) {
            int num;
            double min, max;

            if (levelNum >= 1 && levelNum <= 1000) {
                // phase 2 (integers)

                min = levelNum;
                max = levelNum * 5 + 15;
                num = (int) (Math.random() * (max - min + 1) + min);

                int ranNegPosNum1 = (int) (Math.random() * 2 + 1);
                int ranNegPosNum2 = (int) (Math.random() * 2 + 1);

                String neg1, neg2;
                if (ranNegPosNum1 == 2) { neg1 = "-"; } else { neg1 = ""; }
                if (ranNegPosNum2 == 2) { neg2 = "-"; } else { neg2 = ""; }

                // check answer begin part
                Math.abs(num);
                if (ranNegPosNum1 == 2) { num *= -1; }
                answer = "" + num;
                // check answer end part

                question = neg1 + "|" + neg2 + num + "| = ";
            }
        } else if (questionType == 3) {
            int num1, num2;
            double min, max;

            if (levelNum >= 1 && levelNum <= 1000) {

                min = levelNum;
                max = levelNum * 2 + 2;
                num1 = (int) (Math.random() * (max - min + 1) + min);
                num2 = (int) (Math.random() * (max - min + 1) + min);

                int ranNegPosNum1 = (int) (Math.random() * 2 + 1);
                int ranNegPosNum2 = (int) (Math.random() * 2 + 1);
                if (ranNegPosNum1 == 2) { ranNegPosNum1 = -1; num1 *= ranNegPosNum1; }
                if (ranNegPosNum2 == 2) { ranNegPosNum2 = -1; num2 *= ranNegPosNum2; }

                // check answer begin part
                answer = "" + (num1 + num2);
                // check answer end part

                String part1, part2;

                if (ranNegPosNum1 == -1) {
                    part1 = "(" + num1 + ")";
                } else {
                    part1 = "" + num1;
                }

                if (ranNegPosNum2 == -1) {
                    part2 = "(" + num2 + ")";
                } else {
                    part2 = "" + num2;
                }

                question = part1 + " + " + part2 + " = ";
            }
        } else if (questionType == 4) {
            int num1, num2;
            double min, max;

            if (levelNum >= 1 && levelNum <= 1000) {

                min = levelNum;
                max = levelNum * 2 + 2;
                num1 = (int) (Math.random() * (max - min + 1) + min);
                num2 = (int) (Math.random() * (max - min + 1) + min);

                int ranNegPosNum1 = (int) (Math.random() * 2 + 1);
                int ranNegPosNum2 = (int) (Math.random() * 2 + 1);
                if (ranNegPosNum1 == 2) { ranNegPosNum1 = -1; num1 *= ranNegPosNum1; }
                if (ranNegPosNum2 == 2) { ranNegPosNum2 = -1; num2 *= ranNegPosNum2; }

                // check answer begin part
                answer = "" + (num1 - num2);
                // check answer end part

                String part1, part2;

                if (ranNegPosNum1 == -1) {
                    part1 = "(" + num1 + ")";
                } else {
                    part1 = "" + num1;
                }

                if (ranNegPosNum2 == -1) {
                    part2 = "(" + num2 + ")";
                } else {
                    part2 = "" + num2;
                }

                question = part1 + " - " + part2 + " = ";
            }
        } else if (questionType == 5) {
            int num1, num2;
            double min, max;

            if (levelNum >= 1 && levelNum <= 1000) {

                min = levelNum;
                max = levelNum * 2 + 2;
                num1 = (int) (Math.random() * (max - min + 1) + min);
                num2 = (int) (Math.random() * (max - min + 1) + min);

                int ranNegPosNum1 = (int) (Math.random() * 2 + 1);
                int ranNegPosNum2 = (int) (Math.random() * 2 + 1);
                if (ranNegPosNum1 == 2) { ranNegPosNum1 = -1; num1 *= ranNegPosNum1; }
                if (ranNegPosNum2 == 2) { ranNegPosNum2 = -1; num2 *= ranNegPosNum2; }

                // check answer begin part
                answer = "" + (num1 * num2);
                // check answer end part

                String part1, part2;

                part1 = "(" + num1 + ")";
                part2 = "(" + num2 + ")";
                question = part1 + part2 + " = ";
            }
        } else if (questionType == 6) {
            int num1, num2;
            double min, max;

            if (levelNum >= 1 && levelNum <= 1000) {

                min = levelNum;
                max = levelNum * 2 + 2;
                num1 = (int) (Math.random() * (max - min + 1) + min);
                num2 = (int) (Math.random() * (max - min + 1) + min);

                int ranNegPosNum1 = (int) (Math.random() * 2 + 1);
                int ranNegPosNum2 = (int) (Math.random() * 2 + 1);
                if (ranNegPosNum1 == 2) { ranNegPosNum1 = -1; num1 *= ranNegPosNum1; }
                if (ranNegPosNum2 == 2) { ranNegPosNum2 = -1; num2 *= ranNegPosNum2; }

                // check answer begin part
                answer = "" + num1;
                // check answer end part

                String part1, part2;

                part1 = "(" + (num1 * num2) + ")";
                part2 = "(" + num2 + ")";
                question = part1 + " / " + part2 + " = ";
            }
        }
        System.out.println("question Type: " + questionType);
        System.out.println("question: " + question);
        System.out.println("answer: " + answer);
        return question;
    }

    // --------------------------------------------------------- <<MAKE MATHEMATICAL QUESTIONS! (ENDS) -------------------------------------------------------

    private void buttonIntents() {
        findViewById(R.id.exercise_one_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isBackButtonPressed = true;
                Intent intent = new Intent(CookieActivity.this, HomeScreenActivity.class);
                startActivity(intent);
            }
        });
    }
}