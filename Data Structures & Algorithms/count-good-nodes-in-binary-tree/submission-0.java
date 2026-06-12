/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int dfs(TreeNode current, int maxVal) {
        if (current == null) return 0;
        int answer = current.val >= maxVal ? 1 : 0;
        maxVal = Math.max(maxVal, current.val);
        return answer + dfs(current.left, maxVal) + dfs(current.right, maxVal);
    }
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
}
