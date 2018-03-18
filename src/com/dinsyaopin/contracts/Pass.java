package com.dinsyaopin.contracts;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.Suits;

public class Pass extends Contract {
    private static final int WEIGHT = 0;

    public Pass(int tricks) {
        this.tricks = 0;
    }

    @Override
    public void setWinner(GameBot gameBot) {

    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public GameBot getWinner() {
        return null;
    }

    @Override
    public Suits getSuit() {
        return null;
    }

    @Override
    public int getWhist() {
        return 0;
    }

    @Override
    public int getTricks() {
        return 0;
    }

    @Override
    public String toString() {
        return "Пас";
    }
}
