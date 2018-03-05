package com.dinsyaopin;

public enum Suits {
    SPADES(1),
    CLUBS(2),
    DIAMONDS(3),
    HEARTS(4);

    private final int value;

    Suits(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}