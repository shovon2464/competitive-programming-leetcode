class Solution {
    public int minCostConnectPoints(int[][] points) {
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> (a[0] - b[0])
        );
        minHeap.add(new int[]{0,0});
        int cost = 0;

        while (!minHeap.isEmpty()) {
            int[] distIndex = minHeap.poll();
            int dist = distIndex[0];
            int index = distIndex[1];
            if (visited.contains(index)) continue;
            cost += dist;
            visited.add(index);
            int x1 = points[index][0];
            int y1 = points[index][1];

            for (int i = 0; i < points.length; i++) {
                if (visited.contains(i)) continue;
                int x2 = points[i][0];
                int y2 = points[i][1];
                int distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                minHeap.add(new int[]{distance, i});
            }
        }

        return cost;
    }
}
