class Solution {
    public int findKthLargest(int[] nums, int k) {
       int left = 0;
       int right = nums.length - 1;
       int target = nums.length - k;
       int pivot = findPivot(nums, left, right);
       while (pivot != target) {
        if (pivot < target) {
            left = pivot + 1;
        } else {
            right = pivot - 1;
        }
        pivot = findPivot(nums, left, right);
       } 
       return nums[pivot];
    }
    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    public int findPivot(int[] nums, int left, int right) {
        int randomIndex = left + new Random().nextInt(right-left+1);
        swap(nums, randomIndex, right);
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] < nums[right]) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }
}
