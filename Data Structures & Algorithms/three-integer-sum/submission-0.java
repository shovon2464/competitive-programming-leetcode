class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 2; i ++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left ++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left ++;
                    }
                } else if (sum < 0) {
                    left ++;
                } else {
                    right --;
                }
            }
        }

        return result;
    }
}
