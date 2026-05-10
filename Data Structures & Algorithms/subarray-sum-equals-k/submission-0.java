class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> tracker = new HashMap<>();
        tracker.put(0,1);
        int prefixSum = 0;

        int count = 0;

        for (int num : nums) {
            prefixSum += num;
            int diff = prefixSum - k;

            count += tracker.getOrDefault(diff, 0);

            tracker.put(prefixSum, tracker.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}