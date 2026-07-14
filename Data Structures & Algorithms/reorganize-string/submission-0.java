class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> (b[1] - a[1])
        );
        for (Map.Entry<Character, Integer> e : countMap.entrySet()) {
            maxHeap.offer(new int[]{(int) e.getKey(), e.getValue()});
        }
        StringBuilder sb = new StringBuilder();
        int[] prev = null;

        while (!maxHeap.isEmpty() || prev != null) {
            if (maxHeap.isEmpty() && prev != null) {
                return "";
            }
            int[] c = maxHeap.poll();
            sb.append((char) c[0]);
            c[1] -= 1;

            if (prev != null) {
                maxHeap.offer(prev);
            }

            if (c[1] > 0) {
                prev = c;
            } else {
                prev = null;
            }
        }

        return sb.toString();
    }
}