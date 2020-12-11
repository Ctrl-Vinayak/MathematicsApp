package com.example.android.mathematicsapp.training_mode;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;

public class TrainingModeActivity extends AppCompatActivity {

    private RelativeLayout _settingsScreenActionBar;
    private LinearLayout _settingsScreenBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_mode);
        applyTheme();
        buttonIntents();
    }

    private void applyTheme() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("SharedPrefKey", Context.MODE_PRIVATE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(prefs.getInt("currentBgKey", getApplicationContext().getResources().getColor(R.color.light_bg)));
        }
    }

    private void buttonIntents() {

    }
}
