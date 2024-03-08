

import java.util.List;

public class Gachapon {


    public int quartersLoaded = 0;

    public ToyBinStrategy tbStrat;

    public Gachapon(List<Toy> toys){
        tbStrat = new Pokemon2QtrStrat();
        tbStrat.fillWithToys(toys);
    }

    public Gachapon loadQuarter(){
        this.quartersLoaded++;
        return this;
    }

    public List<Toy> receiveToys(){
        GachaResult result = this.tbStrat.receiveToy(this.quartersLoaded);
        this.quartersLoaded -= result.quartersSpent;
        return result.toysReceived;
    }

    public void setStrategy(ToyBinStrategy strategy){
        this.tbStrat.switchStrategy(strategy);
        this.tbStrat = strategy;
    }

    public int howManyRareToysLeft(){
        int count = 0;
        for(Toy toy : this.tbStrat.getToyList()){
            if(toy.rarity > 6){
                count++;
            }
        }
        return count;
    }


}
