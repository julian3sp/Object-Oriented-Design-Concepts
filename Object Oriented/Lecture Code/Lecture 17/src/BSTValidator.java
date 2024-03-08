public class BSTValidator implements BTValidator{
    /**
     * Check if adding i to the old tree and getting the new tree is possible with the current invariants
     *
     * @param oldTree the given tree we assume respects the invariants
     * @param i       the element to add
     * @param newTree the new tree which we are validating
     * @return true if we determine that the new tree respects the invariants
     */
    @Override
    public boolean validAdd(IBinTree oldTree, int i, IBinTree newTree) {
        // new tree to contain i DONE
        // every element of old tree needs to be in new tree DONE
        // new tree should not contain anything other than old tree + i
        // bst invariant:
          // empty -> true
          // node -> all of left < root < all of right
          //  left is also a bst, right is also a bst

        return this.contains(newTree, i) && this.allIn(oldTree, newTree) && newTree.size() == oldTree.size() + 1 &&
                this.isBST(newTree);
    }

    private boolean isBST(IBinTree aTree){
        if(aTree.isEmpty()){
            return true;
        }
        else{
            // node -> all of left < root < all of right
            // aTree's root > aTree.left's elements
            boolean leftSideGood = this.biggerThanAll(aTree.getRoot(), aTree.getLeft());
            // AND
            // aTree's root < aTree.right's elements
            boolean rightSideGood = this.smallerThanAll(aTree.getRoot(), aTree.getRight());

            return leftSideGood && rightSideGood && this.isBST(aTree.getLeft()) && this.isBST(aTree.getRight());

        }
    }

    private boolean biggerThanAll(int elt, IBinTree aTree){
        if(aTree.isEmpty()){
            return true;
        }
        else{
            return elt > aTree.getRoot() &&
                    this.biggerThanAll(elt, aTree.getLeft()) && this.biggerThanAll(elt, aTree.getRight());
        }
    }

    private boolean smallerThanAll(int elt, IBinTree aTree){
        if(aTree.isEmpty()){
            return true;
        }
        else{
            return elt < aTree.getRoot() &&
                    this.smallerThanAll(elt, aTree.getLeft()) && this.smallerThanAll(elt, aTree.getRight());
        }
    }
    private boolean contains(IBinTree aTree, int i){
        if(aTree.isEmpty()){
            return false;
        }
        else {
            return aTree.getRoot() == i || this.contains(aTree.getLeft(), i) || this.contains(aTree.getRight(), i);
        }
    }

    private boolean allIn(IBinTree elements, IBinTree container){ // O(n^2)
        if(elements.isEmpty()){
            return true;
        }
        else{
             return this.contains(container, elements.getRoot()) && //O(n)
                    this.allIn(elements.getLeft(), container) &&
                    this.allIn(elements.getRight(), container);
        }
    }

    /**
     * Check if removing i from the old tree and getting the new tree is possible with the current invariants
     *
     * @param oldTree the given tree we assume respects the invariants
     * @param i       the element to remove
     * @param newTree the new tree which we are validating
     * @return true if we determine that the new tree respects the invariants
     */
    @Override
    public boolean validRemove(IBinTree oldTree, int i, IBinTree newTree) {
        return (! this.contains(newTree, i)) && this.allIn(newTree, oldTree) && newTree.size() == oldTree.size() - 1 &&
                this.isBST(newTree);
    }
}
