/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), c = l, i = l1, j = l2;
        while(i != null && j != null) if(i.val <= j.val) {
            c = c.next = i;
            i = i.next;
        } else {
            c = c.next = j;
            j = j.next;
        }
        c.next = i == null ? j : i;
        return l.next;
    }
}