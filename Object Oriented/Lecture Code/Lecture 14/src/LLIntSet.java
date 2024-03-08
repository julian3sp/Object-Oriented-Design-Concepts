

import java.util.LinkedList;

public class LLIntSet implements IntSet {

    public LinkedList<Integer> data = new LinkedList<>();

    @Override
    public IntSet add(int element) {
        data.add(element);
        return this;
    }

    @Override
    public boolean contains(int element) {
        return data.contains(element);
    }
}
