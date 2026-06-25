class Solution {
    int[][] grid;
    int rowN;
    int colN;
    boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.rowN = grid.length;
        this.colN = grid[0].length;
        this.visited = new boolean[rowN][colN];
        int maxArea = 0;

        for (int r = 0; r < rowN; r ++) {
            for (int c = 0; c < colN; c ++) {
                if (grid[r][c] == 0) continue;
                if (visited[r][c]) continue;
                int area = dfs(r, c);
                maxArea = Math.max(area, maxArea);
            }
        }

        return maxArea;
    }

    public int dfs(int row, int col) {
        if (row < 0 || row >= rowN) return 0;
        if (col < 0 || col >= colN) return 0;
        if (visited[row][col]) return 0;
        if (grid[row][col] == 0) return 0;

        visited[row][col] = true;

        return 1 + dfs(row + 1, col) + dfs(row - 1, col) + dfs(row, col + 1) + dfs(row, col - 1);
    }
}
