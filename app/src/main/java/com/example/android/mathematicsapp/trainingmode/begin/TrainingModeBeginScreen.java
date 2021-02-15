package com.example.android.mathematicsapp.trainingmode.begin;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.homescreen.HomeScreenActivity;
import com.example.android.mathematicsapp.trainingmode.exerciseTheory.TheoryEight;
import com.example.android.mathematicsapp.trainingmode.exerciseTheory.TheoryFive;
import com.example.android.mathematicsapp.trainingmode.exerciseTheory.TheoryFour;
import com.example.android.mathematicsapp.trainingmode.exerciseTheory.TheoryNine;
import com.example.android.mathematicsapp.trainingmode.exerciseTheory.TheoryOne;
import com.example.android.mathematicsapp.trainingmode.exerciseTheory.TheorySeven;
import com.example.android.mathematicsapp.trainingmode.exerciseTheory.TheorySix;
import com.example.android.mathematicsapp.trainingmode.exerciseTheory.TheoryThree;
import com.example.android.mathematicsapp.trainingmode.exerciseTheory.TheoryTwo;

public class TrainingModeBeginScreen extends AppCompatActivity {

    // TODO add a few extra exercises in this app!
    // TODO this is for the presentation, so I can talk more about my app (:

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
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, TheoryFive.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, TheorySix.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, TheorySeven.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, TheoryEight.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingModeBeginScreen.this, TheoryNine.class);
                startActivity(intent);
            }
        });
    }
}