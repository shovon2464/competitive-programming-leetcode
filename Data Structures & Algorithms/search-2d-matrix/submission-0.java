class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowN = matrix.length;
        int colN = matrix[0].length;

        int topRow = 0;
        int bottomRow = rowN - 1;

        while (topRow <= bottomRow) {
            int midRow = topRow + (bottomRow - topRow) / 2;

            if (matrix[midRow][colN - 1] < target) {
                topRow = midRow + 1;
            } else if (matrix[midRow][0] > target) {
                bottomRow = midRow - 1;
            } else {
                topRow = midRow;
                break;
            }
        }

        int leftColumn = 0;
        int rightColumn = colN - 1;

        while (leftColumn <= rightColumn) {
            int midColumn = leftColumn + (rightColumn - leftColumn) / 2;

            if (matrix[topRow][midColumn] == target) {
                return true;
            } else if (matrix[topRow][midColumn] < target) {
                leftColumn = midColumn + 1;
            } else {
                rightColumn = midColumn - 1;
            }
        }

        return false;
    }
}
