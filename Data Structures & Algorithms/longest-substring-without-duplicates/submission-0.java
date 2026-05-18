class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Set<Character> tracker = new HashSet<>();
        int longest = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right ++) {
            while (!tracker.isEmpty() && tracker.contains(s.charAt(right))) {
                tracker.remove(s.charAt(left));
                left ++;
            }
            tracker.add(s.charAt(right));
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
