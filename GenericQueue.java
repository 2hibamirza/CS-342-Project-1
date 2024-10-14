import java.util.Iterator;

/**
 * GenericQueue is a generic queue implementation that extends GenericList<T>. It provides 
 * queue-specific methods for enqueuing and dequeuing elements. The queue uses a singly linked 
 * list to store its elements.
 *
 * @param <T> The type of the data stored in the queue.
 */
public class GenericQueue<T> extends GenericList<T> {
    private Node<T> tail;  // The tail (last node) of the linked list.

    /**
     * Constructor to initialize the queue with a single element.
     * 
     * @param data The data for the first node in the queue.
     */
    public GenericQueue(T data) {
        Node<T> newNode = new Node<>(data);  // Create a new node with the provided data.
        setHead(newNode);  // Set the new node as the head.
        tail = newNode;  // Set the new node as the tail.
        setLength(1);  // Set the length of the queue to 1.
    }

    /**
     * Adds a new element to the back of the queue.
     * 
     * @param data The data to add to the queue.
     */
    @Override
    public void add(T data) {
        Node<T> newNode = new Node<>(data);  // Create a new node.
        if (getHead() == null) {
            setHead(newNode);  // If the queue is empty, set head and tail to the new node.
            tail = newNode;
        } else {
            tail.next = newNode;  // Otherwise, append to the tail.
            tail = newNode;
        }
        setLength(getLength() + 1);  // Increment the length.
    }

    /**
     * Adds a new element with a specific code to the back of the queue.
     * 
     * @param data The data to add to the queue.
     * @param code The code to associate with the data.
     */
    public void add(T data, int code) {
        Node<T> newNode = new Node<>(data, code);  // Create a new node with the code.
        if (getHead() == null) {
            setHead(newNode);  // If the queue is empty, set head and tail to the new node.
            tail = newNode;
        } else {
            tail.next = newNode;  // Otherwise, append to the tail.
            tail = newNode;
        }
        setLength(getLength() + 1);  // Increment the length.
    }

    /**
     * Removes and returns the first element of the queue.
     * 
     * @return The data of the first element or null if the queue is empty.
     */
    @Override
    public T delete() {
        if (getHead() == null) {
            return null;  // Return null if the queue is empty.
        }
        T data = getHead().data;  // Get the data of the head node.
        setHead(getHead().next);  // Move the head to the next node.
        setLength(getLength() - 1);  // Decrement the length.
        if (getHead() == null) {
            tail = null;  // If the queue becomes empty, set tail to null.
        }
        return data;  // Return the data of the removed node.
    }

    /**
     * Adds an element to the back of the queue.
     * 
     * @param data The data to enqueue.
     */
    public void enqueue(T data) {
        add(data);  // Enqueue by adding to the back of the queue.
    }

    /**
     * Removes and returns the first element of the queue.
     * 
     * @return The data of the dequeued element.
     */
    public T dequeue() {
        return delete();  // Dequeue by removing from the front of the queue.
    }

    /**
     * Returns an iterator that iterates over the queue from head to tail.
     * 
     * @return An iterator over the queue elements.
     */
    @Override
    public Iterator<T> iterator() {
        return new GLLIterator<>(getHead());
    }

    /**
     * Returns an iterator that iterates over the queue from tail to head.
     * 
     * @return An iterator in reverse order over the queue elements.
     */
    @Override
    public Iterator<T> descendingIterator() {
        return new ReverseGLLIterator<>(this);
    }
}
