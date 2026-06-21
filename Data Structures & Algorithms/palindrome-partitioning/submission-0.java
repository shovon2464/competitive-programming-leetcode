class Solution {
    List<List<String>> result;
    List<String> current;
    String s;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        this.current = new ArrayList<>();
        this.s = s;
        dfs(0);
        return result;
    }

    public void dfs(int idx) {
        if (idx == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = idx; i < s.length(); i ++) {
            if (checkPalindrome(s.substring(idx, i + 1))) {
                current.add(s.substring(idx, i + 1));
                dfs(i + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    public boolean checkPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left ++;
            right --;
        }
        return true;
    }
}
