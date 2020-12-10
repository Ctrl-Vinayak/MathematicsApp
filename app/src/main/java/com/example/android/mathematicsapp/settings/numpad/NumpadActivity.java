package com.example.android.mathematicsapp.settings.numpad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.homescreen.HomeScreenActivity;
import com.example.android.mathematicsapp.settings.SettingsActivity;
import com.example.android.mathematicsapp.single_game.SingleGameActivity;

public class NumpadActivity extends AppCompatActivity {

    private RelativeLayout _numpadActionBar;
    private LinearLayout _numpadBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numpad);
        applyTheme();
        buttonIntents();
    }

    private void applyTheme() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("SharedPrefKey", Context.MODE_PRIVATE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(prefs.getInt("currentBgKey", getApplicationContext().getResources().getColor(R.color.light_bg)));
        }

        _numpadActionBar = (RelativeLayout) findViewById(R.id.numpad_action_bar);
        _numpadBackground = (LinearLayout) findViewById(R.id.numpad_background);
        _numpadActionBar.setBackgroundColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));
        _numpadBackground.setBackgroundColor(prefs.getInt("currentBgKey", getApplicationContext().getResources().getColor(R.color.light_bg)));
    }

    private void buttonIntents() {
        findViewById(R.id.numpad_back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NumpadActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}
