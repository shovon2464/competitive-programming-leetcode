class TrieNode {
    TrieNode[] children = new TrieNode[26];
    Boolean isWord = false;
}
class Trie {
    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isWord = true;
    }
    public void addWords(String[] words) {
        for (String word : words) {
            addWord(word);
        }
    }
}
class Solution {
    char[][] board;
    boolean[][] visited;
    int rowN;
    int colN;
    Trie trie;
    Set<String> result;
    StringBuilder sb;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.rowN = board.length;
        this.colN = board[0].length;
        this.visited = new boolean[rowN][colN];
        this.trie = new Trie();
        trie.addWords(words);
        this.result = new HashSet<>();
        this.sb = new StringBuilder();
        
        for (int r = 0; r < rowN; r ++) {
            for (int c = 0; c < colN; c ++) {
                dfs(r, c, trie.root);
            }
        }

        return new ArrayList<>(result);
    }

    public void dfs(int row, int col, TrieNode current) {
        if (row < 0 || row >= rowN) return;
        if (col < 0 || col >= colN) return;
        if (visited[row][col]) return;
        int index = board[row][col] - 'a';
        if (current.children[index] == null) return;

        visited[row][col] = true;
        sb.append(board[row][col]);
        current = current.children[index];
        if (current.isWord) {
            result.add(sb.toString());
        }
        dfs(row + 1, col, current);
        dfs(row - 1, col, current);
        dfs(row, col + 1, current);
        dfs(row, col - 1, current);
        visited[row][col] = false;
        sb.deleteCharAt(sb.length() - 1);
    }
}
