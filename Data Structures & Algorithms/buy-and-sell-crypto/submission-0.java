class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int left = 0;
        for (int right = 1; right < prices.length; right ++) {
            if (prices[right] > prices[left]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(profit, maxProfit);
            } else {
                left = right;
            }
        }

        return maxProfit;
    }
}
