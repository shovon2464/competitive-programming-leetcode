class Solution {
    public int maxSubArray(int[] nums) {
        return divideAndConquer(nums, 0, nums.length-1);
    }

    public int divideAndConquer(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int mid = left + (right - left) / 2;

        int leftMax = divideAndConquer(nums, left, mid);
        int rightMax = divideAndConquer(nums, mid+1, right);
        int crossMax = findCrossMax(nums, left, mid, right);

        return Math.max(leftMax, Math.max(rightMax, crossMax));
    }

    public int findCrossMax(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = mid; i >= left; i --) {
            currentSum += nums[i];
            leftSum = Math.max(currentSum, leftSum);
        }

        int rightSum = Integer.MIN_VALUE;
        currentSum = 0;

        for (int i = mid+1; i <= right; i++) {
            currentSum += nums[i];
            rightSum = Math.max(currentSum, rightSum);
        }

        return leftSum + rightSum;

    }
}
