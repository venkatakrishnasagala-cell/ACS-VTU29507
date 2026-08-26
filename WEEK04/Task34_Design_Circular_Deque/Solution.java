class MyCircularDeque {
    private final int[] deque;
    private int front;
    private int rear;
    private int size;

    public MyCircularDeque(int k) {
        deque = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + deque.length) % deque.length;
        }

        deque[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % deque.length;
        }

        deque[rear] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;

        front = (front + 1) % deque.length;
        size--;

        if (size == 0) {
            front = 0;
            rear = -1;
        }

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;

        rear = (rear - 1 + deque.length) % deque.length;
        size--;

        if (size == 0) {
            front = 0;
            rear = -1;
        }

        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : deque[front];
    }

    public int getRear() {
        return isEmpty() ? -1 : deque[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == deque.length;
    }
}
