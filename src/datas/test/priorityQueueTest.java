package datas.test;
//package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.PriorityQueue;

class PriorityQueueTest {

    @Test
    void testEnqueueAndDequeue() {
        PriorityQueue pq = new PriorityQueue();

        pq.enqueue(45);
        pq.enqueue(20);
        pq.enqueue(14);
        pq.enqueue(12);
        pq.enqueue(31);
        pq.enqueue(7);
        pq.enqueue(11);
        pq.enqueue(13);
        pq.enqueue(7);

        assertEquals(9, pq.length());
        assertEquals(45, pq.frontValue());
        assertEquals(45, pq.dequeue());
        assertEquals(31, pq.frontValue());
        assertEquals(31, pq.dequeue());
        assertEquals(20, pq.frontValue());
    }

    @Test
    void testFrontValueAndLength() {
        PriorityQueue pq = new PriorityQueue();

        pq.enqueue(45);
        pq.enqueue(20);
        pq.enqueue(14);
        pq.enqueue(12);
        pq.enqueue(31);

        assertEquals(45, pq.frontValue());
        assertEquals(5, pq.length());
    }

    @Test
    void testClear() {
        PriorityQueue pq = new PriorityQueue();

        pq.enqueue(45);
        pq.enqueue(20);
        pq.enqueue(14);
        pq.enqueue(12);
        pq.enqueue(31);

        pq.clear();
        assertEquals(0, pq.length());

        Exception exception = assertThrows(IllegalStateException.class, pq::frontValue);
        assertTrue(exception.getMessage().contains("Priority queue is empty"));
    }

    @Test
    void testEmptyQueue() {
        PriorityQueue pq = new PriorityQueue();

        Exception exception1 = assertThrows(IllegalStateException.class, pq::dequeue);
        assertTrue(exception1.getMessage().contains("Priority queue is empty"));

        Exception exception2 = assertThrows(IllegalStateException.class, pq::frontValue);
        assertTrue(exception2.getMessage().contains("Priority queue is empty"));
    }

    @Test
    void testPrintTree() {
        PriorityQueue pq = new PriorityQueue();

        pq.enqueue(45);
        pq.enqueue(20);
        pq.enqueue(14);
        pq.enqueue(12);
        pq.enqueue(31);
        pq.enqueue(7);
        pq.enqueue(11);
        pq.enqueue(13);
        pq.enqueue(7);

        pq.printTree(); // Will print 45, 31, 14, 13, 20, 7, 11, 12, 7 elements
    }
}
