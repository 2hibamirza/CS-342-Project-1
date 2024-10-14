import java.util.Iterator;
import java.util.ArrayList;

/**
 * ReverseGLLIterator class implements the Iterator interface for GenericList.
 * It allows reverse iteration over the elements in the GenericList.
 *
 * @param <T> The type of elements in the GenericList
 */
public class ReverseGLLIterator<T> implements Iterator<T> {
    private ArrayList<T> reversedList;
    private int currentIndex;

    /**
     * Constructor for ReverseGLLIterator.
     *
     * @param list The GenericList to iterate over in reverse
     */
    public ReverseGLLIterator(GenericList<T> list) {
        reversedList = new ArrayList<>();
        GenericList.Node<T> current = list.getHead();
        while (current != null) {
            reversedList.add(0, current.data);
            current = current.next;
        }
        currentIndex = 0;
    }

    /**
     * Checks if there are more elements to iterate over.
     *
     * @return true if there are more elements, false otherwise
     */
    @Override
    public boolean hasNext() {
        return currentIndex < reversedList.size();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return The next element
     * @throws java.util.NoSuchElementException if there are no more elements
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        return reversedList.get(currentIndex++);
    }
}