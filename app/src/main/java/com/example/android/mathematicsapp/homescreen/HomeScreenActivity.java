package com.example.android.mathematicsapp.homescreen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.joint_game.JointGameActivity;
import com.example.android.mathematicsapp.settings.SettingsActivity;
import com.example.android.mathematicsapp.single_game.SingleGameActivity;

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

    private LinearLayout _cashLayout;
    private ImageView _lockImage;
    private ImageView _snakeImage;
    private RelativeLayout _dateLayout;

    private RelativeLayout _single_game_btn;
    private RelativeLayout _joint_game_btn;
    private RelativeLayout _training_mode_btn;
    private RelativeLayout _cookie_mode_btn;
    private RelativeLayout _advancements_btn;
    private RelativeLayout _settings_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        applyTheme();
        changeText();
        buttonIntents();

        // TODO add here a new better condition then just "true".
        if (true) {
            findViewById(R.id.snake_image).setVisibility(View.GONE);
        }
    }

    private void applyTheme() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("SharedPrefKey", Context.MODE_PRIVATE);
        _homeScreenActionBar = (RelativeLayout) findViewById(R.id.home_screen_action_bar);
        _homeScreenBackground = (LinearLayout) findViewById(R.id.home_screen_background);
        _homeScreenActionBar.setBackgroundColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));
        _homeScreenBackground.setBackgroundColor(prefs.getInt("currentBgKey", getApplicationContext().getResources().getColor(R.color.light_bg)));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(prefs.getInt("currentBgKey", getApplicationContext().getResources().getColor(R.color.light_bg)));
        }

        // non buttons
        _cashLayout = (LinearLayout) findViewById(R.id.cash_layout);
        _cashLayout.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableCashLayout = (GradientDrawable) _cashLayout.getBackground();
        drawableCashLayout.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _lockImage = (ImageView) findViewById(R.id.lock_image);
        _lockImage.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableLockImage = (GradientDrawable) _lockImage.getBackground();
        drawableLockImage.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _snakeImage = (ImageView) findViewById(R.id.snake_image);
        _snakeImage.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableSnakeImage = (GradientDrawable) _snakeImage.getBackground();
        drawableSnakeImage.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _dateLayout = (RelativeLayout) findViewById(R.id.date_layout);
        _dateLayout.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableDateLayout = (GradientDrawable) _dateLayout.getBackground();
        drawableDateLayout.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        // buttons
        _single_game_btn = (RelativeLayout) findViewById(R.id.single_game_btn);
        _single_game_btn.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableSingleGame = (GradientDrawable) _single_game_btn.getBackground();
        drawableSingleGame.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _joint_game_btn = (RelativeLayout) findViewById(R.id.joint_game_btn);
        _joint_game_btn.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableJointGame = (GradientDrawable) _joint_game_btn.getBackground();
        drawableJointGame.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _training_mode_btn = (RelativeLayout) findViewById(R.id.training_mode_btn);
        _training_mode_btn.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableTrainingMode = (GradientDrawable) _training_mode_btn.getBackground();
        drawableTrainingMode.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _cookie_mode_btn = (RelativeLayout) findViewById(R.id.cookie_mode_btn);
        _cookie_mode_btn.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableCookieMode = (GradientDrawable) _cookie_mode_btn.getBackground();
        drawableCookieMode.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _advancements_btn = (RelativeLayout) findViewById(R.id.advancements_btn);
        _advancements_btn.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableAdvancements = (GradientDrawable) _advancements_btn.getBackground();
        drawableAdvancements.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _settings_btn = (RelativeLayout) findViewById(R.id.settings_btn);
        _settings_btn.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableSettings = (GradientDrawable) _settings_btn.getBackground();
        drawableSettings.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));
    }

    /** most of the scores are set here */
    private void changeText() {
        // TODO save scores here for home screen activity appearance.
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("SharedPrefKey", Context.MODE_PRIVATE);
//        _homeScreenActionBar.setBackgroundColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));
//        _homeScreenBackground.setBackgroundColor(prefs.getInt("currentBgKey", getApplicationContext().getResources().getColor(R.color.light_bg)));

        _exp = getApplicationContext().getString(R.string.exp);
        TextView exp = (TextView) findViewById(R.id.exp);
        exp.setText(String.format(_exp, "1000"));

        _dayStreak = getApplicationContext().getString(R.string.day_streak);
        TextView dayStreak = (TextView) findViewById(R.id.day_streak);
        dayStreak.setText(String.format(_dayStreak, "14"));

        _somethingOfGoalAchieved = getApplicationContext().getString(R.string.daily_goal);
        TextView somethingOfGoalAchieved = (TextView) findViewById(R.id.something_of_goal_achieved);
        somethingOfGoalAchieved.setText(String.format(_somethingOfGoalAchieved, "513" + " / " + "200"));

        _cash = getApplicationContext().getString(R.string.cash);
        TextView cash = (TextView) findViewById(R.id.cash_num);
        cash.setText(String.format(_cash, "5513"));

        // get and set the date for the text view, to display current date.
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String strDate= formatter.format(date);
        _date = getApplicationContext().getString(R.string.current_date);
        TextView dateTv = (TextView) findViewById(R.id.date);
        dateTv.setText(String.format(_date, strDate));
    }

    private void buttonIntents() {
        findViewById(R.id.single_game_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreenActivity.this, SingleGameActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.joint_game_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreenActivity.this, JointGameActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.settings_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreenActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}