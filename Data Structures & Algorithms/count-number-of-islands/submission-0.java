class Solution {
    char[][] grid;
    int rowN;
    int colN;
    boolean[][] visited;
    Queue<int[]> queue;
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.rowN = grid.length;
        this.colN = grid[0].length;
        this.visited = new boolean[rowN][colN];
        this.queue = new LinkedList<>();
        int count = 0;

        for (int r = 0; r < rowN; r ++) {
            for (int c = 0; c < colN; c ++) {
                if (grid[r][c] == '0') continue;
                if (visited[r][c]) continue;
                count ++;
                visited[r][c] = true;
                queue.offer(new int[]{r,c});
                bfs();
            }
        }
        return count;
    }

    public void bfs() {
        while (!queue.isEmpty()) {
            int[] rc = queue.poll();
            int r = rc[0];
            int c = rc[1];
            for (int[] direction : directions) {
                int rn = r + direction[0];
                int cn = c + direction[1];
                if (rn < 0 || rn >= rowN) continue;
                if (cn < 0 || cn >= colN) continue;
                if (grid[rn][cn] == '0') continue;
                if (visited[rn][cn]) continue;
                visited[rn][cn] = true;
                queue.offer(new int[]{rn, cn});
            }
        }
    }
}

