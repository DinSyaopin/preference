package com.dinsyaopin;

import java.util.ArrayList;

public class BotsQuery {
    public static int[] countBotsIndexes(int nextBot) {
        int[] botsIndexes = new int[3];
        int k = nextBot;
        int botsQuantity = 3;
        for (int i = 0;  i < botsQuantity; i++, k++) {
            if (k > 2) {
                k = 0;
            }
            botsIndexes[i] = k;
        }
        return botsIndexes;
    }
}
