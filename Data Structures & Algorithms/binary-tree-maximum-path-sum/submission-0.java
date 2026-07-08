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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        dfs(root, max);
        return max[0];
    }

    public int dfs(TreeNode node, int[] max) {
        if(node == null) return 0;
        
        int leftVal = dfs(node.left, max);
        int rightVal = dfs(node.right, max);
        max[0] = Math.max(max[0], node.val + leftVal + rightVal);
        return Math.max(0, Math.max(leftVal, rightVal) + node.val);
    }
}
