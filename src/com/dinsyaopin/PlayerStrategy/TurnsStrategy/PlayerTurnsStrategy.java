package com.dinsyaopin.PlayerStrategy.TurnsStrategy;

import com.dinsyaopin.Card;
import com.dinsyaopin.GameBot;
import com.dinsyaopin.Suits;
import com.dinsyaopin.contracts.Contract;

public interface PlayerTurnsStrategy {
    //public Card putCard(Contract winnerContract);
    public Card putPass(GameBot gameBot);
    public Card putPass(GameBot gameBot, Suits suit);
    public Card putMisere();
    public Card putNoTrump();
    public Card putTrump();
}
