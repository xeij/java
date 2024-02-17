//Shaya Arya
import java.io.*;

public class LinkedList {
    
    Node head;

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }


    public static LinkedList insert(LinkedList list, int data){

        Node newNode = new Node(data);
        if (list.head == null) {
            list.head = newNode;
        }
        else {
            Node last = list.head;
            while(last.next != null){
                last = last.next;
            }

            last.next = newNode;
        }

        return list;
    }

    public static void printList(LinkedList list){

        Node current = list.head;
        System.out.println("LinkedList: ");
        while(current != null){
            System.out.println(current.data + " ");
            current = current.next;
        }

    }


    public static void main(String[] args){

        LinkedList list = new LinkedList();

        list = insert(list, 1);
        list = insert(list, 2);

        printList(list);

    }

}
