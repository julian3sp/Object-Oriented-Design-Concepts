

import java.util.LinkedList;
import java.util.List;

public class Rigged2QtrStrat implements ToyBinStrategy {

    List<Toy> toys = new LinkedList<>();

    @Override
    public void fillWithToys(List<Toy> toys) {
        this.toys.addAll(toys);
        this.toys.sort(Toy::compareTo); // <- always gives the common toys first
    }

    @Override
    public GachaResult receiveToy(int numQuarters) {
        LinkedList<Toy> toysToReceive = new LinkedList<>();
        int qtrsPerToy = 2;
        int quartersLeft = numQuarters;
        if(numQuarters < qtrsPerToy){
            System.err.println("Not enough quarters for one toy");
        }
        while(quartersLeft >= qtrsPerToy && ! toys.isEmpty()){
            quartersLeft -= qtrsPerToy;
            toysToReceive.add(toys.remove(0));
        }


        return new GachaResult(toysToReceive, numQuarters - quartersLeft);
    }

    @Override
    public void switchStrategy(ToyBinStrategy strategy) {
        strategy.fillWithToys(this.toys);
        this.toys.clear();
    }

    @Override
    public List<Toy> getToyList() {
        return this.toys;
    }
}
