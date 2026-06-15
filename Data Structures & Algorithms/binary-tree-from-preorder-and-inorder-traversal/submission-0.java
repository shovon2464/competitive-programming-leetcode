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
    int[] preorder;
    int[] inorder;
    int preIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.preIdx = 0;
        return build(0, inorder.length-1);
    }

    public TreeNode build(int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        if (preIdx >= preorder.length) return null;
        TreeNode root = new TreeNode(preorder[preIdx]);
        preIdx ++;
        int mid = findMid(inStart, inEnd, root.val);
        root.left = build(inStart, mid - 1);
        root.right = build(mid + 1, inEnd);
        return root;
    }

    public int findMid(int inStart, int inEnd, int target) {
        for (int i = inStart; i <= inEnd; i ++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
