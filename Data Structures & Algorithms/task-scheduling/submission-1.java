class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char task : tasks) {
            countMap.put(task, countMap.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a,b) -> (b - a)
        );
        for (int value : countMap.values()) {
            maxHeap.offer(value);
        }
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time ++;
            if (!maxHeap.isEmpty()) {
                int task = maxHeap.poll();
                if (task - 1 > 0) {
                    queue.offer(new int[]{task - 1, time + n});
                }
            }

            while (!queue.isEmpty() && queue.peek()[1] <= time) {
                maxHeap.offer(queue.poll()[0]);
            }
        }

        return time;
    }
}
