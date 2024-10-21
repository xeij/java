public static void shift(Stack<Integer> s, int n) {
    Queue<Integer> q = new LinkedList<Integer>();
    
    int remove = s.size() - n;
    
    while (remove > 0) {
        q.add(s.pop());
        remove--;
    }
    
    while (!q.isEmpty()) {
        s.push(q.remove());
    }
    
    while (!s.isEmpty()) {
        q.add(s.pop());
    }
    
    while (!q.isEmpty()) {
        s.push(q.remove());
    }
}
