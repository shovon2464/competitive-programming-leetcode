class Solution {
    int[][] heights;
    int rowN;
    int colN;

    public void dfs(int row, int col, boolean[][] visited, int prevHeight) {
        if (row < 0 || row >= rowN) return;
        if (col < 0 || col >= colN) return;
        if (visited[row][col]) return;
        if (heights[row][col] < prevHeight) return;

        visited[row][col] = true;

        dfs(row + 1, col, visited, heights[row][col]);
        dfs(row - 1, col, visited, heights[row][col]);
        dfs(row, col + 1, visited, heights[row][col]);
        dfs(row, col - 1, visited, heights[row][col]);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.rowN = heights.length;
        this.colN = heights[0].length;
        boolean[][] pac = new boolean[rowN][colN];
        boolean[][] atl = new boolean[rowN][colN];

        for (int r = 0; r < rowN; r ++) {
            dfs(r, 0, pac, heights[r][0]);
            dfs(r, colN - 1, atl, heights[r][colN - 1]);
        } 

        for (int c = 0; c < colN; c ++) {
            dfs(0, c, pac, heights[0][c]);
            dfs(rowN - 1, c, atl, heights[rowN - 1][c]);
        }   

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < rowN; r ++) {
            for (int c = 0; c < colN; c ++) {
                if (pac[r][c] && atl[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }

        return result;
    }
}
