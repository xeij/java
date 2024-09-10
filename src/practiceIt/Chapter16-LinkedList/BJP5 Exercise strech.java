public void  stretch(int copies) {
    if (copies <= 0) {
        front = null;
    } else {
        ListNode current = front;
        
        while (current != null) {
            int value = current.data;
            
            for (int i = 1; i < copies; i++) {
                current.next = new ListNode(value, current.next);
                current = current.next;
            }
            
            current = current.next;
        }
    }
}
