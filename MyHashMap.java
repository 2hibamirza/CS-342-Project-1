import java.util.ArrayList;
import java.util.Iterator;

/**
 * MyHashMap class implements a custom HashMap data structure.
 * It uses an ArrayList of GenericQueues to handle collisions.
 *
 * @param <T> The type of values stored in the HashMap
 */
public class MyHashMap<T> implements Iterable<T> {
    private ArrayList<GenericQueue<MapEntry<T>>> map;
    private int size;

    /**
     * MapEntry class represents a key-value pair in the HashMap.
     *
     * @param <T> The type of the value
     */
    public static class MapEntry<T> {
        String key;
        T value;

        MapEntry(String key, T value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Constructor for MyHashMap.
     *
     * @param key The initial key
     * @param value The initial value
     */
    public MyHashMap(String key, T value) {
        map = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            map.add(null);
        }
        put(key, value);
    }

    /**
     * Puts a key-value pair into the HashMap.
     *
     * @param key The key
     * @param value The value
     */
    public void put(String key, T value) {
        int hashCode = key.hashCode();
        int index = hashCode & 9; // This ensures that hash values are in the range [0,9]
    
        if (map.get(index) == null) {
            map.set(index, new GenericQueue<>(new MapEntry<>(key, value)));
        } else {
            GenericQueue<MapEntry<T>> bucket = map.get(index);
            
            // Check if the key already exists in the bucket
            for (MapEntry<T> entry : bucket) {
                if (entry.key.equals(key)) {
                    entry.value = value; // Update the value for existing key
                    return;
                }
            }
    
            // If no existing key is found, add a new entry
            bucket.add(new MapEntry<>(key, value), hashCode);
        }
        size++;
    }
    
    /**
     * Checks if the HashMap contains a specific key.
     *
     * @param key The key to check
     * @return true if the key exists, false otherwise
     */
    public boolean contains(String key) {
        int hashCode = key.hashCode();
        int index = hashCode & 9;

        if (map.get(index) == null) {
            return false;
        }

        for (MapEntry<T> entry : map.get(index)) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the value associated with a specific key.
     *
     * @param key The key
     * @return The value associated with the key, or null if the key doesn't exist
     */
    public T get(String key) {
        int hashCode = key.hashCode();
        int index = hashCode & 9;

        if (map.get(index) == null) {
            return null;
        }

        for (MapEntry<T> entry : map.get(index)) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    /**
     * Returns the number of key-value mappings in the HashMap.
     *
     * @return The size of the HashMap
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the HashMap is empty.
     *
     * @return true if the HashMap is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Replaces the value for a specific key.
     *
     * @param key The key
     * @param value The new value
     * @return The old value associated with the key, or null if the key doesn't exist
     */
    public T replace(String key, T value) {
        int hashCode = key.hashCode();
        int index = hashCode & 9;

        if (map.get(index) == null) {
            return null;
        }

        for (MapEntry<T> entry : map.get(index)) {
            if (entry.key.equals(key)) {
                T oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        return null;
    }

    /**
     * Returns an iterator over the values in the HashMap.
     *
     * @return An iterator over the values
     */
    @Override
    public Iterator<T> iterator() {
        return new HMIterator<>(map);
    }
}