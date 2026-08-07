class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        for (int j = i; j < nums.length; j ++) {
            if (nums[j] == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i ++;
            }
        }
        for (int j = i; j < nums.length; j ++) {
            if (nums[j] == 1) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i ++;
            }
        }
    }
}