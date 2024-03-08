package edu.wpi.ahrens.lecture19.part2_addKeyGeneric;

import java.util.Optional;

public class BinarySearchTreeDB<K extends Comparable<K>,T> extends BinaryTreeDB<K,T> {

    /**
     * The default constructor which provides a default strategy and an no invariant (always valid) validator
     */
    public BinarySearchTreeDB(){
        super(new BSTStrategyDB<K,T>(),new BSTValidatorDB<K,T>());
    }

    /**
     * A constructor which takes in a strategy and a validator to customize the binary tree
     * @param strategy the strategy used to add and remove integers to this tree
     * @param validator the validator which reports success after add and remove is called
     */
    public BinarySearchTreeDB(BTStrategyDB<K,T> strategy, BTValidatorDB<K,T> validator){
        super(strategy, validator);
    }

    /**
     * A copy constructor
     * @param bt the binary tree which we copy the data, strategy, and validator from
     */
    public BinarySearchTreeDB(BinaryTreeDB<K,T> bt){
        super(bt);
    }


    /**
     * A constructor for initializing with a particular tree
     * @param bt the particular immutable tree to start with
     */
    public BinarySearchTreeDB(IBinTreeDB<K,T> bt){
        super(bt);
    }

    // BST part

    public Optional<T> search(K key){
        return this.search(key, this.data);
    }

    private Optional<T> search(K key, IBinTreeDB<K,T> bst){
        if(bst.isEmpty()){
            return Optional.empty();
        }
        else if(key.compareTo(bst.getRoot()) == 0){
            return Optional.of(bst.getValue());
        }
        else if(key.compareTo(bst.getRoot()) < 0){
            return this.search(key, bst.getLeft());
        }
        else {
            return this.search(key,bst.getRight());
        }
    }
}
