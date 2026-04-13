class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> stonesList = new ArrayList<>();
        for (int stone : stones) {
            stonesList.add(stone * -1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(stonesList);

        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if (stone2 > stone1) {
                maxHeap.add(stone1 - stone2);
            } else if (stone1 > stone2) {
                maxHeap.add(stone2 - stone1);
            }
        }

        return !maxHeap.isEmpty() ? maxHeap.peek() * -1 : 0;
    }
}
