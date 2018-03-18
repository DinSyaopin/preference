package com.dinsyaopin;

import java.util.ArrayList;

public class Dealer {
    private Deck deck;

    public void giveCardsToPlayers(ArrayList<GameBot> gameBots) {
        for (GameBot gameBot:
             gameBots) {
            gameBot.setHand(gameBot.initializeHand(deck));
        }
    }
    public void giveBuyIn(GameBot gameBot) {
        for (int i = 0; i < 2; i++) {
            gameBot.addCardToHand(deck.getRandomCardFromDeck());
        }
    }

    public void initializeDeck() {
        deck = new Deck();
    }
}