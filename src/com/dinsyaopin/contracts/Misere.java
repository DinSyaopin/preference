package com.dinsyaopin.contracts;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.Suits;

public class Misere extends Contract {
    private static final int WEIGHT = 16;

    public int getWeight() {
        return WEIGHT;
    }

    public Misere(int tricks) {
        this.tricks = tricks;
    }

    public void setWinner(GameBot gameBot) {
        this.winner = gameBot;
    }

    @Override
    public GameBot getWinner() {
        return this.winner;
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
        return "Мизер";
    }
}
