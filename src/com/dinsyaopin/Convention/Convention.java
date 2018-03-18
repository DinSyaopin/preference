package com.dinsyaopin.Convention;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.contracts.Contract;
import com.dinsyaopin.contracts.ContractWithSuit;
import com.dinsyaopin.contracts.Misere;
import com.dinsyaopin.contracts.Pass;

import java.util.ArrayList;

public abstract class Convention {
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
    public abstract int checkWhistsMultiplier(Contract contract);
    public abstract int checkRemiseGameMultiplier(Contract contract);
    public abstract int checkRemiseWhistsMultiplier(Contract contract);
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
                    gameBot.addToMountain(penalty * checkRemiseGameMultiplier(contract));
                }
            }
            else {
                if (gameBot.isWhisting()) {
                    if (gameBot.getTricks() >= contract.getWhist()) {
                        gameBot.addWhists(contract.getWinner(),contract.getWhist() * checkWhistsMultiplier(contract));
                    }
                    else {
                        penalty = contract.getWhist() - gameBot.getTricks();
                        gameBot.addToMountain(penalty * checkRemiseWhistsMultiplier(contract));
                    }
                }
            }
        }
    }
    public void countPoints(ArrayList<GameBot> gameBots, ContractWithSuit contract) {
        GameBot botWithContract = contract.getWinner();
        for (GameBot gameBot:
                gameBots) {
            int penalty = contract.getTricks() - gameBot.getTricks();

            if (gameBot == botWithContract) {
                if (gameBot.getTricks() == contract.getTricks()) {
                    gameBot.addToPool(contract.getTricks() * checkPoolMultiplier(contract));
                }
                else {
                    gameBot.addToMountain(penalty * checkRemiseGameMultiplier(contract));
                }
            }
            else {
                if (gameBot.isWhisting()) {
                    if (gameBot.getTricks() >= contract.getWhist()) {
                        gameBot.addWhists(contract.getWinner(),contract.getWhist() * checkWhistsMultiplier(contract));
                    }
                    else {
                        penalty = contract.getWhist() - gameBot.getTricks();
                        gameBot.addToMountain(penalty * checkRemiseWhistsMultiplier(contract));
                    }
                }
            }
        }
    }
    public abstract void countPoints(ArrayList<GameBot> bots, Pass winnerContract);
    public abstract void countPoints(ArrayList<GameBot> bots, Misere winnerContract);
}
