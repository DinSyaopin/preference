package com.dinsyaopin.Convention;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.contracts.Contract;

import java.util.ArrayList;

public class RostovConvention extends Convention {
    @Override
    public String toString() {
        return "Rostov";
    }

    @Override
    public int checkPoolMultiplier(Contract contract) {
        return 0;
    }

    @Override
    public int checkMountainMultiplier(Contract contract) {
        return 0;
    }

    @Override
    public void countPass(ArrayList<GameBot> gameBots) {

    }

    @Override
    public void countTricks(ArrayList<GameBot> gameBots, GameBot gameBotWithContract, Contract contract) {

    }

    @Override
    public void countMisere(GameBot gameBotWithContract) {

    }
}
