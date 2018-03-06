package com.dinsyaopin;

import java.util.ArrayList;

public class GameBot {
    public String botName;
    public ArrayList<Card> hand;
    private boolean winInTradeFlag;
    private int trick;

    public int getTrick() {
        return trick;
    }

    public void setTrick(int trick) {
        this.trick = trick;
    }

    public GameBot(String botName) {
        this.botName = botName;
    }

    public String getBotName() {
        return botName;
    }

    public ArrayList<Card> initializeHand(Deck deck) {
        ArrayList<Card> hand = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            hand.add(deck.getRandomCardFromDeck());
        }
        return hand;
    }

    public boolean toTrade() {
        //if (this.contract)
        //процедура торгов. Если выиграли, то вернуть флаг true.
        return winInTradeFlag;
    }

    public void takeBuyIn(Deck deck) {
        if (this.toTrade()) {
            hand.add(deck.getRandomCardFromDeck()); //здесь надо подумать, может быть разместить карты прикупа на столе и со стола забирать а не из колоды?
        }
    }

    public void putCard() {

    }
}