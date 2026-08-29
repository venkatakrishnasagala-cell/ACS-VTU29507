import java.util.Arrays;

/**
 * LeetCode 621 - Task Scheduler
 *
 * The most frequent task determines the minimum possible schedule.
 *
 * Formula:
 * max(total tasks, (maxFrequency - 1) * (n + 1) + numberOfTasksWithMaxFrequency)
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];

        for (char task : tasks) {
            frequency[task - 'A']++;
        }

        Arrays.sort(frequency);

        int maxFrequency = frequency[25];
        int tasksWithMaxFrequency = 0;

        for (int count : frequency) {
            if (count == maxFrequency) {
                tasksWithMaxFrequency++;
            }
        }

        int minimumIntervals =
                (maxFrequency - 1) * (n + 1) + tasksWithMaxFrequency;

        return Math.max(tasks.length, minimumIntervals);
    }
}
