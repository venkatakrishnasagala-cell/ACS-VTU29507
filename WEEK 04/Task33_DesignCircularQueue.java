public class Task33_DesignCircularQueue {
    static class MyCircularQueue {
        private final int[] queue;
        private int front;
        private int rear;
        private int size;

        public MyCircularQueue(int k) {
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
            rear = (rear + 1) % queue.length;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }

            front = (front + 1) % queue.length;
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

            int index = (rear - 1 + queue.length) % queue.length;
            return queue[index];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == queue.length;
        }
    }
}
