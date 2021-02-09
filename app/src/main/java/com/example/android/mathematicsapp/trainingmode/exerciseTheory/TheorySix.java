package com.example.android.mathematicsapp.trainingmode.exerciseTheory;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.trainingmode.begin.TrainingModeBeginScreen;
import com.example.android.mathematicsapp.trainingmode.levelSelectionExerciseNum.LevelSelectionExerciseSix;

public class TheorySix extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_six);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }

        TextView actionBarTitle = (TextView) findViewById(R.id.action_bar_title_exercise_theory);
        actionBarTitle.setText(getApplicationContext().getString(R.string.dividing_signed_numbers) + ", THEORY");

        String theoryString = "i: The rules for dividing signed numbers are exactly the same as those for multiplying signed numbers, as far as the sign goes.\n" +
                "The rules do differ, though, because you have to divide, of course.\n\n" +
                "ii: When you divide signed numbers, just count the number of negative signs in the porblem, in the numerator, in the denominator, and perhaps in front of the problem\n\n" +
                "iii: If you have an even number of negative signs, the answer is positive. If you have an odd number of negative signs, the answer is negative.";
        TextView theory = (TextView) findViewById(R.id.theory);
        theory.setText(theoryString);

        String exampleString = "-22/-11 = 2\n\n" +
                "24/-3 = -8\n\n" +
                "-12/-2 = 6\n\n" +
                "-1000/1000 = -1";
        TextView example = (TextView) findViewById(R.id.example);
        example.setText(exampleString);

        buttonIntents();
    }

    private void buttonIntents() {
        findViewById(R.id.theory_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TheorySix.this, TrainingModeBeginScreen.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TheorySix.this, LevelSelectionExerciseSix.class);
                startActivity(intent);
            }
        });
    }
}