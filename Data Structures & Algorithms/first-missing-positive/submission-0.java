class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i ++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (index >= 0 && index < n) {
                int val = Math.abs(nums[index]);
                if (val > 0) {
                    nums[index] = val * - 1;
                } else {
                    nums[index] = (n + 1) * - 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!(nums[i] < 0)) {
                return i + 1;
            }
        }

        return n + 1;
    }
}