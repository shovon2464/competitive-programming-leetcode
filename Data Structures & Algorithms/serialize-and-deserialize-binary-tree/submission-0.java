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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    public void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N");
            sb.append(",");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        return deserializeHelper(strs, new int[]{0});
    }

    public TreeNode deserializeHelper(String[] strs, int[] index) {
        if (strs[index[0]].equals("N")) {
            index[0] ++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(strs[index[0]]));
        index[0] ++;
        root.left = deserializeHelper(strs, index);
        root.right = deserializeHelper(strs, index);
        return root;
    }
}
