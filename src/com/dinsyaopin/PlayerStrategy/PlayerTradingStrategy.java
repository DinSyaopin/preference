package com.dinsyaopin.PlayerStrategy;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.Ranks;

public interface PlayerTradingStrategy {
    int[] countElderCardsOfCertainSuits(GameBot gameBot, Ranks rank);
    String setContract(int[] elderCardsOfEachSuits, int quantityOfTricks);
    String checkElderCardsOfOneSuit(GameBot gameBot, Ranks rank, int quantityOfTricks);
    String checkNineElderCardsOfOneSuit(GameBot gameBot);
    String checkTenElderCardsOfOneSuit(GameBot gameBot);
    int countWinningCardsOfAllSuits(GameBot gameBot, Ranks rank, int counterOfWinningCards);
    String checkElderCardsOfAllSuits(GameBot gameBot, int totalWinCardsQuantity);
    public String checkNineElderCardsOfAllSuits(GameBot gameBot);
    public String checkTenElderCardsOfAllSuits(GameBot gameBot);
    public String checkMisere(GameBot gameBot);
}
