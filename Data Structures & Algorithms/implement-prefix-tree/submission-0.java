class PrefixTreeNode {
    PrefixTreeNode[] children = new PrefixTreeNode[26];
    boolean isWord = false;
}
class PrefixTree {

    PrefixTreeNode root;
    public PrefixTree() {
        this.root = new PrefixTreeNode();
    }

    public void insert(String word) {
        PrefixTreeNode current = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new PrefixTreeNode();
            }
            current = current.children[index];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        PrefixTreeNode current = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        PrefixTreeNode current = root;

        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }
}
