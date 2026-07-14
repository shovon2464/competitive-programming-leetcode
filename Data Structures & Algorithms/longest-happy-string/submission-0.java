class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (d,e) -> (e[1] - d[1])
        );
        if (a > 0) {
            maxHeap.offer(new int[]{(int) 'a', a});
        }
        if (b > 0) {
            maxHeap.offer(new int[]{(int) 'b', b});
        }
        if (c > 0) {
            maxHeap.offer(new int[]{(int) 'c', c});
        }
        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            int[] c1 = maxHeap.poll();
            char t = (char) c1[0];
            int len = sb.length();
            if (len > 1 && t == sb.charAt(len - 1) && t == sb.charAt(len - 2)) {
                if (maxHeap.isEmpty()) {
                    break;
                }
                int[] c2 = maxHeap.poll();
                sb.append((char)c2[0]);
                c2[1] -= 1;
                if (c2[1] > 0) {
                    maxHeap.offer(c2);
                }
            } else {
                sb.append((char) c1[0]);
                c1[1] -= 1;
            }
            if (c1[1] > 0) {
                maxHeap.offer(c1);
            }
        }

        return sb.toString();
    }
}