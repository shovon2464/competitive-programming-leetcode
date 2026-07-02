class Solution {
    Random random;
    public int findKthLargest(int[] nums, int k) {
        this.random = new Random();
        int start = 0;
        int end = nums.length - 1;
        int target = nums.length - k;
        int pivot = findPivot(nums, start, end);
        while (pivot != target) {
            if (pivot > target) {
                end = pivot - 1;
            } else {
                start = pivot + 1;
            }
            pivot = findPivot(nums, start, end);
        }
        return nums[pivot];
    }

    public void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    public int findPivot(int[] nums, int start, int end) {
        int randomIdx = start + random.nextInt(end - start + 1);
        swap(nums, randomIdx, end);
        int i = start;
        for (int j = start; j < end; j ++) {
            if (nums[j] < nums[end]) {
                swap(nums, i, j);
                i ++;
            }
        }

        swap(nums, i, end);
        return i;
    }
}
