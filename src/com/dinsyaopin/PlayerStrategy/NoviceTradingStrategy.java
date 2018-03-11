package com.dinsyaopin.PlayerStrategy;

import com.dinsyaopin.Card;
import com.dinsyaopin.GameBot;
import com.dinsyaopin.Suits;
import com.dinsyaopin.Ranks;

public class NoviceTradingStrategy implements PlayerTradingStrategy {
    @Override
    public int[] countCardsOfCertainSuits(GameBot gameBot) {
        int[] cardsOfEachSuits = {0, 0, 0, 0};
        for (Card c:
                gameBot.hand) {
                cardsOfEachSuits[c.suit.getValue()]++;
        }
        return cardsOfEachSuits;
    }

    @Override
    public String setContract(int[] cardsOfEachSuits, GameBot gameBot) {
        String currentContract = "";
        int quantityOfTricks = 0;
        int countOfAcesNotTrump = 0;
        for(int suit = 0; suit < cardsOfEachSuits.length; suit++) {
            if (cardsOfEachSuits[suit] >= 6 && cardsOfEachSuits[suit] < 8) {
                currentContract = quantityOfTricks + " " + Suits.values()[suit];
            }
            if (cardsOfEachSuits[suit] == 8) {
                for (Card c :
                        gameBot.hand) {
                    if (c.rank.getValue() == Ranks.ACE.getValue() && c.suit.getValue() != suit) { //find Ace without trump suit
                        countOfAcesNotTrump++;
                    }
                }
                if (countOfAcesNotTrump == 1) {
                    currentContract = "9 " + Suits.values()[suit];
                } else if (countOfAcesNotTrump == 2) {
                    currentContract = "10 " + Suits.values()[suit];
                }
            }
        }
        return currentContract;
    }

    @Override
    public String checkElderCardsOfOneSuit(GameBot gameBot) {
        int[] suitsCounterArray = countCardsOfCertainSuits(gameBot);
        return setContract(suitsCounterArray, gameBot);
    }
    @Override
    public int countCurrentCard(GameBot gameBot, Ranks rank, int counterOfWinningCards) {
        for (Card c :
                gameBot.hand) {
            if (c.rank.getValue() == rank.getValue()) counterOfWinningCards++;
        }
        return counterOfWinningCards;
    }
    @Override
    public String checkElderCardsOfAllSuits(GameBot gameBot) {
        int counterOfWinningCards = 0;
        String currentContract = "";
        counterOfWinningCards = countCurrentCard(gameBot, Ranks.ACE, counterOfWinningCards);
        if (counterOfWinningCards == 4) {
            counterOfWinningCards = countCurrentCard(gameBot, Ranks.KING, counterOfWinningCards);
            if (counterOfWinningCards >= 6 && counterOfWinningCards < 8) {
                currentContract = counterOfWinningCards + "_NO_TRUMP";
            }
            if (counterOfWinningCards == 8) {
                currentContract = counterOfWinningCards + "_NO_TRUMP";
                counterOfWinningCards = countCurrentCard(gameBot, Ranks.QUEEN, counterOfWinningCards);
                if (counterOfWinningCards > 8) {
                    currentContract = counterOfWinningCards + "_NO_TRUMP";
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
    @Override
    public String toTrade(GameBot gameBot, PlayerTradingStrategy playerTradingStrategy) {
        if (gameBot.getPass()) {
            return "";
        }
        else {
            if (!playerTradingStrategy.checkElderCardsOfOneSuit(gameBot).equals("")) {
                return playerTradingStrategy.checkElderCardsOfOneSuit(gameBot);
            }
            if (!playerTradingStrategy.checkElderCardsOfAllSuits(gameBot).equals("")) {
                return playerTradingStrategy.checkElderCardsOfAllSuits(gameBot);
            }
            if (!playerTradingStrategy.checkMisere(gameBot).equals("")) {
                return playerTradingStrategy.checkMisere(gameBot);
            }
        }
        return "";
    }
}

