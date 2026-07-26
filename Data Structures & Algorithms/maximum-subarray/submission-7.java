class Solution {
    public int maxSubArray(int[] nums) {
        int currentMax = 0;
        int globalMax = nums[0];

        for (int num : nums) {
            if (currentMax < 0) {
                currentMax = 0;
            }
            currentMax += num;
            globalMax = Math.max(currentMax, globalMax);
        }

        return globalMax;
    }
}
