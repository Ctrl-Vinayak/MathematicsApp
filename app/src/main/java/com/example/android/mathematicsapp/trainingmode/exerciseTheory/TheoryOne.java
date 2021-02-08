package com.example.android.mathematicsapp.trainingmode.exerciseTheory;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.homescreen.HomeScreenActivity;
import com.example.android.mathematicsapp.trainingmode.begin.TrainingModeBeginScreen;
import com.example.android.mathematicsapp.trainingmode.levelSelectionExerciseNum.LevelSelectionExerciseOne;

public class TheoryOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_one);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }

        TextView actionBarTitle = (TextView) findViewById(R.id.action_bar_title_exercise_theory);
        actionBarTitle.setText(getApplicationContext().getString(R.string.assigning_numbers_their_places) + ", THEORY");

        String theoryString = "i: Find each number's position on the number line.\n\n" +
                "ii: The number line goes from negatives on the left to positives on the right.\n\n" +
                "iii: Whichever number is farther to the right has the greater value, meaning it's bigger or larger.";
        TextView theory = (TextView) findViewById(R.id.theory);
        theory.setText(theoryString);

        String exampleString = "Which is larger, 1 or 4? answer is 4.\n\n" +
                "Which is larger, -9 or -6? answer is -6.\n\n" +
                "Which is larger, -0.003 or -0.1? answer is -0.003.\n\n" +
                "Which is larger, -1/6 or -2/3? answer is -1/6.";
        TextView example = (TextView) findViewById(R.id.example);
        example.setText(exampleString);

        buttonIntents();
    }

    private void buttonIntents() {
        findViewById(R.id.theory_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TheoryOne.this, TrainingModeBeginScreen.class);
                startActivity(intent);
            }
        });

        /** TODO new intents... from training mode begin screen it will go to exercise theory screen */

        findViewById(R.id.ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TheoryOne.this, LevelSelectionExerciseOne.class);
                startActivity(intent);
            }
        });
    }
}