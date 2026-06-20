class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return dfs(nums, 0);
    }

    public List<List<Integer>> dfs(int[] nums, int idx) {
        if (idx == nums.length) {
            List<List<Integer>> temp = new ArrayList<>();
            temp.add(new ArrayList<>());
            return temp;
        }
        List<List<Integer>> permutations = dfs(nums, idx + 1);
        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> permutation : permutations) {
            for (int i = 0; i < permutation.size() + 1; i ++) {
                List<Integer> permutationCopy = new ArrayList<>(permutation);
                permutationCopy.add(i, nums[idx]);
                result.add(permutationCopy);
            }
        }

        return result;
    }
}
