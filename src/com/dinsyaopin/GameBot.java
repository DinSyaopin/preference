package com.dinsyaopin;

import com.dinsyaopin.contracts.Contract;

import java.util.ArrayList;

public class GameBot {

    private String botName;
    public ArrayList<Card> hand = new ArrayList<>();
    private int trick;
    private boolean pass;
    private int mountain;
    private int pool;

    public int getTricks() {
        return trick;
    }

    public void setTrick(int trick) {
        this.trick = trick;
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

    public void putCard(Contract contract, Table table) {
        table.addCard(hand.get(0));
        hand.remove(0);
    }
}