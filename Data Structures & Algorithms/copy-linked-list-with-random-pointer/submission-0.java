/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> cpyNode = new HashMap<>();
        Node ptr = head;
        while(ptr != null) {
            cpyNode.put(ptr, new Node(ptr.val));
            ptr = ptr.next;
        }

        ptr = head;
        while(ptr != null) {
            cpyNode.get(ptr).next = cpyNode.get(ptr.next);
            cpyNode.get(ptr).random = cpyNode.get(ptr.random);
            ptr = ptr.next;
        }
        return cpyNode.get(head);
    }
}
