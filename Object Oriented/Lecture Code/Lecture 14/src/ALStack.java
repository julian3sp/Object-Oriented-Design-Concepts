import java.util.ArrayList;
import java.util.LinkedList;

public class ALStack implements IntStack{
    ArrayList<Integer> ints = new ArrayList<>();
    @Override
    public IntStack push(int element) {
        ints.addFirst(element);
        return this;
    }

    @Override
    public IntStack pop() {
        ints.removeFirst();
        return this;
    }

    @Override
    public int peek() {
        return ints.getFirst();
    }
}
