import java.util.*;

public class Task52_TopKFrequentElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }

        int k = sc.nextInt();
        List<Integer> values = new ArrayList<>(frequency.keySet());
        values.sort((a, b) -> {
            int byFrequency = frequency.get(b) - frequency.get(a);
            return byFrequency != 0 ? byFrequency : Integer.compare(a, b);
        });

        if (k <= 0 || k > values.size()) {
            System.out.println("Invalid k");
        } else {
            for (int i = 0; i < k; i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(values.get(i));
            }
            System.out.println();
        }
        sc.close();
    }
}
