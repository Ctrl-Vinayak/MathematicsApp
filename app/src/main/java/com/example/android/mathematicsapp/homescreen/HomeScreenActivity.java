package com.example.android.mathematicsapp.homescreen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.settings.SettingsActivity;
import com.example.android.mathematicsapp.settings.theme.ThemeActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeScreenActivity extends AppCompatActivity {

    private String _exp;
    private String _dayStreak;
    private String _somethingOfGoalAchieved;
    private String _cash;
    private String _date;

    private RelativeLayout _homeScreenActionBar;
    private LinearLayout _homeScreenBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        changeText();
        buttonIntents();

        SharedPreferences prefs = getApplicationContext().getSharedPreferences("SharedPrefKey", Context.MODE_PRIVATE);
        _homeScreenActionBar = (RelativeLayout) findViewById(R.id.home_screen_action_bar);
        _homeScreenBackground = (LinearLayout) findViewById(R.id.home_screen_bg);
        _homeScreenActionBar.setBackgroundColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.light_bg)));
        _homeScreenBackground.setBackgroundColor(prefs.getInt("currentBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));
    }

    private void changeText() {
        _exp = getApplicationContext().getString(R.string.exp);
        TextView exp = (TextView) findViewById(R.id.exp);
        exp.setText(String.format(_exp, "1000"));

        _dayStreak = getApplicationContext().getString(R.string.day_streak);
        TextView dayStreak = (TextView) findViewById(R.id.day_streak);
        dayStreak.setText(String.format(_dayStreak, "14"));

        _somethingOfGoalAchieved = getApplicationContext().getString(R.string.x_of_200);
        TextView somethingOfGoalAchieved = (TextView) findViewById(R.id.something_of_goal_achieved);
        somethingOfGoalAchieved.setText(String.format(_somethingOfGoalAchieved, "513"));

        _cash = getApplicationContext().getString(R.string.cash);
        TextView cash = (TextView) findViewById(R.id.cash_num);
        cash.setText(String.format(_cash, "5513"));

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String strDate= formatter.format(date);
        _date = getApplicationContext().getString(R.string.current_date);
        TextView dateTv = (TextView) findViewById(R.id.date);
        dateTv.setText(String.format(_date, strDate));
    }

    private void buttonIntents() {
        findViewById(R.id.settings_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreenActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}
