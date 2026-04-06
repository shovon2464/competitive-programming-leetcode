class Solution {
    List<List<Integer>> adjacencyList;
    Set<Integer> visited;
    public boolean dfs(int node, int prevNode) {
        if (visited.contains(node)) return false;
        visited.add(node);
        for(int neighbor : adjacencyList.get(node)) {
            if (neighbor == prevNode) continue;
            if (!dfs(neighbor, node)) return false;
        }
        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        this.adjacencyList = new ArrayList<>();
        this.visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        return dfs(0, -1) && visited.size() == n; 

    }
}
