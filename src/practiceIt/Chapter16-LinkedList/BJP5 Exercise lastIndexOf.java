public int lastIndexOf(int value) {
    ListNode current = front;
    int index = -1;
    int i = 0;
    
    while (current != null) {
        if (current.data == value) {
            index = i;
        }
        
        i++;
        current = current.next;
    }
    
    return index;
}
