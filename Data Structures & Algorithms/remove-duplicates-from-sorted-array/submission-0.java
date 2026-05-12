class Solution {
    public int removeDuplicates(int[] nums) {
       int i = 0;
       int last = Integer.MIN_VALUE;
       for (int j = 0; j < nums.length; j++) {
        if (nums[j] != last) {
            nums[i] = nums[j];
            i ++;
            last = nums[j];
        }
       } 
       return i;
    }
}