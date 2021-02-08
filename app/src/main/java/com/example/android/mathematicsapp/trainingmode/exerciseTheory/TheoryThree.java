package com.example.android.mathematicsapp.trainingmode.exerciseTheory;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.trainingmode.begin.TrainingModeBeginScreen;
import com.example.android.mathematicsapp.trainingmode.levelSelectionExerciseNum.LevelSelectionExerciseThree;

public class TheoryThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_three);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }

        TextView actionBarTitle = (TextView) findViewById(R.id.action_bar_title_exercise_theory);
        actionBarTitle.setText(getApplicationContext().getString(R.string.added_signed_numbers) + ", THEORY");

        String theoryString = "i: The absolute value of a number, written as |a|, is an operation that evaluates whatever is between the vertical bars and then outputs a positive number.\n\n" +
                "ii: Another way of looking at this operation is that it can tell you how far a number is from 0 on the number line, with no reference to which side.\n\n" +
                "iii: The absolute value of a: |a| = a, if a is a positive number (a > 0) or if a = 0.\n\n" +
                "iv: The absolute value of a: |a| = -a, if a is a negative number (a < 0). Read this as \"The absolute value of a is equal to the opposite of a.\"";
        TextView theory = (TextView) findViewById(R.id.theory);
        theory.setText(theoryString);

        String exampleString = "|8| = 8\n\n" +
                "|-3| = 3\n\n" +
                "-|25| = -25\n\n" +
                "-|-32| = -32";
        TextView example = (TextView) findViewById(R.id.example);
        example.setText(exampleString);

        buttonIntents();
    }

    private void buttonIntents() {
        findViewById(R.id.theory_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TheoryThree.this, TrainingModeBeginScreen.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TheoryThree.this, LevelSelectionExerciseThree.class);
                startActivity(intent);
            }
        });
    }
}