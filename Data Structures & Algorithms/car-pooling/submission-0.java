class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> (a[1] - b[1]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> (a[2] - b[2])
        );
        for (int[] trip : trips) {
            while (!minHeap.isEmpty() && minHeap.peek()[2] <= trip[1]) {
                capacity += minHeap.poll()[0];
            }
            capacity -= trip[0];
            minHeap.offer(trip);
            if (capacity < 0) {
                return false;
            }
        }

        return true;
    }
}