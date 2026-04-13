class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Encode: upper bits = negative distance, lower bits = index
        List<Long> encoded = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            long dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            encoded.add(dist * 100000L + i);  // combine distance + index
        }

        // ✅ True heapify O(n) — Long is Comparable, no custom comparator
        PriorityQueue<Long> minHeap = new PriorityQueue<>(encoded);

        // Poll k times → O(k log n)
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int index = (int)(minHeap.poll() % 100000L);  // extract index
            result[i] = points[index];
        }
        return result;
    }
}