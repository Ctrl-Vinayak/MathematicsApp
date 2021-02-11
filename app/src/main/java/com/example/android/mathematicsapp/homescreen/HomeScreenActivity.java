package com.example.android.mathematicsapp.homescreen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.challengemode.ChallengeActivity;
import com.example.android.mathematicsapp.cookiemode.CookieActivity;
import com.example.android.mathematicsapp.snakegame.SnakeActivity;
import com.example.android.mathematicsapp.trainingmode.begin.TrainingModeBeginScreen;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeScreenActivity extends AppCompatActivity {

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

        SharedPreferences cookiePref = this.getSharedPreferences("cookieMode", Context.MODE_PRIVATE);
        int totalCookies = cookiePref.getInt("totalCookies", 0);
        ImageView snakeGame = (ImageView) findViewById(R.id.snake_image);
        snakeGame.setVisibility(View.INVISIBLE);
        if (totalCookies >= 200) {
            snakeGame.setVisibility(View.VISIBLE);
        }
    }

    private void changeText() {

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
        findViewById(R.id.cookie_mode_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreenActivity.this, CookieActivity.class);
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