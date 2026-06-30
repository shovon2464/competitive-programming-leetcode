class Solution {
    int[] rank;
    int[] parent;

    public int find(int node) {
        if (parent[node] == node) return node;
        parent[node] = find(parent[node]);
        return parent[node];
    }

    public boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 == p2) return false;

        int r1 = rank[p1];
        int r2 = rank[p2];

        if (r1 > r2) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }

        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        this.rank = new int[n];
        this.parent = new int[n];


        for (int i = 1; i < n; i ++) {
            rank[i] = 1;
            parent[i] = i;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) return edge;
        }

        return new int[2];
    }
}
