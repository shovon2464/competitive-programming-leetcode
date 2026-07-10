class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>(
            (a,b) -> (b - a)
        );
        this.minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        if (maxHeap.size() - minHeap.size() > 1) {
            int maxNum = maxHeap.poll();
            minHeap.offer(maxNum);
        }
        if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            int maxNum = maxHeap.poll();
            int minNum = minHeap.poll();
            maxHeap.offer(minNum);
            minHeap.offer(maxNum);
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        } else {
            return (double) minHeap.peek();
        }
    }
}
