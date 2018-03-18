package com.dinsyaopin.PlayerStrategy.TradingStrategy;

import com.dinsyaopin.Card;
import com.dinsyaopin.GameBot;
import com.dinsyaopin.Suits;
import com.dinsyaopin.Ranks;
import com.dinsyaopin.contracts.Contract;
import com.dinsyaopin.contracts.ContractWithSuit;
import com.dinsyaopin.contracts.Misere;
import com.dinsyaopin.contracts.Pass;

import java.util.ArrayList;

public class NoviceTradingStrategy implements PlayerTradingStrategy {
    @Override
    public int[] countCardsOfCertainSuits(GameBot gameBot) {
        int[] cardsOfEachSuits = {0, 0, 0, 0};
        for (Card c:
                gameBot.getHand()) {
                cardsOfEachSuits[c.suit.getValue()]++;
        }
        return cardsOfEachSuits;
    }

    @Override
    public Contract setContractWithTrump(int[] cardsOfEachSuits, GameBot gameBot) {
        Contract currentContract = new Pass(0);
        int countOfAcesNotTrump = 0;
        int quantityCardsOneSuit;
        for(int suit = 0; suit < cardsOfEachSuits.length; suit++) {
            quantityCardsOneSuit = cardsOfEachSuits[suit];
            if (quantityCardsOneSuit >= 6 && quantityCardsOneSuit < 8) {
                currentContract = new ContractWithSuit(quantityCardsOneSuit, Suits.values()[suit]);
            }
            if (quantityCardsOneSuit == 8) {
                for (Card c :
                        gameBot.getHand()) {
                    if (c.rank.getValue() == Ranks.ACE.getValue() && c.suit.getValue() != suit) { //find Ace without trump suit
                        countOfAcesNotTrump++;
                    }
                }
                currentContract = new ContractWithSuit(quantityCardsOneSuit + countOfAcesNotTrump, Suits.values()[suit]);
            }
        }
        return currentContract;
    }

    @Override
    public Contract checkElderCardsOfOneSuit(GameBot gameBot) {
        int[] suitsCounterArray = countCardsOfCertainSuits(gameBot);
        return setContractWithTrump(suitsCounterArray, gameBot);
    }
    @Override
    public int countCurrentCard(GameBot gameBot, Ranks rank, int counterOfWinningCards) {
        for (Card c :
                gameBot.getHand()) {
            if (c.rank.getValue() == rank.getValue()) counterOfWinningCards++;
        }
        return counterOfWinningCards;
    }
    @Override
    public Contract checkElderCardsOfAllSuits(GameBot gameBot) {
        int counterOfWinningCards = 0;
        Contract currentContract = new Pass(0);
        counterOfWinningCards = countCurrentCard(gameBot, Ranks.ACE, counterOfWinningCards);
        if (counterOfWinningCards == 4) {
            counterOfWinningCards = countCurrentCard(gameBot, Ranks.KING, counterOfWinningCards);
            if (counterOfWinningCards >= 6 && counterOfWinningCards < 8) {
                currentContract = new Contract(counterOfWinningCards);
            }
            if (counterOfWinningCards == 8) {
                currentContract = new Contract(counterOfWinningCards);
                counterOfWinningCards = countCurrentCard(gameBot, Ranks.QUEEN, counterOfWinningCards);
                if (counterOfWinningCards > 8) {
                    currentContract = new Contract(counterOfWinningCards);
                }
            }
        }
        return currentContract;
    }
    @Override
    public Contract checkMisere(GameBot gameBot) {
        int quantityOfWinningCards = 0;
        for (Card c :
                gameBot.getHand()) {
            if (c.rank.getValue() <= Ranks.NINE.getValue()) quantityOfWinningCards++;
        }
        if (quantityOfWinningCards == 10) {
            return new Misere(0);
        }
        else return new Pass(0);
    }

    @Override
    public Contract checkContract(GameBot gameBot) {
        Contract contract = new Pass(0);
        ArrayList<Contract> checkContractArray = new ArrayList<>();
        checkContractArray.add(checkElderCardsOfAllSuits(gameBot));
        checkContractArray.add(checkElderCardsOfOneSuit(gameBot));
        checkContractArray.add(checkMisere(gameBot));
        for (Contract contractFromArray:
             checkContractArray) {
            if (contract.getWeight() < contractFromArray.getWeight()) {
                contract = contractFromArray;
            }
        }
        if (!(contract instanceof Pass)) {
            contract.setWinner(gameBot);//add reference of player to contract
        }
        return contract;
    }

    @Override
    public Contract toTrade(ArrayList<GameBot> gameBots) {
        ArrayList<Contract> botsContracts = new ArrayList<>();
        for (GameBot gameBot:
                gameBots) {
            botsContracts.add(checkContract(gameBot));
        }
        Contract gameContract = botsContracts.get(0);
        for (Contract contract:
                botsContracts) {
            if (gameContract.getWeight() < contract.getWeight()) {
                gameContract = contract;
            }
        }
        return gameContract;
    }

    public ArrayList<GameBot> takeBotsWithoutContract(ArrayList<GameBot> gameBots, Contract gameContract) {
        ArrayList<GameBot> bots = new ArrayList<>();
        for (GameBot gameBot:
                gameBots) {
            if (!(gameBot == gameContract.getWinner())) {
                bots.add(gameBot);
            }
        }
        return bots;
    }

    @Override
    public void tradeWhists(Contract contract, ArrayList<GameBot> botsWithoutContract) {//queue of trading isn't corresponds to rules
        if (contract.toString().equals("Контракт с мастью")) {
            for (GameBot gameBot:
                    botsWithoutContract) {
                int[] quantityOfCardsOfEachSuit = countCardsOfCertainSuits(gameBot);
                for (int i = 0; i < quantityOfCardsOfEachSuit.length; i++) {
                    if (contract.getSuit().getValue() == i) {
                        if (quantityOfCardsOfEachSuit[i] >= contract.getWhist()) {
                            gameBot.setWhisting(true);
                        }
                    }
                }
            }
        }
        else {
            for (GameBot gameBot:
                    botsWithoutContract) {
                int expectedTricks = 0;
                for (Card card:
                        gameBot.getHand()) {
                    if (card.rank.getValue() == Ranks.ACE.getValue()) {
                        expectedTricks++;
                    }
                }
                if (expectedTricks >= contract.getWhist()) {
                    gameBot.setWhisting(true);
                }
            }
        }
    }
}