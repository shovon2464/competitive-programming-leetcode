class Solution {
    public int orangesRotting(int[][] grid) {
        int rowN = grid.length;
        int colN = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        int time = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int r = 0; r < rowN; r ++) {
            for (int c = 0; c < colN; c ++) {
                if (grid[r][c] == 1) {
                    freshCount ++;
                } else if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        while (!queue.isEmpty() && freshCount > 0) {
            int levelSize = queue.size();
            time ++;
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
                    if (grid[rn][cn] == 2) continue;
                    freshCount --;
                    grid[rn][cn] = 2;
                    queue.offer(new int[]{rn, cn});
                }
            }
        }

        return freshCount == 0 ? time : - 1;
    }
}
