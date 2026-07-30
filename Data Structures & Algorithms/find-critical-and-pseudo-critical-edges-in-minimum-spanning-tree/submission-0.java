class UnionFind {
    int[] rank;
    int[] parent;
    public UnionFind(int n) {
        this.rank = new int[n];
        this.parent = new int[n];

        for (int i = 0; i < n; i ++) {
            rank[i] = 1;
            parent[i] = i;
        }
    }

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

    public int maxRank() {
        int max = 0;
        for (int r : rank) {
            max = Math.max(r, max);
        }

        return max;
    }
}
class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int[][] newEdges = new int[edges.length][4];
        for (int i = 0; i < edges.length; i ++) {
            newEdges[i] = new int[]{edges[i][0], edges[i][1], edges[i][2], i};
        }

        Arrays.sort(newEdges, (a,b) -> (a[2] - b[2]));

        int mstWeight = 0;
        UnionFind uf = new UnionFind(n);

        for (int[] edge : newEdges) {
            if (uf.union(edge[0], edge[1])) {
                mstWeight += edge[2];
            }
        }

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int[] edge1 : newEdges) {
            int n1 = edge1[0];
            int n2 = edge1[1];
            int w1 = edge1[2];
            int idx1 = edge1[3];

            int weight = 0;
            uf = new UnionFind(n);

            for (int[] edge2 : newEdges) {
                int v1 = edge2[0];
                int v2 = edge2[1];
                int w2 = edge2[2];
                int idx2 = edge2[3];

                if (idx1 == idx2) continue;

                if (uf.union(v1, v2)) {
                    weight += w2;
                }
            }

            if (uf.maxRank() < n || mstWeight < weight) {
                critical.add(idx1);
                continue;
            }

            weight = w1;
            uf = new UnionFind(n);
            uf.union(n1, n2);

            for (int[] edge2 : newEdges) {
                int v1 = edge2[0];
                int v2 = edge2[1];
                int w2 = edge2[2];
                int idx2 = edge2[3];

                if (uf.union(v1, v2)) {
                    weight += w2;
                }
            }

            if (weight == mstWeight) {
                pseudo.add(idx1);
            }
        }

        return List.of(critical, pseudo);
    }
}