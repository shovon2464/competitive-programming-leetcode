class Node {
    int val;
    Node next;
    Node prev;
    public Node(int val) {
        this.val = val;
    }
}
class MyCircularQueue {

    Node left;
    Node right;
    int size;
    int limit;
    public MyCircularQueue(int k) {
        this.left = new Node(-1);
        this.right = new Node(-1);
        left.next = right;
        left.prev = right;
        right.prev = right;
        right.next = right;
        this.size = 0;
        this.limit = k;
    }
    
    public boolean enQueue(int value) {
        if (size == limit) return false;
        Node newNode = new Node(value);
        Node next = left.next;
        left.next = newNode;
        newNode.prev = left;
        newNode.next = next;
        next.prev = newNode;
        size ++;
        return true;
    }
    
    public boolean deQueue() {
        if (size == 0) return false;
        Node prev = right.prev.prev;
        prev.next = right;
        right.prev = prev;
        size --;
        return true;
    }
    
    public int Front() {
        if (size == 0) return -1;
        return right.prev.val;
    }
    
    public int Rear() {
        if (size == 0) return -1;
        return left.next.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == limit;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */