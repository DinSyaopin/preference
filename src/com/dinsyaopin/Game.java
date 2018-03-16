package com.dinsyaopin;

import com.dinsyaopin.Convention.Convention;
import com.dinsyaopin.Log.LogData;
import com.dinsyaopin.PlayerStrategy.TradingStrategy.PlayerTradingStrategy;
import com.dinsyaopin.PlayerStrategy.TurnsStrategy.PlayerTurnsStrategy;
import com.dinsyaopin.contracts.Contract;
import com.dinsyaopin.Log.LogDataInitial;
import com.dinsyaopin.contracts.ContractWithSuit;
import com.dinsyaopin.contracts.Misere;
import com.dinsyaopin.contracts.Pass;

import java.io.IOException;
import java.util.ArrayList;

import static com.dinsyaopin.BotsQuery.countBotsIndexes;
import static com.dinsyaopin.Configuration.*;

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
        startGame(playerTradingStrategy, playerTurnsStrategy, convention);
    }

    private void startGame(PlayerTradingStrategy playerTradingStrategy, PlayerTurnsStrategy playerTurnsStrategy, Convention convention) throws IOException {
        int pool = getPool();
        logDataInitial.setPool(pool);
        bot1 = new GameBot("Player1");
        bot2 = new GameBot("Player2");
        bot3 = new GameBot("Player3");
        logDataInitial.setGameBot1Name(bot1.getBotName());
        logDataInitial.setGameBot2Name(bot2.getBotName());
        logDataInitial.setGameBot3Name(bot3.getBotName());
        bot1.setPlayerTurnsStrategy(playerTurnsStrategy);
        bot2.setPlayerTurnsStrategy(playerTurnsStrategy);
        bot3.setPlayerTurnsStrategy(playerTurnsStrategy);
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
            ArrayList<GameBot> bots = new ArrayList<>();

            int[] botsIndexes = countBotsIndexes(currentBot + 1);

            for (int i = 0; i <= 2; i++) {
                bots.add(gameBots.get(botsIndexes[i]));
            }

            Contract winnerContract = playerTradingStrategy.toTrade(bots);
            GameBot currentWinner = null;
            int countOfTurns = 10;
            int indexOfCurrentWinner = 0;

            for (int i = 0; i < countOfTurns; i++) {//turns
                //initialize table every turn
                Table table = new Table();
                //players put cards
                //table chooses trick winner
                //convention counts points

                if (winnerContract instanceof Pass) {
                    if (currentWinner == null) {
                        bots.get(0).putCard(table, winnerContract);//putCard() надо дописать
                        Suits turnSuit = table.getFirstCard().suit;
                        bots.get(1).putCard(table, winnerContract);
                        bots.get(2).putCard(table, winnerContract);
                        currentWinner = table.showTurnWinner(bots);//проверить метод
                        currentWinner.addTrick();//проверить метод
                        indexOfCurrentWinner = bots.indexOf(currentWinner);//работает
                    }
                    else {//sorting array with currentWinner as 0 element
                        botsIndexes = countBotsIndexes(indexOfCurrentWinner);
                        for (int j = 0; i < 2; i++) {
                            bots.add(gameBots.get(botsIndexes[j]));
                        }
                        table.addCard(playerTurnsStrategy.putPass(bots.get(0)));

                        table.addCard(playerTurnsStrategy.putPass(bots.get(1)));
                        table.addCard(playerTurnsStrategy.putPass(bots.get(2)));
                        currentWinner = table.showTurnWinner(bots);
                        currentWinner.addTrick();
                        indexOfCurrentWinner = bots.indexOf(currentWinner);
                    }
                    convention.countPass(bots);
                }
                else if (winnerContract instanceof Contract) {
                    //some code
                    convention.countTricks(bots, bots.get(0), winnerContract);//pseudo
                }
                else if (winnerContract instanceof ContractWithSuit) {
                    convention.countTricks(bots, bots.get(0), winnerContract);//pseudo
                }
                else if (winnerContract instanceof Misere){
                    convention.countMisere(bots.get(0));//pseudo
                }
            }

            //shitcode moves bots in array for next turn
            currentBot++;
            if (currentBot == 1) {
                currentBot = -1;
            }
        }
    }
}