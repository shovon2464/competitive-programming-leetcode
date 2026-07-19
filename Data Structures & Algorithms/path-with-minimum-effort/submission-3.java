class Solution {
    public int minimumEffortPath(int[][] heights) {
       int rowN = heights.length;
       int colN = heights[0].length;
       PriorityQueue<int[]> queue = new PriorityQueue<>(
          (a,b) -> (a[2] - b[2])
       );
       boolean[][] visited = new boolean[rowN][colN];
       int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
       queue.offer(new int[]{0, 0, 0});

       while (!queue.isEmpty()) {
          int[] c = queue.poll();
          int row = c[0];
          int col = c[1];
          int effort = c[2];
          if (visited[row][col]) continue;
          visited[row][col] = true;
          if (row == rowN - 1 && col == colN - 1) return effort;
          for (int[] direction : directions) {
              int rn = row + direction[0];
              int cn = col + direction[1];
              if (rn < 0 || rn >= rowN) continue;
              if (cn < 0 || cn >= colN) continue;
              if (visited[rn][cn]) continue;
              int maxEffort = Math.max(effort, Math.abs(heights[row][col] - heights[rn][cn]));
              queue.offer(new int[]{rn, cn, maxEffort});
          }
       }

       return - 1;
    }
}