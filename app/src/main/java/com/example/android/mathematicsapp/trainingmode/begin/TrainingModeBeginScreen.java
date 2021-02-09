package com.example.android.mathematicsapp.trainingmode.begin;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.homescreen.HomeScreenActivity;
import com.example.android.mathematicsapp.trainingmode.exerciseTheory.TheoryFour;
import com.example.android.mathematicsapp.trainingmode.exerciseTheory.TheoryOne;
import com.example.android.mathematicsapp.trainingmode.exerciseTheory.TheoryThree;
import com.example.android.mathematicsapp.trainingmode.exerciseTheory.TheoryTwo;
import com.example.android.mathematicsapp.trainingmode.levelSelectionExerciseNum.LevelSelectionExerciseFour;

public class TrainingModeBeginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_mode_begin_screen);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }

        buttonIntents();
    }

    private void buttonIntents() {
        findViewById(R.id.training_mode_back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, HomeScreenActivity.class);
                startActivity(intent);
            }
        });

        /** TODO new intents... from training mode begin screen it will go to exercise theory screen */

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, TheoryOne.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, TheoryTwo.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, TheoryThree.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, TheoryFour.class);
                startActivity(intent);
            }
        });
//        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(TrainingModeBeginScreen.this, LevelSelectionExerciseFive.class);
//                startActivity(intent);
//            }
//        });
//        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(TrainingModeBeginScreen.this, LevelSelectionExerciseSix.class);
//                startActivity(intent);
//            }
//        });
    }
}