package com.dinsyaopin.contracts;

import com.dinsyaopin.Suits;

public class ContractWithSuit extends Contract {
    private Suits suit;

    public Suits getSuit() {
        return suit;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    public ContractWithSuit(int tricks, Suits suit) {
        super(tricks);
        this.suit = suit;
    }
}