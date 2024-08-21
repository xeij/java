
public void stutter() {
    ListNode current = front;
    
    while (current != null) {
        current.next = new ListNode(current.data, current.next);
        current = current.next.next;
    }
}
