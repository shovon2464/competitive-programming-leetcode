class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int prevTwo = nums[0];
        int prevOne = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i ++) {
            int rob = nums[i] + prevTwo;
            int skip = prevOne;
            int current = Math.max(rob, skip);
            prevTwo = prevOne;
            prevOne = current;
        }

        return prevOne;
    }
}
