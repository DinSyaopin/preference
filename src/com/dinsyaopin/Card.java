package com.dinsyaopin;

public class Card {
    public Suits suit;
    public Ranks rank;

    public Card(int cardSuit, int cardRank) {
        switch (cardSuit) {
            case 0 : suit = Suits.HEARTS; break;
            case 1 : suit = Suits.DIAMONDS; break;
            case 2 : suit = Suits.CLUBS; break;
            case 3 : suit = Suits.SPADES; break;
            default: suit = null;
                System.out.println("Incompatible suit.");
        }
        switch (cardRank) {
            case 7 : rank = Ranks.SEVEN; break;
            case 8 : rank = Ranks.EIGHT; break;
            case 9 : rank = Ranks.NINE; break;
            case 10 : rank = Ranks.TEN; break;
            case 11 : rank = Ranks.JACK; break;
            case 12 : rank = Ranks.QUEEN; break;
            case 13 : rank = Ranks.KING; break;
            case 14 : rank = Ranks.ACE; break;
            default: rank = null;
                System.out.println("Incompatible rank.");
        }
    }
}
