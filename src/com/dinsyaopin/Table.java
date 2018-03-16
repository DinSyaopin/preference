package com.dinsyaopin;

import com.dinsyaopin.contracts.Contract;

import java.util.ArrayList;

public class Table {
    private ArrayList<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }
    public GameBot showTurnWinner(ArrayList<GameBot> gameBots) {
        return null;
    }
    public Card getFirstCard() {
        return cards.get(0);
    }
}