class UnionFind {
    int[] rank;
    int[] parent;
    int count;

    public UnionFind(int n) {
        this.rank = new int[n];
        this.parent = new int[n];
        this.count = n;

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

    public void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 == p2) return;

        int r1 = rank[p1];
        int r2 = rank[p2];

        if (r1 > r2) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }

        count --;
    }
}

class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        UnionFind uf = new UnionFind(n);
        Map<Integer, Integer> factorToIdx = new HashMap<>();

        for (int i = 0; i < n; i ++) {
            int num = nums[i];
            int f = 2;

            while (f * f <= num) {
                if (num % f == 0) {
                    if (factorToIdx.containsKey(f)) {
                        uf.union(i, factorToIdx.get(f));
                    } else {
                        factorToIdx.put(f, i);
                    }
                    while (num % f == 0) {
                        num = num / f;
                    }
                } else {
                    f ++;
                }
            }

            if (num > 1) {
                if (factorToIdx.containsKey(num)) {
                    uf.union(i, factorToIdx.get(num));
                } else {
                    factorToIdx.put(num, i);
                }
            }
        }

        return uf.count == 1 ? true : false;
    }
}