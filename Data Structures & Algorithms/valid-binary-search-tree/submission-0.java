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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean dfs(TreeNode node, int lowerBound, int upperBound) {
        if(node == null) return true; 

        if(node.val >= upperBound || node.val <= lowerBound) return false;

        return dfs(node.left, lowerBound, node.val) && dfs(node.right, node.val, upperBound);
    }
}
