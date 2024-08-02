public static void rearrange(Queue<Integer> q) {
    Stack<Integer> s = new Stack<Integer>();
    int oldSize = q.size();
    
    for (int i = 0; i < oldSize; i++) {
        int num = q.remove();
        if (num % 2 == 0) {
            s.push(num);
        } else {
            q.add(num);
        }
    }
    
    for (int i = 0; i < 2; i++) {
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
    
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }
}
