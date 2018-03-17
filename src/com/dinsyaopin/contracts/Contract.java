package com.dinsyaopin.contracts;


import com.dinsyaopin.GameBot;
import com.dinsyaopin.Suits;

public class Contract {
    private GameBot winner;
    private int tricks;
    private int weight;
    private Suits suit;

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
    }

    public Suits getSuit() {
        return suit;
    }
}
