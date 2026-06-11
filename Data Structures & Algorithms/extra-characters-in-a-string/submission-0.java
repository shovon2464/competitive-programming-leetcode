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
    Map<Integer, Integer> memo;
    String s;
    Trie trie;
    public int minExtraChar(String s, String[] dictionary) {
        this.memo = new HashMap<>();
        this.s = s;
        memo.put(s.length(), 0);
        this.trie = new Trie();
        trie.addWords(dictionary);
        return dfs(0);
    }
    public int dfs(int idx) {
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }
        int result = 1 + dfs(idx + 1);
        TrieNode current = trie.root;

        for (int i = idx; i < s.length(); i ++) {
            int index = s.charAt(i) - 'a';
            if (current.children[index] == null) {
                break;
            }
            current = current.children[index];
            if (current.isWord) {
                result = Math.min(result, dfs(i + 1));
            }
        }
        memo.put(idx, result);
        return result;
    }
}