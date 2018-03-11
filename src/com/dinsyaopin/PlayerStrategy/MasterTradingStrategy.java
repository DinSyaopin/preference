package com.dinsyaopin.PlayerStrategy;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.Ranks;

public class MasterTradingStrategy implements PlayerTradingStrategy {
    @Override
    public int[] countCardsOfCertainSuits(GameBot gameBot) {
        return new int[0];
    }

    @Override
    public String setContract(int[] elderCardsOfEachSuits, GameBot gameBot) {
        return null;
    }

    @Override
    public String checkElderCardsOfOneSuit(GameBot gameBot) {
        return null;
    }

    @Override
    public int countCurrentCard(GameBot gameBot, Ranks rank, int counterOfWinningCards) {
        return 0;
    }

    @Override
    public String checkElderCardsOfAllSuits(GameBot gameBot) {
        return null;
    }

    @Override
    public String checkMisere(GameBot gameBot) {
        return null;
    }
    @Override
    public String toTrade(GameBot gameBot, PlayerTradingStrategy playerTradingStrategy) {
        return null;
    }
}
