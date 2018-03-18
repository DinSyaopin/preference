package com.dinsyaopin.Convention;

import com.dinsyaopin.Game;
import com.dinsyaopin.GameBot;
import com.dinsyaopin.contracts.Contract;
import com.dinsyaopin.contracts.ContractWithSuit;
import com.dinsyaopin.contracts.Misere;
import com.dinsyaopin.contracts.Pass;

import java.util.ArrayList;
import java.util.Arrays;

public class RostovConvention extends Convention {

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
            case 6 : return 1;
            case 7 : return 2;
            case 8 : return 3;
            case 9 : return 4;
            case 10 : return 5;
            default: return 1;
        }
    }

    @Override
    public void countPoints(ArrayList<GameBot> gameBots, Pass winnerContract) {
        GameBot bot1 = gameBots.get(0);
        GameBot bot2 = gameBots.get(1);
        GameBot bot3 = gameBots.get(2);
        int whistMultiplier = 5;
        int[] tricksArray = {bot1.getTricks(), bot2.getTricks(), bot3.getTricks()};
        Arrays.sort(tricksArray);
        GameBot looser = new GameBot("");
        for (GameBot gameBot:
                gameBots) {
            if (gameBot.getTricks() == tricksArray[2]) {
                looser = gameBot;
            }
        }
        for (GameBot gameBot:
                gameBots) {
            if (gameBot.getTricks() == 0) {
                gameBot.addToPool(1);
                gameBot.addWhists(gameBot.getBotLeft(), gameBot.getBotLeft().getTricks() * whistMultiplier);
                gameBot.addWhists(gameBot.getBotRight(), gameBot.getBotRight().getTricks() * whistMultiplier);
            }
            else {
                if (tricksArray[0] == tricksArray[1] && gameBot.getTricks() == tricksArray[0]) {
                    gameBot.addWhists(looser, looser.getTricks() * whistMultiplier / 2);
                }
                else {
                    if (gameBot.getTricks() == tricksArray[0]) {
                        gameBot.addWhists(gameBot.getBotLeft(), gameBot.getBotLeft().getTricks() * whistMultiplier);
                        gameBot.addWhists(gameBot.getBotRight(), gameBot.getBotRight().getTricks() * whistMultiplier);
                    }
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
        return "Rostov";
    }
}
