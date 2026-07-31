/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> old2New = new HashMap<>();
        return dfs(node, old2New);
    }

    public Node dfs(Node node, Map<Node, Node> old2New) {
        if(old2New.containsKey(node)) return old2New.get(node);

        Node curr = new Node(node.val);
        old2New.put(node, curr);
        for(Node n : node.neighbors) {
            curr.neighbors.add(dfs(n, old2New));
        }
        return curr;
    }
}


/*

    1               
   /  \. 
  4    2
      / 
     3


      1
    /.  \
   4     2



*/