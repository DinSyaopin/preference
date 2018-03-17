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
    public Card takeRandomCardAndRemoveItFromHand(GameBot gameBot) {
        Random random = new Random();
        int randomCard = random.nextInt() * gameBot.getHand().size();
        Card card = gameBot.getHand().get(randomCard);
        gameBot.getHand().remove(randomCard);
        return card;
    }

    @Override
    public Card putCard(Pass pass, GameBot gameBot, Suits suit) {
        Card puttedCard = null;
        if (suit == null) {
            puttedCard = takeRandomCardAndRemoveItFromHand(gameBot);
        }
        else {
            for (Card card:
                    gameBot.getHand()) {
                if (card.suit == suit) {
                    puttedCard = card;
                    gameBot.getHand().remove(card);
                    break;
                }
            }
            if (puttedCard == null) {
                puttedCard = takeRandomCardAndRemoveItFromHand(gameBot);
            }
        }

        return puttedCard;
    }

    @Override
    public Card putCard(Contract contract, GameBot gameBot, Suits suit) {
        return null;
    }

    @Override
    public Card putCard(Misere misere, GameBot gameBot, Suits suit) {
        return null;
    }

    @Override
    public Card putCard(ContractWithSuit contractWithSuit, GameBot gameBot, Suits suit) {
        return null;
    }
}