package com.dinsyaopin.Convention;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.contracts.Contract;

import java.util.ArrayList;

public class LeningradConvention extends Convention {

    @Override
    public int checkMultiplier(Contract contract) {
        if (contract.getTricks() == 6) {
            return 2;
        }
        if (contract.getTricks() == 7) {
            return 4;
        }
        if (contract.getTricks() == 8) {
            return 6;
        }
        if (contract.getTricks() == 8) {
            return 8;
        }
        if (contract.getTricks() == 9) {
            return 10;
        }
        return 0;
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
            if (gameBot == gameBotWithContract) {
                if (gameBot.getTricks() == contract.getTricks()) {
                    //checkMultiplier
                    //gameBot.addToPool();
                }
            }

        }
    }

    @Override
    public void countMisere(GameBot gameBotWithContract) {
        if (gameBotWithContract.getTricks() == 0) {
            gameBotWithContract.addToPool(10);
        }
        else gameBotWithContract.addToMountain(gameBotWithContract.getTricks() * 20);
    }
}
