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
//     public ListNode mergeKLists(ListNode[] lists) {
//         Queue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
//         for(ListNode list : lists) {
//             q.offer(list);
//         }

//         ListNode dummy = new ListNode();
//         ListNode ptr = dummy;
//         while(!q.isEmpty()) {
//             ListNode curr = q.poll();
//             ListNode currRemain = curr.next;
//             curr.next = null;
//             ptr.next = curr;
//             ptr = ptr.next;
//             if(currRemain != null) q.offer(currRemain);
//         }
//         return dummy.next;
//     }
// }

/*
n = len(lists)
m = average number of list node 
T : O(mlogn)
S : O(mn)
*/


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if(left == right) return lists[left];

        if(left + 1 == right) {
            return sortTwoLists(lists[left], lists[right]);
        }

        int mid = left + (right - left) / 2;
        return sortTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }


    public ListNode sortTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode ptr = dummy;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                ptr.next = list1;
                list1 = list1.next;
            }
            else {
                ptr.next = list2; 
                list2 = list2.next;
            }
            ptr = ptr.next;
        }

        if(list1 == null) list1 = list2;
        
        while(list1 != null) {
            ptr.next = list1;
            list1 = list1.next;
            ptr = ptr.next;
        }

        return dummy.next; 
    }
}