public class MaxHeapValidator implements BTValidator{
    @Override
    public boolean validAdd(IBinTree oldTree, int i, IBinTree newTree) {
        return this.contains(newTree, i) && this.allIn(oldTree, newTree) && newTree.size() == oldTree.size() + 1 &&
                this.isMaxHeap(newTree);
    }

    @Override
    public boolean validRemove(IBinTree oldTree, int i, IBinTree newTree) {
        return (! this.contains(newTree, i)) && this.allIn(newTree, oldTree) && newTree.size() == oldTree.size() - 1 &&
                this.isMaxHeap(newTree);
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
    private boolean contains(IBinTree aTree, int i){
        if(aTree.isEmpty()){
            return false;
        }
        else {
            return aTree.getRoot() == i || this.contains(aTree.getLeft(), i) || this.contains(aTree.getRight(), i);
        }
    }
    private boolean isMaxHeap(IBinTree aTree){
        if(aTree.isEmpty()){
            return true;
        }
        else{
            // node -> all of left && all of right < root
            // aTree's root > aTree.left's elements
            boolean leftSideGood = this.biggerThanAll(aTree.getRoot(), aTree.getLeft());
            // AND
            // aTree's root > aTree.right's elements
            boolean rightSideGood = this.biggerThanAll(aTree.getRoot(), aTree.getRight());

            return leftSideGood && rightSideGood && this.isMaxHeap(aTree.getLeft()) && this.isMaxHeap(aTree.getRight());

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
}
