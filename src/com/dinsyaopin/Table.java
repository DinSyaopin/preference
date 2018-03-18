package com.dinsyaopin;

import com.dinsyaopin.contracts.*;

import java.util.ArrayList;

public class Table {
    private ArrayList<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }
    public GameBot showTurnWinner(ArrayList<GameBot> gameBots, Suits turnSuit, Contract contract) {
        Card winnerCard = getFirstCard();
        GameBot winnerBot = null;
        ArrayList<Card> trumpCards = new ArrayList<>();
        if (contract.getSuit() != null) {
            for (Card card:
                    getCards()) {
                if (card.suit == contract.getSuit()) {
                    trumpCards.add(card);
                }
            }
            if (trumpCards.size() >= 1) {
                for (Card card:
                        trumpCards) {
                    if (winnerCard.rank.getValue() < card.rank.getValue()) {
                        winnerCard = card;
                    }
                }
                for (GameBot gameBot:
                        gameBots) {
                    for (Card card:
                            gameBot.getHand()) {
                        if (card == winnerCard) {
                            winnerBot = gameBot;
                        }
                    }
                }
            }
            else {
                for (Card card :
                        getCards()) {
                    if ((card.suit == turnSuit) && (winnerCard.rank.getValue() < card.rank.getValue())) {
                        winnerCard = card;
                    }
                }
                for (GameBot gameBot:
                        gameBots) {
                    for (Card card:
                            gameBot.getHand()) {
                        if (card == winnerCard) {
                            winnerBot = gameBot;
                            break;
                        }
                    }
                }
            }
        }
        else {//contract.getSuit() == 0
            for (Card card :
                    getCards()) {
                if ((card.suit == turnSuit) && (winnerCard.rank.getValue() < card.rank.getValue())) {
                    winnerCard = card;
                }
            }
            for (GameBot gameBot :
                    gameBots) {
                for (Card card :
                        gameBot.getHand()) {
                    if (card == winnerCard) {
                        winnerBot = gameBot;
                        break;
                    }
                }
            }
        }
        removeTableCardsFromPlayers(gameBots);
        return winnerBot;
    }
    private void removeTableCardsFromPlayers(ArrayList<GameBot> gameBots) {
        for (GameBot gameBot:
                gameBots) {
            for (Card tableCard:
                    getCards()) {
                for (Card card:
                        gameBot.getHand()) {
                    if (card == tableCard) {
                        gameBot.getHand().remove(card);
                        break;
                    }
                }
            }
        }
    }

    public Card getFirstCard() {
        return cards.get(0);
    }

    private ArrayList<Card> getCards() {
        return cards;
    }
}