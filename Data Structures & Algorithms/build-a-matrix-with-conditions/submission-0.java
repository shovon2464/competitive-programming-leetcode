class Solution {
    public boolean dfs(int node, Map<Integer, List<Integer>> adj, Set<Integer> visited,
            Set<Integer> path, List<Integer> order) {
            
            if (path.contains(node)) return true;
            if (visited.contains(node)) return false;

            path.add(node);
            for (int neighbor : adj.getOrDefault(node, Collections.emptyList())) {
                if (dfs(neighbor, adj, visited, path, order)) return true;
            }

            path.remove(node);
            visited.add(node);
            order.add(node);

            return false;
    }

    public List<Integer> topoSort(int[][] edges, int k) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> path = new HashSet<>();
        List<Integer> order = new ArrayList<>();

        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
        }

        for (int i = 1; i <= k; i ++) {
            if (dfs(i, adj, visited, path, order)) return new ArrayList<>();
        }

        Collections.reverse(order);
        return order;
    }
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder = topoSort(rowConditions, k);
        List<Integer> colOrder = topoSort(colConditions, k);

        if (rowOrder.size() == 0 || colOrder.size() == 0) {
            return new int[0][0];
        }

        Map<Integer, Integer> rowIdx = new HashMap<>();
        Map<Integer, Integer> colIdx = new HashMap<>();

        for (int i = 0; i < rowOrder.size(); i ++) {
            rowIdx.put(rowOrder.get(i), i);
            colIdx.put(colOrder.get(i), i);
        }

        int[][] result = new int[k][k];
        for (int i = 1; i <= k; i ++) {
            int row = rowIdx.get(i);
            int col = colIdx.get(i);

            result[row][col] = i;
        }

        return result;
    }
}