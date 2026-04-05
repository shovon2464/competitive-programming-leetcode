class Solution {
    int[] parents;
    int[] rank;
    public int find(int node) {
        int res = node;
        while (res != parents[res]) {
            res = parents[res];
        }
        return res;
    }
    public int union(int node1, int node2) {
        int parent1 = node1;
        int parent2 = node2;

        if (parent1 == parent2) return 0;

        if(rank[parent1] > rank[parent2]) {
            parents[node2] = node1;
            rank[node1] += rank[node2];
        } else {
            parents[node1] = node2;
            rank[node2] += rank[node1];
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
