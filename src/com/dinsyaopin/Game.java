package com.dinsyaopin;

import com.dinsyaopin.Convention.Convention;
import com.dinsyaopin.Log.LogData;
import com.dinsyaopin.PlayerStrategy.TradingStrategy.PlayerTradingStrategy;
import com.dinsyaopin.PlayerStrategy.TurnsStrategy.PlayerTurnsStrategy;
import com.dinsyaopin.contracts.Contract;
import com.dinsyaopin.Log.LogDataInitial;
import com.dinsyaopin.contracts.Pass;

import java.io.IOException;
import java.util.ArrayList;

import static com.dinsyaopin.BotsQuery.countBotsIndexes;
import static com.dinsyaopin.Configuration.getCurrentConvention;
import static com.dinsyaopin.Configuration.getPlayerTradingStrategy;
import static com.dinsyaopin.Configuration.getPool;

public class Game {
    private GameBot bot1;
    private GameBot bot2;
    private GameBot bot3;
    private ArrayList<LogData> logData;
    private LogDataInitial logDataInitial = new LogDataInitial();

    public void startGame() throws IOException {
        logData = new ArrayList<>();
        logData.add(logDataInitial);

        PlayerTradingStrategy playerTradingStrategy = getPlayerTradingStrategy();
        PlayerTurnsStrategy playerTurnsStrategy = getPlayerTurnsStrategy();
        Convention convention = getCurrentConvention();
        startGame(playerTradingStrategy, convention);
    }

    private void startGame(PlayerTradingStrategy playerTradingStrategy, Convention convention) throws IOException {
        int pool = getPool();
        logDataInitial.setPool(pool);
        bot1 = new GameBot("Player1");
        bot2 = new GameBot("Player2");
        bot3 = new GameBot("Player3");
        logDataInitial.setGameBot1Name(bot1.getBotName());
        logDataInitial.setGameBot2Name(bot2.getBotName());
        logDataInitial.setGameBot3Name(bot3.getBotName());
        ArrayList<GameBot> gameBots = new ArrayList<>();
        gameBots.add(bot1);
        gameBots.add(bot2);
        gameBots.add(bot3);
        Dealer dealer = new Dealer();

        int currentBot = -1;

        while (bot1.getPool() != pool || bot2.getPool() != pool || bot3.getPool() != pool) {

            dealer.initializeDeck();
            dealer.giveCardsToPlayer(bot1);
            dealer.giveCardsToPlayer(bot2);
            dealer.giveCardsToPlayer(bot3);
            ArrayList<GameBot> botsQueue = new ArrayList<>();

            int[] botsIndexes = countBotsIndexes(currentBot + 1);

            for (int i = 0; i < 2; i++) {
                botsQueue.add(gameBots.get(botsIndexes[i]));
            }
            Contract winnerContract = playerTradingStrategy.toTrade(botsQueue);
            int countOfTurns = 10;
            for (int i = 0; i < countOfTurns; i++) {
                Table table = new Table(winnerContract);
                if (winnerContract instanceof Pass) {
                    botsQueue.get(0).
                }
                else {

                    //table.addCard(botsQueue.get(0).);
                    //table.addCard(botsQueue.get(0).);
                    //table.addCard(botsQueue.get(0).);
                }
            }
            if (winnerContract instanceof Pass) {
                convention.countPass(gameBots);
            }


            currentBot++;
            if (currentBot == 1) {
                currentBot = -1;
            }
        }
    }
}