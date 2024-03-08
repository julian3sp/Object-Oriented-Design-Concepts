public class BSTStrategy extends AbsBTStrategy implements BTStrategy{
    @Override
    public NodeBT addInt(int i, IBinTree b) {
        // assume b is a valid binary search tree

        // base case we reach a leaf:
        // make a node
        if (b.isEmpty()) {
            return new NodeBT(i, new EmptyBT(), new EmptyBT());
        }
        // recursive cases:
        // if i is less than the root, we want to insert into the left
        else if (i < b.getRoot()) {
            return new NodeBT(b.getRoot(), this.addInt(i, b.getLeft()), b.getRight());
        }
        // else we want to insert into the right
        else { // i > root
            return new NodeBT(b.getRoot(), b.getLeft(), this.addInt(i, b.getRight()));
        }
    }
}
