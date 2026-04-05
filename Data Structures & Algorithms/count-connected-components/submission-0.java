class Solution {
    List<List<Integer>> adjacencyList;
    Set<Integer> visited;
    public void dfs(int node) {
        if (visited.contains(node)) return;
        visited.add(node);
        for (int neighbor : adjacencyList.get(node)) {
            dfs(neighbor);
        }
    }
    public int countComponents(int n, int[][] edges) {
        this.adjacencyList = new ArrayList<>();
        this.visited = new HashSet<>();
        for (int i = 0; i < n; i ++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) continue;
            dfs(i);
            count ++;
        }

        return count;
    }
}
