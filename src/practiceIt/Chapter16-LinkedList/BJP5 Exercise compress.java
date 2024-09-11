public void compress(int factor) {
    ListNode current = front;
    
    while (current != null) {
    
        for (int i = 1; i < factor; i++) {
            if (current.next != null) {
                current.data += current.next.data;
                current.next = current.next.next;
            } 
        }
        
        current = current.next;
    }
}
