package com.dinsyaopin;

import com.dinsyaopin.contracts.Contract;

import java.util.ArrayList;

public class Table {
    private ArrayList<Card> cards = new ArrayList<>();
    private Contract winnerContract;

    public Table(Contract winnerContract) {
        this.winnerContract = winnerContract;
    }

    public void addCard(Card card) {
        cards.add(card);
    }
    public GameBot showTurnWinner(ArrayList<GameBot> gameBots) {

        return null;
    }
}
