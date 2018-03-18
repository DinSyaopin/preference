package com.dinsyaopin.contracts;

public class Pass extends Contract {
    private static final int WEIGHT = 0;

    public int getWeight() {
        return WEIGHT;
    }

    public Pass(int tricks) {
        super(tricks);
    }

    @Override
    public String toString() {
        return "Пас";
    }
}
