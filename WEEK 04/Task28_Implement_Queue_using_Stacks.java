import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 232 - Implement Queue using Stacks
 *
 * Queue behavior is achieved with two stacks:
 * - inputStack stores newly added elements.
 * - outputStack provides FIFO order.
 *
 * Elements are transferred only when outputStack is empty,
 * giving amortized O(1) time per operation.
 */
class MyQueue {
    private final Deque<Integer> inputStack;
    private final Deque<Integer> outputStack;

    public MyQueue() {
        inputStack = new ArrayDeque<>();
        outputStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        moveIfNeeded();
        return outputStack.pop();
    }

    public int peek() {
        moveIfNeeded();
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    private void moveIfNeeded() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
}
