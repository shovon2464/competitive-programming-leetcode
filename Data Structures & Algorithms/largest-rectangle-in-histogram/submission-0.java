class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i ++) {
            int start = i;

            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] idxHgt = stack.pop();
                maxArea = Math.max(maxArea, idxHgt[1] * (i - idxHgt[0]));
                start = idxHgt[0];
            }
            stack.push(new int[] {start, heights[i]});
        }

        while (!stack.isEmpty()) {
            int[] idxHgt = stack.pop();
            maxArea = Math.max(maxArea, idxHgt[1] * (n - idxHgt[0]));
        }

        return maxArea;
    }
}
