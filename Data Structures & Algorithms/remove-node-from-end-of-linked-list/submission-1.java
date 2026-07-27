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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode ptr = head;
        while(ptr != null) {
            len++;
            ptr = ptr.next;
        }

        int leftCnt = len - n;
        ListNode dummy = new ListNode(-1, head);
        ptr = dummy;
        for(int i = 0; i < leftCnt; i++) {
            ptr = ptr.next;
        }
        ptr.next = ptr.next.next;

        return dummy.next;
    }
}

/*

Input: head = [1,2,3,4], n = 1

Output: [1,2,3]

len = 4
leftCnt = 3

dummy -> 1 -> 2 -> 3 -> null

                  ptr

i = 2

head = [4], n = 1

len = 1 
leftCnt = 0

dummy -> 4 -> null


*/