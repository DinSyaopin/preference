package com.dinsyaopin;

import com.dinsyaopin.Convention.Convention;
import com.dinsyaopin.Convention.LeningradConvention;
import com.dinsyaopin.Convention.RostovConvention;
import com.dinsyaopin.Convention.SochiConvention;
import com.dinsyaopin.PlayerStrategy.TradingStrategy.MasterTradingStrategy;
import com.dinsyaopin.PlayerStrategy.TradingStrategy.NoviceTradingStrategy;
import com.dinsyaopin.PlayerStrategy.TradingStrategy.PlayerTradingStrategy;
import com.dinsyaopin.PlayerStrategy.TradingStrategy.StudentTradingStrategy;
import com.dinsyaopin.PlayerStrategy.TurnsStrategy.MasterTurnsStrategy;
import com.dinsyaopin.PlayerStrategy.TurnsStrategy.NoviceTurnsStrategy;
import com.dinsyaopin.PlayerStrategy.TurnsStrategy.PlayerTurnsStrategy;
import com.dinsyaopin.PlayerStrategy.TurnsStrategy.StudentTurnsStrategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Configuration {

    public static int getPool() throws IOException {
        System.out.println("Enter a value of pool.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }

    public static PlayerTurnsStrategy getPlayerTurnsStrategy() throws IOException {
        System.out.println("Enter a digit. Level of player in turn: novice(0), student(1), master(2)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int currentStrategy = Integer.parseInt(reader.readLine());
        PlayerTurnsStrategy playerTurnsStrategy = null;
        switch (currentStrategy) {
            case 0:
                playerTurnsStrategy = new NoviceTurnsStrategy(); break;
            case 1:
                playerTurnsStrategy = new StudentTurnsStrategy(); break;
            case 2:
                playerTurnsStrategy = new MasterTurnsStrategy(); break;
            default:
                playerTurnsStrategy = new NoviceTurnsStrategy(); break;
        }
        return playerTurnsStrategy;
        //Need refactoring. Read strategy pattern again.
    }

    public static PlayerTradingStrategy getPlayerTradingStrategy() throws IOException {
        System.out.println("Enter a digit. Level of player in trading: novice(0), student(1), master(2)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int currentStrategy = Integer.parseInt(reader.readLine());
        PlayerTradingStrategy playerTradingStrategy = null;
        switch (currentStrategy) {
            case 0:
                playerTradingStrategy = new NoviceTradingStrategy(); break;
            case 1:
                playerTradingStrategy = new StudentTradingStrategy(); break;
            case 2:
                playerTradingStrategy = new MasterTradingStrategy(); break;
            default:
                playerTradingStrategy = new NoviceTradingStrategy(); break;
        }
        return playerTradingStrategy;
    }

    public static Convention getCurrentConvention() throws IOException {
        System.out.println("Enter a digit. Convention: Leningrad(0), Rostov(1), Sochi(2)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int convention = Integer.parseInt(reader.readLine());
        Convention currentConvention = null;
        switch (convention) {
            case 0:
                currentConvention = new LeningradConvention(); break;
            case 1:
                currentConvention = new RostovConvention(); break;
            case 2:
                currentConvention = new SochiConvention(); break;
            default:
                currentConvention = new LeningradConvention(); break;
        }
        return currentConvention;
    }
}
