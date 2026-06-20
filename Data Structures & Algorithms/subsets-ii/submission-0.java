class Solution {
    List<List<Integer>> result;
    List<Integer> current;
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.result = new ArrayList<>();
        this.current = new ArrayList<>();
        this.nums = nums;
        Arrays.sort(nums);
        dfs(0);
        return result;
    }

    public void dfs(int idx) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[idx]);
        dfs(idx + 1);
        current.remove(current.size() - 1);
        int prev = nums[idx];
        while (idx < nums.length && nums[idx] == prev) {
            idx ++;
        }
        dfs(idx);
    }
}
