package edu.wpi.ahrens.lecture19.part2_addKeyGeneric;


/**
 * A strategy for inserting numbers into a binary search tree (BST) using the invariant
 * assumes the given IBinTree is a valid BST
 */
public class BSTStrategyDB<K extends Comparable<K>,T> extends AbsBTStrategyDB<K,T> implements BTStrategyDB<K,T> {
    @Override
    public NodeBTDB<K,T> addKeyValue(K i, T value, IBinTreeDB<K,T> b) {
        if(b.isEmpty()){ //add at leaf
            return new NodeBTDB<K,T>(i, value, new EmptyBTDB<K,T>(), new EmptyBTDB<K,T>());
        }
        else if( i.compareTo(b.getRoot()) < 0){ //add left
            return new NodeBTDB<K,T>(b.getRoot(), b.getValue(), this.addKeyValue(i, value, b.getLeft()), b.getRight());
        }
        else if( i.compareTo(b.getRoot()) == 0){ // update
            return new NodeBTDB<K,T>(b.getRoot(),value,b.getLeft(),b.getRight());
        }
        else { //add right
            return new NodeBTDB<K,T>(b.getRoot(), b.getValue(), b.getLeft(), this.addKeyValue(i, value, b.getRight()));
        }
    }

}
