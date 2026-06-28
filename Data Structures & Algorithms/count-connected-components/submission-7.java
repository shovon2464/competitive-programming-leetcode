class Solution {
    Set<Integer> visited;
    Map<Integer, List<Integer>> adj;
    public void dfs(int node) {
        if (visited.contains(node)) return;

        visited.add(node);
        for (int n : adj.get(node)) {
            dfs(n);
        }
    }
    public int countComponents(int n, int[][] edges) {
        this.visited = new HashSet<>();
        this.adj = new HashMap<>();

        for (int i = 0; i < n; i ++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int connected = 0;
        int i = 0;

        while (i < n && visited.size() < n) {
            int prev = visited.size();
            dfs(i);
            i ++;
            if (prev < visited.size()) {
                connected ++;
            }
        }

        return connected;
    }
}
