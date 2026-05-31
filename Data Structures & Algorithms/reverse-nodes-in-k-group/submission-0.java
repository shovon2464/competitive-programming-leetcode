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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while (true) {
            ListNode nthNode = findNthNode(groupPrev, k);

            if (nthNode == null) {
                break;
            }

            ListNode groupNext = nthNode.next;

            ListNode current = groupPrev.next;
            ListNode newHead = null;

            while (current != groupNext) {
                ListNode temp = current.next;
                current.next = newHead;
                newHead = current;
                current = temp;
            }

            ListNode temp = groupPrev.next;
            temp.next = groupNext;
            groupPrev.next = nthNode;
            groupPrev = temp;
        }

        return dummy.next;
    }

    public ListNode findNthNode(ListNode current, int k) {
        while (current != null && k > 0) {
            current = current.next;
            k --;
        }

        return current;
    }
}
