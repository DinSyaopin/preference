package com.dinsyaopin;

import java.util.ArrayList;
import java.util.Arrays;

public class GameBot {
    public String botName;
    public ArrayList<Card> hand;
    private boolean winInTradeFlag;
    private int trick;
    private String contract;

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

    /*public ArrayList<Card> initializeHand(Deck deck) {
        ArrayList<Card> hand = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            hand.add(deck.getRandomCardFromDeck());
        }
        return hand;
    }*/

    public String toTrade() {
        int[] suitsCounterArray = {0, 0, 0, 0};

        for (Card c:
             hand) {
            if (c.rank.getValue() >= Ranks.JACK.getValue()) {
                suitsCounterArray[c.suit.getValue()]++;
                }
            }
        for(int i = 0; i < suitsCounterArray.length; i++)
        {
            if (suitsCounterArray[i] == 4)
                return "6 " + Suits.values()[i];
        }
        return contract;
    }

    /*public void takeBuyIn(Deck deck) {
        if (this.toTrade()) {
            hand.add(deck.getRandomCardFromDeck()); //здесь надо подумать, может быть разместить карты прикупа на столе и со стола забирать а не из колоды?
        }
    }*/

    public void putCard() {

    }


}