class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> tracker = new HashMap<>();
        int maxFreq = 0;
        for (int num : nums) {
            tracker.put(num, tracker.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, tracker.get(num));
        }

        List<Integer>[] buckets = new ArrayList[maxFreq + 1];

        for (Map.Entry<Integer, Integer> entry : tracker.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            if (buckets[val] == null) {
                buckets[val] = new ArrayList<>();
            }

            buckets[val].add(key);
        }

        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.length-1; i >= 0; i --) {
            if (buckets[i] != null) {
                for (int val : buckets[i]) {
                    result[index] = val;
                    index ++;
                    if (index == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
