import java.util.ArrayDeque;
import java.util.Queue;

public class Task36_NumberOfRecentCalls {
    static class RecentCounter {
        private final Queue<Integer> requests = new ArrayDeque<>();

        public RecentCounter() {
        }

        public int ping(int t) {
            requests.offer(t);

            while (!requests.isEmpty() && requests.peek() < t - 3000) {
                requests.poll();
            }

            return requests.size();
        }
    }
}
