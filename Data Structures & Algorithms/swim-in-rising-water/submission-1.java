class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a,b) -> (a[2] - b[2])
        ); 
        boolean[][] visited = new boolean[N][N];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        queue.offer(new int[]{0, 0, grid[0][0]});

        while (!queue.isEmpty()) {
            int[] c = queue.poll();
            int row = c[0];
            int col = c[1];
            int time = c[2];
            if (visited[row][col]) continue;
            visited[row][col] = true;
            if (row == N - 1 && col == N - 1) return time;
            for (int[] direction : directions) {
                int rn = row + direction[0];
                int cn = col + direction[1];
                if (rn < 0 || rn >= N) continue;
                if (cn < 0 || cn >= N) continue;
                if (visited[rn][cn]) continue;
                int maxTime = Math.max(time, grid[rn][cn]);
                queue.offer(new int[]{rn, cn, maxTime});
            }
        }

        return - 1;
    }
}
