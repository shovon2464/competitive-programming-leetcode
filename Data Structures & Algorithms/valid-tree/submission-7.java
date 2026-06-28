class Solution {
    Map<Integer, List<Integer>> adj;
    Set<Integer> visited;
    public boolean dfs(int node, int prev) {
        if (visited.contains(node)) return false;

        visited.add(node);
        for (int n : adj.get(node)) {
            if (n == prev) continue;
            if (!dfs(n, node)) return false;
        }

        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        this.adj = new HashMap<>();
        this.visited = new HashSet<>();

        for (int i = 0; i < n; i ++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return dfs(0, -1) && visited.size() == n;
    }
}
