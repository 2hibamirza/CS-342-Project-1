import java.util.ArrayList;
import java.util.Iterator;

/**
 * This abstract class provides the foundation for a generic linked list. It implements the Iterable<T>
 * interface allowing users to iterate through the list. It defines common methods like get, set, 
 * print, and abstract methods like add and delete that will be implemented by specific data 
 * structures extending this class.
 *
 * @param <T> The type of the data stored in the list.
 */
public abstract class GenericList<T> implements Iterable<T> {
    private Node<T> head;  // The head (first node) of the linked list.
    private int length;    // The length (number of elements) in the linked list.

    /**
     * The inner Node class is used to store the data and code for each element of the list. 
     * Each node also points to the next node in the linked list.
     */
    protected static class Node<T> {
        T data;  // The data stored in the node.
        int code;  // Optional code value associated with the data.
        Node<T> next;  // Reference to the next node in the list.

        // Constructor to initialize node with data and default code.
        Node(T data) {
            this.data = data;
            this.code = 0;  // Default code value.
            this.next = null;
        }

        // Constructor to initialize node with data and specified code.
        Node(T data, int code) {
            this.data = data;
            this.code = code;
            this.next = null;
        }
    }

    /**
     * Prints the entire list. If the list is empty, it prints "Empty List".
     */
    public void print() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);  // Print the data of each node.
            current = current.next;  // Move to the next node.
        }
    }

    // Abstract methods to be implemented by subclasses for adding and deleting elements.
    public abstract void add(T data);
    public abstract T delete();

    /**
     * Converts the linked list into an ArrayList and returns it.
     * 
     * @return ArrayList containing all elements in the linked list.
     */
    public ArrayList<T> dumpList() {
        ArrayList<T> result = new ArrayList<>();
        Node<T> current = head;
        while (current != null) {
            result.add(current.data);  // Add data of each node to the ArrayList.
            current = current.next;
        }
        return result;
    }

    /**
     * Gets the data at the specified index.
     * 
     * @param index The index of the element to retrieve.
     * @return The data at the specified index or null if index is out of bounds.
     */
    public T get(int index) {
        if (index < 0 || index >= length) {
            return null;  // Return null if the index is invalid.
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;  // Traverse the list to the specified index.
        }
        return current.data;  // Return the data at the specified node.
    }

    /**
     * Replaces the element at the specified index with the provided element and returns the 
     * original element.
     * 
     * @param index The index to replace.
     * @param element The new element to set at the index.
     * @return The previous element at the index, or null if out of bounds.
     */
    public T set(int index, T element) {
        if (index < 0 || index >= length) {
            return null;  // Return null if index is invalid.
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;  // Traverse to the node at the index.
        }
        T oldValue = current.data;  // Store the old value.
        current.data = element;  // Replace with the new value.
        return oldValue;  // Return the old value.
    }

    // Getters and setters for private fields.
    public int getLength() { return length; }
    protected void setLength(int length) { this.length = length; }
    protected Node<T> getHead() { return head; }
    protected void setHead(Node<T> head) { this.head = head; }

    // Abstract methods for iterator implementation.
    public abstract Iterator<T> descendingIterator();

    @Override
    public abstract Iterator<T> iterator();
}
