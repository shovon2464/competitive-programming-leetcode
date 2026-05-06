class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder currentPrefix = new StringBuilder();
        int currentIndex = 0;

        while (true) {
            if (currentIndex >= strs[0].length()) return currentPrefix.toString();
            char current = strs[0].charAt(currentIndex);
            for (int i = 1; i < strs.length; i++) {
                if (currentIndex >= strs[i].length()) return currentPrefix.toString();
                if (strs[i].charAt(currentIndex) != current) return currentPrefix.toString();
            }
            currentPrefix.append(current);
            currentIndex ++;
        }
    }
}