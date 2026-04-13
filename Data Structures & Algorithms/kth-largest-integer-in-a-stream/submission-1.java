class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().toList();
        minHeap = new PriorityQueue<>(numsList);

        while (minHeap.size() > k) {
            minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return !minHeap.isEmpty() ? minHeap.peek() : -1;
    }
}
