package com.dinsyaopin.PlayerStrategy.TurnsStrategy;

import com.dinsyaopin.Card;
import com.dinsyaopin.GameBot;
import com.dinsyaopin.Suits;
import com.dinsyaopin.contracts.*;

public interface PlayerTurnsStrategy {
    public Card putCard(Contract contract, GameBot gameBot, Suits suit);
    public Card putCard(Pass pass, GameBot gameBot, Suits suit);
    public Card putCard(Misere misere, GameBot gameBot, Suits suit);
    public Card putCard(ContractWithSuit contractWithSuit, GameBot gameBot, Suits suit);
}
