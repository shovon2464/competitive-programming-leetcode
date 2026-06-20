class Solution {
    List<String> result;
    StringBuilder sb;
    int n;
    int openCount;
    int closedCount;
    public List<String> generateParenthesis(int n) {
        this.result = new ArrayList<>();
        this.sb = new StringBuilder();
        this.n = n;
        this.openCount = 0;
        this.closedCount = 0;
        dfs();
        return result;
    }
    public void dfs() {
        if (closedCount == n) {
            result.add(sb.toString());
            return;
        }
        if (openCount < n) {
            sb.append("(");
            openCount ++;
            dfs();
            sb.deleteCharAt(sb.length() - 1);
            openCount --;
        }
        if (closedCount < openCount) {
            sb.append(")");
            closedCount ++;
            dfs();
            sb.deleteCharAt(sb.length() - 1);
            closedCount --;
        }
    }
}
