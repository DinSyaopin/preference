package com.dinsyaopin;

public class LogDataInitial extends LogData {
    private int pool;
    GameBot gameBot1;
    GameBot gameBot2;
    GameBot gameBot3;
    String gameBot1Name;
    String gameBot2Name;
    String gameBot3Name;
    public int getPool() {
        return pool;
    }

    public void setPool(int pool) {
        this.pool = pool;
    }

    public GameBot getGameBot1() {
        return gameBot1;
    }

    public void setGameBot1(GameBot gameBot1) {
        this.gameBot1 = gameBot1;
    }

    public GameBot getGameBot2() {
        return gameBot2;
    }

    public void setGameBot2(GameBot gameBot2) {
        this.gameBot2 = gameBot2;
    }

    public GameBot getGameBot3() {
        return gameBot3;
    }

    public void setGameBot3(GameBot gameBot3) {
        this.gameBot3 = gameBot3;
    }

    public void setGameBot1Name(String gameBot1Name) {
        this.gameBot1Name = gameBot1Name;
    }

    public void setGameBot2Name(String gameBot2Name) {
        this.gameBot2Name = gameBot2Name;
    }

    public void setGameBot3Name(String gameBot3Name) {
        this.gameBot3Name = gameBot3Name;
    }
}