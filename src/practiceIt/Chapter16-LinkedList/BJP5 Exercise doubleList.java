public void doubleList() {
    if (front != null) {
        ListNode end = front;
        int size = 1;
        
        while (end.next != null) {
            size++;
            end = end.next;
        }
        
        ListNode current = front;
        
        while (size > 0) {
            size--;
            end.next = new ListNode(current.data);
            current = current.next;
            end = end.next;
        }
        
    }
}
