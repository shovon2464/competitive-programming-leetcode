class Solution {
    public int jump(int[] nums) {
        int left = 0;
        int right = 0;
        int level = 0;

        while (right < nums.length - 1) {
            level ++;
            int farthest = 0;

            for (int i = left; i <= right; i ++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right + 1;
            right = farthest;
        }

        return level;
    }
}
