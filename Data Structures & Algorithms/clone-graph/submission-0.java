/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> tracker;
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        this.tracker = new HashMap<>();
        return dfs(node);
    }

    public Node dfs(Node node) {
        if (tracker.containsKey(node)) {
            return tracker.get(node);
        }

        Node copyNode = new Node(node.val);
        tracker.put(node, copyNode);
        
        for (Node n : node.neighbors) {
            copyNode.neighbors.add(dfs(n));
        }

        return copyNode;
    }
}