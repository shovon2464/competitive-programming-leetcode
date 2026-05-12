class Solution {
    public String mergeAlternately(String word1, String word2) {
        int idx1 = 0;
        int idx2 = 0;
        StringBuilder sb = new StringBuilder();

        while (idx1 < word1.length() || idx2 < word2.length()) {
            if (idx1 < word1.length()) {
                sb.append(word1.charAt(idx1));
                idx1 ++;
            }
            if (idx2 < word2.length()) {
                sb.append(word2.charAt(idx2));
                idx2 ++;
            }
        }

        return sb.toString();
    }
}