class Solution {
    int rowN;
    int colN;
    boolean[][] visited;
    Queue<int[]> queue;
    int[][] grid;
    public void add(int r, int c) {
        if (r < 0 || r >= rowN) return;
        if (c < 0 || c >= colN) return;
        if (visited[r][c]) return;
        if (grid[r][c] == -1) return;
        queue.add(new int[]{r,c});
        visited[r][c] = true;
    }
    public void bfs() {
        int distance = 0;
        while(!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] rc = queue.poll();
                int r = rc[0];
                int c = rc[1];
                grid[r][c] = distance;
                add(r+1, c);
                add(r-1, c);
                add(r, c+1);
                add(r, c-1);
            }
            distance++;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        this.rowN = grid.length;
        this.colN = grid[0].length;
        this.visited = new boolean[rowN][colN];
        this.queue = new LinkedList<>();
        this.grid = grid;

        for (int r = 0; r < rowN; r++) {
            for (int c = 0; c < colN; c++) {
                if (grid[r][c] == 0) {
                    queue.add(new int[]{r,c});
                    visited[r][c] = true;
                }
            }
        }
        bfs();
    }
}
