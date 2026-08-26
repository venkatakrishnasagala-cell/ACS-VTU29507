import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];

        for (char task : tasks) {
            frequency[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int count : frequency) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }

        int time = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> used = new ArrayList<>();
            int slots = n + 1;

            while (slots > 0 && !maxHeap.isEmpty()) {
                int count = maxHeap.poll();
                count--;
                used.add(count);
                time++;
                slots--;
            }

            for (int count : used) {
                if (count > 0) {
                    maxHeap.offer(count);
                }
            }

            if (!maxHeap.isEmpty()) {
                time += slots;
            }
        }

        return time;
    }
}
