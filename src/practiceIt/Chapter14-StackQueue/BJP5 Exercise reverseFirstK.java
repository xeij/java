public static void reverseFirstK(int k, Queue<Integer> q) {
    Stack<Integer> s = new Stack<Integer>();
    
    if (q == null || q.size() < k) {
        throw new IllegalArgumentException();
    } else if (k > 0) {
        
        for (int i = k; i > 0; i--) {
            s.push(q.remove());
        }
        
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        
        int moves = q.size() - k;
        
        while (moves > 0) {
            q.add(q.remove());
            moves--;
        }
    }
}
