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
    public int diameterOfBinaryTree(TreeNode root) {
       int[] longest = new int[]{0};
       dfs(root, longest);
       return longest[0];
    }

    public int dfs(TreeNode root, int[] longest) {
        if(root == null) return 0; 

        int leftH = dfs(root.left, longest);
        int rightH = dfs(root.right, longest);
        longest[0] = Math.max(longest[0], (leftH + rightH));
        return Math.max(leftH, rightH) + 1;
    }


}
