package com.dinsyaopin;

import com.dinsyaopin.PlayerStrategy.PlayerTradingStrategy;

import java.util.ArrayList;

public class Trader {
    private String contract = "";
    public static int pass = 0;
    public String toTrade(ArrayList<GameBot> gameBots, PlayerTradingStrategy playerTradingStrategy) {
        boolean endTradeCondition = (pass == 2 && !contract.equals("")) || pass != 3;
        while (endTradeCondition) {
            for (GameBot gameBot :
                    gameBots) {
                contract = playerTradingStrategy.toTrade(gameBot, playerTradingStrategy);
                if (contract.equals("")) {
                    gameBot.setPass(true);
                }
            }
            pass = gameBots.get(0).getIntPass() + gameBots.get(1).getIntPass() + gameBots.get(2).getIntPass();
        }
        return contract; //in the end of trading we're taking contract(thinking that in another method we should compare
        //winner's contract with players contract and take winner)
    }
}