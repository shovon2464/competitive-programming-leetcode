class Solution {
    public String longestCommonPrefix(String[] strs) {
        for (int idx = 0; idx < strs[0].length(); idx ++) {
            char current = strs[0].charAt(idx);
            for (int i = 1; i < strs.length; i ++) {
                if (idx > strs[i].length() || strs[i].charAt(idx) != current) {
                    return strs[0].substring(0, idx);
                }
            }
        }
        return strs[0];
    }
}