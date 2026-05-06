class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] tracker = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int indexS = (int) s.charAt(i) - 'a';
            int indexT = (int) t.charAt(i) - 'a';
            tracker[indexS] ++;
            tracker[indexT] --;
        }

        for (int i = 0; i < tracker.length; i++) {
            if (tracker[i] != 0) return false;
        }

        return true;
    }
}
