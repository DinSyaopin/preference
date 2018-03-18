package com.dinsyaopin.contracts;


import com.dinsyaopin.GameBot;
import com.dinsyaopin.Suits;

public class Contract {
    private GameBot winner;
    private int tricks;
    private int weight;
    private Suits suit;
    private int whist;

    public GameBot getWinner() {
        return winner;
    }

    public void setWinner(GameBot winner) {
        this.winner = winner;
    }

    public int getTricks() {
        return tricks;
    }

    public void setTricks(int tricks) {
        this.tricks = tricks;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Contract(int tricks) {
        this.tricks = tricks;
        switch (tricks) {
            case 6 : setWhist(4); break;
            case 7 : setWhist(2); break;
            default : setWhist(1); break;
        }
    }

    public Suits getSuit() {
        return suit;
    }

    public int getWhist() {
        return whist;
    }

    public void setWhist(int whist) {
        this.whist = whist;
    }

    @Override
    public String toString() {
        return "Контракт без масти";
    }
}
