

public interface IntSet {

    /**
     * Adds an element to the set
     * @param element an element to add
     * @return this set for method chaining
     */
    IntSet add(int element);

    /**
     * is an element in this set
     * @param element the element to check for
     * @return true iff the element is in the set
     */
    boolean contains(int element);
}
