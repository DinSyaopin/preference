package com.dinsyaopin.Convention;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.contracts.Contract;

import java.util.ArrayList;

public class LeningradConvention extends Convention {

    @Override
    public int checkPoolMultiplier(Contract contract) {
        switch (contract.getTricks()) {
            case 6 : return 2;
            case 7 : return 4;
            case 8 : return 6;
            case 9 : return 10;
            default: return 0;
        }
    }

    @Override
    public int checkMountainMultiplier(Contract contract) {
        switch (contract.getTricks()) {
            case 6 : return 4;
            case 7 : return 8;
            case 8 : return 12;
            case 9 : return 16;
            default: return 20;
        }
    }

    @Override
    public void countPass(ArrayList<GameBot> gameBots) {
        for (GameBot gameBot:
                gameBots) {
            if (gameBot.getTricks() == 0) {
                gameBot.addToPool(1);
            }
            else {
                gameBot.addToMountain(gameBot.getTricks() * 2);
            }
        }
    }

    @Override
    public void countTricks(ArrayList<GameBot> gameBots, GameBot gameBotWithContract, Contract contract) {
        for (GameBot gameBot:
                gameBots) {
            int penalty = contract.getTricks() - gameBot.getTricks();

            if (gameBot == gameBotWithContract) {
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
    public void countMisere(GameBot gameBotWithContract) {
        if (gameBotWithContract.getTricks() == 0) {
            gameBotWithContract.addToPool(10);
        }
        else gameBotWithContract.addToMountain(gameBotWithContract.getTricks() * 20);
    }

    @Override
    public String toString() {
        return "Leningrad";
    }
}
