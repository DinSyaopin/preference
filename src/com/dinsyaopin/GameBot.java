package com.dinsyaopin;

import com.dinsyaopin.PlayerStrategy.TurnsStrategy.PlayerTurnsStrategy;
import com.dinsyaopin.contracts.Contract;

import java.util.ArrayList;

public class GameBot {

    private String botName;
    private ArrayList<Card> hand = new ArrayList<>();
    private int trick;
    private boolean pass;
    private int mountain;
    private int pool;
    private PlayerTurnsStrategy playerTurnsStrategy;
    private int whistsToLeft;
    private int whistsToRight;
    private int totalWhists;

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public int getTricks() {
        return trick;
    }

    public void setTrick(int trick) {
        this.trick = trick;
    }

    public void addTrick() {
        this.trick++;
    }

    public boolean getPass() {
        return pass;
    }

    public int getIntPass() {
        return pass ? 1 : 0;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public int getMountain() {
        return mountain;
    }

    public void setMountain(int mountain) {
        this.mountain = mountain;
    }

    public void addToMountain(int value) {
        this.mountain += value;
    }

    public int getPool() {
        return pool;
    }

    public void setPool(int pool) {
        this.pool = pool;
    }

    public void addToPool(int value) {
        this.pool += value;
    }

    public GameBot(String botName) {
        this.botName = botName;
    }

    public String getBotName() {
        return botName;
    }

    public PlayerTurnsStrategy getPlayerTurnsStrategy() {
        return playerTurnsStrategy;
    }

    public void setPlayerTurnsStrategy(PlayerTurnsStrategy playerTurnsStrategy) {
        this.playerTurnsStrategy = playerTurnsStrategy;
    }

    public int getWhistsToLeft() {
        return whistsToLeft;
    }

    public void setWhistsToLeft(int whistsToLeft) {
        this.whistsToLeft = whistsToLeft;
    }

    public int getWhistsToRight() {
        return whistsToRight;
    }

    public void setWhistsToRight(int whistsToRight) {
        this.whistsToRight = whistsToRight;
    }

    public int getTotalWhists() {
        return totalWhists;
    }

    public void setTotalWhists(int totalWhists) {
        this.totalWhists = totalWhists;
    }

    public ArrayList<Card> initializeHand(Deck deck) {
        ArrayList<Card> hand = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            hand.add(deck.getRandomCardFromDeck());
        }
        return hand;
    }

    /*public void takeBuyIn(Deck deck) {
        if (this.toTrade()) {
            hand.add(deck.getRandomCardFromDeck()); //здесь надо подумать, может быть разместить карты прикупа на столе и со стола забирать а не из колоды?
        }
    }*/

    public void putCard(Table table, Contract contract, Suits suit) {
        Card card = playerTurnsStrategy.putCard(contract, this, suit);
        table.addCard(card);
    }
}