public static boolean isConsecutive(Stack<Integer> s) {
    Queue<Integer> q = new LinkedList<Integer>();
    
    if (s.size() < 2) {
        return false;
    }
    
    while (!s.isEmpty()) {
        q.add(s.pop());
    }
    
    boolean consecutive = true;
    s.push(q.remove());
    
    while (!q.isEmpty()) {
        if (s.peek() - 1 != q.peek()) {
            consecutive = false;
        }
        s.push(q.remove());
    }
    
    while (!s.isEmpty()) {
        q.add(s.pop());
    }
    
    while (!q.isEmpty()) {
        s.push(q.remove());
    }
    
    return consecutive;
}
