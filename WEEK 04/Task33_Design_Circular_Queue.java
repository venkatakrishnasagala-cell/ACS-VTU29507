/**
 * LeetCode 622 - Design Circular Queue
 *
 * Uses a fixed-size array with:
 * - front: index of the first element.
 * - rear: index where the next element is inserted.
 * - size: number of stored elements.
 *
 * Circular movement is handled with modulo arithmetic.
 */
class MyCircularQueue {
    private final int[] queue;
    private final int capacity;
    private int front;
    private int rear;
    private int size;

    public MyCircularQueue(int k) {
        capacity = k;
        queue = new int[k];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        queue[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        int index = (rear - 1 + capacity) % capacity;
        return queue[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
