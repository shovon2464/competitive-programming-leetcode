class Solution {

    public int find(int idx, int[] nums, Map<Integer, Integer> memo) {
        if (idx >= nums.length) {
            return 0;
        }
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }
        int rob = nums[idx] + find(idx + 2, nums, memo);
        int skip = find(idx + 1, nums, memo);
        int result = Math.max(rob, skip);
        memo.put(idx, result);
        return result;
    }
    public int rob(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();
        return find(0, nums, memo);
    }
}
