package com.example.android.mathematicsapp.single_game;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.homescreen.HomeScreenActivity;

public class SingleGameActivity extends AppCompatActivity {

    private String _title;

    private TextView _singleGameActionBarTitle;

    private RelativeLayout _singleGameActionBar;
    private LinearLayout _singleGameBackground;

    private ImageView _arrowUpBtn;
    private TextView _levelTxt;
    private ImageView _arrowDownBtn;

    private RelativeLayout _bitterEndBtn;
    private RelativeLayout _minuteChallengeBtn;
    private RelativeLayout _speedChallengeBtn;
    private RelativeLayout _noTimeLimitBtn;

    private ImageView _bitterEndGraph;
    private ImageView _minuteChallengeGraph;
    private ImageView _speedChallengeGraph;
    private ImageView _noTimeLimitGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_game);
        applyTheme();
        changeText();
        buttonIntents();
    }

    private void applyTheme() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("SharedPrefKey", Context.MODE_PRIVATE);
        _singleGameActionBar = (RelativeLayout) findViewById(R.id.single_game_action_bar);
        _singleGameBackground = (LinearLayout) findViewById(R.id.single_game_background);
        _singleGameActionBar.setBackgroundColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));
        _singleGameBackground.setBackgroundColor(prefs.getInt("currentBgKey", getApplicationContext().getResources().getColor(R.color.light_bg)));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(prefs.getInt("currentBgKey", getApplicationContext().getResources().getColor(R.color.light_bg)));
        }

        // levels
        _arrowUpBtn = (ImageView) findViewById(R.id.arrow_up_btn);
        _arrowUpBtn.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableArrowUpBtn = (GradientDrawable) _arrowUpBtn.getBackground();
        drawableArrowUpBtn.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _levelTxt = (TextView) findViewById(R.id.level_txt);
        _levelTxt.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableLevelTxt = (GradientDrawable) _levelTxt.getBackground();
        drawableLevelTxt.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _arrowDownBtn = (ImageView) findViewById(R.id.arrow_down_btn);
        _arrowDownBtn.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableArrowDownBtn = (GradientDrawable) _arrowDownBtn.getBackground();
        drawableArrowDownBtn.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        // buttons
        _bitterEndBtn = (RelativeLayout) findViewById(R.id.bitter_end_btn);
        _bitterEndBtn.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableBitterEndBtn = (GradientDrawable) _bitterEndBtn.getBackground();
        drawableBitterEndBtn.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _minuteChallengeBtn = (RelativeLayout) findViewById(R.id.minute_challenge_btn);
        _minuteChallengeBtn.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableMinuteChallenge = (GradientDrawable) _minuteChallengeBtn.getBackground();
        drawableMinuteChallenge.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _speedChallengeBtn = (RelativeLayout) findViewById(R.id.speed_challenge_btn);
        _speedChallengeBtn.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableSpeedChallenge = (GradientDrawable) _speedChallengeBtn.getBackground();
        drawableSpeedChallenge.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _noTimeLimitBtn = (RelativeLayout) findViewById(R.id.no_time_limit_btn);
        _noTimeLimitBtn.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableNoTimeLimit = (GradientDrawable) _noTimeLimitBtn.getBackground();
        drawableNoTimeLimit.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        // graphs
        _bitterEndGraph = (ImageView) findViewById(R.id.graph_bitter_end_btn);
        _bitterEndGraph.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableBitterEndGraph = (GradientDrawable) _bitterEndGraph.getBackground();
        drawableBitterEndGraph.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _minuteChallengeGraph = (ImageView) findViewById(R.id.graph_minute_challenge_btn);
        _minuteChallengeGraph.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableMinuteChallengeGraph = (GradientDrawable) _minuteChallengeGraph.getBackground();
        drawableMinuteChallengeGraph.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _speedChallengeGraph = (ImageView) findViewById(R.id.graph_speed_challenge_btn);
        _speedChallengeGraph.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableSpeedChallengeGraph = (GradientDrawable) _speedChallengeGraph.getBackground();
        drawableSpeedChallengeGraph.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _noTimeLimitGraph = (ImageView) findViewById(R.id.graph_no_time_limit_btn);
        _noTimeLimitGraph.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableNoTimeLimitGraph = (GradientDrawable) _noTimeLimitGraph.getBackground();
        drawableNoTimeLimitGraph.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));
    }

    private void changeText() {
        _title = getApplicationContext().getString(R.string.level_nums);
        _singleGameActionBarTitle = (TextView) findViewById(R.id.single_game_action_bar_title);
        _singleGameActionBarTitle.setText(String.format(_title, 1));

        _levelTxt.setText("1");
    }

    private void buttonIntents() {
        findViewById(R.id.single_game_back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingleGameActivity.this, HomeScreenActivity.class);
                startActivity(intent);
            }
        });
    }
}
