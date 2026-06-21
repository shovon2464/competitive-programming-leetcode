class Solution {
    char[][] board;
    int rowN;
    int colN;
    String word;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rowN = board.length;
        this.colN = board[0].length;
        this.word = word;

        for (int r = 0; r < rowN; r ++) {
            for (int c = 0; c < colN; c ++) {
                if (dfs(r,c,0)) return true;
            }
        }

        return false;
    }

    public boolean dfs(int row, int col, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (row < 0 || row >= rowN) return false;
        if (col < 0 || col >= colN) return false;
        if (board[row][col] != word.charAt(idx)) return false;

        char temp = board[row][col];
        board[row][col] = '#';
        boolean result = dfs(row + 1, col, idx + 1) || dfs(row - 1, col, idx + 1) 
            || dfs(row, col + 1, idx + 1) || dfs(row, col - 1, idx + 1);
        
        board[row][col] = temp;
        return result;
    }
}
