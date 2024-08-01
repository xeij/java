public static void stutter(Stack<Integer> s) {
    Queue<Integer> q = new LinkedList<Integer>();
    
    while (!s.isEmpty()) {
        int num = s.pop();
        q.add(num);
        q.add(num);
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
