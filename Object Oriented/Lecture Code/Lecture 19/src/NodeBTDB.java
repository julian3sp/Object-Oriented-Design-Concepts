package edu.wpi.ahrens.lecture19.part2_addKeyGeneric;

import java.util.Arrays;

/**
 * One of two possible cases for an immutable Binary Tree
 * Not meant to be extended/inherited from, used as a simple data container (DTO)
 */
public  class NodeBTDB<K,T> implements IBinTreeDB<K,T> {


    /** The int in this data node */
    private K data;
    /** The left subtree */
    private IBinTreeDB left;

    /** The right subtree */
    private IBinTreeDB right;

    /** the payload being carried by this node **/
    private T value;

    /**
     * A typical constructor for building an immutable binary tree node
     * @param data the root data
     * @param left the left subtree
     * @param right the right subtree
     */
    public NodeBTDB(K data, T value, IBinTreeDB left, IBinTreeDB right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.value = value;
    }

    /**
     * The number of non-leaf nodes in this tree
     * @return 1 + the number of non-leaf nodes in the subtrees
     */
    public int size(){
        return 1 + this.left.size() + this.right.size();
    }

    /**
     * gets the non-key value at the current node
     *
     * @return
     */
    @Override
    public T getValue() {
        return this.value;
    }


    /**
     * A helper method for formatting numbers to 3 digits (numbers greater than 3 digits don't get pretty printed well)
     * @return
     */
    private String to4Chars(){
        return this.data.toString().substring(0,Math.min(this.data.toString().length(),4));
    }

    /**
     * Code that took Prof. Ahrens too long to write to pretty-print the binary tree
     * @return the pretty-printed tree which is easier on the eyes than the debugging window
     */
    @Override
    public String toString(){
        String[] leftLines = this.left.toString().split("\n");
        String[] rightLines = this.right.toString().split("\n");


        int maxLeft = 0;
        int maxRight = 0;
        for(String s : leftLines){
            maxLeft = Math.max(maxLeft, s.length() );

        }

        for(String s : rightLines){
            maxRight = Math.max(maxRight, s.length() );
        }
        int length = 4 + maxLeft + maxRight;
        for(int i = 0; i < leftLines.length; i++){
            int pad = maxLeft - leftLines[i].length();
            for(int j = 0; j < pad; j++ ){
                leftLines[i] += " ";
            }
            leftLines[i] += "    ";
        }
        for(int i = 0; i < rightLines.length; i++){
            int pad = maxRight - rightLines[i].length();
            for(int j = 0; j < pad; j++ ){
                rightLines[i] += " ";
            }
        }
        String[] lines = new String[Math.max(leftLines.length, rightLines.length)];
        for(int i = 0; i < Math.max(leftLines.length, rightLines.length); i++){
            if(i < leftLines.length){
                lines[i] = leftLines[i];
            }
            else {
                lines[i] = "";
                for(int j = 0; j < 4 + maxLeft; j++){
                    lines[i] += " ";
                }
            }
            if(i < rightLines.length){
                lines[i] += rightLines[i];
            }
            else{
                for(int j =0; j < maxRight; j++){
                    lines[i] += " ";
                }
            }
        }
        String firstLine = "";
        for(int i = 0; i < maxLeft; i++){
            firstLine += " ";
        }
        firstLine += " | ";
        for(int i = 0; i < maxRight; i++){
            firstLine += " ";
        }
        firstLine += "\n";
        for(int i = 0; i < maxLeft; i++){
            firstLine += "_";
        }
        firstLine += this.to4Chars();
        for(int i = 0; i < maxRight; i++){
            firstLine += "_";
        }
        return firstLine + "\n" + Arrays.stream(lines).reduce((s, a) -> s + "\n" + a).get();

    }

    /**
     * Overriding equality to mean the same data and shape. Ignores strategy equality.
     * @param o another tree, hopefully
     * @return true if the two trees have the same data in the same "structure".
     */
    @Override
    public boolean equals(Object o){
        if(! (o instanceof NodeBTDB)){
            return false;
        }

        NodeBTDB no = (NodeBTDB) o;
        return no.data.equals(this.data) && no.left.equals(this.left) && no.right.equals(this.right);

    }

    /**
     * @return false since this is a non-leaf node
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     *
     * @return the root int of this node
     */
    @Override
    public K getRoot() {
        return this.data;
    }

    /**
     *
     * @return the left subtree of this node
     */
    @Override
    public IBinTreeDB<K,T> getLeft() {
        return this.left;
    }

    /**
     *
     * @return the right subtree of this node
     */
    @Override
    public IBinTreeDB<K,T> getRight() {
        return this.right;
    }
}
