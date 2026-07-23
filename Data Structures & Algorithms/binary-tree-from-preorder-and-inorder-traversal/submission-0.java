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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n == 0) return null;
        int root = preorder[0];
        int leftSize = indexOf(inorder, root);

        int[] pre1 = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] pre2 = Arrays.copyOfRange(preorder, 1 + leftSize, n);
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(inorder, leftSize + 1, n);

        return new TreeNode(root, buildTree(pre1, in1), buildTree(pre2, in2));
    }

    public int indexOf(int[] nums, int x) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == x) return i;
        }
        return -1;
    }
}


/*
Input: preorder = [1,2,3,4], inorder = [2,1,3,4]

            1
          /   \
        2       3
                 \
                   4
    

*/