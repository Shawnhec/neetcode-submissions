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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode ptr = dummy;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            ptr.next = new ListNode(sum % 10);
            carry = sum / 10;
            ptr = ptr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null) l1 = l2;
        while(l1 != null) {
            int sum = l1.val + carry;
            ptr.next = new ListNode(sum % 10);
            carry = sum / 10;
            ptr = ptr.next; 
            l1 = l1.next;
        }
        if(carry > 0) ptr.next = new ListNode(carry);
        return dummy.next;
    }
}

/*

l1: 8 -> 9 -> 
              ^
l2: 2 -> 0 -> 9
              ^

l1: 9 

dummy -> 0 -> 0 -> 0
             ptr 

carry = 1
sum = 10
*/
