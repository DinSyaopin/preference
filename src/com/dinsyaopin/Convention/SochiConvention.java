package com.dinsyaopin.Convention;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.contracts.Contract;
import com.dinsyaopin.contracts.ContractWithSuit;
import com.dinsyaopin.contracts.Misere;
import com.dinsyaopin.contracts.Pass;

import java.util.ArrayList;
import java.util.Arrays;

public class SochiConvention extends Convention {

    @Override
    public int checkWhistsMultiplier(Contract contract) {
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
    public int checkRemiseGameMultiplier(Contract contract) {
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
    public int checkRemiseWhistsMultiplier(Contract contract) {
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
    public void countPoints(ArrayList<GameBot> gameBots, Pass winnerContract) {
        int[] tricksArray = {gameBots.get(0).getTricks(),gameBots.get(1).getTricks(), gameBots.get(2).getTricks()};
        Arrays.sort(tricksArray);
        for (GameBot gameBot:
                gameBots) {
            if (gameBot.getTricks() == 0) {
                gameBot.addToPool(1);
            }
            else {
                gameBot.setTrick(gameBot.getTricks() - tricksArray[0]);
                if (gameBot.getTricks() != 0) {
                    gameBot.addToMountain(gameBot.getTricks() * 2);
                }
            }
        }
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
        return "Sochi";
    }
}
