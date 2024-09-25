public void transferFrom(LinkedIntList list) {
    if (front == null) {
        front = list.front;
    } else {
        ListNode current = front;
        
        while (current.next != null) {
            current = current.next;
        }
        
        current.next = list.front;
    }
    
    list.front = null;
}
