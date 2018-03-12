package com.dinsyaopin.contracts;


public class Contract {
    private int tricks;
    private int weight;

    public int getTricks() {
        return tricks;
    }

    public void setTricks(int tricks) {
        this.tricks = tricks;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Contract(int tricks) {
        this.tricks = tricks;
    }
}
