class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        int[] prices = new int[n];
        Arrays.fill(prices, INF);
        prices[src] = 0;

        for (int i = 0; i < k + 1; i ++) {
            int[] tmpPrices = prices.clone();

            for (int[] flight : flights) {
                int source = flight[0];
                int destination = flight[1];
                int cost = flight[2];

                if (prices[source] == INF) continue;

                if (prices[source] + cost < tmpPrices[destination]) {
                    tmpPrices[destination] = prices[source] + cost;
                }
            }

            prices = tmpPrices.clone();
        }

        return prices[dst] != INF ? prices[dst] : -1;
    }
}
