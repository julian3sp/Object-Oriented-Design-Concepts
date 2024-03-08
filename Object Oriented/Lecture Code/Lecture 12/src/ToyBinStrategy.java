

import java.util.LinkedList;
import java.util.List;

public interface ToyBinStrategy {

    public void fillWithToys(List<Toy> toys);
    public GachaResult receiveToy(int numQuarters);

    public void switchStrategy(ToyBinStrategy strategy);

    public List<Toy> getToyList();
}
