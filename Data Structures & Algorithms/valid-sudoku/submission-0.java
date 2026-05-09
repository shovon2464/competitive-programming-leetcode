class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<List<Integer>, Set<Character>> sqrMap = new HashMap<>();

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j++) {
                Set<Character> rowSet = rowMap.computeIfAbsent(i, key -> new HashSet<>());
                Set<Character> colSet = colMap.computeIfAbsent(j, key -> new HashSet<>());
                Set<Character> sqrSet = sqrMap.computeIfAbsent(List.of(i/3, j/3), key -> new HashSet<>());

                char current = board[i][j];

                if (current == '.') {
                    continue;
                } else if (!rowSet.add(current) || !colSet.add(current) || !sqrSet.add(current)) {
                    return false;
                } 
            }
        }

        return true;
    }
}
