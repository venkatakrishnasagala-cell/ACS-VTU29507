import java.util.HashMap;

public class ContainsDuplicateII {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        int k = 3;

        HashMap<Integer, Integer> map = new HashMap<>();

        boolean result = false;

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {

                int previousIndex = map.get(nums[i]);

                if (i - previousIndex <= k) {
                    result = true;
                    break;
                }
            }

            map.put(nums[i], i);
        }

        System.out.println(result);
    }
}