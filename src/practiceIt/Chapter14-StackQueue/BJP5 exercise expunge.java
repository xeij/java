public static void expunge(Stack<Integer> s) {
    Stack<Integer> storage = new Stack<Integer>();
    
    if (s.size() > 1) {
        storage.push(s.pop());
        
        while (!s.isEmpty()) {
            int num = s.pop();
            if (num >= storage.peek()) {
                storage.push(num);
            }
        }
        
        while (!storage.isEmpty()) {
            s.push(storage.pop());
        }
    }
}
