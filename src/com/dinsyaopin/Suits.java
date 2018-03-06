package com.dinsyaopin;

public enum Suits {
    SPADES(0),
    CLUBS(1),
    DIAMONDS(2),
    HEARTS(3);

    private final int value;

    Suits(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}