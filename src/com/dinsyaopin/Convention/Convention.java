package com.dinsyaopin.Convention;

import com.dinsyaopin.Card;
import com.dinsyaopin.GameBot;
import com.dinsyaopin.contracts.Contract;

import java.util.ArrayList;

public abstract class Convention {

    public abstract int checkPoolMultiplier(Contract contract);
    public abstract int checkMountainMultiplier(Contract contract);
    public abstract void countPass(ArrayList<GameBot> gameBots);
    public abstract void countTricks(ArrayList<GameBot> gameBots, GameBot gameBotWithContract, Contract contract);
    public abstract void countMisere(GameBot gameBotWithContract);
}
