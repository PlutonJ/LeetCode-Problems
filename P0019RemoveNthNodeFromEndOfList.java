/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 1 pass, 2 pointers, first one going n before the second one starts so that the second one stops at n from the end

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode i = head, j = head;
        while(n --> 0) i = i.next;
        if(i == null) return head.next;
        while((i = i.next) != null) j = j.next;
        j.next = j.next.next;
        return head;
    }
}