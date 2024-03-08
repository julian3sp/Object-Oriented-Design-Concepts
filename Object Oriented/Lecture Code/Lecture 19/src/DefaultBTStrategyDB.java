package edu.wpi.ahrens.lecture19.part2_addKeyGeneric;


/**
 * A Strategy for adding integers in breadth first order
 */
public class DefaultBTStrategyDB<K,T> extends AbsBTStrategyDB<K,T> implements BTStrategyDB<K,T>
{
    /**
     * Used as a helper method used to measure the shortest path between the root node and leaf
     * @param b the tree to measure
     * @return how many non-leaf nodes are between the root node and the closest leaf
     */
    private int minDepth(IBinTreeDB<K,T> b){
        if(b.isEmpty()){
            return 0;
        }
        else{
            return 1 + Math.min(this.minDepth(b.getLeft()), this.minDepth(b.getRight()));
        }
    }

    /**
     * Get a tree by replacing the nearest leaf (closest to root, left to right) with a node containing i
     * @param i the element to add to the tree
     * @param b a tree (no invariants)
     * @return a new (immutable) tree with i added
     */
    @Override
    public NodeBTDB<K,T> addKeyValue(K i, T value, IBinTreeDB<K,T> b) {
        if(b.isEmpty()){
            return new NodeBTDB<K,T>(i, value, new EmptyBTDB<K,T>(), new EmptyBTDB<K,T>());
        }
        else {
            if(this.minDepth(b.getLeft()) <= this.minDepth(b.getRight())){
                return new NodeBTDB<K,T>(b.getRoot(), b.getValue(), this.addKeyValue(i,value,b.getLeft()), b.getRight());
            }
            else {
                return new NodeBTDB<K,T>(b.getRoot(), b.getValue(),b.getLeft(), this.addKeyValue(i,value,b.getRight()));
            }
        }
    }



}
