import java.util.LinkedList;
import java.util.List;

public class RiggedToyBin implements ToyRarity, ToyBinStrategy{
    private List<Toy> toys = new LinkedList<>();
    private List<Toy> toysToReceive = new LinkedList<>();
    @Override
    public void add(List<Toy> toys) {
        this.toys.addAll(toys);
        this.toys.sort(Toy::compareTo);
    }
    @Override
    public int gacha(int numQuarters, int quartersPerToy) {
        if(numQuarters < quartersPerToy){
            System.err.println("Not enough quarters");
        }
        int count = 0;
        for(int i = numQuarters;
            i >= quartersPerToy && ! toys.isEmpty();
            i = i - quartersPerToy){
            toysToReceive.add(toys.remove(0));
            count++;
        }
        return count;
    }

    @Override
    public List<Toy> pon() {
        List<Toy> t = new LinkedList<>(this.toysToReceive);
        this.toysToReceive.clear();
        return t;
    }

    @Override
    public void switchStrategy(ToyBinStrategy strat) {
        strat.add(this.toys);
        this.toys.clear();
    }

    public int howManyWithRarity(int rarity){
        int count = 0;
        for(Toy t : toys){
            if(t.getRarity() == rarity){
                count++;
            }
        }
        return count;
    }
}