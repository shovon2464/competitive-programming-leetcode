class Solution {
    public int find(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int result = find(n - 1, memo) + find(n - 2, memo) + find(n - 3, memo);
        memo.put(n, result);
        return result;
    }
    public int tribonacci(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 0);
        memo.put(1, 1);
        memo.put(2, 1);
        return find(n, memo);
    }
}