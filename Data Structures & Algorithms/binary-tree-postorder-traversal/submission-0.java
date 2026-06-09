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
    List<Integer> result;
    public List<Integer> postorderTraversal(TreeNode root) {
        this.result = new ArrayList<>();
        postorder(root);
        return result;
    }
    public void postorder(TreeNode current) {
        if (current == null) return;
        postorder(current.left);
        postorder(current.right);
        result.add(current.val);
    }
}