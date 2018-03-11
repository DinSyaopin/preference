package com.dinsyaopin.PlayerStrategy;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.Ranks;

public class MasterTradingStrategy implements PlayerTradingStrategy {
    @Override
    public int[] countElderCardsOfCertainSuits(GameBot gameBot, Ranks rank) {
        return new int[0];
    }

    @Override
    public String setContract(int[] elderCardsOfEachSuits, int quantityOfTricks) {
        return null;
    }

    @Override
    public String checkElderCardsOfOneSuit(GameBot gameBot, Ranks rank, int quantityOfTricks) {
        return null;
    }

    @Override
    public String checkNineElderCardsOfOneSuit(GameBot gameBot) {
        return null;
    }

    @Override
    public String checkTenElderCardsOfOneSuit(GameBot gameBot) {
        return null;
    }

    @Override
    public int countWinningCardsOfAllSuits(GameBot gameBot, Ranks rank, int counterOfWinningCards) {
        return 0;
    }

    @Override
    public String checkElderCardsOfAllSuits(GameBot gameBot, int totalWinCardsQuantity) {
        return null;
    }

    @Override
    public String checkNineElderCardsOfAllSuits(GameBot gameBot) {
        return null;
    }

    @Override
    public String checkTenElderCardsOfAllSuits(GameBot gameBot) {
        return null;
    }

    @Override
    public String checkMisere(GameBot gameBot) {
        return null;
    }
}
