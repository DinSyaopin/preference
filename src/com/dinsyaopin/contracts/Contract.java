package com.dinsyaopin.contracts;


import com.dinsyaopin.GameBot;
import com.dinsyaopin.Suits;

public abstract class Contract {
    GameBot winner;
    int tricks;
    int weight;
    Suits suit;
    int whist;

    public abstract void setWinner(GameBot gameBot);
    public abstract int getWeight();
    public abstract GameBot getWinner();
    public abstract Suits getSuit();
    public abstract int getWhist();
    public abstract int getTricks();
}
