class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        boolean[][] visited = new boolean[N][N];
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> (a[0] - b[0])
        );
        minHeap.add(new int[] {grid[0][0], 0, 0});

        while(!minHeap.isEmpty()) {
            int[] hrc = minHeap.poll();
            int height = hrc[0];
            int row = hrc[1];
            int col = hrc[2];

            if (visited[row][col]) continue;

            visited[row][col] = true;

            if (row == N - 1 && col == N - 1) return height;

            for (int[] direction : directions) {
                int rowN = row + direction[0];
                int colN = col + direction[1];
                if (rowN < 0 || rowN >= N) continue;
                if (colN < 0 || colN >= N) continue;
                if (visited[rowN][colN]) continue;

                int maxHeight = Math.max(height, grid[rowN][colN]);

                minHeap.add(new int[] {maxHeight, rowN, colN});
            }
        }

        return -1;
    }
}
