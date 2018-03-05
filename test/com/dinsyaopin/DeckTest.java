package com.dinsyaopin;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class DeckTest extends Assert {
    @Test
    public void testDeckCreation() {
        Deck deck = new Deck();
        assertEquals(32, deck.cards.size());
    }
}
