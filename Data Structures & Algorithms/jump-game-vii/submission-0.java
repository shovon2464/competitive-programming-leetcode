class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int farthest = 0;

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            int start = Math.max(idx + minJump, farthest + 1);
            int end = Math.min(idx + maxJump, s.length() - 1);

            for (int i = start; i <= end; i ++) {
                if (s.charAt(i) == '0') {
                    if (i == s.length() - 1) return true;
                    queue.offer(i);
                }
            }

            farthest = Math.max(farthest, end);
        }

        return false;
    }
}