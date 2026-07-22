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
    public int goodNodes(TreeNode root) {
        int[] cnt = new int[1];
        dfs(root, Integer.MIN_VALUE, cnt);
        return cnt[0];
    }

    public void dfs(TreeNode node, int max, int[] cnt) {
        if(node == null) return;
        
        if(node.val >= max) {
            cnt[0]++;
            max = node.val;
        }
        dfs(node.left, max, cnt);
        dfs(node.right, max, cnt);
    }
}


/*
            3
          /   \
        3.     n 
       /. \ 
     4.   2

*/
