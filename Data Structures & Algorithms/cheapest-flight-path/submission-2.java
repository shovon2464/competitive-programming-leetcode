class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;

        for (int i = 0; i < k + 1; i ++) {
            int[] tempCosts = costs.clone();

            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int c = flight[2];

                if (costs[s] == Integer.MAX_VALUE) continue;
                if (costs[s] + c < tempCosts[d]) {
                    tempCosts[d] = costs[s] + c;
                }
            }

            costs = tempCosts.clone();
        }

        return costs[dst] == Integer.MAX_VALUE ? - 1 : costs[dst];
    }
}
