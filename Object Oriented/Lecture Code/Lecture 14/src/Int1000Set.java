

/** An IntSet optimized for just the numbers 0 - 999 */
public class Int1000Set implements IntSet{
    /**
     * Adds an element to the set
     *
     * @param element an element to add
     * @return this set for method chaining
     */
    @Override
    public IntSet add(int element) {
        return null;
    }

    /**
     * is an element in this set
     *
     * @param element the element to check for
     * @return true iff the element is in the set
     */
    @Override
    public boolean contains(int element) {
        return false;
    }
}
