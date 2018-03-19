package com.dinsyaopin.contracts.Script;

import com.dinsyaopin.Game;

import java.io.IOException;

import static com.dinsyaopin.Game.*;

public class Script2 {
    public static void main(String[] args) throws IOException {
        new Game().startGame(12);
        for (int i = 0; i < 12; i++) {
            System.out.println(showCurrentGameStatistics(i));
        }
    }
}
