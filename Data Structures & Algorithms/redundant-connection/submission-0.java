class Solution {
    int[] parents;
    int[] ranks;
    public boolean union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);

        if (parent1 == parent2) return false;

        if (ranks[parent1] > ranks[parent2]) {
            parents[parent2] = parent1;
            ranks[parent1] += ranks[parent2];
        } else {
            parents[parent1] = parent2;
            ranks[parent2] += ranks[parent1];
        }
        return true;
    }

    public int find(int node) {
        if (node != parents[node]) {
            parents[node] = find(parents[node]);
        }
        return parents[node];
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        this.parents = new int[n];
        this.ranks = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        for (int[] edge : edges) {
            if(!union(edge[0], edge[1])) return edge;
        }

        return new int[2];
    }
}
