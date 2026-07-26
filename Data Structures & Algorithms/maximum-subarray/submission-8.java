class Solution {
    public int maxSubArray(int[] nums) {
        int currentMax = 0;
        int globalMax = nums[0];

        for (int num : nums) {
            currentMax = Math.max(currentMax + num, num);
            globalMax = Math.max(globalMax, currentMax);
        }

        return globalMax;
    }
}
