package com.example.android.mathematicsapp.intro;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;

import com.example.android.mathematicsapp.R;

import java.util.Random;

public class IntroActivity extends AppCompatActivity {

    private static final String TAG = "Intro";

    private final long MILLIS_PER_SECOND = 1000;
    private final int FPS = 60;
    private boolean _isRunning;

    private long _nextFrameTime = System.currentTimeMillis();

    int test = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

//    public void update(int chooseRandomColor) {
//        System.out.println("testtesttest + " + chooseRandomColor + " test = " + test);
//        test--;
//        if (test == 0) _isRunning = false;
//    }
//
//    public boolean updateRequired() {
//        if (_nextFrameTime <= System.currentTimeMillis()) {
//            _nextFrameTime = System.currentTimeMillis() + MILLIS_PER_SECOND / FPS;
//            return true;
//        }
//        return false;
//    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onResume() {
        super.onResume();
        Random random = new Random();
        final int chooseRandomColor = random.nextInt(4);
        _isRunning = true;

//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                while (_isRunning) {
//                    if (updateRequired()) {
//                        update(chooseRandomColor);
//                        if (test == 100) findViewById(R.id.mathematics_text).setBackgroundColor(getResources().getColor(R.color.food));
//                    }
//                }
//            }
//        });

//        switch (chooseRandomColor) {
//            case 0: {
//                ObjectAnimator.ofObject((TextView) findViewById(R.id.mathematics_text), "textColor", new ArgbEvaluator(), Color.WHITE, Color.BLUE).setDuration(2000).start();
//                ((TextView) findViewById(R.id.mathematics_text)).setShadowLayer(8, 0,0, 4);
//                break;
//            }
//            case 1: {
//                ObjectAnimator.ofObject((TextView) findViewById(R.id.mathematics_text), "textColor", new ArgbEvaluator(), Color.WHITE, Color.GREEN).setDuration(2000).start();
//                break;
//            }
//            case 2: {
//                ObjectAnimator.ofObject((TextView) findViewById(R.id.mathematics_text), "textColor", new ArgbEvaluator(), Color.WHITE, Color.YELLOW).setDuration(2000).start();
//                break;
//            }
//            case 3: {
//                ObjectAnimator.ofObject((TextView) findViewById(R.id.mathematics_text), "textColor", new ArgbEvaluator(), Color.WHITE, Color.RED).setDuration(2000).start();
//                break;
//            }
//        }

//        android:shadowColor="#cf1d1d"
//        android:shadowDx="0.0"
//        android:shadowDy="0.0"
//        android:shadowRadius="8"

    }

    @Override
    protected void onPause() {
        super.onPause();
        _isRunning = false;
    }

    private class TextAnimationAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
