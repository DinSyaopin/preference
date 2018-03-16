package com.dinsyaopin.PlayerStrategy.TurnsStrategy;

import com.dinsyaopin.Card;
import com.dinsyaopin.GameBot;
import com.dinsyaopin.Suits;
import com.dinsyaopin.contracts.Contract;

public class MasterTurnsStrategy implements PlayerTurnsStrategy{

    @Override
    public Card putPass(GameBot gameBot) {
        return null;
    }

    @Override
    public Card putCard(Contract winnerContract) {
        return null;
    }

    @Override
    public Card putPass(GameBot gameBot, Suits suit) {
        return null;
    }

    @Override
    public Card putMisere() {
        return null;
    }

    @Override
    public Card putNoTrump() {
        return null;
    }

    @Override
    public Card putTrump() {
        return null;
    }
}
