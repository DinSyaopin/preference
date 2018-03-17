package com.dinsyaopin.Convention;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.contracts.Contract;
import com.dinsyaopin.contracts.ContractWithSuit;
import com.dinsyaopin.contracts.Misere;
import com.dinsyaopin.contracts.Pass;

import java.util.ArrayList;

public class SochiConvention extends Convention {
    @Override
    public int checkPoolMultiplier(Contract contract) {
        return 0;
    }

    @Override
    public int checkMountainMultiplier(Contract contract) {
        return 0;
    }

    @Override
    public void countPoints(ArrayList<GameBot> bots, GameBot gameBotWithContract, Contract winnerContract) {

    }

    @Override
    public void countPoints(ArrayList<GameBot> bots, GameBot gameBotWithContract, ContractWithSuit winnerContract) {

    }

    @Override
    public void countPoints(ArrayList<GameBot> bots, GameBot gameBotWithContract, Pass winnerContract) {

    }

    @Override
    public void countPoints(ArrayList<GameBot> bots, GameBot gameBotWithContract, Misere winnerContract) {

    }
}
