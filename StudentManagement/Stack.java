public class Stack {
    private int maxSize;    
    private int[] stackArray; 
    private int top;       

    // Constructor to initialize the stack
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; 
    }

    // Push operation: Add an element to the top of the stack
    public void push(int value) {
        if (top < maxSize - 1) {
            top++;
            stackArray[top] = value;
        } else {
            System.out.println("Stack overflow: Cannot push " + value);
        }
    }

    // Pop operation: Remove and return the top element from the stack
    public int pop() {
        if (top >= 0) {
            int value = stackArray[top];
            top--;
            return value;
        } else {
            System.out.println("Stack underflow: Cannot pop from an empty stack");
            return -1; 
        }
    }

    // Peek operation: Return the top element without removing it
    public int peek() {
        if (top >= 0) {
            return stackArray[top];
        } else {
            System.out.println("Stack is empty: Cannot peek");
            return -1; 
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Return the current size of the stack
    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5); 
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("The top element is: " + stack.peek()); 
        stack.pop(); 
        System.out.println("After popping, the top element is: " + stack.peek()); 
        System.out.println("Is the stack empty? " + stack.isEmpty()); 
    }
}
