class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> tracker = new HashSet<>();

        int left = 0; 
        for (int right = 0; right < nums.length; right++) {
            if (tracker.contains(nums[right])) {
                return true;
            } 
            tracker.add(nums[right]);
            if (right - left == k) {
                tracker.remove(nums[left]);
                left ++;
            }
        }

        return false;
    }
}