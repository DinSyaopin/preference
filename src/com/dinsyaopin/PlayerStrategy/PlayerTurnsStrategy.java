package com.dinsyaopin.PlayerStrategy;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.contracts.Contract;

public interface PlayerTurnsStrategy {
    public void putCard(Contract winnerContract);
    public void putPass(GameBot gameBot);
    public void putMisere();
    public void putNoTrump();
    public void putTrump();
}
