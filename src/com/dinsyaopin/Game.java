package com.dinsyaopin;

public class Game {
    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        GameBot bot1 = new GameBot("Player1");
        GameBot bot2 = new GameBot("Player2");
        GameBot bot3 = new GameBot("Player3");
        dealer.initializeDeck();
        dealer.giveCardsToPlayer(bot1);
        dealer.giveCardsToPlayer(bot2);
        dealer.giveCardsToPlayer(bot3);
    }
}