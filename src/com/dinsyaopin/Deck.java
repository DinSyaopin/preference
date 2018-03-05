package com.dinsyaopin;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<>(32);
    public Deck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 7; j < 14; j++) {
                cards.add(new Card(i, j));
            }
        }
    }
    public Card getCardFromDeck() {
        Random random = new Random();
        Card card = cards.get(random.nextInt());
        cards.remove(card);
        return card;
    }
}
