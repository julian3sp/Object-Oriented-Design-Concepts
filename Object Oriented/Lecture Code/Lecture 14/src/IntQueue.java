

/**
 * A FirstIn-FirstOut (FIFO) abstract data type
 */
public interface IntQueue {

    /**
     * Adds an element to the queue
     * @param element the element to add
     * @return this queue for method chaining
     */
    IntQueue enqueue(int element);

    /**
     * removes an element from the front of the queue
     * @return this queue for method chaining
     */
    IntQueue dequeue();

    /**
     * looks at the current first element in the queue without mutating the queue
     * @return the next element
     */
    int peek();
}
