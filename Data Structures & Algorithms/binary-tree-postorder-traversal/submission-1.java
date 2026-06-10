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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Boolean> visited = new ArrayDeque<>();
        stack.push(root);
        visited.push(false);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            Boolean v = visited.pop();

            if (v) {
                result.add(current.val);
            } else {
                stack.push(current);
                visited.push(true);
                if (current.right != null) {
                    stack.push(current.right);
                    visited.push(false);
                }
                if (current.left != null) {
                    stack.push(current.left);
                    visited.push(false);
                }
            }
        }

        return result;
    }
}