package com.dinsyaopin.contracts;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.Suits;

public class ContractWithSuit extends Contract {
    private Suits suit;

    public Suits getSuit() {
        return suit;
    }

    public ContractWithSuit(int tricks, Suits suit) {
        this.tricks = tricks;
        switch (tricks) {
            case 6 : setWhist(4); break;
            case 7 : setWhist(2); break;
            default : setWhist(1); break;
        }
        this.suit = suit;
    }

    public void setWhist(int whist) {
        this.whist = whist;
    }

    public void setWinner(GameBot gameBot) {
        this.winner = gameBot;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public GameBot getWinner() {
        return this.winner;
    }

    @Override
    public int getWhist() {
        return this.whist;
    }

    @Override
    public int getTricks() {
        return this.tricks;
    }

    @Override
    public String toString() {
        return "Контракт с мастью";
    }
}