package com.example.android.mathematicsapp.trainingmode.exerciseTheory;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.trainingmode.begin.TrainingModeBeginScreen;
import com.example.android.mathematicsapp.trainingmode.levelSelectionExerciseNum.LevelSelectionExerciseFour;

public class TheoryFour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_four);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }

        TextView actionBarTitle = (TextView) findViewById(R.id.action_bar_title_exercise_theory);
        actionBarTitle.setText(getApplicationContext().getString(R.string.making_a_difference_with_signed_numbers) + ", THEORY");

        String theoryString = "i: You just change the subtraction problem to an addition problem and use the rules for addition of signed numbers.\n\n" +
                "ii: To ensure that the answer to this new addition problem is the answer to the original subtraction problem, you change the operation from subtraction to addition, and you change the sign of the second number, the one that's being subtracted.\n\n" +
                "iii: To subtract two signed numbers:\n" +
                "a - (+b) = a + (-b) and a - (-b) = a + (+b)";
        TextView theory = (TextView) findViewById(R.id.theory);
        theory.setText(theoryString);

        String exampleString = "5 - (-2) = -7\n\n" +
                "-6 - (-8) = 2\n\n" +
                "4 - 87 = -83\n\n" +
                "0 - (-15) = 15";
        TextView example = (TextView) findViewById(R.id.example);
        example.setText(exampleString);

        buttonIntents();
    }

    private void buttonIntents() {
        findViewById(R.id.theory_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TheoryFour.this, TrainingModeBeginScreen.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TheoryFour.this, LevelSelectionExerciseFour.class);
                startActivity(intent);
            }
        });
    }
}