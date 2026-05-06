class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tracker = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (tracker.containsKey(diff)) {
                return new int[] {tracker.get(diff), i};
            }
            tracker.put(nums[i],i);
        }

        return new int[] {-1, -1};
    }
}
