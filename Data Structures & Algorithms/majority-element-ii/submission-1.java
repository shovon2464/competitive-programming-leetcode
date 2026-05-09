class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int majority1 = Integer.MIN_VALUE;
        int majority2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (num == majority1) {
                count1 ++;
            } else if (num == majority2) {
                count2 ++;
            } else if (count1 == 0) {
                majority1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                majority2 = num;
                count2 = 1;
            } else {
                count1 --;
                count2 --;
            }
        }

        int count11 = 0;
        int count22 = 0;

        for (int num : nums) {
            if (num == majority1) count11 ++;
            if (num == majority2) count22 ++;
        }

        int comparator = nums.length / 3;

        List<Integer> result = new ArrayList<>();

        if (count11 > comparator) {
            result.add(majority1);
        }
        if (count22 > comparator) {
            result.add(majority2);
        }

        return result;
    }
}