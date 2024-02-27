//Shaya Arya
package metro;

class Stack {

    private int[] arr;
    private int capacity;
    private int top;

    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            throw new IllegalStateException("Stack Overflow");
        }
        System.out.println("Pushing " + x + " to stack");
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow");
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= top; i++) {
            sb.append(arr[i]);
            if (i < top) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        System.out.println("Current Stack: " + stack);
        stack.pop();
        System.out.println("Stack after pop: " + stack);
    }
}
