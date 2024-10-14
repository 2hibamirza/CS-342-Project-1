import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * GQTest contains JUnit tests for the GenericQueue class. It tests various functionalities 
 * of the queue including adding, deleting, enqueueing, dequeuing, and iteration.
 */
public class GQTest {

    @Test
    void testConstructor() {
        // Test that the queue is correctly initialized with one element.
        GenericQueue<Integer> queue = new GenericQueue<>(5);
        assertEquals(1, queue.getLength());
        assertEquals(5, queue.get(0));
    }

    @Test
    void testAdd() {
        // Test that elements are correctly added to the queue.
        GenericQueue<String> queue = new GenericQueue<>("first");
        queue.add("second");
        queue.add("third");
        assertEquals(3, queue.getLength());
        assertEquals("first", queue.get(0));
        assertEquals("third", queue.get(2));
    }

    @Test
    void testAddWithCode() {
        // Test the overloaded add method that adds a code to the node.
        GenericQueue<Double> queue = new GenericQueue<>(1.0);
        queue.add(2.0, 100);
        queue.add(3.0, 200);
        assertEquals(3, queue.getLength());
        // Can't directly test code, but data addition should be correct.
    }

    @Test
    void testDelete() {
        // Test that the delete method correctly removes the first element.
        GenericQueue<Character> queue = new GenericQueue<>('a');
        queue.add('b');
        queue.add('c');
        assertEquals('a', queue.delete());
        assertEquals(2, queue.getLength());
        assertEquals('b', queue.get(0));
    }

    @Test
    void testDeleteEmptyQueue() {
        // Test that deleting from an empty queue returns null.
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        queue.delete();
        assertNull(queue.delete());
        assertEquals(0, queue.getLength());
    }

    @Test
    void testEnqueueDequeue() {
        // Test enqueue and dequeue operations.
        GenericQueue<String> queue = new GenericQueue<>("first");
        queue.enqueue("second");
        queue.enqueue("third");
        assertEquals("first", queue.dequeue());
        assertEquals("second", queue.dequeue());
        assertEquals(1, queue.getLength());
    }

    @Test
    void testDumpList() {
        // Test that the queue can be dumped into an ArrayList.
        GenericQueue<String> queue = new GenericQueue<>("a");
        queue.add("b");
        queue.add("c");
        ArrayList<String> dumpedList = queue.dumpList();
        assertEquals(3, dumpedList.size());
        assertEquals("a", dumpedList.get(0));
        assertEquals("c", dumpedList.get(2));
    }

    @Test
    void testGet() {
        // Test the get method for retrieving elements by index.
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        queue.add(2);
        queue.add(3);
        assertEquals(2, queue.get(1));
        assertNull(queue.get(3));  // Out of bounds
    }

    @Test
    void testSet() {
        // Test that the set method replaces elements at the correct index.
        GenericQueue<String> queue = new GenericQueue<>("a");
        queue.add("b");
        queue.add("c");
        assertEquals("b", queue.set(1, "d"));
        assertEquals("d", queue.get(1));
        assertNull(queue.set(3, "e"));  // Out of bounds
    }

    @Test
    void testIterator() {
        // Test that the iterator works correctly.
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        queue.add(2);
        queue.add(3);
        Iterator<Integer> iterator = queue.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testDescendingIterator() {
        // Test that the descending iterator works correctly.
        GenericQueue<String> queue = new GenericQueue<>("a");
        queue.add("b");
        queue.add("c");
        Iterator<String> descIterator = queue.descendingIterator();
        assertTrue(descIterator.hasNext());
        assertEquals("c", descIterator.next());
        assertEquals("b", descIterator.next());
        assertEquals("a", descIterator.next());
        assertFalse(descIterator.hasNext());
    }

    @Test
    void testForEachLoop() {
        // Test that the queue can be iterated over using a for-each loop.
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        queue.add(2);
        queue.add(3);
        int sum = 0;
        for (int num : queue) {
            sum += num;
        }
        assertEquals(6, sum);  // 1 + 2 + 3 = 6
    }

    @Test
    void testMultipleDequeueUntilEmpty() {
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();  // Queue should be empty now.
        assertNull(queue.dequeue());  // Ensure the next dequeue returns null.
        assertEquals(0, queue.getLength());  // Ensure the length is zero.
    }

    @Test
    void testAddWithCodeQueueBehavior() {
        GenericQueue<String> queue = new GenericQueue<>("First");
        queue.add("Second", 100);
        queue.add("Third", 200);
        assertEquals("First", queue.dequeue());  // Verify that `add(T data, int code)` doesn't affect order.
        assertEquals("Second", queue.dequeue());
    }

    @Test
    void testPrintEmptyQueue() {
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        queue.dequeue();  // Empty the queue.
        queue.print();  // Should print "Empty List".
    }
}
