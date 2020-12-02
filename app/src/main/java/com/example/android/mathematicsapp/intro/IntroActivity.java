package com.example.android.mathematicsapp.intro;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.homescreen.HomeScreenActivity;

import java.util.Random;

public class IntroActivity extends AppCompatActivity implements Runnable {

    private static final String TAG = "Intro";
    private long _launchStartedTime = System.currentTimeMillis();
    private long _launchFinishedTime = System.currentTimeMillis() + 2200;
    private Thread _thread;
    private boolean _isRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        new HomeScreenActivity();
        findViewById(R.id.intro).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroActivity.this, HomeScreenActivity.class);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onResume() {
        super.onResume();
        Random random = new Random();
        final int chooseRandomColor = random.nextInt(5);
        final int chooseZoomInOrNot = random.nextInt(20);

        switch (chooseRandomColor) {
            case 0: {
                ObjectAnimator.ofObject((TextView) findViewById(R.id.mathematics_text), "textColor", new ArgbEvaluator(), Color.WHITE, getResources().getColor(R.color.neon_blue)).setDuration(2000).start();
                ((TextView) findViewById(R.id.mathematics_text)).setShadowLayer(64, 0,0, getResources().getColor(R.color.neon_blue));
                break;
            }
            case 1: {
                ObjectAnimator.ofObject((TextView) findViewById(R.id.mathematics_text), "textColor", new ArgbEvaluator(), Color.WHITE, getResources().getColor(R.color.neon_green)).setDuration(2000).start();
                ((TextView) findViewById(R.id.mathematics_text)).setShadowLayer(64, 0,0, getResources().getColor(R.color.neon_green));
                break;
            }
            case 2: {
                ObjectAnimator.ofObject((TextView) findViewById(R.id.mathematics_text), "textColor", new ArgbEvaluator(), Color.WHITE, getResources().getColor(R.color.neon_yellow)).setDuration(2000).start();
                ((TextView) findViewById(R.id.mathematics_text)).setShadowLayer(64, 0,0, getResources().getColor(R.color.neon_yellow));
                break;
            }
            case 3: {
                ObjectAnimator.ofObject((TextView) findViewById(R.id.mathematics_text), "textColor", new ArgbEvaluator(), Color.WHITE, getResources().getColor(R.color.neon_orange)).setDuration(2000).start();
                ((TextView) findViewById(R.id.mathematics_text)).setShadowLayer(64, 0,0, getResources().getColor(R.color.neon_orange));
                break;
            }
            case 4: {
                ObjectAnimator.ofObject((TextView) findViewById(R.id.mathematics_text), "textColor", new ArgbEvaluator(), Color.WHITE, getResources().getColor(R.color.neon_red)).setDuration(2000).start();
                ((TextView) findViewById(R.id.mathematics_text)).setShadowLayer(64, 0,0, getResources().getColor(R.color.neon_red));
                break;
            }
        }

        if (chooseZoomInOrNot == 19) {
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
            findViewById(R.id.mathematics_text).startAnimation(animation);
        }

        _launchStartedTime = System.currentTimeMillis();
        _launchFinishedTime = _launchStartedTime + 2200;

        _isRunning = true;
        _thread = new Thread(this);
        _thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        _isRunning = false;
        try {
            _thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        _launchStartedTime = System.currentTimeMillis();
        while (_isRunning) {
            if (updateRequired()) {
                Intent intent = new Intent(this, HomeScreenActivity.class);
                startActivity(intent);
                _isRunning = false;

            }
        }
    }

    public boolean updateRequired() {
        if (_launchFinishedTime <= System.currentTimeMillis()) {
            return true;
        }
        return false;
    }
}
