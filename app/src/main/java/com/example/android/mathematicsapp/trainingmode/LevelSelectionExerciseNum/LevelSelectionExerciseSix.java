package com.example.android.mathematicsapp.trainingmode.LevelSelectionExerciseNum;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.trainingmode.ExerciseNum.ExerciseSix;
import com.example.android.mathematicsapp.trainingmode.begin.TrainingModeBeginScreen;

public class LevelSelectionExerciseSix extends AppCompatActivity {

    private LinearLayout _linearLayout;
    private LinearLayout _rowOfLevels[] = new LinearLayout[34];
    private Button _buttonLevel[] = new Button[100];
    private LinearLayout.LayoutParams[] _buttonParams = new LinearLayout.LayoutParams[4];
    private ImageView _backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection_exercise_six);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("SharedPrefKey", Context.MODE_PRIVATE);

        _linearLayout = findViewById(R.id.level_selection_exercise_one_contents);
        _linearLayout.setWeightSum(34);

        for (int i = 0; i < 33; i++) {
            _rowOfLevels[i] = new LinearLayout(this);
            _rowOfLevels[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
            _rowOfLevels[i].setWeightSum(3);
            _rowOfLevels[i].setOrientation(LinearLayout.HORIZONTAL);

            _linearLayout.addView(_rowOfLevels[i]);

            _buttonLevel[(i * 3)] = new Button(this);
            _buttonLevel[(i * 3) + 1] = new Button(this);
            _buttonLevel[(i * 3) + 2] = new Button(this);

            _buttonParams[0] = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
            _buttonParams[1] = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
            _buttonParams[2] = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
            _buttonParams[3] = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);

            if (i == 0) {
                _buttonParams[0].setMargins(60, 40, 30, 20);
                _buttonParams[1].setMargins(30, 40, 30, 20);
                _buttonParams[2].setMargins(30, 40, 60, 20);
            } else {
                _buttonParams[0].setMargins(60, 20, 30, 10);
                _buttonParams[1].setMargins(30, 20, 30, 10);
                _buttonParams[2].setMargins(30, 20, 60, 10);
            }

            _buttonLevel[(i * 3)].setLayoutParams(_buttonParams[0]);
            _buttonLevel[(i * 3) + 1].setLayoutParams(_buttonParams[1]);
            _buttonLevel[(i * 3) + 2].setLayoutParams(_buttonParams[2]);

            _buttonLevel[(i * 3)].setText("" + ((i * 3) + 1));
            _buttonLevel[(i * 3) + 1].setText("" + ((i * 3) + 2));
            _buttonLevel[(i * 3) + 2].setText("" + ((i * 3) + 3));
            _buttonLevel[(i * 3)].setTextSize(25);
            _buttonLevel[(i * 3) + 1].setTextSize(25);
            _buttonLevel[(i * 3) + 2].setTextSize(25);

            _buttonLevel[(i * 3)].setBackgroundColor(getApplicationContext().getResources().getColor(R.color.locked_button));
            _buttonLevel[(i * 3) + 1].setBackgroundColor(getApplicationContext().getResources().getColor(R.color.neon_orange));
            _buttonLevel[(i * 3) + 2].setBackgroundColor(getApplicationContext().getResources().getColor(R.color.locked_button));

            _rowOfLevels[i].addView(_buttonLevel[(i * 3)]);
            _rowOfLevels[i].addView(_buttonLevel[(i * 3) + 1]);
            _rowOfLevels[i].addView(_buttonLevel[(i * 3) + 2]);

            final int finalI = i;
            _buttonLevel[(i * 3)].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(LevelSelectionExerciseSix.this, ExerciseSix.class);
                    intent.putExtra("levelnum", (finalI * 3) + 1);
                    startActivity(intent);
                }
            });
            _buttonLevel[(i * 3) + 1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(LevelSelectionExerciseSix.this, ExerciseSix.class);
                    intent.putExtra("levelnum", (finalI * 3) + 2);
                    startActivity(intent);
                }
            });
            _buttonLevel[(i * 3) + 2].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(LevelSelectionExerciseSix.this, ExerciseSix.class);
                    intent.putExtra("levelnum", (finalI * 3) + 3);
                    startActivity(intent);
                }
            });
        }
        _rowOfLevels[33] = new LinearLayout(this);
        _rowOfLevels[33].setWeightSum(1);
        _rowOfLevels[33].setOrientation(LinearLayout.HORIZONTAL);
        _linearLayout.addView(_rowOfLevels[33]);

        _buttonLevel[99] = new Button(this);
        _buttonParams[3].setMargins(60, 20, 60, 40);
        _buttonLevel[99].setLayoutParams(_buttonParams[3]);
        _buttonLevel[99].setText("100");
        _buttonLevel[99].setTextSize(25);
        _buttonLevel[99].setBackgroundColor(getApplicationContext().getResources().getColor(R.color.neon_orange));
        _rowOfLevels[33].addView(_buttonLevel[99]);
        _buttonLevel[99].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelSelectionExerciseSix.this, ExerciseSix.class);
                intent.putExtra("levelnum", 100);
                startActivity(intent);
            }
        });

        // back button
        _backButton = findViewById(R.id.level_selection_exercise_one_back_button);
        _backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelSelectionExerciseSix.this, TrainingModeBeginScreen.class);
                startActivity(intent);
            }
        });
    }
}