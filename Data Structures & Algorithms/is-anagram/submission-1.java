class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] tracker = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            int idx1 = s.charAt(i) - 'a';
            tracker[idx1] ++;
            int idx2 = t.charAt(i) - 'a';
            tracker[idx2] --;
        }
        for (int i = 0; i < 26; i ++) {
            if (tracker[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
