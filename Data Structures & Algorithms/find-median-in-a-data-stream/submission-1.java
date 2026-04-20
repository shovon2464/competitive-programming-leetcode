class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            int max = maxHeap.poll();
            int min = minHeap.poll();
            minHeap.add(max);
            maxHeap.add(min);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            int max = maxHeap.poll();
            minHeap.add(max);
        } else if (minHeap.size() > maxHeap.size() + 1) {
            int min = minHeap.poll();
            maxHeap.add(min);
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
