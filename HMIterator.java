import java.util.ArrayList;
import java.util.Iterator;

/**
 * HMIterator class implements the Iterator interface for MyHashMap.
 * It allows iteration over the values stored in the HashMap.
 *
 * @param <T> The type of values stored in the HashMap
 */
public class HMIterator<T> implements Iterator<T> {
    private ArrayList<GenericQueue<MyHashMap.MapEntry<T>>> map;
    private int currentBucket;
    private Iterator<MyHashMap.MapEntry<T>> currentQueueIterator;

    /**
     * Constructor for HMIterator.
     *
     * @param map The ArrayList of GenericQueues representing the HashMap
     */
    public HMIterator(ArrayList<GenericQueue<MyHashMap.MapEntry<T>>> map) {
        this.map = map;
        this.currentBucket = 0;
        moveToNextNonEmptyBucket();
    }

    /**
     * Moves the iterator to the next non-empty bucket in the HashMap.
     */
    private void moveToNextNonEmptyBucket() {
        while (currentBucket < map.size() && (map.get(currentBucket) == null || !map.get(currentBucket).iterator().hasNext())) {
            currentBucket++;
        }
        if (currentBucket < map.size()) {
            currentQueueIterator = map.get(currentBucket).iterator();
        }
    }

    /**
     * Checks if there are more elements to iterate over.
     *
     * @return true if there are more elements, false otherwise
     */
    @Override
    public boolean hasNext() {
        return currentBucket < map.size();
    }

    /**
     * Returns the next value in the iteration.
     *
     * @return The next value
     * @throws java.util.NoSuchElementException if there are no more elements
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        T value = currentQueueIterator.next().value;
        if (!currentQueueIterator.hasNext()) {
            currentBucket++;
            moveToNextNonEmptyBucket();
        }
        return value;
    }
}