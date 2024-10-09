public void rotate() {
    if (front != null && front.next != null) {
        ListNode firstNode = front;
        front = front.next;
        firstNode.next = null;
        ListNode current = front;
        
        while (current.next != null) {
            current = current.next;
        }
        
        current.next = firstNode;
    }
}
