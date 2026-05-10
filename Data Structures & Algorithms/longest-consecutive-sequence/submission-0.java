class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> tracker = new HashSet<>();

        for (int num : nums) {
            tracker.add(num);
        }

        int longest = Integer.MIN_VALUE;

        for (int num : tracker) {
            if (!tracker.contains(num-1)) {
                int curNum = num;
                int curLen = 0;

                while (true) {
                    if (tracker.contains(curNum)) {
                        curLen ++;
                        curNum ++;
                    } else {
                        longest = Math.max(longest, curLen);
                        break;
                    }
                }
            }
        }

        return longest;

    }
}
