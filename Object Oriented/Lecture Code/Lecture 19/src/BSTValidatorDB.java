package edu.wpi.ahrens.lecture19.part2_addKeyGeneric;


/**
 * A Validator object for binary search trees and their invariants
 */
public class BSTValidatorDB<K extends Comparable<K>,T> implements BTValidatorDB<K,T> {


    /**
     * Checks ALL of the properties of a valid addition into a binary search tree
     * @param oldTree the tree being added to
     * @param i the element being added to the tree
     * @param newTree the tree we got after attempting to add the element to the tree
     * @return true if the resulting tree respects the invariants
     */
    @Override
    public boolean validAdd(IBinTreeDB<K,T> oldTree, K i, IBinTreeDB<K,T> newTree) {
        // assume:
        // - oldTree is a valid BST
        // show:
        // - that adding i to oldTree results in a valid BST newTree
        // Properties
        // - oldTree does not contain i
        // - newTree does contain i
        // - |newTree| is |OldTree| + 1
        // - every element in oldTree is in newTree
        // BST Invariant:
        // - All values in newTree.left() are < newTree.root()
        // - All values in newTree.right() are > newTree.root()
        // - newTree.left() and newTree.right are valid BSTs
        // - empty BSTs are valid BSTs by default

        boolean allOldInNew = this.containsAll(newTree, oldTree);
        boolean oldTreeDopesNotContainElement = ! this.contains(oldTree, i);
        boolean newTreeContainsElement = this.contains(newTree, i);
        boolean newTreeOnlyHas1MoreElement = newTree.size() == oldTree.size() + 1;
        boolean newTreeIsValidBST = this.validBST(newTree);
        return  allOldInNew && oldTreeDopesNotContainElement && newTreeContainsElement &&
                newTreeOnlyHas1MoreElement && newTreeIsValidBST;
    }

    /**
     * Checks ALL of the properties of a valid removal from a binary search tree
     * @param oldTree the tree being removed from
     * @param i the element being removed from the tree
     * @param newTree the tree we got after attempting to remove the element from the tree
     * @return true if the resulting tree respects the invariants
     */
    @Override
    public boolean validRemove(IBinTreeDB<K,T> oldTree, K i, IBinTreeDB<K,T> newTree) {
        // assume:
        // - oldTree is a valid BST
        // show:
        // - that removing i from oldTree results in a valid BST newTree
        // Properties
        // - oldTree is not empty
        // - oldTree does contain i
        // - newTree does not contain i
        // - |newTree| is |OldTree| - 1
        // - every element newTree is in oldTree
        // BST Invariant:
        // - All values in newTree.left() are < newTree.root()
        // - All values in newTree.right() are > newTree.root()
        // - newTree.left() and newTree.right are valid BSTs
        // - empty BSTs are valid BSTs by default

        boolean allNewInOld = this.containsAll(oldTree, newTree);
        boolean oldTreeIsNotEmpty = ! oldTree.isEmpty();
        boolean oldTreeContainsElement = this.contains(oldTree, i);
        boolean newTreeDoesNotContainsElement = ! this.contains(newTree, i);
        boolean newTreeOnlyHas1lessElement = newTree.size() == oldTree.size() - 1;
        boolean newTreeIsValidBST = this.validBST(newTree);
        return allNewInOld && oldTreeIsNotEmpty && oldTreeContainsElement &&
                newTreeDoesNotContainsElement && newTreeOnlyHas1lessElement &&
                newTreeIsValidBST;
    }

    /**
     * A helper method for if a tree contains an element
     * @param b the tree to recurse over
     * @param i the element to look for
     * @return true if the element appears in the tree
     */
    private boolean contains(IBinTreeDB<K,T> b, K i){
        if(b.isEmpty()){
            return false;
        }
        return b.getRoot().compareTo(i) == 0 || this.contains(b.getLeft(),i) || this.contains(b.getRight(),i);
    }

    /**
     * A helper method for if a tree contains all of the elements of another
     * @param container the tree we are checking
     * @param elements the tree holding the elements
     * @return true if the container tree has the elements from the elements tree in any order
     */
    private boolean containsAll(IBinTreeDB<K,T> container, IBinTreeDB<K,T> elements){
        if(elements.isEmpty()){
            return true;
        }
        return this.contains(container, elements.getRoot()) &&
                this.containsAll(container, elements.getLeft()) &&
                this.containsAll(container, elements.getRight());
    }

    /**
     * The BST invariant of all left < node < all right
     * @param b the tree we are checking
     * @return true if the root node is sorted between all values of its left and right subtrees and all subtrees are valid BSTs
     */
    private boolean validBST(IBinTreeDB<K,T> b){
        if(b.isEmpty()) { return true; }
        boolean newTreeNodeIsBiggerThanLeft = this.isBiggerThanAll( b.getLeft(), b.getRoot());
        boolean newTreeNodeIsSmallerThanRight = this.isSmallerThanAll( b.getRight(), b.getRoot());
        boolean leftIsValidBST = this.validBST(b.getLeft());
        boolean rightIsValidBST = this.validBST(b.getRight());
        return newTreeNodeIsBiggerThanLeft && newTreeNodeIsSmallerThanRight && leftIsValidBST && rightIsValidBST;
    }

    /**
     * A helper method to check if an integer is bigger than every element in a tree
     * @param b the tree to check against
     * @param i the element that should be bigger
     * @return true if i is bigger than all ints in b
     */
    public boolean isBiggerThanAll(IBinTreeDB<K,T> b, K i){
        if(b.isEmpty()) { return true; }
        return i.compareTo(b.getRoot()) > 0 && this.isBiggerThanAll(b.getLeft(), i) && this.isBiggerThanAll(b.getRight(), i);
    }
    /**
     * A helper method to check if an integer is smaller than every element in a tree
     * @param b the tree to check against
     * @param i the element that should be smaller
     * @return true if i is smaller than all ints in b
     */
    public boolean isSmallerThanAll(IBinTreeDB<K,T> b, K i){
        if(b.isEmpty()) { return true; }
        return i.compareTo(b.getRoot()) < 0 && this.isSmallerThanAll(b.getLeft(), i) && this.isSmallerThanAll(b.getRight(), i);
    }




}
