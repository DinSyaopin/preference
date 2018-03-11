package com.dinsyaopin.PlayerStrategy;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.Ranks;

public interface PlayerTradingStrategy {
    int[] countElderCardsOfCertainSuits(GameBot gameBot, Ranks rank);
    String setContract(int[] elderCardsOfEachSuits, int quantityOfTricks);
    String checkElderCardsOfOneSuit(GameBot gameBot, Ranks rank, int quantityOfTricks);
    String checkNineTenElderCardsOfOneSuit(GameBot gameBot);
    int countWinningCardsOfAllSuits(GameBot gameBot, Ranks rank, int counterOfWinningCards);
    String checkElderCardsOfAllSuits(GameBot gameBot, int totalWinCardsQuantity);
    public String checkNineTenElderCardsOfAllSuits(GameBot gameBot);
    public String checkMisere(GameBot gameBot);

    /*Надо сделать процесс торговли зависимым от уровня игрока.
    -Новичок не перебивает контракт другого игрока.
    -Студент перебивает до мизера.
    -Мастер перебивает всё.
    */
}
