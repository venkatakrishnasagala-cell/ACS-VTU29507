import java.util.Stack;

class MyQueue {
    private Stack<Integer> input = new Stack<>();
    private Stack<Integer> output = new Stack<>();

    public MyQueue() {}

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        moveIfNeeded();
        return output.pop();
    }

    public int peek() {
        moveIfNeeded();
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    private void moveIfNeeded() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }
}
