class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rowN = heights.length;
        int colN = heights[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a,b) -> (a[0] - b[0])
        );
        queue.offer(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[rowN][colN];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int diff = current[0];
            int row = current[1];
            int col = current[2];

            if (visited[row][col]) continue;
            visited[row][col] = true;

            if (row == rowN - 1 && col == colN - 1) {
                return diff;
            }

            for (int[] direction : directions) {
                int rn = row + direction[0];
                int cn = col + direction[1];
                
                if (rn < 0 || rn == rowN) continue;
                if (cn < 0 || cn == colN) continue;
                if (visited[rn][cn]) continue;
                int newDiff = Math.max(diff, Math.abs(heights[rn][cn] - heights[row][col]));
                queue.offer(new int[] {newDiff, rn, cn});
            }
        }
        return -1;
    }
}