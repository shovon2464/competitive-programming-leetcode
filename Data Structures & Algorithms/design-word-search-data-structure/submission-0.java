class TrieNode {
    TrieNode[] children = new TrieNode[26];
    Boolean isWord = false;
}
class Trie {
    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    public void insert(String word) {
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
}
class WordDictionary {

    Trie trie;
    public WordDictionary() {
        this.trie = new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, trie.root);
    }

    public boolean dfs(String word, int idx, TrieNode current) {
        if (current == null) return false;
        for (int i = idx; i < word.length(); i ++) {
            if (word.charAt(i) == '.') {
                for (int j = 0; j < 26; j ++) {
                    if (dfs(word, i + 1, current.children[j])) return true;
                }
                return false;
            } else {
                int index = word.charAt(i) - 'a';
                if (current.children[index] == null) {
                    return false;
                }
                current = current.children[index];
            }
        }
        return current.isWord;
    }
}
