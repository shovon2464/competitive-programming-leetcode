class Solution {
    char[][] board;
    int rowN;
    int colN;

    public void dfs(int row, int col) {
        if (row < 0 || row >= rowN) return;
        if (col < 0 || col >= colN) return;
        if (board[row][col] != 'O') return;

        board[row][col] = 'T';
        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }

    public void solve(char[][] board) {
        this.board = board;
        this.rowN = board.length;
        this.colN = board[0].length;

        for (int r = 0; r < rowN; r ++) {
            for (int c = 0; c < colN; c ++) {
                if (board[r][c] == 'O') {
                    if (r == 0 || r == rowN - 1 || c == 0 || c == colN - 1) {
                        dfs(r, c);
                    }
                }
            }
        }    

        for (int r = 0; r < rowN; r ++) {
            for(int c = 0; c < colN; c ++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } 
            }
        }

        for (int r = 0; r < rowN; r ++) {
            for (int c = 0; c < colN; c ++) {
                if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}
