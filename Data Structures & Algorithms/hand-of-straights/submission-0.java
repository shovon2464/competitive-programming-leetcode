class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : hand) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(countMap.keySet());

        while (!minHeap.isEmpty()) {
            int start = minHeap.peek();

            for (int i = start; i < start + groupSize; i ++) {
                if (!countMap.containsKey(i) || countMap.get(i) == 0) {
                    return false;
                }
                countMap.put(i, countMap.get(i) - 1);

                if (countMap.get(i) == 0) {
                    if (minHeap.peek() != i) {
                        return false;
                    }
                    minHeap.poll();
                }
            }
        }
        

        return true;
    }
}
