class Solution {
    String[][] phone = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"},
        { "j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"},
        {"t","u", "v"}, {"w", "x", "y", "z"}};
    List<String> result;
    StringBuilder sb;
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        this.result = new ArrayList<>();
        this.sb = new StringBuilder();
        dfs(digits, 0);
        return result;
    }

    public void dfs(String digits, int idx) {
        if (idx == digits.length()) {
            result.add(sb.toString());
            return;
        }

        int button = digits.charAt(idx) - '0';
        for (String s : phone[button - 2]) {
            sb.append(s);
            dfs(digits, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
