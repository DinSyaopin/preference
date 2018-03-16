package com.dinsyaopin.PlayerStrategy.TurnsStrategy;

import com.dinsyaopin.Card;
import com.dinsyaopin.GameBot;
import com.dinsyaopin.Suits;
import com.dinsyaopin.contracts.Contract;
import com.dinsyaopin.contracts.ContractWithSuit;
import com.dinsyaopin.contracts.Misere;
import com.dinsyaopin.contracts.Pass;

public class MasterTurnsStrategy implements PlayerTurnsStrategy{

    @Override
    public Card putCard(Contract contract, GameBot gameBot, Suits suit) {
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
