public class Task34_DesignCircularDeque {
    static class MyCircularDeque {
        private final int[] deque;
        private int front;
        private int rear;
        private int size;

        public MyCircularDeque(int k) {
            deque = new int[k];
            front = 0;
            rear = 0;
            size = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }

            front = (front - 1 + deque.length) % deque.length;
            deque[front] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }

            deque[rear] = value;
            rear = (rear + 1) % deque.length;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }

            front = (front + 1) % deque.length;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }

            rear = (rear - 1 + deque.length) % deque.length;
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

            int index = (rear - 1 + deque.length) % deque.length;
            return deque[index];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == deque.length;
        }
    }
}
