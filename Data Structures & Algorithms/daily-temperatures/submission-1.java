class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        Deque<int[]> stack = new ArrayDeque<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[0] <= temps[i]) {
                int[] tempIdx = stack.pop();
                result[tempIdx[1]] = i - tempIdx[1];
            }
            stack.push(new int[] {temps[i],i});
        }

        return result;
    }
}
