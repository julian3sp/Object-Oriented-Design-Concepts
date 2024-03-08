package edu.wpi.ahrens.lecture19.part2_addKeyGeneric;


/**
 * The strategy for adding and removing integers from an integer binary tree
 */
public interface BTStrategyDB<K,T> {

    /**
     * Produces a new tree by adding i to the elements of the old tree (respecting any invariants)
     * @param i the element to add to the tree
     * @param b a tree assumed to respect any invariants needed by the strategy
     * @return the new (immutable) tree now containing i
     */
    public NodeBTDB<K,T> addKeyValue(K i, T value, IBinTreeDB<K,T> b);

    /**
     * Produces a new tree by removing i from the elements of the old tree (respecting any invariants)
     * @param i the element to remove from the tree
     * @param b a tree assumed to respect any invariants needed by the strategy
     * @return the new (immutable) tree no longer containing i
     */
    public IBinTreeDB<K,T> removeKey(K i, IBinTreeDB<K,T> b);


}
