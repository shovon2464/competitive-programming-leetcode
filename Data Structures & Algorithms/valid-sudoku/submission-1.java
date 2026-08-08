class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<List<Integer>, Set<Character>> sqrMap = new HashMap<>();

        for (int r = 0; r < 9; r ++) {
            for (int c = 0; c < 9; c ++) {
                Set<Character> rowSet = rowMap.computeIfAbsent(r, key -> new HashSet<>());
                Set<Character> colSet = colMap.computeIfAbsent(c, key -> new HashSet<>());
                Set<Character> sqrSet = sqrMap.computeIfAbsent(List.of(r / 3, c / 3), key -> new HashSet<>());

                char a = board[r][c];
                if (a != '.') {
                    if (!rowSet.add(a) || !colSet.add(a) || !sqrSet.add(a)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
