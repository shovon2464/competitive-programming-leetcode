class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> enqHeap = new PriorityQueue<>(
            (a,b) -> (a[0] - b[0])
        );
        for (int i = 0; i < tasks.length; i ++) {
            int[] task = tasks[i];
            enqHeap.offer(new int[]{task[0], task[1], i});
        }
        PriorityQueue<int[]> taskHeap = new PriorityQueue<>(
            (a,b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1])
        );
        int time = enqHeap.peek()[0];
        int[] result = new int[tasks.length];
        int i = 0;
        while (!enqHeap.isEmpty() || !taskHeap.isEmpty()) {
            while (!enqHeap.isEmpty() && enqHeap.peek()[0] <= time) {
                int[] task = enqHeap.poll();
                taskHeap.offer(new int[]{task[1], task[2]});
            }

            if (taskHeap.isEmpty()) {
                time = enqHeap.peek()[0];
            } else {
                int[] task = taskHeap.poll();
                result[i] = task[1];
                i ++;
                time += task[0];
            }
        }

        return result;
    }
}