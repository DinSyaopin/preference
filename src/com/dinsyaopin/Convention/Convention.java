package com.dinsyaopin.Convention;

import com.dinsyaopin.Card;
import com.dinsyaopin.GameBot;
import com.dinsyaopin.contracts.Contract;
import com.dinsyaopin.contracts.ContractWithSuit;
import com.dinsyaopin.contracts.Misere;
import com.dinsyaopin.contracts.Pass;

import java.util.ArrayList;

public abstract class Convention {
    public abstract int checkPoolMultiplier(Contract contract);
    public abstract int checkMountainMultiplier(Contract contract);
    /*public abstract void countPass(ArrayList<GameBot> gameBots);
    public abstract void countTricks(ArrayList<GameBot> gameBots, GameBot gameBotWithContract, Contract contract);
    public abstract void countMisere(GameBot gameBotWithContract);*/
    public abstract void countPoints(ArrayList<GameBot> bots, GameBot gameBotWithContract,  Contract winnerContract);
    public abstract void countPoints(ArrayList<GameBot> bots, GameBot gameBotWithContract,  ContractWithSuit winnerContract);
    public abstract void countPoints(ArrayList<GameBot> bots, GameBot gameBotWithContract,  Pass winnerContract);
    public abstract void countPoints(ArrayList<GameBot> bots, GameBot gameBotWithContract,  Misere winnerContract);
}
