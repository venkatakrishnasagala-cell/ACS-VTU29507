/**
 * LeetCode 641 - Design Circular Deque
 *
 * A fixed-size circular array supports insertion and deletion
 * from both the front and rear in O(1) time.
 */
class MyCircularDeque {
    private final int[] deque;
    private final int capacity;
    private int front;
    private int size;

    public MyCircularDeque(int k) {
        capacity = k;
        deque = new int[k];
        front = 0;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        int rearIndex = (front + size) % capacity;
        deque[rearIndex] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : deque[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        int rearIndex = (front + size - 1) % capacity;
        return deque[rearIndex];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
