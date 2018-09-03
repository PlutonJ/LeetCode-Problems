/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// divide & conquer(~merge step in merge sort)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        if(lists.length == 2) {
            ListNode l = new ListNode(0), c = l, i = lists[0], j = lists[1];
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
        return mergeKLists(new ListNode[] {mergeKLists(Arrays.copyOfRange(lists, 0, lists.length / 2)), mergeKLists(Arrays.copyOfRange(lists, lists.length / 2, lists.length))});
    }
}