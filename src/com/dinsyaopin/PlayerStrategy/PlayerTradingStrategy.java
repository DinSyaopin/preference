package com.dinsyaopin.PlayerStrategy;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.Ranks;

public interface PlayerTradingStrategy {
    int[] countCardsOfCertainSuits(GameBot gameBot);
    String setContract(int[] elderCardsOfEachSuits, GameBot gameBot);
    String checkElderCardsOfOneSuit(GameBot gameBot);
    int countCurrentCard(GameBot gameBot, Ranks rank, int counterOfWinningCards);
    String checkElderCardsOfAllSuits(GameBot gameBot);
    String checkMisere(GameBot gameBot);
    String toTrade(GameBot gameBot, PlayerTradingStrategy playerTradingStrategy);

    /*Надо сделать процесс торговли зависимым от уровня игрока.
    -Новичок не перебивает контракт другого игрока.
    -Студент перебивает до мизера.
    -Мастер перебивает всё.
    */
}
