package com.dinsyaopin.PlayerStrategy.TurnsStrategy;

import com.dinsyaopin.Card;
import com.dinsyaopin.GameBot;
import com.dinsyaopin.Suits;
import com.dinsyaopin.contracts.*;

public class StudentTurnsStrategy implements PlayerTurnsStrategy {

    @Override
    public Card putCard(ContractWithoutSuit contract, GameBot gameBot, Suits suit) {
        return null;
    }

    @Override
    public Card putCard(Pass pass, GameBot gameBot, Suits suit) {
        return null;
    }

    @Override
    public Card putCard(Misere misere, GameBot gameBot, Suits suit) {
        return null;
    }

    @Override
    public Card putCard(ContractWithSuit contractWithSuit, GameBot gameBot, Suits suit) {
        return null;
    }
}
