package com.example.android.mathematicsapp.homescreen;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;

public class HomeScreenActivity extends AppCompatActivity {

    private String _exp;
    private String _dayStreak;
    private String _somethingOfGoalAchieved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        _exp = getApplicationContext().getString(R.string.exp);
        TextView exp = (TextView) findViewById(R.id.exp);
        exp.setText(String.format(_exp, "1000"));

        _dayStreak = getApplicationContext().getString(R.string.day_streak);
        TextView dayStreak = (TextView) findViewById(R.id.day_streak);
        dayStreak.setText(String.format(_dayStreak, "14"));

        _somethingOfGoalAchieved = getApplicationContext().getString(R.string.x_of_200);
        TextView somethingOfGoalAchieved = (TextView) findViewById(R.id.something_of_goal_achieved);
        somethingOfGoalAchieved.setText(String.format(_somethingOfGoalAchieved, "513"));
    }
}
