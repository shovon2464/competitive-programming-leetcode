class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> (a[1] - b[1])
        );
        for (int i = 0; i < profits.length; i ++) {
            minHeap.offer(new int[]{profits[i], capital[i]});
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> (b[0] - a[0])
        );

        for (int i = 0; i < k; i ++) {
            while (!minHeap.isEmpty() && minHeap.peek()[1] <= w) {
                maxHeap.offer(minHeap.poll());
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.poll()[0];
        }

        return w;
    }
}