package com.dinsyaopin;

import org.junit.Assert;
import org.junit.Test;

public class CardTest extends Assert {
    private Card<Integer, String> card;
    @Test
    public void testCardInitialize() {
        card = new Card<Integer, String>(7, "hearts");
    }
}