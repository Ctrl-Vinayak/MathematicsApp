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
import com.example.android.mathematicsapp.settings.SettingsActivity;
import com.example.android.mathematicsapp.settings.theme.ThemeActivity;

public class SingleGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_game);
        backBtn();

//        SharedPreferences prefs = getApplicationContext().getSharedPreferences("SharedPrefKey", Context.MODE_PRIVATE);
//        _homeScreenActionBar = (RelativeLayout) findViewById(R.id.home_screen_action_bar);
//        _homeScreenBackground = (LinearLayout) findViewById(R.id.home_screen_bg);
//        _homeScreenActionBar.setBackgroundColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.light_bg)));
//        _homeScreenBackground.setBackgroundColor(prefs.getInt("currentBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));
    }

    private void backBtn() {
        findViewById(R.id.single_game_back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingleGameActivity.this, HomeScreenActivity.class);
                startActivity(intent);
            }
        });
    }
}
