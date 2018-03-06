package com.dinsyaopin;

public class Game {
    public int countOfTurns;
    public GameBot winnerOfTrading = null;
    public static void main(String[] args) {
        Game game = new Game();
        Dealer dealer = new Dealer();
        GameBot bot1 = new GameBot("Player1");
        GameBot bot2 = new GameBot("Player2");
        GameBot bot3 = new GameBot("Player3");
        dealer.initializeDeck();
        dealer.giveCardsToPlayer(bot1);
        dealer.giveCardsToPlayer(bot2);
        dealer.giveCardsToPlayer(bot3);
        Trader trader = new Trader();
        trader.gameBots.add(bot1);
        trader.gameBots.add(bot2);
        trader.gameBots.add(bot3);
        //game.startTrading();
        //game.startGame(bot1, bot2, bot3);
        System.out.println("11");
    }
    public void startTrading() {
        Contract contract = new Contract();
    }

    public void startGame(GameBot bot1, GameBot bot2, GameBot bot3) {
        countOfTurns = 1;
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