import java.util.Stack;

class MyQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    // Pushes element x to the back of the queue. O(1) time
    public void push(int x) {
        inputStack.push(x);
    }
    
    // Removes the element from the front of the queue and returns it. Amortized O(1) time
    public int pop() {
        peek(); // Ensures outputStack has the front elements ready
        return outputStack.pop();
    }
    
    // Returns the element at the front of the queue. Amortized O(1) time
    public int peek() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }
    
    // Returns true if the queue is empty, false otherwise. O(1) time
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}

