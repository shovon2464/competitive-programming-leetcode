class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            countMap.put(i, adj.get(i).size());
            if (adj.get(i).size() == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            if (n <= 2) {
                return new ArrayList<>(queue);
            }
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i ++) {
                int current = queue.poll();
                n --;
                for (int neighbor : adj.get(current)) {
                    countMap.put(neighbor, countMap.get(neighbor) - 1);
                    if (countMap.get(neighbor) == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return List.of(0);
    }
}