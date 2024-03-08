import java.util.LinkedList;

public class LLIntStack implements IntStack{

    LinkedList<Integer> ints = new LinkedList<Integer>();
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
