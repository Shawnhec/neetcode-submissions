/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode ptr = head;
        while(ptr != null) {
            len++;
            ptr = ptr.next;
        }

        ListNode dummy = new ListNode(-1, head);
        ptr = dummy;
        int i = 0; 
        while(i < len) {
            if(len - i >= k) {
                ListNode pre = null;
                ListNode curr = ptr.next;
                for(int j = 0; j < k; j++) {
                    ListNode nxt = curr.next;
                    curr.next = pre;
                    pre = curr;
                    curr = nxt; 
                    i++;
                }
                ListNode tail = ptr.next;
                tail.next = curr;
                ptr.next = pre;
                ptr = tail;
            }
            else {
                break;
            }
        }
        return dummy.next;
    }
}
