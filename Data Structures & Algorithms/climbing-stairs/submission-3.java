class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int prevOne = 2;
        int prevTwo = 1;

        for (int i = 3; i <= n; i ++) {
            int current = prevOne + prevTwo;
            prevTwo = prevOne;
            prevOne = current;
        }

        return prevOne;
    }
}
