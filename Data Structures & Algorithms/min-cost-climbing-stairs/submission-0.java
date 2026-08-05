class Solution {

    public int climb(int idx, int[] cost, Map<Integer, Integer> memo) {
        if (idx >= cost.length) return 0;
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }
        int result = cost[idx] + Math.min(climb(idx + 1, cost, memo), climb(idx + 2, cost, memo));
        memo.put(idx, result);
        return result;
    }
    public int minCostClimbingStairs(int[] cost) {
        Map<Integer, Integer> memo = new HashMap<>();
        return Math.min(climb(0, cost, memo), climb(1, cost, memo));
    }
}
