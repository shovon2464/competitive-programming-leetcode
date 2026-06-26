class Solution {
    List<String> result;
    List<String> current;
    String s;
    Set<String> words;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.result = new ArrayList<>();
        this.current = new ArrayList<>();
        this.s = s;
        this.words = new HashSet<>(wordDict);
        dfs(0);
        return result;
    }

    public void dfs(int idx) {
        if (idx == s.length()) {
            result.add(stringify());
            return;
        }

        for (int i = idx; i < s.length(); i ++) {
            if (words.contains(s.substring(idx, i + 1))) {
                current.add(s.substring(idx, i + 1));
                dfs(i + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    public String stringify() {
        StringBuilder sb = new StringBuilder();
        for (String str : current) {
            sb.append(str);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}