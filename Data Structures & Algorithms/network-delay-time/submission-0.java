class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] time : times) {
            adj.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[] {time[1], time[2]});
            // {destination, cost}
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> (a[0] - b[0])
        );
        minHeap.add(new int[]{0,k});
        // {cost, destination}

        int totalCost = 0;

        while (!minHeap.isEmpty()) {
            int[] costDest = minHeap.poll();
            int cost1 = costDest[0];
            int dest1 = costDest[1];

            if (visited.contains(dest1)) continue;
            visited.add(dest1);
            
            totalCost = Math.max(totalCost, cost1);

            List<int[]> neighbors = adj.get(dest1);

            if (neighbors == null || neighbors.isEmpty()) continue;

            for (int[] neighbor : neighbors) {
                int dest2 = neighbor[0];
                int cost2 = neighbor[1];
                if (!visited.contains(dest2)) {
                    minHeap.add(new int[] {cost2+cost1, dest2});
                }
            }
        }

        return visited.size() == n ? totalCost : -1;
    }
}
