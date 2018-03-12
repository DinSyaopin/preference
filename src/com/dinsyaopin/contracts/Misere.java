package com.dinsyaopin.contracts;

public class Misere extends Contract {
    public final int weight = 16;

    @Override
    public int getWeight() {
        return weight;
    }

    public Misere(int tricks) {
        super(tricks);
    }
}
