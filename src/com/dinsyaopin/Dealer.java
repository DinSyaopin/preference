package com.dinsyaopin;

public class Dealer {
    private Deck deck;

    public void giveCardsToPlayer(GameBot gameBot) {
        gameBot.hand = gameBot.initializeHand(deck);
    }

    public void initializeDeck() {
        deck = new Deck();
    }
}