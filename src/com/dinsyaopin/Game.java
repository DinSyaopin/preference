package com.dinsyaopin;

public class Game {
    public static void main(String[] args) {
        //System.out.println("start");
        Deck deck = new Deck();
        GameBot bot1 = new GameBot();
        bot1.hand = bot1.initializeHand(deck);
        GameBot bot2 = new GameBot();
        bot2.hand = bot2.initializeHand(deck);
        GameBot bot3 = new GameBot();
        bot3.hand = bot3.initializeHand(deck);
    }
}