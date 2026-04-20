class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (currentSum < 0) {
                currentSum = 0;
                left = right;
            }
            currentSum += nums[right];
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }
}
