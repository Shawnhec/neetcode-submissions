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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int res = treeHeight(root);
        if(res == -1) return false;
        return true;
    }

    public int treeHeight(TreeNode node) {
        if(node == null) return 0;
        
        int leftH = treeHeight(node.left);
        int rightH = treeHeight(node.right);
        if(leftH == -1 || rightH == -1 || Math.abs(leftH - rightH) > 1) return -1;
        return 1 + Math.max(leftH, rightH);
    }

}
