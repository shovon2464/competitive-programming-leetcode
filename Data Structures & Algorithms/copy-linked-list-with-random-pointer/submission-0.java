/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node current = head;

        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        current = head;

        while (current != null) {
            current.next.random = current.random != null ? current.random.next : null;
            current = current.next.next;
        }

        current = head;
        Node newHead = current.next;

        while (current != null) {
            Node copy = current.next;
            current.next = copy.next;
            current = copy.next;
            copy.next = copy.next != null ? copy.next.next : null;
        }

        return newHead;
    }
}
