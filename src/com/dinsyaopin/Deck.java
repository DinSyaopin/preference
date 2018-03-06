package com.dinsyaopin;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    public ArrayList<Card> cards = new ArrayList<>(32);
    public Deck() {
        for (Ranks r:
             Ranks.values()) {
            for (Suits s:
                 Suits.values()) {
                cards.add(new Card(r, s));
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
