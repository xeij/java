public static void splitStack(Stack<Integer> s) {
    Queue<Integer> q = new LinkedList<Integer>();
    
    while (!s.isEmpty()) {
        q.add(s.pop());
    }
    
    int sizeOfStorage = q.size();
    
    for (int i = 0; i < sizeOfStorage; i++) {
        int num = q.remove();
        if (num < 0) {
            s.push(num);
        } else {
            q.add(num);
        }
    }
    
    while (!q.isEmpty()) {
        s.push(q.remove());
    }
}
