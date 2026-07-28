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

// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode tail = null;
//         ListNode tmp = null;
//         while(head != null) {
//             tmp = head;
//             head = head.next;
//             tmp.next = tail;
//             tail = tmp;
//         }
//         return tail;
//     }
// }

// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode pre = null;
//         ListNode curr = head;
//         while(curr != null) {
//             ListNode nxt = curr.next; 
//             curr.next = pre;
//             pre = curr;
//             curr = nxt; 
//         }
//         return pre;
//     }
// }


class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode ptr = head;
        ListNode tail = null;
        while(ptr != null) {
            ListNode tmp = ptr;
            ptr = ptr.next;
            tmp.next = tail;
            tail = tmp;
        }
        return tail;
    }
}
