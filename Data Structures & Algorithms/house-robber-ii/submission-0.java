class Solution {
    public int find(int idx, int limit, int[] nums, Map<Integer, Integer> memo) {
        if (idx >= limit) {
            return 0;
        }
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }
        int rob = nums[idx] + find(idx + 2, limit, nums, memo);
        int skip = find(idx + 1, limit, nums, memo);
        int result = Math.max(rob, skip);
        memo.put(idx, result);
        return result;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        Map<Integer, Integer> memo1 = new HashMap<>();
        Map<Integer, Integer> memo2 = new HashMap<>();
        return Math.max(find(0, n - 1, nums, memo1), find(1, n, nums, memo2));
    }
}
