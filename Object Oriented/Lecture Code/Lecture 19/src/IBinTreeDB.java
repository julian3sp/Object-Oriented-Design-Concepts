package edu.wpi.ahrens.lecture19.part2_addKeyGeneric;

/**
 * An Interface for an Immutable Binary Tree that take an arbitrary value
 * Uses the Strategy Pattern for how to add elements
 */
public interface IBinTreeDB<K,T>{

    /**
     * A replacement for dynamic type checking (avoid instanceof) to determine if we are in a base-case
     * @return true if we are a representation of a leaf, false otherwise
     */
    public boolean isEmpty();

    /**
     * Assume valid for all non-leaves
     * @return the int at the root of the tree
     */
    public K getRoot();

    /**
     * Assume valid for all non-leaves
     * @return the left subtree which may be a leaf or a node
     */
    public IBinTreeDB<K,T> getLeft();

    /**
     * Assume valid for all non-leaves
     * @return the right subtree which may be a leaf or a node
     */
    public IBinTreeDB<K,T> getRight();

    /**
     *
     * @return the count of all non-leaf nodes in this tree
     */
    public int size();

    /**
     * gets the non-key value at the current node
     * @return
     */
    public T getValue();

}
