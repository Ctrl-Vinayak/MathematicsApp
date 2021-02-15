package com.example.android.mathematicsapp.cookiemode;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
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

        SharedPreferences cookiePref = this.getSharedPreferences("cookieMode", Context.MODE_PRIVATE);
        int totalCookies = cookiePref.getInt("totalCookies", 0);

        buttonIntents();

        final int levelNum = 200;
        final TextView actionbarTitle = findViewById(R.id.action_bar_title_exercise_one);
        actionbarTitle.setText(getApplicationContext().getString(R.string.cookie_mode) + ", Total Cookies: " + totalCookies);

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
                    tvTime.setText(mathematicsQuestions(levelNum));
                    userInput = "";
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
                    tvTime.setText(mathematicsQuestions(levelNum));
                    userInput = "";
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
                    tvTime.setText(mathematicsQuestions(levelNum));
                    userInput = "";
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
                    tvTime.setText(mathematicsQuestions(levelNum));
                    userInput = "";
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
                    tvTime.setText(mathematicsQuestions(levelNum));
                    userInput = "";
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
                    tvTime.setText(mathematicsQuestions(levelNum));
                    userInput = "";
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
                    tvTime.setText(mathematicsQuestions(levelNum));
                    userInput = "";
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
                    tvTime.setText(mathematicsQuestions(levelNum));
                    userInput = "";
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
                    tvTime.setText(mathematicsQuestions(levelNum));
                    userInput = "";
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
                    tvTime.setText(mathematicsQuestions(levelNum));
                    userInput = "";
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
                    tvTime.setText(mathematicsQuestions(levelNum));
                    userInput = "";
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

        int questionType = (int) (Math.random() * (9 - 1) + 2);
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
        } else if (questionType == 7) {
            int num1, num2, num3;
            double min, max;

            if (levelNum >= 1 && levelNum <= 1000) {

                min = levelNum;
                max = levelNum * 2 + 2;
                num1 = (int) (Math.random() * (max - min + 1) + min);
                num2 = (int) (Math.random() * (max - min + 1) + min);
                num3 = (int) (Math.random() * (max - min + 1) + min);

                int ranNegPosNum1 = (int) (Math.random() * 2 + 1);
                int ranNegPosNum2 = (int) (Math.random() * 2 + 1);
                int ranNegPosNum3 = (int) (Math.random() * 2 + 1);
                if (ranNegPosNum1 == 2) { ranNegPosNum1 = -1; num1 *= ranNegPosNum1; }
                if (ranNegPosNum2 == 2) { ranNegPosNum2 = -1; num2 *= ranNegPosNum2; }
                if (ranNegPosNum3 == 2) { ranNegPosNum3 = -1; num3 *= ranNegPosNum3; }

                int ranPlusOrMinus = (int) (Math.random() * 2 + 1);

                // check answer begin part
                if (ranPlusOrMinus == 2) {
                    answer = "" + ((num1 * num2) + (num1 * num3));
                } else if (ranPlusOrMinus == 1) {
                    answer = "" + ((num1 * num2) - (num1 * num3));
                }
                // check answer end part

                if (ranPlusOrMinus == 2) {
                    question = num1 + "(" + num2 + " + " + num3 + ")" + " = ";
                } else if (ranPlusOrMinus == 1){
                    question = num1 + "(" + num2 + " - " + num3 + ")" + " = ";
                }
            }
        } else if (questionType == 8) {
            int num1, num2;
            double min, max;

            if (levelNum >= 1 && levelNum <= 1000) {

                min = levelNum;
                max = levelNum * 2 + 2;
                num1 = (int) (Math.random() * (max - min + 1) + min);
                num2 = (int) (Math.random() * (max - min + 1) + min);

                int ranBracketsPlacement = (int) (Math.random() * 4 + 1);

                // check answer begin part
                if (ranBracketsPlacement == 1) {
                    answer = "" + (num2);
                } else if (ranBracketsPlacement == 2) {
                    answer = "" + (num1);
                } else if (ranBracketsPlacement == 3) {
                    answer = "" + (num2);
                } else if (ranBracketsPlacement == 4) {
                    answer = "" + (num2);
                }
                // check answer end part

                if (ranBracketsPlacement == 1) {
                    question = num1 + "(1/" + num1 + " * " + num2 + ")" + " = ";
                } else if (ranBracketsPlacement == 2){
                    question = "(1/" + num2 + " * " + num1 + ")" + num2 + " = ";
                } else if (ranBracketsPlacement == 3) {
                    question = num1 + "(" + num2 + " * " + "1/" + num1 + ")" + " = ";
                } else if (ranBracketsPlacement == 4) {
                    question = "(1/" + num1 + " * " + num2 + ")" + num1 + " = ";
                }
            }
        } else if (questionType == 9) {
            int num1;
            double min, max;

            if (levelNum >= 1 && levelNum <= 1000) {
                min = levelNum;
                max = levelNum * 2 + 2;
                num1 = (int) (Math.random() * (max - min + 1) + min);

                int defaultAnswer = (int) (Math.random() * (max - min + 1) + min);
                int ranNegPosNum1 = (int) (Math.random() * 2 + 1);
                if (ranNegPosNum1 == 2) { ranNegPosNum1 = -1; num1 *= ranNegPosNum1; }

                // check answer begin part
                answer = "" + (defaultAnswer);
                // check answer end part

                question = num1 + "x" + " = " + (defaultAnswer * num1) + "x" + ". x = ";
            }
        }
        System.out.println("question Type: " + questionType);
        System.out.println("question: " + question);
        System.out.println("answer: " + answer);
        return question;
    }

    // --------------------------------------------------------- <<MAKE MATHEMATICAL QUESTIONS! (ENDS) -------------------------------------------------------

    private void saveDate() {
        SharedPreferences cookiePref = this.getSharedPreferences("cookieMode", Context.MODE_PRIVATE);
        cookiePref.edit().putInt("totalCookies", questionsDone + cookiePref.getInt("totalCookies", 0)).apply();
    }

    private void buttonIntents() {
        findViewById(R.id.exercise_one_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isBackButtonPressed = true;
                saveDate();
                Intent intent = new Intent(CookieActivity.this, HomeScreenActivity.class);
                startActivity(intent);
            }
        });
    }
}