/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// straightforward addition by keeping a carry bit

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int s, c = 0;
        ListNode root = new ListNode((s = l1.val + l2.val) > 9 ? s % ((c = 1) * 10) : s), cur = root;
        while((l1 != null && (l1 = l1.next) != null) | (l2 != null && (l2 = l2.next) != null)) cur = (cur.next = new ListNode((s = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + c) > 9 ? s % ((c = 1) * 10) : s + (c = 0)));
        if(c > 0) cur.next = new ListNode(c);
        return root;
    }
}