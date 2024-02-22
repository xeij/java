//Shaya Arya
package metro;
public class linkedList {
    
    Node head;

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static linkedList insert(linkedList list, int data){

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

    public static void printList(linkedList list){

        Node current = list.head;
        System.out.println("LinkedList: ");
        while(current != null){
            System.out.println(current.data + " ");
            current = current.next;
        }

    }


    public static void main(String[] args){

        linkedList list = new linkedList();

        list = insert(list, 1);
        list = insert(list, 2);

        printList(list);

    }

}
