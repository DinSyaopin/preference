package com.dinsyaopin;

import com.dinsyaopin.Convention.Convention;
import com.dinsyaopin.Convention.LeningradConvention;
import com.dinsyaopin.Convention.RostovConvention;
import com.dinsyaopin.Convention.SochiConvention;
import com.dinsyaopin.PlayerStrategy.MasterTradingStrategy;
import com.dinsyaopin.PlayerStrategy.NoviceTradingStrategy;
import com.dinsyaopin.PlayerStrategy.PlayerTradingStrategy;
import com.dinsyaopin.PlayerStrategy.StudentTradingStrategy;
import com.dinsyaopin.contracts.Contract;
import com.dinsyaopin.contracts.Misere;
import com.dinsyaopin.contracts.Pass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Game {

    public int countOfTurns;
    public GameBot winnerOfTrading = null;
    public static void main(String[] args) throws IOException {
        Dealer dealer = new Dealer();
        GameBot bot1 = new GameBot("Player1");
        GameBot bot2 = new GameBot("Player2");
        GameBot bot3 = new GameBot("Player3");
        dealer.initializeDeck();
        dealer.giveCardsToPlayer(bot1);
        dealer.giveCardsToPlayer(bot2);
        dealer.giveCardsToPlayer(bot3);
        //players have cards on their hands
        System.out.println("Enter a digit. Level of player: novice(0), student(1), master(2)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int currentStrategy = Integer.parseInt(reader.readLine());
        PlayerTradingStrategy playerTradingStrategy = null;
        switch (currentStrategy) {
            case 0 : playerTradingStrategy = new NoviceTradingStrategy();
            case 1 : playerTradingStrategy = new StudentTradingStrategy();
            case 2 : playerTradingStrategy = new MasterTradingStrategy();
        }
        ArrayList<GameBot> gameBots = new ArrayList<>();
        gameBots.add(bot1);
        gameBots.add(bot2);
        gameBots.add(bot3);
        try {
            Contract contract = playerTradingStrategy.toTrade(gameBots);
        }
        catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        System.out.println("Enter a digit. Convention: Leningrad(0), Rostov(1), Sochi(2)");
        int convention = Integer.parseInt(reader.readLine());
        Convention currentConvention = null;
        switch (currentStrategy) {
            case 0 : currentConvention = new LeningradConvention();
            case 1 : currentConvention = new RostovConvention();
            case 2 : currentConvention = new SochiConvention();
        }

        startTurns(gameBots.get(0), gameBots.get(1), gameBots.get(2), currentConvention);

        if (contract instanceof Pass) {
            //passes
        }
        else {
            //whisting
        }
        //trader.gameBots.add(bot1);
        //trader.gameBots.add(bot2);
        //trader.gameBots.add(bot3);
        //String contract = trader.toTrade(); //take contract from trading of players

        //game.startGame(bot1, bot2, bot3);
        System.out.println("11");
    }

    public static void startTurns(GameBot bot1, GameBot bot2, GameBot bot3, Convention convention) {
        int countOfTurns = 1;
        while (countOfTurns != 9) {
            winnerOfTrading.putCard();
            if (!bot1.equals(winnerOfTrading)) {
                bot1.putCard();
            } else if (!bot2.equals(winnerOfTrading)) {
                bot2.putCard();
            } else {
                bot3.putCard();
            }
            countOfTurns++;

        }
    }
}