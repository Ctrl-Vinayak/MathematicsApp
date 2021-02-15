package com.example.android.mathematicsapp.trainingmode.exerciseTheory;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.trainingmode.begin.TrainingModeBeginScreen;
import com.example.android.mathematicsapp.trainingmode.levelSelectionExerciseNum.LevelSelectionExerciseEight;

public class TheoryEight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_eight);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }

        TextView actionBarTitle = (TextView) findViewById(R.id.action_bar_title_exercise_theory);
        actionBarTitle.setText(getApplicationContext().getString(R.string.associative_rule) + ", THEORY");

        String theoryString = "i: The associative rule in math says that in addition and multiplication problems, you can change the association, or grouping, of three or more numbers and not change the final result.\n\n" +
                "ii: The associative rule looks like the following:\n" +
                "a + (b + c) = (a + b) + c and a × (b × c) = (a × b) × c\n\n" +
                "iii: This rule is special to addition and multiplication. It doesn't work for subtraction or division.\n\n" +
                "iv: You've probably wondering why even use this rule? Because it can sometimes make the computation easier.\n\n" +
                "v: Instead of doing 5 + (-5 + 17), change it to [5 + (-5)] + 17 = 0 + 17 = 17.";
        TextView theory = (TextView) findViewById(R.id.theory);
        theory.setText(theoryString);

        String exampleString = "16 + (-16 + 47) = 47\n\n" +
                "(5 - 13) + 13 = 5\n\n" +
                "(110 × 8) × 1/8 = 110\n\n" +
                "18(1/18 * 7) = 7";
        TextView example = (TextView) findViewById(R.id.example);
        example.setText(exampleString);

        buttonIntents();
    }

    private void buttonIntents() {
        findViewById(R.id.theory_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TheoryEight.this, TrainingModeBeginScreen.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TheoryEight.this, LevelSelectionExerciseEight.class);
                startActivity(intent);
            }
        });
    }
}