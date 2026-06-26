class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int INF = Integer.MAX_VALUE;
        int rowN = grid.length;
        int colN = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int distance = 0;
        boolean[][] visited = new boolean[rowN][colN];
        
        for (int r = 0; r < rowN; r ++) {
            for (int c = 0; c < colN; c ++) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[] {r, c});
                    visited[r][c] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            distance ++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i ++) {
                int[] rc = queue.poll();
                int r = rc[0];
                int c = rc[1];

                for (int[] direction : directions) {
                    int rn = r + direction[0];
                    int cn = c + direction[1];
                    if (rn < 0 || rn >= rowN) continue;
                    if (cn < 0 || cn >= colN) continue;
                    if (grid[rn][cn] == 0) continue;
                    if (visited[rn][cn]) continue;
                    if (grid[rn][cn] == -1) continue;
                    grid[rn][cn] = distance;
                    visited[rn][cn] = true;
                    queue.offer(new int[] {rn, cn});
                }
            }
        }
    }
}
