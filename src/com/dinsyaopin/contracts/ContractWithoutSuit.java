package com.dinsyaopin.contracts;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.Suits;

public class ContractWithoutSuit extends Contract {

    public ContractWithoutSuit(int tricks) {
        this.tricks = tricks;
        switch (tricks) {
            case 6 : setWhist(4); break;
            case 7 : setWhist(2); break;
            default : setWhist(1); break;
        }
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
    public Suits getSuit() {
        return this.suit;
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
        return "Контракт без масти";
    }
}
