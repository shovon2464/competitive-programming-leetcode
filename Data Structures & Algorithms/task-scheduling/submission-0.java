class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> tracker = new HashMap<>();
        for (char task : tasks) {
            tracker.put(task, tracker.getOrDefault(task, 0)+1);
        }
        List<Integer> taskCount = new ArrayList<>();
        for (int count : tracker.values()) {
            taskCount.add(count * -1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(taskCount);
        int time = 0;
        Queue<List<Integer>> queue = new LinkedList<>();

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time ++;

            if (!maxHeap.isEmpty()) {
                int current = maxHeap.poll();
                if (current + 1 < 0) {
                    queue.add(List.of(time + n, current + 1));
                }
            }

            if (!queue.isEmpty() && queue.peek().get(0) == time) {
                maxHeap.add(queue.poll().get(1));
            }
        }

        return time;
    }
}
