package com.example.android.mathematicsapp.snakegame;

public class Snake {

    public enum Direction {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }

    public int[] bodyXs;
    public int[] bodyYs;
    private int _snakeLength;
    private Direction _currentDirection;

    public Snake(int initX, int initY, Direction direction, int maxLength) {
        bodyXs = new int[maxLength];
        bodyYs = new int[maxLength];
        bodyXs[0] = initX;
        bodyYs[0] = initY;
        _currentDirection = direction;
        _snakeLength = 0;
    }

    public void increaseSize() {
        _snakeLength++;
    }

    public void moveSnake() {

        // Move the snake body.
        for (int i = getSnakeLength(); i > 0; i--) {
            bodyXs[i] = bodyXs[i - 1];
            bodyYs[i] = bodyYs[i - 1];
        }

        // Move the snake head.
        switch (getCurrentDirection()) {
            case UP:
                bodyYs[0]--;
                break;

            case RIGHT:
                bodyXs[0]++;
                break;

            case DOWN:
                bodyYs[0]++;
                break;

            case LEFT:
                bodyXs[0]--;
                break;
        }
    }

    public int getHeadX() {
        return bodyXs[0];
    }

    public int getHeadY() {
        return bodyYs[0];
    }

    public int getSnakeLength() {
        return _snakeLength;
    }

    public void setCurrentDirection(Direction direction) {
        _currentDirection = direction;
    }

    public Direction getCurrentDirection() {
        return _currentDirection;
    }
}
