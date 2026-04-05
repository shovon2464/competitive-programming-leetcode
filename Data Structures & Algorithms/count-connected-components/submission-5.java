class Solution {
    int[] parents;
    int[] rank;
    public int find(int node) {
        int result = node;
        while (result != parents[result]) {
            parents[result] = parents[parents[result]];
            result = parents[result];
        }
        return result;
    }

    public int union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);
        if (parent1 == parent2) return 0;
        if (rank[parent1] > rank[parent2]) {
            parents[parent2] = parent1;
            rank[parent1] += rank[parent2];
        } else {
            parents[parent1] = parent2;
            rank[parent2] += rank[parent1]; 
        }
        return 1;
    }
    public int countComponents(int n, int[][] edges) {
        this.parents = new int[n];
        this.rank = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            rank[i] = 1;
        }

        int result = n;
        for (int[] edge : edges) {
            result -= union(edge[0], edge[1]);
        }
        return result;
    }
}
