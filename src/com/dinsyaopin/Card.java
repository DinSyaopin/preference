package com.dinsyaopin;

public class Card {
    public Suits suit;
    public Ranks rank;

    public Card( Ranks cardRank, Suits cardSuit) {
        rank = cardRank;
        suit = cardSuit;
    }
}
