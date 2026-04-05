class Solution {
    List<List<Integer>> adjacencyList;
    boolean[] visited;
    int count = 0;
    public void dfs(int node) {
        if (visited[node]) return;
        visited[node] = true;
        count++;
        for (int neighbor : adjacencyList.get(node)) {
            dfs(neighbor);
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        this.adjacencyList = new ArrayList<>();
        this.visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        dfs(0);
        return count == n;
     }
}