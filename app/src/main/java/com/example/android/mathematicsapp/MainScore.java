package com.example.android.mathematicsapp;

public class MainScore {

    private int _expTotal;
    private int _dailyStreak;
    private int _dailygoal;
    private int _expToday;
    private int _cash;
    private int _level;
    private boolean _isDailyTaskDone;

    /** setters */
    public void setExpTotal(int expTotal) {
        _expTotal = expTotal;
    }

    public void setDailyStreak(int dailyStreak) {
        _dailyStreak = dailyStreak;
    }

    public void setDailyGoal(int dailyGoal){
        _dailygoal = dailyGoal;
    }

    public void setExpToday(int expToday){
        _expToday = expToday;
    }

    public void setCash(int cash) {
        _cash = cash;
    }

    public void setLevel(int level) {
        _level = level;
    }

    public void setDailyTaskDone(boolean isDailyTaskDone) {
        _isDailyTaskDone = isDailyTaskDone;
    }

    /** getters */
    public int getExpTotal() {
        return _expTotal;
    }

    public int getDailyStreak() {
        return _dailyStreak;
    }

    public int getDailyGaol() {
        return _dailygoal;
    }

    public int getExpToday() {
        return _expToday;
    }

    public int getCash() {
        return _cash;
    }

    public int getLevel() {
        return _level;
    }

    public boolean isDailyTaskDone() {
        return _isDailyTaskDone;
    }
}
