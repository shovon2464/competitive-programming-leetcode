class Solution {
    List<List<String>> result;
    int n;
    char[][] board;
    boolean[] column;
    boolean[] posDiag;
    boolean[] negDiag;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.n = n;
        this.board = new char[n][n];
        for (int r = 0; r < n; r ++) {
            for (int c = 0; c < n; c ++) {
                board[r][c] = '.';
            }
        }
        this.column = new boolean[n * 2];
        this.posDiag = new boolean[n * 2];
        this.negDiag = new boolean[n * 2];
        dfs(0);
        return result;
    }
    public void dfs(int row) {
        if (row == n) {
            result.add(stringify());
            return;
        }

        for (int col = 0; col < n; col ++) {
            if (column[col]) continue;
            if (posDiag[row + col]) continue;
            if (negDiag[row - col + n]) continue;

            board[row][col] = 'Q';
            column[col] = true;
            posDiag[row + col] = true;
            negDiag[row - col + n] = true;

            dfs(row + 1);

            board[row][col] = '.';
            column[col] = false;
            posDiag[row + col] = false;
            negDiag[row - col + n] = false;
        }
    }

    public List<String> stringify() {
        List<String> result = new ArrayList<>();

        for (char[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (char c : row) {
                sb.append(c);
            }
            result.add(sb.toString());
        }

        return result;
    }
}
