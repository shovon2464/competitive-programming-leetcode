class Solution {
    public int orangesRotting(int[][] grid) {
        int rowN = grid.length;
        int colN = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int fresh = 0;
        int time = 0;

        for (int r = 0; r < rowN; r++) {
            for (int c = 0; c < colN; c++) {
                if (grid[r][c] == 1) {
                    fresh ++;
                }
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r,c});
                }
            }
        }

        while(!queue.isEmpty() && fresh > 0) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] rc = queue.poll();
                int r = rc[0];
                int c = rc[1];
                for (int[] direction : directions) {
                    int nr = r + direction[0];
                    int nc = c + direction[1];
                    if (nr < 0 || nr >= rowN) continue;
                    if (nc < 0 || nc >= colN) continue;
                    if (grid[nr][nc] == 0) continue;
                    if (grid[nr][nc] == 2) continue;
                    fresh --;
                    grid[nr][nc] = 2;
                    queue.add(new int[] {nr, nc});
                }
            }
            time ++;
        }

        return fresh == 0 ? time : -1;
    }
}
