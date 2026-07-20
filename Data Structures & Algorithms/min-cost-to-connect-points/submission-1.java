class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a,b) -> (a[1] - b[1])
        );
        Set<Integer> visited = new HashSet<>();
        int totalCost = 0;
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] c = queue.poll();
            int idx1 = c[0];
            int cost1 = c[1];
            if (visited.contains(idx1)) continue;
            visited.add(idx1);
            totalCost += cost1;
            int x1 = points[idx1][0];
            int y1 = points[idx1][1];
            for (int i = 0; i < points.length; i ++) {
                if (visited.contains(i)) continue;
                int x2 = points[i][0];
                int y2 = points[i][1];
                int dst = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                queue.offer(new int[]{i, dst});
            }
        }

        return totalCost;
    }
}
