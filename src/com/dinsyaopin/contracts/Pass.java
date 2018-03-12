package com.dinsyaopin.contracts;

public class Pass extends Contract {
    public final int weight = 0;

    public int getWeight() {
        return weight;
    }

    public Pass(int tricks) {
        super(tricks);
    }
}
