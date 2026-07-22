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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        List<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            List<TreeNode> tmp = new LinkedList<>();
            for(TreeNode node : que) {
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);
            }
            TreeNode leaving = que.removeLast();
            ans.add(leaving.val);
            que = tmp;
        }
        return ans;
    }
}
