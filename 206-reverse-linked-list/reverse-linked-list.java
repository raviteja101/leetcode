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
    public ListNode reverseList(ListNode head) {
        // ListNode cur = head, prev = null, next = null;
        // while(cur != null) {
        //     next = cur.next;
        //     cur.next = prev;
        //     prev = cur;
        //     cur = next;
        // }
        // return prev;
        return reverseListRecursion(head, null, null);
    }

    public ListNode reverseListRecursion(ListNode curr, ListNode prev, ListNode next) {
        if(curr == null) {
            return prev;
        }
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        return reverseListRecursion(curr, prev, next);
    }

}