package com.example.android.mathematicsapp.snakegame;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.snakegame.Snake.Direction;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SnakeGame extends View implements Runnable {

    private static final String TAG = "SnakeGame";

    private final long MILLIS_PER_SECOND = 1000;
    private final short NUM_BLOCKS_WIDE = 20;
    private final short FPS = 7;

    private Thread _thread = null;
    private volatile boolean _isRunning;
    private volatile boolean _isPlaying;
    private long _nextFrameTime;

    private String _currentScoreMsg;
    private String _lastScoreMsg;
    private String _highScoreMsg;
    private String _startPromptMsg;
    private String _congratulationsMsg;

    private int _backgroundBeginColor;
    private int _backgroundScreenColor;
    private int _backgroundInputColor;
    private int _controllersColor;
    private int _foodColor;
    private int _snakeColor;
    private int _textColor;

    private Rect _backgroundScreenRect;
    private Rect _backgroundInputRect;
    private Paint _backgroundScreenPaint;
    private Paint _backgroundInputPaint;

    private int _screenWidth;
    private int _screenHeight;
    private int _snakeHeightScreen;
    private int _snakeBlockSize;
    private int _snakeWidthBlockFits;
    private int _maxBlocksOnScreen;

    private Rect _upBtn;
    private Rect _rightBtn;
    private Rect _downBtn;
    private Rect _leftBtn;
    private Paint _btnPaint;

    private Snake _snake;
    private Paint _snakePaint;
    private Direction _snakeDirection;

    private Rect _foodRect;
    private Paint _foodPaint;

    private Paint textPaint;
    private int _score;
    private int _highScore;

    public SnakeGame(Context context, Point size) {
        super(context);

        // screen size
        _screenWidth = size.x;
        _screenHeight = size.y;

        // snake game screen is 7/10 of the display height.
        // snake block size is 7/10 of the display height divided by 20.
        // snake width block fits means how many snake blocks there fits in the display width.
        // max blocks on screen is just 20 times the (snake width block fits).
        _snakeHeightScreen = _screenHeight / 10 * 7;
        _snakeBlockSize = _snakeHeightScreen / NUM_BLOCKS_WIDE;
        _snakeWidthBlockFits = _screenWidth / _snakeBlockSize;
        _maxBlocksOnScreen = NUM_BLOCKS_WIDE * _snakeWidthBlockFits;

        // Texts for the snake game.
        _currentScoreMsg = getContext().getString(R.string.current_score);
        _lastScoreMsg = getContext().getString(R.string.last_score);
        _highScoreMsg = getContext().getString(R.string.high_score);
        _startPromptMsg = getContext().getString(R.string.start_game_prompt);
        _congratulationsMsg = getContext().getString(R.string.congratulations);

        // Colors for the snake game.
        _backgroundBeginColor = getContext().getResources().getColor(R.color.background_snake_begin);
        _backgroundScreenColor = getContext().getResources().getColor(R.color.background_snake_screen);
        _backgroundInputColor = getContext().getResources().getColor(R.color.background_snake_input);
        _controllersColor = getContext().getResources().getColor(R.color.controllers);
        _foodColor = getContext().getResources().getColor(R.color.food);
        _snakeColor = getContext().getResources().getColor(R.color.snake);
        _textColor = getContext().getResources().getColor(R.color.text);

        // Background Color for Input and Screen for the snake game.
        _backgroundScreenRect = new Rect(0, 0, _screenWidth, _snakeHeightScreen);
        _backgroundInputRect = new Rect(0, _snakeHeightScreen, _screenWidth, _screenHeight);
        _backgroundScreenPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        _backgroundInputPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        _backgroundScreenPaint.setColor(_backgroundScreenColor);
        _backgroundInputPaint.setColor(_backgroundInputColor);

        // Buttons, it haves some complex coordinates...
        _upBtn = new Rect(
                _screenWidth / 2 - (_screenHeight / 10 / 2),
                _snakeHeightScreen,
                _screenWidth / 2 + (_screenHeight / 10 / 2),
                _snakeHeightScreen + (_screenHeight / 10));
        _rightBtn = new Rect(
                _screenWidth / 2 + (_screenHeight / 10 / 2),
                _snakeHeightScreen + (_screenHeight / 10),
                _screenWidth / 2 + (_screenHeight / 10 / 2) + (_screenHeight / 10),
                _snakeHeightScreen + (_screenHeight / 10 * 2));
        _downBtn = new Rect(
                _screenWidth / 2 - (_screenHeight / 10 / 2),
                _snakeHeightScreen + (_screenHeight / 10 * 2),
                _screenWidth / 2 + (_screenHeight / 10 / 2),
                _snakeHeightScreen + (_screenHeight / 10 * 3));
        _leftBtn = new Rect(
                _screenWidth / 2 - (_screenHeight / 10 / 2) - (_screenHeight / 10),
                _snakeHeightScreen + (_screenHeight / 10),
                _screenWidth / 2 - (_screenHeight / 10 / 2),
                _snakeHeightScreen + (_screenHeight / 10 * 2));
        _btnPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        _btnPaint.setColor(_controllersColor);

        // Snake Color and Default Direction.
        _snakePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        _snakePaint.setColor(_snakeColor);

        // Food Color and Rectangle.
        _foodRect = new Rect();
        _foodPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        _foodPaint.setColor(_foodColor);

        // Text Color...
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(_textColor);

        _nextFrameTime = System.currentTimeMillis();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(_backgroundBeginColor);
        if (_isPlaying) {

            // draw background.
            canvas.drawRect(_backgroundScreenRect, _backgroundScreenPaint);
            canvas.drawRect(_backgroundInputRect, _backgroundInputPaint);

            // draw buttons.
            canvas.drawRect(_upBtn, _btnPaint);
            canvas.drawRect(_rightBtn, _btnPaint);
            canvas.drawRect(_downBtn, _btnPaint);
            canvas.drawRect(_leftBtn, _btnPaint);

            // draw score text.
            textPaint.setTextSize(70);
            canvas.drawText(String.format(_currentScoreMsg, _score), 20, 60, textPaint);

            // draw food.
            canvas.drawRect(_foodRect, _foodPaint);

            // draw snake.
            for (int i = 0; i < _snake.getSnakeLength() + 1; i++) {
                canvas.drawRect(
                        _snake.bodyXs[i] * _snakeBlockSize,
                        _snake.bodyYs[i] * _snakeBlockSize,
                        _snake.bodyXs[i] * _snakeBlockSize + _snakeBlockSize,
                        _snake.bodyYs[i] * _snakeBlockSize + _snakeBlockSize,
                        _snakePaint);
            }
        } else {
            textPaint.setTextSize(60);
            int halfScreen = _screenWidth / 2;
            int halfText;

            // last score message.
            if (_score > 0) {
                String msgScore = String.format(_lastScoreMsg, _score);
                float scoreMeasure = textPaint.measureText(msgScore);
                halfText = Math.round(scoreMeasure / 2);
                canvas.drawText(
                        msgScore,
                        halfScreen - halfText,
                        (_screenHeight / 2) + 100,
                        textPaint);
            }

            // high score message.
            if (_score > 0) {
                String msgHighScore = String.format(_highScoreMsg, _highScore);
                float highScoreMeasure = textPaint.measureText(msgHighScore);
                halfText = Math.round(highScoreMeasure / 2);
                canvas.drawText(
                        msgHighScore,
                        halfScreen - halfText,
                        (_screenHeight / 2) - 100,
                        textPaint
                );
            }

            // congratulation message.
            if (_score >= (_maxBlocksOnScreen - 1)) {
                float congratsMeasure = textPaint.measureText(_congratulationsMsg);
                halfText = Math.round(congratsMeasure / 2);
                canvas.drawText(
                        _congratulationsMsg,
                        halfScreen - halfText,
                        (_screenHeight / 2 + 200),
                        textPaint
                );
            }

            // Here is instruction message at the begin screen of the snake game.
            float startMeasure = textPaint.measureText(_startPromptMsg);
            halfText = Math.round(startMeasure / 2);
            canvas.drawText(_startPromptMsg, halfScreen - halfText,_screenHeight / 2, textPaint);
        }
    }

    @Override
    public void run() {
        while(_isRunning) {
            if(updateRequired()) {
                if (_isPlaying) {
                    update();
                }
                postInvalidate();
            }
        }
    }

    public void pause() {
        _isRunning = false;
        try {
            _thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        _isRunning = true;
        _thread = new Thread(this);
        _thread.start();
    }

    /**
     * Note: in this explanation, I say current time instead of System.currentTimeMillis().
     *
     * This method is for the game loop.
     * This method is being used in the run method from Runnable.
     * If the current time is bigger than the value of _nextFrameTime.
     * Then _nextFrameTime will have a bigger value, how this happens is by
     * adding the current time plus next frame time, in other words:
     *
     * _nextFrameTime = current time + 1000 / FPS.
     *
     * @return most of the time false, because _nextFrameTime is usually bigger than current time.
     */
    public boolean updateRequired() {
        if (_nextFrameTime <= System.currentTimeMillis()) {
            _nextFrameTime = System.currentTimeMillis() + MILLIS_PER_SECOND / FPS;
            return true;
        }
        return false;
    }

    public void update() {
        if ((_snake.getHeadX() * _snakeBlockSize) == _foodRect.left &&
            _snake.getHeadY() * _snakeBlockSize == _foodRect.top) {
            eatFood();
        }

        if (_score > _highScore) _highScore = _score;

        _snake.moveSnake();

        if (detectDeath()) {
            saveData();
            _isPlaying = false;
        }
    }

    public void saveData() {
        SharedPreferences prefs = getContext().getSharedPreferences("SharedPrefKey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("highScoreKey", _highScore);
        editor.apply();
    }

    public void loadData() {
        SharedPreferences prefs = getContext().getSharedPreferences("SharedPrefKey", Context.MODE_PRIVATE);
        _highScore = prefs.getInt("highScoreKey", 0);
    }

    public void startGame() {
        _nextFrameTime = System.currentTimeMillis();
        _snakeDirection = Direction.RIGHT;
        _snake = new Snake(0, 0, _snakeDirection, _maxBlocksOnScreen);
        spawnFood();
        _score = 0;
        loadData();
        _isPlaying = true;
    }

    /**
     * this method is not really made 100% by me (aka Vinayak), but
     * by https://github.com/michelrbr/snake-game
     * without this repository, it would take me a month or more to make this method.
     */
    public void spawnFood() {
        Random random = new Random();
        int rx;
        int ry;

        List xs = Arrays.asList(_snake.bodyYs);
        List ys = Arrays.asList(_snake.bodyYs);

        do {
            rx = random.nextInt(_snakeWidthBlockFits - 1) + 1;
            ry = random.nextInt(NUM_BLOCKS_WIDE - 1) + 1;
        } while (xs.contains(rx) && ys.contains(ry));

        int x = rx * _snakeBlockSize;
        int y = ry * _snakeBlockSize;

        _foodRect.set(
                x,
                y,
                x + _snakeBlockSize,
                y + _snakeBlockSize
        );
    }

    public void eatFood() {

        _score++;

        if (_score < (_maxBlocksOnScreen - 1)) {
            spawnFood();
            _snake.increaseSize();
        } else {
            _isPlaying = false;
        }
    }

    private boolean detectDeath() {

        boolean dead = false;

        // Hit the screen edge.
        if (_snake.getHeadX() == -1) dead = true;
        if (_snake.getHeadY() == -1) dead = true;
        if (_snake.getHeadX() >= _snakeWidthBlockFits) dead = true;
        if (_snake.getHeadY() >= NUM_BLOCKS_WIDE) dead = true;

        // Hit itself
        for (int i = _snake.getSnakeLength() + 1; i > 0; i--) {
            if ((i > 4)
                && (_snake.getHeadX() == _snake.bodyXs[i])
                && (_snake.getHeadY() == _snake.bodyYs[i])) {
                dead = true;
            }
        }

        return dead;
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            if (_isPlaying) {

                // Touch X and Y position.
                int posX = Math.round(motionEvent.getX());
                int posY = Math.round(motionEvent.getY());

                // Up Button.
                if (posX >= _screenWidth / 2 - (_screenHeight / 10 / 2) &&
                    posX <= _screenWidth / 2 + (_screenHeight / 10 / 2) &&
                    posY >= _snakeHeightScreen &&
                    posY <= _snakeHeightScreen + (_screenHeight / 10) &&
                    _snakeDirection != Direction.DOWN) {
                    _snakeDirection = Direction.UP;
                }
                // Right Button.
                if (posX >= _screenWidth / 2 + (_screenHeight / 10 / 2) &&
                    posX <= _screenWidth / 2 + (_screenHeight / 10 / 2) + (_screenHeight / 10) &&
                    posY >= _snakeHeightScreen + (_screenHeight / 10) &&
                    posY <= _snakeHeightScreen + (_screenHeight / 10 * 2) &&
                    _snakeDirection != Direction.LEFT) {
                    _snakeDirection = Direction.RIGHT;
                }
                // Down Button.
                if (posX >= _screenWidth / 2 - (_screenHeight / 10 / 2) &&
                    posX <= _screenWidth / 2 + (_screenHeight / 10 / 2) &&
                    posY >= _snakeHeightScreen + (_screenHeight / 10 * 2) &&
                    posY <= _snakeHeightScreen + (_screenHeight / 10 * 3) &&
                    _snakeDirection != Direction.UP) {
                    _snakeDirection = Direction.DOWN;
                }
                // Left Button.
                if (posX >= _screenWidth / 2 - (_screenHeight / 10 / 2) - (_screenHeight / 10) &&
                    posX <= _screenWidth / 2 - (_screenHeight / 10 / 2) &&
                    posY >= _snakeHeightScreen + (_screenHeight / 10) &&
                    posY <= _snakeHeightScreen + (_screenHeight / 10 * 2) &&
                    _snakeDirection != Direction.RIGHT) {
                    _snakeDirection = Direction.LEFT;
                }

                // pass the direction value to Snake class.
                _snake.setCurrentDirection(_snakeDirection);

            } else {
                startGame();
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
