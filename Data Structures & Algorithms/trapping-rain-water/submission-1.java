class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int leftMax = height[left];
        int rightMax = height[right]; 
        int result = 0;

        while (left < right) {
            if (leftMax <= rightMax) {
                result += Math.max((Math.min(leftMax, rightMax) - height[left]), 0);
                left ++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                result += Math.max((Math.min(leftMax, rightMax) - height[right]), 0);
                right --;
                rightMax = Math.max(rightMax, height[right]);
            }
        }

        return result;
    }
}
