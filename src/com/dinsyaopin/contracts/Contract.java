package com.dinsyaopin.contracts;


public class Contract {
    private int tricks;

    public int getTricks() {
        return tricks;
    }

    public void setTricks(int tricks) {
        this.tricks = tricks;
    }

    public Contract(int tricks) {
        this.tricks = tricks;
    }
}
