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


/*
root=[5,3,8,1,4,7,9,null,2]
p=3
q=8

dfs(5)
    
    root.left = 
    dfs(3)

        root.left = 
        dfs(1)

            root.left = 
            dfs(null)
            return null

            root.right = 
            dfs(2)

                root.left = 
                dfs(null)
                return null

                root.right = 
                dfs(null)
                return null
            return null
        retur null

        root.right = 
        dfs(4)

            root.left =
            dfs(null)
            return null

            root.right = 
            dfs(null)
            return null
        return null
        
    return null

    root.right = 
    dfs(8)

    

*/

/*
T : O(n)
S : O(n)
*/
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root == null) return null;
//         if(root.val == p.val || root.val == q.val) return root;

//         root.left = lowestCommonAncestor(root.left, p, q);
//         root.right = lowestCommonAncestor(root.right, p, q);
//         if(root.left != null && root.right == null) return root.left;
//         if(root.right != null && root.left == null) return root.right;
//         if(root.left != null && root.right != null) return root;
//         return null;
//     }
// }


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root; 

        while(curr != null) {
            if(p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
                continue;
            }
            else if(p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
                continue;
            }
            return curr;
        }
        return null;
    }
}