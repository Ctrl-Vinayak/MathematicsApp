package com.example.android.mathematicsapp.settings.theme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.settings.SettingsActivity;

public class ThemeActivity extends AppCompatActivity {

    // Colors for the theme of the mathematics main app.
    private int _lightBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        initColor();

        findViewById(R.id.theme_back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThemeActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initColor() {
        _lightBg = getApplicationContext().getResources().getColor(R.color.light_bg);
    }

//    public void saveDate() {
//        SharedPreferences prefs = getApplicationContext().getSharedPreferences("SharedPrefKey", Context.MODE_PRIVATE);
//    }

    public int getData() {
        return _lightBg;
    }
}
