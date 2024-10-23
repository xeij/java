public static void mirror(Stack<Integer> s) {
    Queue<Integer> q = new LinkedList<Integer>();
    
    if (s == null) {
        throw new IllegalArgumentException();
    }
    
    while (!s.isEmpty()) {
        q.add(s.pop());
    }
    
    int sizeOfQueue = q.size();
    
    for (int i = 0; i < sizeOfQueue; i++) {
        int num = q.remove();
        q.add(num);
        s.push(num);
    }
    
    while (!s.isEmpty()) {
        q.add(s.pop());
    }
    
    for (int i = 0; i < sizeOfQueue; i++) {
        q.add(q.remove());
    }
    
    while (!q.isEmpty()) {
        s.push(q.remove());
    }
}
