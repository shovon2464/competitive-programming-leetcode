class Solution {
    int[] parent;
    int[] rank;
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

    public int find(int node) {
        if (parent[node] == node) return node;
        parent[node] = find(parent[node]);
        return parent[node];
    }
    public boolean validTree(int n, int[][] edges) {
        this.parent = new int[n];
        this.rank = new int[n];

        for (int i = 0; i < n; i ++){
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) return false;
        }

        int root = find(0);
        for (int i = 1; i < n; i ++) {
            if (find(i) != root) return false;
        }

        return true;
    }
}
