class NumMatrix {

    int[][] m;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        this.m = new int[row + 1][col + 1];
        for (int r = 1; r <= row; r ++) {
            for (int c = 1; c <= col; c ++) {
                m[r][c] = m[r - 1][c] + m[r][c - 1] - m[r - 1][c - 1] + matrix[r - 1][c - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1 ++;
        col1 ++;
        row2 ++;
        col2 ++;
        return m[row2][col2] - m[row2][col1 - 1] - m[row1 - 1][col2] + m[row1 - 1][col1 -1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */