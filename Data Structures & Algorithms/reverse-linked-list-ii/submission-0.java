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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode current = head;
        ListNode previous = dummy;

        for (int i = 0; i < left - 1; i ++) {
            current = current.next;
            previous = previous.next;
        }

        ListNode newHead = null;

        for (int i = 0; i < right - left + 1; i ++) {
            ListNode temp = current.next;
            current.next = newHead;
            newHead = current;
            current = temp;
        }

        previous.next.next = current;
        previous.next = newHead;

        return dummy.next;
    }
}