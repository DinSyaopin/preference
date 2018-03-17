package com.dinsyaopin.Convention;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.contracts.Contract;
import com.dinsyaopin.contracts.ContractWithSuit;
import com.dinsyaopin.contracts.Misere;
import com.dinsyaopin.contracts.Pass;

import java.util.ArrayList;

public class RostovConvention extends Convention {
    @Override
    public int checkPoolMultiplier(Contract contract) {
        switch (contract.getTricks()) {
            case 6 : return 2;
            case 7 : return 4;
            case 8 : return 6;
            case 9 : return 8;
            case 10 : return 10;
            default: return 2;
        }
    }

    @Override
    public int checkMountainMultiplier(Contract contract) {
        switch (contract.getTricks()) {
            case 6 : return 2;
            case 7 : return 4;
            case 8 : return 6;
            case 9 : return 8;
            case 10 : return 10;
            default: return 2;
        }
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
        if (gameBotWithContract.getTricks() == 0) {
            gameBotWithContract.addToPool(10);
        }
        else gameBotWithContract.addToMountain(gameBotWithContract.getTricks() * 10);
    }

    @Override
    public String toString() {
        return "Rostov";
    }
}
