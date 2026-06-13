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
    public boolean validate(TreeNode root, long leftLimit, long rightLimit) {
        if (root == null) return true;
        if (!(root.val > leftLimit && root.val < rightLimit)) return false;
        return validate(root.left, leftLimit, root.val) && validate(root.right, root.val, rightLimit);
    }
    public boolean isValidBST(TreeNode root) {
     return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);   
    }
}
