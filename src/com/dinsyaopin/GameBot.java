package com.dinsyaopin;

import java.util.ArrayList;

public class GameBot {
    public String botName;
    public ArrayList<Card> hand;

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
}
