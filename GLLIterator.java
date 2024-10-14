import java.util.Iterator;

/**
 * GLLIterator is a generic iterator class that allows iteration through the elements of a GenericList
 * from head to tail. It implements the Iterator<T> interface and provides the logic to traverse the list.
 *
 * @param <T> The type of the data stored in the GenericList.
 */
public class GLLIterator<T> implements Iterator<T> {
    private GenericList.Node<T> current;  // The current node being iterated over.

    /**
     * Constructor to initialize the iterator with the head of the list.
     * 
     * @param head The head of the list to start iterating from.
     */
    public GLLIterator(GenericList.Node<T> head) {
        current = head;  // Set the current node to the head of the list.
    }

    /**
     * Checks if there is another element in the list.
     * 
     * @return true if there is a next element, false otherwise.
     */
    @Override
    public boolean hasNext() {
        return current != null;  // Return true if the current node is not null.
    }

    /**
     * Returns the next element in the list and moves the iterator to the next node.
     * 
     * @return The data of the current node.
     * @throws java.util.NoSuchElementException if no more elements exist.
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();  // Throw exception if no more elements.
        }

        T data = current.data;  // Get the data of the current node.
        current = current.next;  // Move to the next node.
        return data;  // Return the data.
    }
}
