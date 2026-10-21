import java.util.*;

public class Task53_KPairsWithSmallestSums {
    static class Pair {
        int i, j;
        Pair(int i, int j) { this.i = i; this.j = j; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] nums1 = new int[n];
        int[] nums2 = new int[m];
        for (int i = 0; i < n; i++) nums1[i] = sc.nextInt();
        for (int j = 0; j < m; j++) nums2[j] = sc.nextInt();

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> {
            int sumA = nums1[a.i] + nums2[a.j];
            int sumB = nums1[b.i] + nums2[b.j];
            if (sumA != sumB) return Integer.compare(sumA, sumB);
            if (nums1[a.i] != nums1[b.i]) return Integer.compare(nums1[a.i], nums1[b.i]);
            return Integer.compare(nums2[a.j], nums2[b.j]);
        });

        List<String> result = new ArrayList<>();
        if (n > 0 && m > 0) {
            for (int i = 0; i < Math.min(n, k); i++) minHeap.offer(new Pair(i, 0));
        }

        while (!minHeap.isEmpty() && result.size() < k) {
            Pair current = minHeap.poll();
            result.add("(" + nums1[current.i] + ", " + nums2[current.j] + ")");
            if (current.j + 1 < m) {
                minHeap.offer(new Pair(current.i, current.j + 1));
            }
        }

        System.out.println(String.join(" ", result));
        sc.close();
    }
}
