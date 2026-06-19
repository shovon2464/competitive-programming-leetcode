class Solution {
    List<List<Integer>> result;
    List<Integer> current;
    int currentSum;
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.result = new ArrayList<>();
        this.current = new ArrayList<>();
        this.currentSum = 0;
        this.candidates = candidates;
        this.target = target;
        Arrays.sort(this.candidates);
        dfs(0);
        return result;
    }
    public void dfs(int idx) {
        if (currentSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (idx >= candidates.length) {
            return;
        }
        if (currentSum > target) {
            return;
        }
        currentSum += candidates[idx];
        current.add(candidates[idx]);
        dfs(idx + 1);
        currentSum -= candidates[idx];
        current.remove(current.size() - 1);
        int prev = candidates[idx];
        while (idx < candidates.length && candidates[idx] == prev) {
            idx ++;
        }
        dfs(idx);
    }
}
