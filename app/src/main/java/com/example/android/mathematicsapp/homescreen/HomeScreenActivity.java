package com.example.android.mathematicsapp.homescreen;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.challengemode.ChallengeActivity;
import com.example.android.mathematicsapp.snakegame.SnakeActivity;
import com.example.android.mathematicsapp.trainingmode.begin.TrainingModeBeginScreen;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeScreenActivity extends AppCompatActivity {

    // TODO Add explanation activities for every exercise.
    // TODO Add the remaining 7 to 10 exercises!
    // TODO Make advancements activity.
    // TODO Save exp after you did an exercise (+1 exp).
    // TODO Save score for challenge mode (+2 exp).
    // TODO Save cookies for cookie mode (+1 cookie).

    // TODO list Advancements
    // TODO When snake image clicked, you got the new achievement, "snake gamer (:".
    // TODO When exp reached 100, you got the achievement, "You reached 100 exp"
    // TODO When score reached 20 on challenge mode, "Challenger mode: 20 difficult question done!"
    // TODO When score reached 100 on challenge mode, "Challenger mode: 100 difficult question done!"
    // TODO When you have 100 cookies, "Cookie monster"

    private String _exp;
    private String _date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getApplicationContext().getResources().getColor(R.color.dark_bg));
        }

        changeText();
        buttonIntents();
    }

    /** most of the scores are set here */
    private void changeText() {
        _exp = getApplicationContext().getString(R.string.exp);
        TextView exp = (TextView) findViewById(R.id.exp);
        exp.setText(String.format(_exp, "1000"));

        // get and set the date for the text view, to display current date.
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String strDate= formatter.format(date);
        _date = getApplicationContext().getString(R.string.current_date);
        TextView dateTv = (TextView) findViewById(R.id.date);
        dateTv.setText(String.format(_date, strDate));
    }

    private void buttonIntents() {
        findViewById(R.id.training_mode_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreenActivity.this, TrainingModeBeginScreen.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.challenge_mode_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreenActivity.this, ChallengeActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.snake_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreenActivity.this, SnakeActivity.class);
                startActivity(intent);
            }
        });
    }
}