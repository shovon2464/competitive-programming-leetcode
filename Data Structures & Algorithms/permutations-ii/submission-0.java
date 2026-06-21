class Solution {
    List<List<Integer>> result;
    List<Integer> current;
    int[] nums;
    Map<Integer, Integer> tracker;
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.result = new ArrayList<>();
        this.current = new ArrayList<>();
        this.nums = nums;
        this.tracker = new HashMap<>();
        for (int n : nums) {
            tracker.put(n, tracker.getOrDefault(n, 0) + 1);
        }
        dfs();
        return result;
    }

    public void dfs() {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int n : tracker.keySet()) {
            if (tracker.get(n) > 0) {
                current.add(n);
                tracker.put(n, tracker.get(n) - 1);
                dfs();
                tracker.put(n, tracker.get(n) + 1);
                current.remove(current.size() - 1);
            }
        }
    }
}