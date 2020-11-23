package com.example.android.mathematicsapp.intro;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import com.example.android.mathematicsapp.snakegame.Snake;

public class Intro extends View {

    private static final String TAG = "Intro";

    public Intro(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

            // Touch X and Y position.
            int posX = Math.round(motionEvent.getX());
            int posY = Math.round(motionEvent.getY());



        }
        return super.onTouchEvent(motionEvent);
    }
}
