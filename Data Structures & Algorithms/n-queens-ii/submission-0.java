class Solution {
    int result;
    int n;
    boolean[] column;
    boolean[] posDiag;
    boolean[] negDiag;
    public int totalNQueens(int n) {
        this.result = 0;
        this.n = n;
        this.column = new boolean[2 * n];
        this.posDiag = new boolean[2 * n];
        this.negDiag = new boolean[2 * n];
        dfs(0);
        return result;
    }

    public void dfs(int row) {
        if (row == n) {
            result ++;
            return;
        }

        for (int col = 0; col < n; col ++) {
            if (column[col]) continue;
            if (posDiag[row + col]) continue;
            if (negDiag[row - col + n]) continue;

            column[col] = true;
            posDiag[row + col] = true;
            negDiag[row - col + n] = true;

            dfs(row + 1);

            column[col] = false;
            posDiag[row + col] = false;
            negDiag[row - col + n] = false;
        }
    }
}