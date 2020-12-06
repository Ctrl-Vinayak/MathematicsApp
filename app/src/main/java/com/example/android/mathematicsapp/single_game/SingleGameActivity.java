package com.example.android.mathematicsapp.single_game;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.homescreen.HomeScreenActivity;

public class SingleGameActivity extends AppCompatActivity {

    private RelativeLayout _singleGameActionBar;
    private LinearLayout _singleGameBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_game);
        applyTheme();
        changeText();
        buttonIntents();
    }

    private void applyTheme() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("SharedPrefKey", Context.MODE_PRIVATE);
        _singleGameActionBar = (RelativeLayout) findViewById(R.id.single_game_action_bar);
        _singleGameBackground = (LinearLayout) findViewById(R.id.single_game_background);
        _singleGameActionBar.setBackgroundColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));
        _singleGameBackground.setBackgroundColor(prefs.getInt("currentBgKey", getApplicationContext().getResources().getColor(R.color.light_bg)));
    }

    private void changeText() {

    }

    private void buttonIntents() {
        findViewById(R.id.single_game_back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingleGameActivity.this, HomeScreenActivity.class);
                startActivity(intent);
            }
        });
    }
}
