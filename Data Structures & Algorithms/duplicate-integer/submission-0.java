class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> tracker = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (tracker.contains(nums[i])) return true;
            tracker.add(nums[i]);
        }

        return false;
    }
}