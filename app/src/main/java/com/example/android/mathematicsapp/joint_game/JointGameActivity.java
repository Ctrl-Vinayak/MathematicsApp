package com.example.android.mathematicsapp.joint_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.homescreen.HomeScreenActivity;
import com.example.android.mathematicsapp.single_game.SingleGameActivity;

public class JointGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joint_game);
        backBtn();
    }

    private void backBtn() {
        findViewById(R.id.joint_game_back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JointGameActivity.this, HomeScreenActivity.class);
                startActivity(intent);
            }
        });
    }
}
