package metro;
import java.util.*;
import java.io.File;
import java.text.MessageFormat;


    class stack {
    
    private int arr[];
    private int capacity;
    private int top;
    public static void main(String[] args) throws Exception {

    Stack stackk = new Stack();
    stackk.pushh(3);

    }

    stack(int size){
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void pushh(int x){
        System.out.println(MessageFormat.format("Pushing {0} to stack",x));
        arr[++top] = x;

    }

}
