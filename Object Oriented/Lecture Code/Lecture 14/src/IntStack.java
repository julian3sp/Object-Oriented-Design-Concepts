

/**
 * A Last In - First Out (LIFO) abstract data type
 */
public interface IntStack {
    /**
     * Adds an integer to the stack and then returns the stack for method chaining
     * @param element the element to push on top of the stack
     * @return this stack
     */
    IntStack push(int element);

    /**
     * Pops the top element off of the top of the stack
     * @return this stack for method chaining
     */
    IntStack pop();

    /**
     * Looks at the element on the top of the stack without mutating the stack
     * @return the element
     */
    int peek();

}
