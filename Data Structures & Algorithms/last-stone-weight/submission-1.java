class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() >= 2) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (x == y) continue;
            int finalValue = y - x;
            maxHeap.offer(finalValue);
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.peek();
    }
}
