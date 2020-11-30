package com.example.android.mathematicsapp.intro;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.snakegame.SnakeActivity;

import java.util.Random;

public class IntroActivity extends AppCompatActivity implements Runnable {

    private static final String TAG = "Intro";
    private long _launchStartedTime = System.currentTimeMillis();
    private long _launchFinishedTime = System.currentTimeMillis() + 2000;
    private Thread _thread;
    private boolean _isRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onResume() {
        super.onResume();
        Random random = new Random();
        final int chooseRandomColor = random.nextInt(5);

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
                Intent intent = new Intent(this, SnakeActivity.class);
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
