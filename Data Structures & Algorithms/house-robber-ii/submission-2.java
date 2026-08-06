class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(robRange(0, n - 1, nums), robRange(1, n, nums));
    }

    public int robRange(int start, int end, int[] nums) {
        int prevTwo = nums[start];
        int prevOne = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i < end; i ++) {
            int rob = nums[i] + prevTwo;
            int skip = prevOne;
            int current = Math.max(rob, skip);
            prevTwo = prevOne;
            prevOne = current;
        }
        return prevOne;
    }
}
