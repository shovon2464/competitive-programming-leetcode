class Solution {
    int[] parent;
    int[] rank;

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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        this.rank = new int[n];
        this.parent = new int[n];

        for (int i = 0; i < n; i ++) {
            rank[i] = 1;
            parent[i] = i;
        }

        Map<String, Integer> emailToIdx = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            for (int j = 1; j < accounts.get(i).size(); j ++) {
                String email = accounts.get(i).get(j);
                if (emailToIdx.containsKey(email)) {
                    union(i, emailToIdx.get(email));
                } else {
                    emailToIdx.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> emailGroup = new HashMap<>();

        for (Map.Entry<String, Integer> entry : emailToIdx.entrySet()) {
            String email = entry.getKey();
            int idx = entry.getValue();
            int leader = find(idx);
            emailGroup.computeIfAbsent(leader, key -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : emailGroup.entrySet()) {
            int idx = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            String name = accounts.get(idx).get(0);
            List<String> merge = new ArrayList<>();
            merge.add(name);
            merge.addAll(emails);
            result.add(merge);
        }

        return result;
    }
}