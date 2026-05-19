class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        int minWeight = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int currentDays = 1;
            int totalWeight = 0;

            for (int w : weights) {
                if (totalWeight + w > mid) {
                    currentDays ++;
                    totalWeight = 0;
                }
                totalWeight += w;
            }

            if (currentDays <= days) {
                minWeight = Math.min(minWeight, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return minWeight;
    }
}