class Solution {
    public int maxArea(int[] heights) {
        int maxVal = Integer.MIN_VALUE;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int currentArea = (right - left) * Math.min(heights[left], heights[right]);
            maxVal = Math.max(maxVal, currentArea);

            if (heights[left] > heights[right]) {
                right --;
            } else {
                left ++;
            }
        }

        return maxVal;
    }
}
