package datas.src;
import java.util.Arrays;

public class priorityQueue {
    private static final int INITIAL_CAPACITY = 50;
    private int[] heap;
    private int size;

    public priorityQueue() {
        heap = new int[INITIAL_CAPACITY];
        size = -1;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (2 * i) + 1;
    }

    private int rightChild(int i) {
        return (2 * i) + 2;
    }

    private void shiftUp(int i) {
        while (i > 0 && heap[parent(i)] < heap[i]) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    private void shiftDown(int i) {
        int maxIndex = i;
        int l = leftChild(i);
        if (l <= size && heap[l] > heap[maxIndex]) {
            maxIndex = l;
        }
        int r = rightChild(i);
        if (r <= size && heap[r] > heap[maxIndex]) {
            maxIndex = r;
        }
        if (i != maxIndex) {
            swap(i, maxIndex);
            shiftDown(maxIndex);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printTree() {
        for (int i = 0; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public void clear() {
        size = -1;
        heap = new int[INITIAL_CAPACITY];
    }

    public void enqueue(int value) {
        if (size == heap.length - 1) {
            expandHeap();
        }
        size += 1;
        heap[size] = value;
        shiftUp(size);
    }

    public int dequeue() {
        if (size == -1) {
            throw new IllegalStateException("Priority queue is empty");
        }
        int result = heap[0];
        heap[0] = heap[size];
        size -= 1;
        shiftDown(0);
        return result;
    }

    public int frontValue() {
        if (size == -1) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return heap[0];
    }

    public int length() {
        return size + 1;
    }

    private void expandHeap() {
        heap = Arrays.copyOf(heap, heap.length * 2);
    }

    public static void main(String[] args) {
        priorityQueue pq = new priorityQueue();

        pq.enqueue(45);
        pq.enqueue(20);
        pq.enqueue(14);
        pq.enqueue(12);
        pq.enqueue(31);
        pq.enqueue(7);
        pq.enqueue(11);
        pq.enqueue(13);
        pq.enqueue(7);

        System.out.print("Tree: ");
        pq.printTree(); 

    }
}
