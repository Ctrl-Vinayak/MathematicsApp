package com.example.android.mathematicsapp.trainingmode.exerciseTheory;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.trainingmode.begin.TrainingModeBeginScreen;
import com.example.android.mathematicsapp.trainingmode.levelSelectionExerciseNum.LevelSelectionExerciseFive;

public class TheoryFive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_five);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }

        TextView actionBarTitle = (TextView) findViewById(R.id.action_bar_title_exercise_theory);
        actionBarTitle.setText(getApplicationContext().getString(R.string.multiplying_signed_numbers) + ", THEORY");

        String theoryString = "i: When you multiply two or more numbers, you just multiply them without worrying about the sign of the answer until the end\n" +
                "Then to assign the sign, just count the number of negative signs in the problem.\n" +
                "If the number of negative sign is an even number, the answer is positive. If the number of negative signs is odd, the answer is negative.\n\n" +
                "ii: The product of two signed numbers:\n" +
                "(+)(+) = + and (-)(-) = +\n" +
                "(+)(-) = - and (-)(+) = -\n\n" +
                "iii: The product of more than two signed numbers:\n" +
                "(+)(+)(+)(-)(-)(-)(-) has a positive answer because there are an even number of negative factors.\n\n" +
                "iv: (+)(+)(+)(-)(-)(-) has a negative answer because there are an odd number of negative factors.";
        TextView theory = (TextView) findViewById(R.id.theory);
        theory.setText(theoryString);

        String exampleString = "(-6)(3) = -18\n\n" +
                "(14)(-1) = -14\n\n" +
                "(-6)(-3) = 18\n\n" +
                "(15)(2) = 30";
        TextView example = (TextView) findViewById(R.id.example);
        example.setText(exampleString);

        buttonIntents();
    }

    private void buttonIntents() {
        findViewById(R.id.theory_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TheoryFive.this, TrainingModeBeginScreen.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TheoryFive.this, LevelSelectionExerciseFive.class);
                startActivity(intent);
            }
        });
    }
}