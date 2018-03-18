package com.dinsyaopin.PlayerStrategy.TradingStrategy;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.Ranks;
import com.dinsyaopin.contracts.Contract;

import java.util.ArrayList;

public class MasterTradingStrategy implements PlayerTradingStrategy {
    @Override
    public int[] countCardsOfCertainSuits(GameBot gameBot) {
        return new int[0];
    }

    @Override
    public Contract setContractWithTrump(int[] elderCardsOfEachSuits, GameBot gameBot) {
        return null;
    }

    @Override
    public Contract checkElderCardsOfOneSuit(GameBot gameBot) {
        return null;
    }

    @Override
    public int countCurrentCard(GameBot gameBot, Ranks rank, int counterOfWinningCards) {
        return 0;
    }

    @Override
    public Contract checkElderCardsOfAllSuits(GameBot gameBot) {
        return null;
    }

    @Override
    public Contract checkMisere(GameBot gameBot) {
        return null;
    }

    @Override
    public Contract checkContract(GameBot gameBot) {
        return null;
    }

    @Override
    public Contract toTrade(ArrayList<GameBot> gameBot) {
        return null;
    }

    @Override
    public void tradeWhists(Contract contract, ArrayList<GameBot> gameBots) {

    }

    @Override
    public ArrayList<GameBot> takeBotsWithoutContract(ArrayList<GameBot> gameBots, Contract winnerContract) {
        return null;
    }
}
