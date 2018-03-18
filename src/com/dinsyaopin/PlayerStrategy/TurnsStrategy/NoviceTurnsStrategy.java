package com.dinsyaopin.PlayerStrategy.TurnsStrategy;

import com.dinsyaopin.Card;
import com.dinsyaopin.GameBot;
import com.dinsyaopin.Suits;
import com.dinsyaopin.contracts.Contract;
import com.dinsyaopin.contracts.ContractWithSuit;
import com.dinsyaopin.contracts.Misere;
import com.dinsyaopin.contracts.Pass;

import java.util.Random;

public class NoviceTurnsStrategy implements PlayerTurnsStrategy {
    private Card takeRandomCardFromHand(GameBot gameBot) {
        Random random = new Random();
        if (gameBot.getHand().size() != 1) {
            int randomCard = random.nextInt(gameBot.getHand().size() - 1);
            return gameBot.getHand().get(randomCard);
        }
        else return gameBot.getHand().get(0);
    }

    @Override
    public Card putCard(Pass pass, GameBot gameBot, Suits turnSuit) {
        if (turnSuit == null) {
            return takeRandomCardFromHand(gameBot);
        }
        else {
            for (Card card:
                    gameBot.getHand()) {
                if (card.suit == turnSuit) {
                    return card;
                }
            }
            return takeRandomCardFromHand(gameBot);
        }
    }

    @Override
    public Card putCard(Contract contract, GameBot gameBot, Suits turnSuit) {
        if (turnSuit == null) {
            return takeRandomCardFromHand(gameBot);
        }
        else {
            for (Card card:
                    gameBot.getHand()) {
                if (card.suit == turnSuit) {
                    return card;
                }
            }
            return takeRandomCardFromHand(gameBot);
        }
    }

    @Override
    public Card putCard(Misere misere, GameBot gameBot, Suits turnSuit) {
        Card puttedCard;
        if (turnSuit == null) {
            return takeRandomCardFromHand(gameBot);
        }
        else {
            for (Card card:
                    gameBot.getHand()) {
                if (card.suit == turnSuit) {
                    return card;
                }
            }
            return takeRandomCardFromHand(gameBot);
        }
    }

    @Override
    public Card putCard(ContractWithSuit contractWithSuit, GameBot gameBot, Suits turnSuit) {
        if (turnSuit == null) {
            return takeRandomCardFromHand(gameBot);
        }
        else {
            for (Card card:
                    gameBot.getHand()) {
                if (card.suit == turnSuit) {
                    return card;
                }
            }
            for (Card card:
                    gameBot.getHand()) {
                if (card.suit == contractWithSuit.getSuit()) {
                    return card;
                }
            }
            return takeRandomCardFromHand(gameBot);
        }
    }
}