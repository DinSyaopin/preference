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
                //
                //Может быть выделить все контракты в отдельную структуру?
                //
                //
                if (gameBot.getPass()) continue;//player with pass, can't be participant of trading
                if (!playerTradingStrategy.checkElderCardsOfOneSuit(gameBot, Ranks.NINE, 6).equals("")) {
                    contract = playerTradingStrategy.checkElderCardsOfOneSuit(gameBot, Ranks.NINE, 6);
                    continue;
                }
                if (!playerTradingStrategy.checkElderCardsOfAllSuits(gameBot, 6).equals("")) {
                    contract = playerTradingStrategy.checkElderCardsOfAllSuits(gameBot, 6);
                    continue;
                }
                if (!playerTradingStrategy.checkElderCardsOfOneSuit(gameBot, Ranks.EIGHT, 7).equals("")) {
                    contract = playerTradingStrategy.checkElderCardsOfOneSuit(gameBot, Ranks.EIGHT, 7);
                    continue;
                }
                if (!playerTradingStrategy.checkElderCardsOfAllSuits(gameBot, 7).equals("")) {
                    contract = playerTradingStrategy.checkElderCardsOfAllSuits(gameBot, 7);
                    continue;
                }
                if (!playerTradingStrategy.checkElderCardsOfOneSuit(gameBot, Ranks.SEVEN, 8).equals("")) {
                    contract = playerTradingStrategy.checkElderCardsOfOneSuit(gameBot, Ranks.SEVEN, 8);
                    continue;
                }
                if (!playerTradingStrategy.checkElderCardsOfAllSuits(gameBot, 8).equals("")) {
                    contract = playerTradingStrategy.checkElderCardsOfAllSuits(gameBot, 8);
                    continue;
                }
                if (!playerTradingStrategy.checkNineTenElderCardsOfOneSuit(gameBot).equals("")) {
                    contract = playerTradingStrategy.checkNineTenElderCardsOfOneSuit(gameBot);
                    continue;
                }
                if (!playerTradingStrategy.checkNineTenElderCardsOfAllSuits(gameBot).equals("")) {
                    contract = playerTradingStrategy.checkNineTenElderCardsOfAllSuits(gameBot);
                    continue;
                }
                if (!playerTradingStrategy.checkMisere(gameBot).equals("")) {
                    contract = playerTradingStrategy.checkMisere(gameBot);
                    continue;
                }
                if (contract.equals("")) gameBot.setPass(true);
            }
            pass = gameBots.get(0).getIntPass() + gameBots.get(1).getIntPass() + gameBots.get(2).getIntPass();
        }
        return contract; //in the end of trading we're taking contract(thinking that in another method we should compare
        //winner's contract with players contract and take winner)
    }
}