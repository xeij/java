public static boolean isPalindrome(Queue<Integer> q) {
    Stack<Integer> s = new Stack<Integer>();
    int oldSize = q.size();
    
    for (int i = 0; i < oldSize; i++) {
        int num = q.remove();
        q.add(num);
        s.push(num);
    }
    
    boolean same = true;
    
    for (int i = 0; i < oldSize; i++) {
        int num = q.remove();
        if (num != s.pop()) {
            same = false;
        }
        q.add(num);
    }
    
    return same;
}
