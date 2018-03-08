package com.dinsyaopin;

import java.util.ArrayList;

public class Trader {
    ArrayList<GameBot> gameBots;
    private String contract;
    int pass = 0;
    public String trading() {
        while (!(pass == 2 && !contract.equals("")) || pass == 3) { //trading ends if 2 players with passes
            // and 1 player with contract or 3 players with passes.
            for (GameBot gameBot :
                    gameBots) {
                int[] suitsCounterArray = {0, 0, 0, 0};

                /*for (Card c :
                        gameBot.hand) {
                    switch (c.rank) {
                        case ACE:
                    }
                }*/
                //
                //Check if player have 6 elder cards of 1 suit
                //
                for (Card c:
                        gameBot.hand) {
                    if (c.rank.getValue() >= Ranks.NINE.getValue()) {
                        suitsCounterArray[c.suit.getValue()]++;
                    }
                }
                for(int i = 0; i < suitsCounterArray.length; i++)
                {
                    if (suitsCounterArray[i] == 6) {
                        contract = "6 " + Suits.values()[i];
                    }
                }
                //
                //Check if player have 6 elder cards of all suits
                //
                int counterOfWinningCards = 0;
                for (Card c :
                        gameBot.hand) {
                    if (c.rank.getValue() == Ranks.ACE.getValue()) counterOfWinningCards++;
                }
                for (Card c :
                        gameBot.hand) {
                    if (c.rank.getValue() == Ranks.KING.getValue()) counterOfWinningCards++;
                }
                if (counterOfWinningCards == 6) {
                    contract = "6_NO_TRUMP";
                }
                //
                //Check if player have 7 elder cards of 1 suit
                //
                for (Card c:
                        gameBot.hand) {
                    if (c.rank.getValue() >= Ranks.EIGHT.getValue()) {
                        suitsCounterArray[c.suit.getValue()]++;
                    }
                }
                for(int i = 0; i < suitsCounterArray.length; i++)
                {
                    if (suitsCounterArray[i] == 7) {
                        contract = "7 " + Suits.values()[i];
                    }
                }
                //
                //Check if player have 7 elder cards of all suits
                //
                counterOfWinningCards = 0;
                for (Card c :
                        gameBot.hand) {
                    if (c.rank.getValue() == Ranks.ACE.getValue()) counterOfWinningCards++;
                }
                for (Card c :
                        gameBot.hand) {
                    if (c.rank.getValue() == Ranks.KING.getValue()) counterOfWinningCards++;
                }
                if (counterOfWinningCards == 7) {
                    contract = "7_NO_TRUMP";
                }
                //
                //Check if player have 8 elder cards of 1 suit
                //
                for (Card c:
                        gameBot.hand) {
                    if (c.rank.getValue() >= Ranks.SEVEN.getValue()) {
                        suitsCounterArray[c.suit.getValue()]++;
                    }
                }
                for(int i = 0; i < suitsCounterArray.length; i++)
                {
                    if (suitsCounterArray[i] == 8) {
                        contract = "8 " + Suits.values()[i];
                    }
                }
                //
                //Check if player have 8 elder cards of all suits
                //
                counterOfWinningCards = 0;
                for (Card c :
                        gameBot.hand) {
                    if (c.rank.getValue() == Ranks.ACE.getValue()) counterOfWinningCards++;
                }
                for (Card c :
                        gameBot.hand) {
                    if (c.rank.getValue() == Ranks.KING.getValue()) counterOfWinningCards++;
                }
                if (counterOfWinningCards == 8) {
                    contract = "8_NO_TRUMP";
                }
                //
                //Check if player have 8 elder cards of 1 suit and any Ace
                //
                for (Card c:
                        gameBot.hand) {
                    if (c.rank.getValue() >= Ranks.SEVEN.getValue()) {
                        suitsCounterArray[c.suit.getValue()]++;
                    }
                }
                for(int i = 0; i < suitsCounterArray.length; i++)
                {
                    if (suitsCounterArray[i] == 8) {
                        for (Card c:
                                gameBot.hand) {
                            if (c.rank.getValue() == Ranks.ACE.getValue() && c.suit.getValue() != i ) { //find Ace without trump suit
                                contract = "9 " + Suits.values()[i];
                            }
                        }
                    }
                }
                //
                //Check if player have 9 elder cards of all suits
                //
                counterOfWinningCards = 0;
                for (Card c :
                        gameBot.hand) {
                    if (c.rank.getValue() >= Ranks.KING.getValue()) counterOfWinningCards++;
                }
                if (counterOfWinningCards == 8) {
                    for (Card c :
                            gameBot.hand) {
                        if (counterOfWinningCards == 9) {
                            contract = "9_NO_TRUMP";
                        }
                        if (c.rank.getValue() == Ranks.QUEEN.getValue()) {
                            counterOfWinningCards++;
                        }
                    }
                }
                //
                //Check if player have 8 elder cards of 1 suit and any 2 Aces
                //
                for (Card c:
                        gameBot.hand) {
                    if (c.rank.getValue() >= Ranks.SEVEN.getValue()) {
                        suitsCounterArray[c.suit.getValue()]++;
                    }
                }
                int countOfAcesNotTrump = 0;
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
                    if (countOfAcesNotTrump == 2) {
                        contract = "10 " + Suits.values()[i];
                    }
                }
                //
                //Check if player have 10 elder cards of all suits
                //
                counterOfWinningCards = 0;
                for (Card c :
                        gameBot.hand) {
                    if (c.rank.getValue() >= Ranks.KING.getValue()) counterOfWinningCards++;
                }
                if (counterOfWinningCards == 8) {
                    for (Card c :
                            gameBot.hand) {
                        if (counterOfWinningCards == 10) {
                            contract = "10_NO_TRUMP";
                        }
                        if (c.rank.getValue() == Ranks.QUEEN.getValue()) {
                            counterOfWinningCards++;
                        }
                    }

                }
                //
                //Check if player have 10 lower cards of all suits
                //
                counterOfWinningCards = 0;
                for (Card c :
                        gameBot.hand) {
                    if (c.rank.getValue() <= Ranks.EIGHT.getValue()) counterOfWinningCards++;
                }
                if (counterOfWinningCards == 8) {
                    for (Card c :
                            gameBot.hand) {
                        if (counterOfWinningCards == 10) break;
                        if (c.rank.getValue() == Ranks.NINE.getValue()) {
                            counterOfWinningCards++;
                        }
                    }
                    contract = "10_NO_TRUMP";
                }
                else pass++;
            }
        }
        return contract; //in the end of trading we're taking contract(thinking that in another method we should compare
        //winner's contract with players contract and take winner)
    }
}