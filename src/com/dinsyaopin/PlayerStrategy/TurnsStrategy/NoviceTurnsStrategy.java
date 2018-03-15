package com.dinsyaopin.PlayerStrategy.TurnsStrategy;

import com.dinsyaopin.Card;
import com.dinsyaopin.GameBot;
import com.dinsyaopin.Suits;
import com.dinsyaopin.contracts.Contract;

import java.util.Random;

public class NoviceTurnsStrategy implements PlayerTurnsStrategy {

    @Override
    public Card putPass(GameBot gameBot) {
        Random random = new Random();
        int randomCard = random.nextInt() * gameBot.hand.size();
        Card card = gameBot.hand.get(randomCard);
        gameBot.hand.remove(randomCard);
        return card;
    }

    @Override
    public Card putPass(GameBot gameBot, Suits suit) {
        return null;
    }

    @Override
    public Card putMisere() {
        return null;
    }

    @Override
    public Card putNoTrump() {
        return null;
    }

    @Override
    public Card putTrump() {
        return null;
    }
}