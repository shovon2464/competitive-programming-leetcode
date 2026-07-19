class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            adj.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a,b) -> (a[1] - b[1])
        );
        Set<Integer> visited = new HashSet<>();
        queue.offer(new int[]{k, 0});
        int totalCost = 0;

        while (!queue.isEmpty()) {
            int[] c = queue.poll();
            int node1 = c[0];
            int cost1 = c[1];
            if (visited.contains(node1)) continue;
            visited.add(node1);
            totalCost = Math.max(totalCost, cost1);
            for (int[] neighbor : adj.getOrDefault(node1, Collections.emptyList())) {
                int node2 = neighbor[0];
                int cost2 = neighbor[1];
                if (visited.contains(node2)) continue;
                queue.offer(new int[]{node2, cost1 + cost2});
            }
        }

        return visited.size() == n ? totalCost : - 1;

    }
}
