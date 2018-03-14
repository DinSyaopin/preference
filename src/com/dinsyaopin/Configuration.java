package com.dinsyaopin;

import com.dinsyaopin.Convention.Convention;
import com.dinsyaopin.Convention.LeningradConvention;
import com.dinsyaopin.Convention.RostovConvention;
import com.dinsyaopin.Convention.SochiConvention;
import com.dinsyaopin.PlayerStrategy.MasterTradingStrategy;
import com.dinsyaopin.PlayerStrategy.NoviceTradingStrategy;
import com.dinsyaopin.PlayerStrategy.PlayerTradingStrategy;
import com.dinsyaopin.PlayerStrategy.StudentTradingStrategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Configuration {

    public static int getPool() throws IOException {
        System.out.println("Enter a value of pool.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }

    public static PlayerTradingStrategy getPlayerTradingStrategy() throws IOException {
        System.out.println("Enter a digit. Level of player: novice(0), student(1), master(2)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int currentStrategy = Integer.parseInt(reader.readLine());
        PlayerTradingStrategy playerTradingStrategy = null;
        switch (currentStrategy) {
            case 0:
                playerTradingStrategy = new NoviceTradingStrategy();
            case 1:
                playerTradingStrategy = new StudentTradingStrategy();
            case 2:
                playerTradingStrategy = new MasterTradingStrategy();
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
                currentConvention = new LeningradConvention();
            case 1:
                currentConvention = new RostovConvention();
            case 2:
                currentConvention = new SochiConvention();
        }
        return currentConvention;
    }
}
