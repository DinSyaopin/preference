package com.dinsyaopin;

import org.junit.Test;

public class CardTest {
    private Card<Integer, String> card;
    @Test
    public void testCard() {
        card = new Card<Integer, String>(7, "Jack");
    }
}