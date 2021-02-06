package com.example.android.mathematicsapp.homescreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.snakegame.SnakeActivity;
import com.example.android.mathematicsapp.trainingmode.begin.TrainingModeBeginScreen;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeScreenActivity extends AppCompatActivity {

    // TODO fix all the intents, so you can also go back to home screen.
    // TODO Add explanation activities for every exercise.
    // TODO Make advancements activity.
    // TODO Save exp after you did an exercise (+1 exp).
    // TODO When snake image clicked, you got the new achievement, "snake gamer (:".
    // TODO When exp reached 10, you got the achievement, "You reached 10 exp"
    // TODO When exp reached 100, you got the achievement, "You reached 100 exp"

    private String _exp;
    private String _date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

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
        findViewById(R.id.snake_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreenActivity.this, SnakeActivity.class);
                startActivity(intent);
            }
        });
    }
}