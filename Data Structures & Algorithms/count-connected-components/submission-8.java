class Solution {
    int[] parent;
    int[] rank;
    public int find(int node) {
        if (parent[node] == node) return node;
        parent[node] = find(parent[node]);
        return parent[node];
    }
    public int union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 == p2) return 0;
        int r1 = rank[p1];
        int r2 = rank[p2];

        if (r1 > r2) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }

        return 1;
    }
    public int countComponents(int n, int[][] edges) {
        this.parent = new int[n];
        this.rank = new int[n];

        for (int i = 0; i < n; i ++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int result = n;
        for (int[] edge : edges) {
            result -= union(edge[0], edge[1]);
        }

        return result;
    }
}
