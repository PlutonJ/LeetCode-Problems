/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode p = head;
        if(head != null && head.next != null) head = head.next;
        while(p != null && p.next != null) {
            ListNode n = p.next.next;
            p.next.next = p;
            p.next = n == null || n.next == null ? n : n.next;
            p = n;
        }
        return head;
    }
}