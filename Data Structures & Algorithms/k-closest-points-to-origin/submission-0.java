class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<Integer> distanceList = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            int rawDistance = (points[i][0]*points[i][0]) + (points[i][1]*points[i][1]);
            distanceList.add(rawDistance * -100000 - i);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(distanceList);

        while (maxHeap.size() > k) {
            maxHeap.poll();
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            int distance = maxHeap.poll() * -1;
            int index = distance % 100000;
            result[i] = points[index];
        }
        return result;
    }
}
