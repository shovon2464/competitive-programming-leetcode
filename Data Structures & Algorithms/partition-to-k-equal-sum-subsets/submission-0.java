class Solution {
    int[] nums;
    boolean[] used;
    int target;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        this.used = new boolean[nums.length];
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % k != 0) return false;
        this.target = sum / k;
        Arrays.sort(nums);
        for (int l = 0, r = nums.length - 1; l < r; l ++, r --) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        if (nums[0] > target) return false;
        return dfs(0, k, 0);
    }

    public boolean dfs(int idx, int k, int subsetSum) {
        if (k == 0) return true;

        if (subsetSum == target) return dfs(0, k - 1, 0);

        for (int i = idx; i < nums.length; i ++) {
            if (used[i]) continue;
            if (subsetSum + nums[i] <= target) {
                used[i] = true;
                if (dfs(i + 1, k, subsetSum + nums[i])) return true;
                used[i] = false;
            }
        }

        return false;
    }
}