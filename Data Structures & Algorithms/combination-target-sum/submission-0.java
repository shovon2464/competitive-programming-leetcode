class Solution {
    List<List<Integer>> result;
    List<Integer> current;
    int currentSum;
    int[] nums;
    int target;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.result = new ArrayList<>();
        this.current = new ArrayList<>();
        this.currentSum = 0;
        this.nums = nums;
        this.target = target;
        dfs(0);
        return result;
    }
    public void dfs(int idx) {
        if (currentSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (idx >= nums.length) {
            return;
        }
        if (currentSum > target) {
            return;
        }
        currentSum += nums[idx];
        current.add(nums[idx]);
        dfs(idx);
        currentSum -= nums[idx];
        current.remove(current.size() - 1);
        dfs(idx + 1);
    }
}
