class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prevTwo = cost[n - 1];
        int prevOne = cost[n - 2];

        for (int i = n - 3; i >= 0; i --) {
            int current = cost[i] + Math.min(prevOne, prevTwo);
            prevTwo = prevOne;
            prevOne = current;
        }

        return Math.min(prevOne, prevTwo);
    }
}
