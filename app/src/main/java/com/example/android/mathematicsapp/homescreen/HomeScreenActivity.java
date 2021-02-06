package com.example.android.mathematicsapp.homescreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.trainingmode.begin.TrainingModeBeginScreen;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeScreenActivity extends AppCompatActivity {

    private String _exp;
    private String _dayStreak;
    private String _somethingOfGoalAchieved;
    private String _cash;
    private String _date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        changeText();
        buttonIntents();

        // TODO add here a new better condition then just "true".
        if (true) {
            findViewById(R.id.snake_image).setVisibility(View.GONE);
        }
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
    }
}