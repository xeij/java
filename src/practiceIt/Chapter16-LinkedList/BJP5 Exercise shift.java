public void shift() {
    if (front != null) {
        int size = 1;
        ListNode current = front;
        
        while (current.next != null) {
            current = current.next;
            size++;
        }
        
        ListNode end = current;
        current = front;
        
        for (int i = 0; i < size / 2; i++) {
            end.next = current.next;
            end = end.next;
            current.next = current.next.next;
            current = current.next;
        }
        
        end.next = null;
    }
}
