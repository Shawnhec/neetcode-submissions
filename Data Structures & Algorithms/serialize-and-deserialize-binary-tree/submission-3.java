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
        List<String> encode = new ArrayList<>();
        dfsSerialize(root, encode);
        return String.join(",", encode);
    }

    private void dfsSerialize(TreeNode node, List<String> encode) {
        if(node == null) {
            encode.add("N");
            return;
        }

        encode.add(Integer.toString(node.val));
        dfsSerialize(node.left, encode);
        dfsSerialize(node.right, encode);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] decode = data.split(",");
        int[] i = {0};
        return dfsDeserialize(decode, i);
    }

    public TreeNode dfsDeserialize(String[] decode, int[] i) {
        if(decode[i[0]].equals("N")) {
            i[0]++;
            return null;
        }

        int idx = i[0];
        i[0]++;
        TreeNode left = dfsDeserialize(decode, i);
        TreeNode right = dfsDeserialize(decode, i);
        return new TreeNode(Integer.parseInt(decode[idx]), left, right);
    }
}

/*
1,2,N,N,3,4,

        1,
      /   \ 
    2      3
  /. \.   /. \ 
N.   N   4.   5 
        / \.  / \
       N.  N  N. N 

*/
