class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currentMax = 0;
        int globalMax = nums[0];
        int currentMin = 0;
        int globalMin = nums[0];

        int total = 0;

        for (int num : nums) {
            currentMax = Math.max(currentMax + num, num);
            currentMin = Math.min(currentMin + num, num);
            globalMax = Math.max(globalMax, currentMax);
            globalMin = Math.min(globalMin, currentMin);
            total += num;
        }

        if (globalMax < 0) {
            return globalMax;
        } else {
            return Math.max(globalMax, total - globalMin);
        }
    }
}