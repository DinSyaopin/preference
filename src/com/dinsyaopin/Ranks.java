package com.dinsyaopin;

public enum Ranks {
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);

    private final int value;

    Ranks(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
