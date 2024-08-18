
public void switchPairs() {
    ListNode current = front;
    
    while (current != null && current.next != null) {
        int temp = current.data;
        current.data = current.next.data;
        current.next.data = temp;
        current = current.next.next;
    }
}
