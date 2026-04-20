class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum = Math.max(currentSum, 0);
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
