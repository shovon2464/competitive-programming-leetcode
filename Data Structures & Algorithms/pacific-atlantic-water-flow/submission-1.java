class Solution {
    int rowN;
    int colN;
    int[][] heights;
    public void dfs(int r, int c, boolean[][] visited, int maxHeight) {
        if (r < 0 || r >= rowN) return;
        if (c < 0 || c >= colN) return;
        if (visited[r][c]) return;
        if (heights[r][c] < maxHeight) return;
        visited[r][c] = true;
        maxHeight = Math.max(maxHeight, heights[r][c]);
        dfs(r + 1, c, visited, maxHeight);
        dfs(r - 1, c, visited, maxHeight);
        dfs(r, c + 1, visited, maxHeight);
        dfs(r, c - 1, visited, maxHeight);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.rowN = heights.length;
        this.colN = heights[0].length;
        this.heights = heights;
        boolean[][] pac = new boolean[rowN][colN];
        boolean[][] atl = new boolean[rowN][colN];

        for (int c = 0; c < colN; c++) {
            dfs(0, c, pac, heights[0][c]);
            dfs(rowN-1, c, atl, heights[rowN-1][c]);
        }

        for (int r = 0; r < rowN; r++) {
            dfs(r, 0, pac, heights[r][0]);
            dfs(r, colN-1, atl, heights[r][colN-1]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rowN; r ++) {
            for (int c = 0; c < colN; c ++) {
                if (pac[r][c] && atl[r][c]) {
                    result.add(List.of(r,c));
                }
            }
        }
        return result;
    }
}
