//Shaya Arya

package metro;
import java.util.*;

public class MyQueue<T> {
    private Node<T> head; 
    private Node<T> tail; 
    private int size; 

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public MyQueue() {
        head = tail = null;
        size = 0;
    }


    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode; 
        } else {
            tail.next = newNode; 
            tail = newNode; 
        }
        size++;
    }

       public T dequeue() {
        if (head == null) {
            return null; 
        }
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;        
        }
        size--;
        return data;
    }
    public T peek() {
        if (head == null) {
            return null; 
        }
        return head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("The front element is: " + queue.peek());
        System.out.println("The queue size is: " + queue.size());

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
