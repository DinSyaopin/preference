package com.dinsyaopin.Convention;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.contracts.Contract;
import com.dinsyaopin.contracts.ContractWithSuit;
import com.dinsyaopin.contracts.Misere;
import com.dinsyaopin.contracts.Pass;

import java.util.ArrayList;

public abstract class Convention {
    public abstract int checkPoolMultiplier(Contract contract);
    public abstract int checkMountainMultiplier(Contract contract);
    public abstract void countPoints(ArrayList<GameBot> bots, Contract winnerContract);
    public abstract void countPoints(ArrayList<GameBot> bots, ContractWithSuit winnerContract);
    public abstract void countPoints(ArrayList<GameBot> bots, Pass winnerContract);
    public abstract void countPoints(ArrayList<GameBot> bots, Misere winnerContract);
}
