package com.example.android.mathematicsapp.joint_game;

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

public class JointGameActivity extends AppCompatActivity {

    private RelativeLayout _jointGameActionBar;
    private LinearLayout _jointGameBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joint_game);
        applyTheme();
        buttonIntents();
    }

    private void applyTheme() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("SharedPrefKey", Context.MODE_PRIVATE);
        _jointGameActionBar = (RelativeLayout) findViewById(R.id.joint_game_action_bar);
        _jointGameBackground = (LinearLayout) findViewById(R.id.joint_game_background);
        _jointGameActionBar.setBackgroundColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));
        _jointGameBackground.setBackgroundColor(prefs.getInt("currentBgKey", getApplicationContext().getResources().getColor(R.color.light_bg)));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(prefs.getInt("currentBgKey", getApplicationContext().getResources().getColor(R.color.light_bg)));
        }
    }

    private void buttonIntents() {
        findViewById(R.id.joint_game_back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JointGameActivity.this, HomeScreenActivity.class);
                startActivity(intent);
            }
        });
    }
}
