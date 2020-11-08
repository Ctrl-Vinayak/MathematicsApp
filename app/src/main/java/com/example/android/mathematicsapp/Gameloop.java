package com.example.android.mathematicsapp;

import android.widget.RelativeLayout;

public class Gameloop implements Runnable {

    private SnakeActivity snakeActivity = new SnakeActivity();
    private Thread thread;
    private boolean isRunning = false;
    private final short FPS = 60;
    private short tickNumber = 0;
    private long targetTime = 1000 / FPS;

    public Gameloop() {
        start();
    }

    private void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while(isRunning) {

            tick();
            tickNumber++;
            if (tickNumber == 60) tickNumber = 0;

            try {
                Thread.sleep(targetTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void tick() {
        if (SnakeActivity.isSnakeGameReadyToUpdate) {
            if (tickNumber % 30 == 0) {
                snakeActivity.snakeBody();
//                System.out.println("gamecells size = " + SnakeActivity.gameCells.size());
            }
        }
    }
}