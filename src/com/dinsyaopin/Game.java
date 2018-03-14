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
import com.dinsyaopin.LogDataInitial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.dinsyaopin.BotsQuery.countBotsIndexes;
import static com.dinsyaopin.Configuration.getCurrentConvention;
import static com.dinsyaopin.Configuration.getPlayerTradingStrategy;
import static com.dinsyaopin.Configuration.getPool;

public class Game {
    private GameBot bot1;
    private GameBot bot2;
    private GameBot bot3;
    private ArrayList<LogData> logData;
    private LogDataInitial logDataInitial;

    public void startGame() throws IOException {
        logData = new ArrayList<>();
        logData.add(logDataInitial);

        PlayerTradingStrategy playerTradingStrategy = getPlayerTradingStrategy();
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
            ArrayList<GameBot> botsQuered = new ArrayList<>();

            int[] botsIndexes = countBotsIndexes(currentBot + 1);

            for (int i = 0; i < 2; i++) {
                botsQuered.add(gameBots.get(botsIndexes[i]));
            }
            if (currentBot == 0) {
                Contract winnerContract = playerTradingStrategy.toTrade(botsQuered);
            }
            else {

            }
            currentBot++;
            if (currentBot == 1) {
                currentBot = -1;
            }
        }
    }
}