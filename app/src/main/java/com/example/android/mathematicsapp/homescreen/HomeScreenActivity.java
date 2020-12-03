package com.example.android.mathematicsapp.homescreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.settings.SettingsActivity;
import com.example.android.mathematicsapp.settings.theme.ThemeActivity;

public class HomeScreenActivity extends AppCompatActivity {

    private String _exp;
    private String _dayStreak;
    private String _somethingOfGoalAchieved;
    private String _cash;
    private String _date;

    private RelativeLayout _homeScreenActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        changeText();
        buttonIntents();

//        ThemeActivity themeActivity = new ThemeActivity();
//        themeActivity.loadData();
//        _homeScreenActionBar = (RelativeLayout) findViewById(R.id.home_screen_action_bar);
//        _homeScreenActionBar.setBackgroundColor(themeActivity.getNonBackgroundColor());
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

        _date = getApplicationContext().getString(R.string.current_date);
        TextView date = (TextView) findViewById(R.id.date);
        date.setText(String.format(_date, "12-05-2020"));
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
