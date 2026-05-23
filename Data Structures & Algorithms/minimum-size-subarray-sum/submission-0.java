class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;

        int currentSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right ++) {
            while (currentSum + nums[right] >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left ++;
            }

            currentSum += nums[right];
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}