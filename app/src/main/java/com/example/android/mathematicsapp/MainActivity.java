package com.example.android.mathematicsapp;

import android.content.Intent;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.play_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SnakeActivity.class);
                startActivity(intent);
            }
        });
    }
}