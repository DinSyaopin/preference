package com.dinsyaopin.contracts;

public class Misere extends Contract {
    private static final int WEIGHT = 16;

    @Override
    public int getWeight() {
        return WEIGHT;
    }

    public Misere(int tricks) {
        super(tricks);
    }

    @Override
    public String toString() {
        return "Мизер";
    }
}
