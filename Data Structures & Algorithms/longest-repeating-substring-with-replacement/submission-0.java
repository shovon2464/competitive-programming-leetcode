class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> tracker = new HashMap<>();
        int longest = 0;
        int maxFreq = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right ++) {
            tracker.put(s.charAt(right), tracker.getOrDefault(s.charAt(right), 0) + 1);
            maxFreq = Math.max(maxFreq, tracker.get(s.charAt(right)));

            while (right - left + 1 - maxFreq > k) {
                tracker.put(s.charAt(left), tracker.get(s.charAt(left)) - 1);
                left ++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
