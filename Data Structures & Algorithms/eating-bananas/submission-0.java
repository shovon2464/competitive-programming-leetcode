class Solution {
    public int minEatingSpeed(int[] piles, int h) {
     int left = 1;
     int right = Integer.MIN_VALUE;

     for (int pile : piles) {
        right = Math.max(pile, right);
     }   

     int min = Integer.MAX_VALUE;

     while (left <= right) {
        int mid = left + (right - left) / 2;

        long hours = 0;

        for (int pile : piles) {
            long hour = (pile + mid -1) / mid;
            hours += hour;
        }

        if (hours <= h) {
            min = Math.min(mid, min);
            right = mid - 1;
        } else {
            left = mid + 1;
        }
     }

     return min;
    }
}
