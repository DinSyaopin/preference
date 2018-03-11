package com.dinsyaopin.PlayerStrategy;

import com.dinsyaopin.Card;
import com.dinsyaopin.GameBot;
import com.dinsyaopin.Suits;
import com.dinsyaopin.Ranks;

public class NoviceTradingStrategy implements PlayerTradingStrategy {
    @Override
    public int[] countElderCardsOfCertainSuits(GameBot gameBot, Ranks rank) {
        int[] elderCardsOfEachSuits = {0, 0, 0, 0};
        for (Card c:
                gameBot.hand) {
            if (c.rank.getValue() >= rank.getValue()) {
                elderCardsOfEachSuits[c.suit.getValue()]++;
            }
        }
        return elderCardsOfEachSuits;
    }

    @Override
    public String setContract(int[] elderCardsOfEachSuits, int quantityOfTricks) {
        String currentContract = "";
        for(int i = 0; i < elderCardsOfEachSuits.length; i++) {
            if (elderCardsOfEachSuits[i] == quantityOfTricks) {
                currentContract = quantityOfTricks + " " + Suits.values()[i];
            }
            else currentContract = "";
        }
        return currentContract;
    }

    @Override
    public String checkElderCardsOfOneSuit(GameBot gameBot, Ranks rank, int quantityOfTricks) {
        int[] suitsCounterArray = countElderCardsOfCertainSuits(gameBot, rank); //fill array with cards value higher or equal rank
        return setContract(suitsCounterArray, quantityOfTricks);
    }

    @Override
    public String checkNineTenElderCardsOfOneSuit(GameBot gameBot) {
        int[] suitsCounterArray = countElderCardsOfCertainSuits(gameBot, Ranks.SEVEN);
        int countOfAcesNotTrump = 0;
        String currentContract = "";
        for(int i = 0; i < suitsCounterArray.length; i++)
        {
            if (suitsCounterArray[i] == 8) {
                for (Card c:
                        gameBot.hand) {
                    if (c.rank.getValue() == Ranks.ACE.getValue() && c.suit.getValue() != i ) { //find Ace without trump suit
                        countOfAcesNotTrump++;
                    }
                }
            }
            if (countOfAcesNotTrump == 1) {
                currentContract = "9 " + Suits.values()[i];
            }
            else if (countOfAcesNotTrump == 2) {
                currentContract = "10 " + Suits.values()[i];

            }
            else currentContract = "";
        }
        return currentContract;
    }

    @Override
    public int countWinningCardsOfAllSuits(GameBot gameBot, Ranks rank, int counterOfWinningCards) {
        for (Card c :
                gameBot.hand) {
            if (c.rank.getValue() == rank.getValue()) counterOfWinningCards++;
        }
        return counterOfWinningCards;
    }

    @Override
    public String checkElderCardsOfAllSuits(GameBot gameBot, int totalWinCardsQuantity) {
        int counterOfWinningCards = 0;
        String currentContract = "";
        counterOfWinningCards = countWinningCardsOfAllSuits(gameBot, Ranks.ACE, counterOfWinningCards);
        if (counterOfWinningCards == 4) {
            counterOfWinningCards = countWinningCardsOfAllSuits(gameBot, Ranks.KING, counterOfWinningCards);
            if (counterOfWinningCards == totalWinCardsQuantity) {
                currentContract = totalWinCardsQuantity + "_NO_TRUMP";
            }
        }
        return currentContract;
    }

    @Override
    public String checkNineTenElderCardsOfAllSuits(GameBot gameBot) {
        int counterOfWinningCards = 0;
        String currentContract = "";
        for (Card c :
                gameBot.hand) {
            if (c.rank.getValue() >= Ranks.KING.getValue()) counterOfWinningCards++;
        }
        if (counterOfWinningCards == 8) {
            for (Card c :
                    gameBot.hand) {
                if (counterOfWinningCards == 9) {
                    currentContract = "9_NO_TRUMP";
                }
                else if (counterOfWinningCards == 10) {
                    currentContract = "10_NO_TRUMP";
                }
                if (c.rank.getValue() == Ranks.QUEEN.getValue()) {
                    counterOfWinningCards++;
                }
            }
        }
        return currentContract;
    }
    @Override
    public String checkMisere(GameBot gameBot) {
        int quantityOfWinningCards = 0;
        for (Card c :
                gameBot.hand) {
            if (c.rank.getValue() <= Ranks.NINE.getValue()) quantityOfWinningCards++;
        }
        if (quantityOfWinningCards == 10) {
            return "MISERE";
        }
        else return "";
    }

    //
    //
    //
    //
}

