class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] tracker = new int[n][2];

        for (int i = 0; i < n; i++) {
            tracker[i] = new int[] {position[i], speed[i]};
        }

        Arrays.sort(tracker, (a,b) -> a[0] - b[0]);

        Deque<Float> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i --) {
            int[] ps = tracker[i];
            float time = (float) (target - ps[0]) / ps[1];
            if (stack.isEmpty() || stack.peek() < time) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
