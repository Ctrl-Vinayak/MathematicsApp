package com.example.android.mathematicsapp.trainingmode.exerciseTheory;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.trainingmode.begin.TrainingModeBeginScreen;
import com.example.android.mathematicsapp.trainingmode.levelSelectionExerciseNum.LevelSelectionExerciseSeven;

public class TheorySeven extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_seven);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }

        TextView actionBarTitle = (TextView) findViewById(R.id.action_bar_title_exercise_theory);
        actionBarTitle.setText(getApplicationContext().getString(R.string.distributive_property) + ", THEORY");

        String theoryString = "i: The distributive property is used to perfrom an operation on each of the terms within a grouping symbol.\n\n" +
                "ii: The following rules show distributing multiplication over addition and distributing multiplication over substraction:\n" +
                "a(b + c) = a × b + a × c and a(b - c) = a × b - a × c";
        TextView theory = (TextView) findViewById(R.id.theory);
        theory.setText(theoryString);

        String exampleString = "4(7 + 2) = 4*7 + 4*2 = 36\n\n" +
                "-1(5 - -3) = (-1)5 - (-1)(-3) = -8\n\n" +
                "8(1 - 2) = 8*1 - 8*2 = -8\n\n" +
                "3(5 + 2) = 3*5 + 3*2 = 21";
        TextView example = (TextView) findViewById(R.id.example);
        example.setText(exampleString);

        buttonIntents();
    }

    private void buttonIntents() {
        findViewById(R.id.theory_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TheorySeven.this, TrainingModeBeginScreen.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TheorySeven.this, LevelSelectionExerciseSeven.class);
                startActivity(intent);
            }
        });
    }
}