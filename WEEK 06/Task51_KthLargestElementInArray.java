import java.util.*;

public class Task51_KthLargestElementInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int k = sc.nextInt();
        if (k <= 0 || k > n) {
            System.out.println("Invalid k");
        } else {
            Arrays.sort(arr);
            System.out.println(arr[n - k]);
        }
        sc.close();
    }
}
