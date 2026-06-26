class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> incoming = new HashMap<>();
        Map<Integer, Integer> outgoing = new HashMap<>();

        for (int[] t : trust) {
            int s = t[0];
            int d = t[1];

            incoming.put(d, incoming.getOrDefault(d,0) + 1);
            outgoing.put(s, outgoing.getOrDefault(s,0) + 1);
        }

        for (int i = 1; i <= n; i ++) {
            if (incoming.getOrDefault(i, 0) == n - 1 && outgoing.getOrDefault(i, 0) == 0) {
                return i;
            }
        }

        return - 1;
    }
}