class Solution {
    public int dfs(int[] nums, int idx, int total) {
        if (idx == nums.length) return total;
        return dfs(nums, idx + 1, total ^ nums[idx]) + dfs(nums, idx + 1, total);
    }
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }
}