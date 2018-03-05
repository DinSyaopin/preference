package com.dinsyaopin;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    public ArrayList<Card> cards = new ArrayList<>(32);
    public Deck() {
        for (int i = 1; i < 5; i++) {
            for (int j = 7; j < 15; j++) {
                cards.add(new Card(i, j));
            }
        }
    }
    public Card getRandomCardFromDeck() {
        Random random = new Random();
        int bound = cards.size();
        int randomNumber = random.nextInt(bound);
        Card card = cards.get(randomNumber);
        cards.remove(card);
        return card;
    }
}
