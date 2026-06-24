class Solution {
    int[][] grid;
    int rowN;
    int colN;
    boolean[][] visited;
    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        this.rowN = grid.length;
        this.colN = grid[0].length;
        this.visited = new boolean[rowN][colN];

        for (int r = 0; r < rowN; r ++) {
            for (int c = 0; c < colN; c ++) {
                if (grid[r][c] == 1) {
                    return dfs(r, c);
                }
            }
        }

        return - 1;
    }

    public int dfs(int row, int col) {
        if (row < 0 || row >= rowN) return 1;
        if (col < 0 || col >= colN) return 1;
        if (grid[row][col] == 0) return 1;
        if (visited[row][col]) return 0;

        visited[row][col] = true;

        return dfs(row + 1, col) + dfs(row -1, col) + dfs(row, col + 1) + dfs(row, col - 1); 
    }
}