package edu.wpi.ahrens.lecture19.part2_addKeyGeneric;


/**
 * An abstract binary tree removal strategy which is defined in terms of addition
 */
public abstract class AbsBTStrategyDB<K,T> implements BTStrategyDB<K,T> {


    /**
     * Adding an element to a tree is a subclass responsibility
     * @param i the element to add
     * @param b the tree to add it to
     * @return a new tree with the element added
     */
    @Override
    public abstract NodeBTDB<K,T> addKeyValue(K i, T value, IBinTreeDB<K,T> b);

    /**
     * A generic removal process defined in terms of addition by:
     * - searching for the element
     * - replacing the node with that element at the root with the left subtree merged into the right using repeated addInt()
     * @param i the element to remove
     * @param b the tree from which to remove it
     * @return a new tree with all the elements from the old tree except i
     */
    @Override
    public IBinTreeDB<K,T> removeKey(K i, IBinTreeDB<K,T> b) {
        if(b.isEmpty()){
            return b;
        }
        else if(b.getRoot().equals(i)){
            return this.merge(b.getLeft(), b.getRight());
        }
        else{
            return new NodeBTDB<K,T>(b.getRoot(),b.getValue(),  this.removeKey(i, b.getLeft()), this.removeKey(i,b.getRight()));
        }
    }

    /**
     * A helper method used to move all of the elements from one tree into another
     * @param from the tree whose elements we are taking from
     * @param to the tree that we are building up
     * @return a new tree with all the elements of `from` added to `to`
     */
    protected IBinTreeDB<K,T> merge(IBinTreeDB<K,T> from, IBinTreeDB<K,T> to){
        if(from.isEmpty()){
            return to;
        }
        else if(to.isEmpty()) {
            return from;
        }
        else{
            IBinTreeDB<K,T> addedRoot = this.addKeyValue(from.getRoot(),from.getValue(),to);
            IBinTreeDB<K,T> mergeLeft = this.merge(from.getLeft(),addedRoot);
            IBinTreeDB<K,T> mergeRight = this.merge(from.getRight(), mergeLeft);
            return mergeRight;
        }
    }
}
