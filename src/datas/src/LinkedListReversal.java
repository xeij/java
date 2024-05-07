package datas.src;
class Node {
    
    int val;
    Node next;
    
    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListReversal {
    
    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;  
            current.next = prev;  
            prev = current;  
            current = next;
        }
        return prev;  
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        head = reverseLinkedList(head);

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
