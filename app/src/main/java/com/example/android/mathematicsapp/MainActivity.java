package com.example.android.mathematicsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Gameloop gameloop;
    Thread gameloopThread;
    public static boolean isRunning;

    public static boolean isUp;
    public static boolean isLeft;
    public static boolean isRight = true;
    public static boolean isDown;

    private static SnakeView mSnakeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSnakeView = (SnakeView) findViewById(R.id.snake_view);

        Button playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), SnakeActivity.class);
//                startActivity(intent);
                if (!isRunning) {
                    isRunning = true;
                    gameloop = new Gameloop();
                    gameloopThread = new Thread(gameloop);
                    gameloopThread.start();
                }
            }
        });

        Button stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        findViewById(R.id.up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isUp = true;
                isLeft = false;
                isRight = false;
                isDown = false;
            }
        });

        findViewById(R.id.left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isUp = false;
                isLeft = true;
                isRight = false;
                isDown = false;
            }
        });

        findViewById(R.id.right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isUp = false;
                isLeft = false;
                isRight = true;
                isDown = false;
            }
        });

        findViewById(R.id.down).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isUp = false;
                isLeft = false;
                isRight = false;
                isDown = true;
            }
        });
    }

    public static void whichDirection() {
        if (isUp) {
            mSnakeView.y -= 50;
            mSnakeView.moveSnake();
        } else if (isLeft) {
            mSnakeView.x -= 50;
            mSnakeView.moveSnake();
        } else if (isRight) {
            mSnakeView.x += 50;
            mSnakeView.moveSnake();
        } else if (isDown) {
            mSnakeView.y += 50;
            mSnakeView.moveSnake();
        }
    }
}