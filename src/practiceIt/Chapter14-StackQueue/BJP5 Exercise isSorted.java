public static boolean isSorted(Stack<Integer> s) {
    Stack<Integer> storage = new Stack<Integer>();
    boolean sorted = true;
    
    while (sorted && s.size() > 1) {
        storage.push(s.pop());
        if (storage.peek() > s.peek()) {
            sorted = false;
        }
    }
        
    while (!storage.isEmpty()) {
        s.push(storage.pop());
    }
    
    return sorted;
}
