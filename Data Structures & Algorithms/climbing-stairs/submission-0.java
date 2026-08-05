class Solution {
    public int climb(int n, Map<Integer, Integer> memo) {
        if (n <= 2) return n;
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int result = climb(n - 1, memo) + climb(n - 2, memo);
        memo.put(n, result);
        return result;
    }
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climb(n, memo);
    }
}
