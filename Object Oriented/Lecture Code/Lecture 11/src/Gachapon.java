//package edu.wpi.ahrens.Lecture11;

import java.util.LinkedList;
import java.util.List;

public class Gachapon {

    private ToyRarity strategy = new BasicToyBin();


    private int quartersLoaded = 0;

    private int quartersPerToy = 2;

    public Gachapon(List<Toy> toys){
        this.strategy.add(toys);
    }


    public Gachapon loadQuarter(){
        this.quartersLoaded++;
        return this;
    }

    public List<Toy> receiveToys(){
        // what should the return type be?
        // how do I handle change back?
          int toysReceived = this.strategy.gacha(quartersLoaded, quartersPerToy);
          int amountPaid = toysReceived * quartersPerToy;
          quartersLoaded -= amountPaid;
          List<Toy> toys = this.strategy.pon();
          return toys;
    }

    public void switchStrategies(ToyRarity strat){
        this.strategy.switchStrategy(strat);
        this.strategy = strat;
    }

    public int howManyWithRarity(int rarity){
        return this.strategy.howManyWithRarity(rarity);
    }


}
