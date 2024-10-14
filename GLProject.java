/*
 * GLProject.java
 *
 * Name: Hiba Mirza
 * netID: hmirz4
 * Email: hmirz4@uic.edu
 *
 * Project #1: Data Structure Library
 * 
 * This project implements custom versions of GenericQueue and MyHashMap data structures,
 * along with their respective iterators. It demonstrates how these data structures can be used
 * in a practical context by simulating a queue and hash map.
 */

 import java.util.Iterator;

 public class GLProject {
 
     public static void main(String[] args) {
         System.out.println("Welcome to Project 1: Data Structure Library");
         
         // Demonstrate the functionality of GenericQueue
         demonstrateGenericQueue();
         
         // Demonstrate the functionality of MyHashMap
         demonstrateMyHashMap();
     }
 
     /**
      * Demonstrates the use of the GenericQueue class. 
      * It showcases queue operations such as enqueue, dequeue, and iteration.
      */
     private static void demonstrateGenericQueue() {
         System.out.println("\n--- GenericQueue Demonstration ---");
         
         GenericQueue<String> queue = new GenericQueue<>("First");
         queue.enqueue("Second");
         queue.enqueue("Third");
         
         // Print the contents of the queue
         System.out.println("Queue contents:");
         queue.print();
         
         // Dequeue an element and print the queue again
         System.out.println("\nDequeuing: " + queue.dequeue());
         System.out.println("Queue after dequeue:");
         queue.print();
         
         // Iterate over the queue using the default iterator
         System.out.println("\nUsing iterator:");
         for (String item : queue) {
             System.out.println(item);
         }
         
         // Iterate over the queue in reverse using the descending iterator
         System.out.println("\nUsing descending iterator:");
         Iterator<String> descIterator = queue.descendingIterator();
         while (descIterator.hasNext()) {
             System.out.println(descIterator.next());
         }
     }
 
     /**
      * Demonstrates the use of the MyHashMap class.
      * It showcases basic hash map operations such as put, get, replace, and iteration.
      */
     private static void demonstrateMyHashMap() {
         System.out.println("\n--- MyHashMap Demonstration ---");
         
         MyHashMap<Integer> map = new MyHashMap<>("One", 1);
         map.put("Two", 2);
         map.put("Three", 3);
         
         // Display the size and check for specific keys
         System.out.println("Map size: " + map.size());
         System.out.println("Contains 'Two': " + map.contains("Two"));
         System.out.println("Value for 'Three': " + map.get("Three"));
         
         // Replace a value and display the updated map
         System.out.println("\nReplacing value for 'Two':");
         Integer oldValue = map.replace("Two", 22);
         System.out.println("Old value: " + oldValue + ", New value: " + map.get("Two"));
         
         // Iterate through the map values using a for-each loop
         System.out.println("\nIterating through map values:");
         for (Integer value : map) {
             System.out.println(value);
         }
     }
 }
 