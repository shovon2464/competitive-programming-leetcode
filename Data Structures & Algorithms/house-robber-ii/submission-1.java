class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(robRange(0, n - 1, nums), robRange(1, n, nums));
    }

    public int robRange(int start, int end, int[] nums) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i ++) {
            int rob = nums[i] + dp[i - 2];
            int skip = dp[i - 1];
            dp[i] = Math.max(rob, skip);
        }

        return dp[end - 1];
    }
}
