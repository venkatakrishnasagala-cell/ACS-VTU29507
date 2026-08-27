class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        long totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        long leftSum = 0;

        for (int i = 0; i < n; i++) {
            long leftCount = i;
            long rightCount = n - i - 1;

            long leftPart = (long) nums[i] * leftCount - leftSum;
            long rightPart = (totalSum - leftSum - nums[i])
                           - (long) nums[i] * rightCount;

            result[i] = (int) (leftPart + rightPart);

            leftSum += nums[i];
        }

        return result;
    }
}
