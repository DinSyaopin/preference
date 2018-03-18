package com.dinsyaopin.Convention;

import com.dinsyaopin.Game;
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
    public void countPoints(ArrayList<GameBot> bots, Contract winnerContract) {

    }

    @Override
    public void countPoints(ArrayList<GameBot> bots, ContractWithSuit winnerContract) {

    }

    @Override
    public void countPoints(ArrayList<GameBot> bots, Pass winnerContract) {

    }

    @Override
    public void countPoints(ArrayList<GameBot> bots, Misere winnerContract) {
        GameBot botWithContract = winnerContract.getWinner();
        if (botWithContract.getTricks() == 0) {
            botWithContract.addToPool(10);
        }
        else botWithContract.addToMountain(botWithContract.getTricks() * 10);
    }

    @Override
    public String toString() {
        return "Rostov";
    }
}
