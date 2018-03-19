package com.dinsyaopin.contracts.Script;

import com.dinsyaopin.Game;

import java.io.IOException;

import static com.dinsyaopin.Game.*;

public class Script1 {
    public static void main(String[] args) throws IOException {
        new Game().startGame(12);
        System.out.println(showStartAlignment(2));
        System.out.println(showStartAlignment(5));
        System.out.println(showTradingForGame(4));
        System.out.println(showBidsForGame(3));
        System.out.println(showGameStatistics(7));
        System.out.println(showPlayersPointsAfterGame(6));
        System.out.println(showPlayerPointsAfterGame(1, 8));
        System.out.println(showTotalPointsOfPlayerAfterGame(2, 10));
        System.out.println(showPlayerStatisticsAfterGame(3, 10));
        System.out.println(countTotalPointsAfterGame(12));
    }
}
