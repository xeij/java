public boolean equals2(LinkedIntList list) {
    ListNode current1 = front;
    ListNode current2 = list.front; 
    
    if (current1 == null && current2 == null) {
        return true;
    } else if (current1 != null && current2 != null) {
    
        while (current1 != null && current2 != null) {
        
            if (current1.data != current2.data) {
                return false;
            } else {
                current1 = current1.next;
                current2 = current2.next;
            }
            
        }
        
        return current1 == null && current2 == null;
    }
    
    return false;
}
