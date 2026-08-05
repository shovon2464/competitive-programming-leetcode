class Solution {
    public int tribonacci(int n) {
        if (n <= 1) return n;
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 3; i <= n; i ++) {
            int current = a + b + c;
            a = b;
            b = c;
            c = current;
        }
        return c;
    }
}