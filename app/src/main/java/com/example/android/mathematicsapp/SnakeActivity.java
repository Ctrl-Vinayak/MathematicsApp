package com.example.android.mathematicsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SnakeActivity extends AppCompatActivity {

    public static boolean isSnakeGameReadyToUpdate = false;

    ArrayList<LinearLayout> gameRows = new ArrayList<>();
    public static ArrayList<LinearLayout> gameCells = new ArrayList<>();

    // snake body position
    int mRow = 0;
    int mColumn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snake);

        // setup 2 main linear layouts: game screen, input screen...
        LinearLayout snakeGameParentLayout = (LinearLayout) findViewById(R.id.snake_game_parent_layout);

        LinearLayout snakeGameScreenLayout = new LinearLayout(SnakeActivity.this);
        snakeGameScreenLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
        snakeGameScreenLayout.setOrientation(LinearLayout.VERTICAL);
        snakeGameScreenLayout.setWeightSum(20);
        snakeGameScreenLayout.setBackgroundColor(getResources().getColor(R.color.snake_game_screen));
        snakeGameParentLayout.addView(snakeGameScreenLayout);

        LinearLayout snakeGameInputLayout = new LinearLayout(SnakeActivity.this);
        snakeGameInputLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
        snakeGameInputLayout.setOrientation(LinearLayout.VERTICAL);
        snakeGameInputLayout.setWeightSum(5);
        snakeGameInputLayout.setBackgroundColor(getResources().getColor(R.color.snake_game_inputs));
        snakeGameParentLayout.addView(snakeGameInputLayout);

        // fill snake game screen with cells...
        LinearLayout.LayoutParams gameRowsLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
        LinearLayout.LayoutParams gameCellsLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
        for (int i = 0; i < 20; i++) {
            gameRows.add(new LinearLayout(SnakeActivity.this));
            gameRows.get(i).setLayoutParams(gameRowsLayout);
            gameRows.get(i).setOrientation(LinearLayout.HORIZONTAL);
            gameRows.get(i).setWeightSum(20);
            for (int j = 0; j < 20; j++) {
                gameCells.add(new LinearLayout(SnakeActivity.this));
                gameCells.get(j + (i * 20)).setLayoutParams(gameCellsLayout);
                gameCells.get(j + (i * 20)).setOrientation(LinearLayout.VERTICAL);
                gameRows.get(i).addView(gameCells.get(j + (i * 20)));
            }
            snakeGameScreenLayout.addView(gameRows.get(i));
        }

        // fill snake input screen with cells...
        ArrayList<LinearLayout> inputRows = new ArrayList<>();
        ArrayList<LinearLayout> inputCells = new ArrayList<>();
        LinearLayout.LayoutParams inputRowsLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
        LinearLayout.LayoutParams inputCellsLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
        for (int i = 0; i < 5; i++) {
            inputRows.add(new LinearLayout(SnakeActivity.this));
            inputRows.get(i).setLayoutParams(inputRowsLayout);
            inputRows.get(i).setOrientation(LinearLayout.HORIZONTAL);
            inputRows.get(i).setWeightSum(5);
            for (int j = 0; j < 5; j++) {
                inputCells.add(new LinearLayout(SnakeActivity.this));
                inputCells.get(j + (i * 5)).setLayoutParams(inputCellsLayout);
                inputCells.get(j + (i * 5)).setOrientation(LinearLayout.VERTICAL);
                inputRows.get(i).addView(inputCells.get(j + (i * 5)));
            }
            snakeGameInputLayout.addView(inputRows.get(i));
        }

        // fill snake input screen with buttons...
        Button up, left, right, down;
        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        up = new Button(SnakeActivity.this);
        up.setText("↑");
        up.setTextSize(20.0f);
        up.setLayoutParams(buttonLayoutParams);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRow--;
            }
        });
        inputCells.get(2 + (1 * 5)).addView(up);

        left = new Button(SnakeActivity.this);
        left.setText("←");
        left.setTextSize(20.0f);
        left.setLayoutParams(buttonLayoutParams);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mColumn--;
            }
        });
        inputCells.get(1 + (2 * 5)).addView(left);

        right = new Button(SnakeActivity.this);
        right.setText("→");
        right.setTextSize(20.0f);
        right.setLayoutParams(buttonLayoutParams);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mColumn++;
                gameCells.get(mColumn + (mRow * 20)).setBackgroundColor(getResources().getColor(R.color.snake_body));
            }
        });
        inputCells.get(3 + (2 * 5)).addView(right);

        down = new Button(SnakeActivity.this);
        down.setText("↓");
        down.setTextSize(20.0f);
        down.setLayoutParams(buttonLayoutParams);
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRow++;
            }
        });
        inputCells.get(2 + (3 * 5)).addView(down);

        //ready for snake game!
        isSnakeGameReadyToUpdate = true;
    }

    /** update snake body method */
    public void snakeBody() {
        mColumn++;
        gameCells.get(mColumn + (mRow * 20)).setBackgroundColor(getResources().getColor(R.color.snake_body));
    }
}
