public void removeAll(int value) {

    while (front != null && front.data == value) {
        front = front.next;
    }
    
    ListNode current = front;
    
    while (current != null && current.next != null) {
    
        if (current.next.data == value) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
        
    } 
}
