class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxFreq = 0;
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, countMap.get(num));
        }
        List<Integer>[] buckets = new ArrayList[maxFreq + 1];
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (buckets[value] == null) {
                buckets[value] = new ArrayList<>();
            }
            buckets[value].add(key);
        }
        int[] result = new int[k];
        int i = 0;
        for (int m = buckets.length - 1; m >= 0; m --) {
            if (buckets[m] == null) continue;
            for (int n = 0; n < buckets[m].size(); n ++) {
                result[i] = buckets[m].get(n);
                i ++;
                if (i == result.length) {
                    return result;
                }
            }
        }
        return result;
    }
}
