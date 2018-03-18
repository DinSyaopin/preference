package com.dinsyaopin.Convention;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.contracts.Contract;
import com.dinsyaopin.contracts.ContractWithSuit;
import com.dinsyaopin.contracts.Misere;
import com.dinsyaopin.contracts.Pass;

import java.util.ArrayList;
import java.util.Arrays;

public class LeningradConvention extends Convention {

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
            case 6 : return 4;
            case 7 : return 8;
            case 8 : return 12;
            case 9 : return 16;
            case 10 : return 20;
            default: return 4;
        }
    }

    @Override
    public void countPoints(ArrayList<GameBot> gameBots, Pass pass) {//ready
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
    public void countPoints(ArrayList<GameBot> gameBots, Contract contract) {
        GameBot botWithContract = contract.getWinner();
        for (GameBot gameBot:
                gameBots) {
            int penalty = contract.getTricks() - gameBot.getTricks();

            if (gameBot == botWithContract) {
                if (gameBot.getTricks() == contract.getTricks()) {
                    gameBot.addToPool(contract.getTricks() * checkPoolMultiplier(contract));
                }
                else {
                    gameBot.addToMountain(penalty * checkMountainMultiplier(contract));
                }
            }/*
            else {
                if (gameBot.whisting()) {
                    if (gameBot.getTricks() == contract.getWhists()) {
                        gameBot.addToWhists(contract.getTricks() * checkWhistsMultiplier(contract));
                    }
                    else {
                        gameBot.addToMountain(penalty * checkMountainMultiplier(contract) / 2);
                        gameBot.addToWhists();
                    }
                }
            }*/
        }
    }

    @Override
    public void countPoints(ArrayList<GameBot> bots, ContractWithSuit winnerContract) {

    }

    @Override
    public void countPoints(ArrayList<GameBot> gameBots, Misere misere) {
        GameBot botWithContract = misere.getWinner();
        if (botWithContract.getTricks() == 0) {
            botWithContract.addToPool(10);
        }
        else botWithContract.addToMountain(botWithContract.getTricks() * 20);
    }

    @Override
    public String toString() {
        return "Leningrad";
    }
}
