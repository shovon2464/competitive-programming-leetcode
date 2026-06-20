class Solution {
    List<List<Integer>> result;
    List<Integer> current;
    int n;
    int k;
    public List<List<Integer>> combine(int n, int k) {
        this.result = new ArrayList<>();
        this.current = new ArrayList<>();
        this.n = n;
        this.k = k;
        dfs(1);
        return result;
    }
    public void dfs(int idx) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (idx > n) {
            return;
        }

        for (int i = idx; i <= n; i ++) {
            current.add(i);
            dfs(i + 1);
            current.remove(current.size() - 1);
        }
    }
}