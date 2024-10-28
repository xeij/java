public static void mirrorHalves(Queue<Integer> q) {
    if (q == null || q.size() % 2 == 1) {
        throw new IllegalArgumentException();
    }
    
    Stack<Integer> s = new Stack<Integer>();
    int moves = q.size() / 2;
    
    for (int i = 0; i < 2; i++) {
        
        for (int k = 0; k < moves; k++) {
            int num = q.remove();
            s.push(num);
            q.add(num);
        }
        
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }
}
