package com.dinsyaopin;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void checkCountOfCardsInPlayerHand() {
        Dealer dealer = new Dealer();
        GameBot bot1 = new GameBot("Player1");
        GameBot bot2 = new GameBot("Player2");
        GameBot bot3 = new GameBot("Player3");
        dealer.initializeDeck();
        dealer.giveCardsToPlayer(bot1);
        dealer.giveCardsToPlayer(bot2);
        dealer.giveCardsToPlayer(bot3);
        assertEquals(10, bot1.hand.size());
        assertEquals(10, bot2.hand.size());
        assertEquals(10, bot3.hand.size());
        System.out.println("Заглушка");
    }
}