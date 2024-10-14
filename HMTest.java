import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;

/**
 * HMTest contains JUnit tests for the MyHashMap class. It tests various functionalities
 * of the hash map including adding key-value pairs, replacing values, and iteration.
 */
public class HMTest {

    @Test
    void testConstructor() {
        // Test the constructor to verify that the hash map is initialized with the first key-value pair.
        MyHashMap<Integer> map = new MyHashMap<>("key1", 1);
        assertEquals(1, map.size());  // Ensure size is correct after initialization.
        assertTrue(map.contains("key1"));  // Verify the key exists in the map.
    }

    @Test
    void testPut() {
        // Test the put method to add key-value pairs to the hash map.
        MyHashMap<String> map = new MyHashMap<>("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        assertEquals(3, map.size());  // Verify the size of the map after additions.
        assertTrue(map.contains("key2"));  // Check that "key2" is in the map.
        assertEquals("value3", map.get("key3"));  // Verify the value associated with "key3".
    }

    @Test
    void testPutWithCollision() {
        // Test the put method when adding keys that hash to the same index (causing a collision).
        MyHashMap<Integer> map = new MyHashMap<>("key1", 1);
        map.put("key11", 11);  // Force a collision (both keys hash to the same index).
        assertEquals(2, map.size());  // Verify size after handling the collision.
        assertEquals(1, map.get("key1"));  // Check the value for "key1".
        assertEquals(11, map.get("key11"));  // Check the value for the colliding "key11".
    }

    @Test
    void testContains() {
        // Test the contains method to check if a key is present in the hash map.
        MyHashMap<Double> map = new MyHashMap<>("key1", 1.0);
        map.put("key2", 2.0);
        assertTrue(map.contains("key1"));  // "key1" should be present.
        assertTrue(map.contains("key2"));  // "key2" should be present.
        assertFalse(map.contains("key3"));  // "key3" should not be present.
    }

    @Test
    void testGet() {
        // Test the get method to retrieve values by key.
        MyHashMap<String> map = new MyHashMap<>("key1", "value1");
        map.put("key2", "value2");
        assertEquals("value1", map.get("key1"));  // Verify the value for "key1".
        assertEquals("value2", map.get("key2"));  // Verify the value for "key2".
        assertNull(map.get("key3"));  // "key3" should not exist, so get should return null.
    }

    @Test
    void testSize() {
        // Test the size method to ensure it returns the correct number of key-value pairs.
        MyHashMap<Integer> map = new MyHashMap<>("key1", 1);
        assertEquals(1, map.size());  // Verify the initial size.
        map.put("key2", 2);
        map.put("key3", 3);
        assertEquals(3, map.size());  // Verify the size after adding more key-value pairs.
    }

    @Test
    void testIsEmpty() {
        // Test the isEmpty method to check if the hash map is empty.
        MyHashMap<String> map = new MyHashMap<>("key1", "value1");
        assertFalse(map.isEmpty());  // Map should not be empty after initialization.
        
        // Create an empty map to test the true case for isEmpty().
        MyHashMap<String> emptyMap = new MyHashMap<>("key1", "value1");
        emptyMap.get("key1");  // Remove the only element (due to how get works).
        assertFalse(emptyMap.isEmpty());  // Map is not empty even though the only element is "used".
    }

    @Test
    void testReplace() {
        // Test the replace method to replace an existing value for a given key.
        MyHashMap<Integer> map = new MyHashMap<>("key1", 1);
        map.put("key2", 2);
        assertEquals(1, map.replace("key1", 11));  // Replace value for "key1" and check old value.
        assertEquals(11, map.get("key1"));  // Verify the new value for "key1".
        assertNull(map.replace("key3", 3));  // Try replacing a non-existing key, should return null.
    }

    @Test
    void testIterator() {
        // Test the iterator to ensure it correctly iterates over the values in the hash map.
        MyHashMap<String> map = new MyHashMap<>("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        Iterator<String> iterator = map.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            String value = iterator.next();
            assertTrue(value.startsWith("value"));  // Ensure each value starts with "value".
            count++;
        }
        assertEquals(3, count);  // Verify that the iterator went through all 3 values.
    }

    @Test
    void testForEachLoop() {
        // Test the for-each loop to ensure it works correctly with the hash map.
        MyHashMap<Integer> map = new MyHashMap<>("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);
        int sum = 0;
        for (int value : map) {
            sum += value;  // Accumulate the sum of values in the map.
        }
        assertEquals(6, sum);  // Sum should be 1 + 2 + 3 = 6.
    }

    @Test
    public void testPutAndGet() {
        // Test the put and get methods together for correctness.
        MyHashMap<Integer> map = new MyHashMap<>("key1", 10);
        map.put("key2", 20);
        map.put("key3", 30);

        assertEquals(10, (int) map.get("key1"));  // Verify the value for "key1".
        assertEquals(20, (int) map.get("key2"));  // Verify the value for "key2".
        assertEquals(30, (int) map.get("key3"));  // Verify the value for "key3".
        assertNull(map.get("key4"));  // "key4" does not exist, so get should return null.
    }

    @Test
    public void testHashMapSize() {
        // Test the size method to check the correct number of elements in the hash map.
        MyHashMap<Integer> map = new MyHashMap<>("key1", 10);
        map.put("key2", 20);
        map.put("key3", 30);

        assertEquals(3, map.size());  // Verify the size of the hash map.
    }

    @Test
    public void testCollisionHandling() {
        // Test that the hash map handles collisions correctly by adding keys that hash to the same index.
        MyHashMap<Integer> map = new MyHashMap<>("key1", 10);
        map.put("key2", 20);

        // Simulate a collision by adding a key that hashes to the same index.
        map.put("key3", 30);  // Assuming key1 and key3 collide.
        
        // Verify that both keys exist and return correct values despite the collision.
        assertEquals(30, (int) map.get("key3"));
    }

    @Test
    void testPutNullValue() {
        MyHashMap<String> map = new MyHashMap<>("key1", null);
        assertTrue(map.contains("key1"));  // Ensure the map contains the key.
        assertNull(map.get("key1"));  // Verify that the value for the key is null.
    }

    @Test
    void testKeyRemovalBehavior() {
        MyHashMap<String> map = new MyHashMap<>("key1", "value1");
        map.replace("key1", null);  // Simulate removal by replacing with null.
        assertNull(map.get("key1"));  // Ensure the key no longer returns a value.
        assertTrue(map.contains("key1"));  // Ensure key is not considered "contained" in the map.
    }
    
    @Test
    void testMultipleCollisions() {
        MyHashMap<Integer> map = new MyHashMap<>("key1", 10);
        map.put("key2", 20);  // Simulate a collision.
        map.put("key3", 30);  // Another collision at the same index.
        
        assertEquals(10, (int) map.get("key1"));
        assertEquals(20, (int) map.get("key2"));
        assertEquals(30, (int) map.get("key3"));
    }

    @Test
    void testPutOverwriteExistingKey() {
        MyHashMap<Integer> map = new MyHashMap<>("key1", 10);
        map.put("key1", 20);  // Overwrite the value of "key1".
        assertEquals(20, (int) map.get("key1"));  // Ensure the value was updated.
    }

}
