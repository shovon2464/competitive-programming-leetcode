/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return build(grid, grid.length, 0, 0);
    }

    public Node build(int[][] grid, int n, int row, int col) {
        boolean isSame = true;
        for (int r = 0; r < n; r ++) {
            for (int c = 0; c < n; c ++) {
                if (grid[row][col] != grid[row + r][col + c]) {
                    isSame = false;
                    break;
                }
            }
        }
        if (isSame) {
            boolean val = grid[row][col] == 1 ? true : false;
            return new Node(val, true);
        }

        n = n / 2;
        Node topLeft = build(grid, n, row, col);
        Node topRight = build(grid, n, row, col + n);
        Node bottomLeft = build(grid, n, row + n, col);
        Node bottomRight = build(grid, n, row + n, col + n);
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}