public void split() {
    ListNode current = front;
    
    if (current != null) {
    
        while (current.next != null) {
        
            if (current.next.data < 0) {
                ListNode temp = current.next.next;
                current.next.next = front;
                front = current.next;
                current.next = temp;
            } else {
                current = current.next;
            }
        }
        
    }
    
}
