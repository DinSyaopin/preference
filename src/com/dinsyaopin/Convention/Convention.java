package com.dinsyaopin.Convention;

import com.dinsyaopin.GameBot;
import com.dinsyaopin.contracts.*;

import java.util.ArrayList;

public abstract class Convention {
    public int checkPoolMultiplier(Contract contract) {
        switch (contract.getTricks()) {
            case 6 : return 2;
            case 7 : return 4;
            case 8 : return 6;
            case 9 : return 8;
            case 10 : return 10;
            default: return 2;
        }
    }
    public abstract int checkWhistsMultiplier(Contract contract);
    public abstract int checkRemiseGameMultiplier(Contract contract);
    public abstract int checkRemiseWhistsMultiplier(Contract contract);
    public  void countPoints(ArrayList<GameBot> gameBots, Contract contract) {
        switch (contract.toString()) {
            case "Мизер" : countPoints(gameBots, (Misere) contract); break;
            case "Пас" : countPoints(gameBots, (Pass) contract); break;
            case "Контракт без масти" : countPoints(gameBots, (ContractWithoutSuit) contract); break;
            case "Контракт с мастью" : countPoints(gameBots, (ContractWithSuit) contract); break;
            default: countPoints(gameBots, (Pass) contract); break;
        }
    }
    public abstract void countPoints(ArrayList<GameBot> bots, Pass winnerContract);
    public abstract void countPoints(ArrayList<GameBot> bots, Misere winnerContract);
}
