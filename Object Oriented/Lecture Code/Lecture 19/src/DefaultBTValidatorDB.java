package edu.wpi.ahrens.lecture19.part2_addKeyGeneric;


/**
 * A default validator which says that all trees are valid
 */
public class DefaultBTValidatorDB<K,T> implements BTValidatorDB<K,T> {


    /**
     * A placeholder validator that says all adds are valid (even if they don't make sense)
     * @param oldTree the given tree we assume respects the invariants
     * @param i the element to add
     * @param newTree the new tree which we are validating
     * @return true always
     */
    @Override
    public boolean validAdd(IBinTreeDB<K,T> oldTree, K i, IBinTreeDB<K,T> newTree) {
        return true;
    }

    /**
     * A placeholder validator that says all removals are valid (even if they don't make sense)
     * @param oldTree the given tree we assume respects the invariants
     * @param i the element to remove
     * @param newTree the new tree which we are validating
     * @return true always
     */
    @Override
    public boolean validRemove(IBinTreeDB<K,T> oldTree, K i, IBinTreeDB<K,T> newTree) {
        return true;
    }
}
