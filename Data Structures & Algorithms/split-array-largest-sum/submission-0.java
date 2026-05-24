class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        int min = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canSplit(nums, mid, k)) {
                min = Math.min(min, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return min;
    }

    public boolean canSplit(int[] nums, int mid, int k) {
        int currentSum = 0;
        int splits = 1;

        for (int num : nums) {
            if (currentSum +  num > mid) {
                splits ++;
                currentSum = 0;
            }
            currentSum += num;
        }

        if (splits <= k) {
            return true;
        } else {
            return false;
        }
    }
}