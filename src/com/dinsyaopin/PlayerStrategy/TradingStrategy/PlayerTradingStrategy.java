package com.dinsyaopin.PlayerStrategy.TradingStrategy;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.Ranks;
import com.dinsyaopin.contracts.Contract;

import java.util.ArrayList;

public interface PlayerTradingStrategy {
    int[] countCardsOfCertainSuits(GameBot gameBot);
    Contract setContractWithTrump(int[] elderCardsOfEachSuits, GameBot gameBot);
    Contract checkElderCardsOfOneSuit(GameBot gameBot);
    int countCurrentCard(GameBot gameBot, Ranks rank, int counterOfWinningCards);
    Contract checkElderCardsOfAllSuits(GameBot gameBot);
    Contract checkMisere(GameBot gameBot);
    Contract checkContract(GameBot gameBot);
    Contract toTrade(ArrayList<GameBot> gameBot);
    void tradeWhists(Contract contract, ArrayList<GameBot> gameBots);
    ArrayList<GameBot> takeBotsWithoutContract(ArrayList<GameBot> gameBots, Contract winnerContract);
    /*Надо сделать процесс торговли зависимым от уровня игрока.
    -Новичок не перебивает контракт другого игрока.
    -Студент перебивает до мизера.
    -Мастер перебивает всё.
    */
}
