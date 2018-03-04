package com.dinsyaopin;

public class Card<Integer, String> {
    public Integer valueOfCard;
    public String cardSuit;

    public Integer getValueOfCard() {
        return valueOfCard;
    }

    public void setValueOfCard(Integer valueOfCard) {
        this.valueOfCard = valueOfCard;
    }

    public Card(Integer valueOfCard, String cardSuit) {
        this.valueOfCard = valueOfCard;
        this.cardSuit = cardSuit;
    }

    public String getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(String cardSuit) {
        this.cardSuit = cardSuit;
    }
}
