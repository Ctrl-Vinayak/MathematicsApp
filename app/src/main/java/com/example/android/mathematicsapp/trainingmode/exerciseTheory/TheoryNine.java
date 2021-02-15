package com.example.android.mathematicsapp.trainingmode.exerciseTheory;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.trainingmode.begin.TrainingModeBeginScreen;
import com.example.android.mathematicsapp.trainingmode.levelSelectionExerciseNum.LevelSelectionExerciseNine;

public class TheoryNine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_nine);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }

        TextView actionBarTitle = (TextView) findViewById(R.id.action_bar_title_exercise_theory);
        actionBarTitle.setText(getApplicationContext().getString(R.string.solve_basic_equations) + ", THEORY");

        String theoryString = "i: Example: x - 2 = 4.\n\n" +
                "ii: When we put 6 in place of x we get:\n" +
                "6 - 2 = 4. Which is true.\n\n" +
                "iii: How about other values for x?\n" +
                "For x = 5 we get \"5 - 2 = 4\" which is not true, so x = 5 is not a solution.\n" +
                "For x = 9 we get \"9 - 2 = 4\" which is not true, so x = 9 is not a solution.";
        TextView theory = (TextView) findViewById(R.id.theory);
        theory.setText(theoryString);

        String exampleString = "2x = 14. x = 7\n\n" +
                "15 - x = 2x + 3. x = 4\n\n" +
                "5x + 3 = 53. x = 10\n\n" +
                "15 = -15x. x = -1";
        TextView example = (TextView) findViewById(R.id.example);
        example.setText(exampleString);

        buttonIntents();
    }

    private void buttonIntents() {
        findViewById(R.id.theory_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TheoryNine.this, TrainingModeBeginScreen.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TheoryNine.this, LevelSelectionExerciseNine.class);
                startActivity(intent);
            }
        });
    }
}