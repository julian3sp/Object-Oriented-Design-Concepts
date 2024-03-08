import java.util.List;

public interface ToyBinStrategy {
    /**
     * Put toys in the bin
     * @param toys toys to add
     */
    public void add(List<Toy> toys);

    /**
     * pay money
     * @param numQuarters the amount of money
     * @param quartersPerToy the ratio of quartersPerToy
     * @return how many toys we should get
     */
    public int gacha(int numQuarters, int quartersPerToy);

    /**
     * get the toys we paid for
     * @return the toys
     */
    public List<Toy> pon();

    public void switchStrategy(ToyBinStrategy strat);


}
