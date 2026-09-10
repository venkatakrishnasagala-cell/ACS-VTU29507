import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Task35_TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        Map<Character, Integer> frequency = new HashMap<>();
        for (char task : tasks) {
            frequency.put(task, frequency.getOrDefault(task, 0) + 1);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        java.util.PriorityQueue<Integer> maxHeap =
                new java.util.PriorityQueue<>((a, b) -> b - a);

        maxHeap.addAll(frequency.values());

        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int remaining = maxHeap.poll() - 1;
                if (remaining > 0) {
                    queue.offer(new int[]{remaining, time + n});
                }
            }

            if (!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.offer(queue.poll()[0]);
            }
        }

        return time;
    }
}
