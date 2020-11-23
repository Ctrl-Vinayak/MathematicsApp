package com.example.android.mathematicsapp;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.snakegame.SnakeActivity;

public class MainActivity extends AppCompatActivity {

    // TODO make main menu better.
    // TODO add the essential buttons...
    // TODO add how many coins you have in game.
    // TODO save the coins in game.
    // TODO add new activities for the buttons.
    // TODO add small hidden button for the snake game.

    // TODO make a new project to test navigation component.
    // TODO make categories for training mode.
    // TODO make some questions for the practices in this app.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

//        setContentView(R.layout.activity_main);
//
//        findViewById(R.id.play_btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), SnakeActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}