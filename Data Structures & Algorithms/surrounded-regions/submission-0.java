class Solution {
    int rowN;
    int colN;
    char[][] board;

    public void dfs(int r, int c) {
        if (r < 0 || r >= rowN) return;
        if (c < 0 || c >= colN) return;
        if (board[r][c] != 'O') return;
        board[r][c] = 'T';
        dfs(r+1, c);
        dfs(r-1, c);
        dfs(r, c+1);
        dfs(r, c-1);
    }
    public void solve(char[][] board) {
        this.rowN = board.length;
        this.colN = board[0].length;
        this.board = board;

        for (int r = 0; r < rowN; r++) {
            for (int c = 0; c < colN; c++) {
                if (board[r][c] == 'O') {
                    if (r == 0 || r == rowN - 1 || c == 0 || c == colN - 1) {
                        dfs(r, c);
                    }
                }
            }
        }

        for (int r = 0; r < rowN; r++) {
            for (int c = 0; c < colN; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }

        for (int r = 0; r < rowN; r++) {
            for (int c = 0; c < colN; c++) {
                if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}
