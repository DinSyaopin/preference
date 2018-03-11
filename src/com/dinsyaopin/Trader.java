package com.dinsyaopin;

import com.dinsyaopin.PlayerStrategy.PlayerTradingStrategy;

import java.util.ArrayList;

public class Trader {
    private String contract = "";
    public static int pass = 0;
    //
    //
    //
    //
    /////////////trading process for contract//////////////////////
    public String toTrade(ArrayList<GameBot> gameBots, PlayerTradingStrategy playerTradingStrategy) {
        boolean endTradeCondition = (pass == 2 && !contract.equals("")) || pass != 3;
        while (endTradeCondition) {
            for (GameBot gameBot :
                    gameBots) {
                if (gameBot.getPass() == 1) break;//player with pass, can't be participant of trading
                if (!playerTradingStrategy.checkElderCardsOfOneSuit(gameBot, Ranks.NINE, 6).equals("")) {
                    contract = playerTradingStrategy.checkElderCardsOfOneSuit(gameBot, Ranks.NINE, 6);
                    break;
                }
                if (!playerTradingStrategy.checkElderCardsOfAllSuits(gameBot, 6).equals("")) {
                    contract = playerTradingStrategy.checkElderCardsOfAllSuits(gameBot, 6);
                    break;
                }
                if (!playerTradingStrategy.checkElderCardsOfOneSuit(gameBot, Ranks.EIGHT, 7).equals("")) {
                    contract = playerTradingStrategy.checkElderCardsOfOneSuit(gameBot, Ranks.EIGHT, 7);
                    break;
                }
                if (!playerTradingStrategy.checkElderCardsOfAllSuits(gameBot, 7).equals("")) {
                    contract = playerTradingStrategy.checkElderCardsOfAllSuits(gameBot, 7);
                    break;
                }
                if (!playerTradingStrategy.checkElderCardsOfOneSuit(gameBot, Ranks.SEVEN, 8).equals("")) {
                    contract = playerTradingStrategy.checkElderCardsOfOneSuit(gameBot, Ranks.SEVEN, 8);
                    break;
                }
                if (!playerTradingStrategy.checkElderCardsOfAllSuits(gameBot, 8).equals("")) {
                    contract = playerTradingStrategy.checkElderCardsOfAllSuits(gameBot, 8);
                    break;
                }
                if (!playerTradingStrategy.checkNineElderCardsOfOneSuit(gameBot).equals("")) {
                    contract = playerTradingStrategy.checkNineElderCardsOfOneSuit(gameBot);
                    break;
                }
                if (!playerTradingStrategy.checkNineElderCardsOfAllSuits(gameBot).equals("")) {
                    contract = playerTradingStrategy.checkNineElderCardsOfAllSuits(gameBot);
                    break;
                }
                if (!playerTradingStrategy.checkTenElderCardsOfOneSuit(gameBot).equals("")) {
                    contract = playerTradingStrategy.checkTenElderCardsOfOneSuit(gameBot);
                    break;
                }
                if (!playerTradingStrategy.checkTenElderCardsOfAllSuits(gameBot).equals("")) {
                    contract = playerTradingStrategy.checkTenElderCardsOfAllSuits(gameBot);
                    break;
                }
                if (!playerTradingStrategy.checkMisere(gameBot).equals("")) {
                    contract = playerTradingStrategy.checkMisere(gameBot);
                    break;
                }
                if (contract.equals("")) gameBot.setPass(1);
            }
            pass = gameBots.get(0).getPass() + gameBots.get(1).getPass() + gameBots.get(2).getPass();
        }
        return contract; //in the end of trading we're taking contract(thinking that in another method we should compare
        //winner's contract with players contract and take winner)
    }
}