class Node {
    int key;
    int val;
    Node next;
    Node prev;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {

    Map<Integer, Node> tracker;
    Node left;
    Node right;
    int size;
    int capacity;
    public LRUCache(int capacity) {
        this.tracker = new HashMap<>();
        this.left = new Node(-1, -1);
        this.right = new Node(-1, -1);
        left.next = right;
        right.prev = left;
        this.size = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (tracker.containsKey(key)) {
            Node toGet = tracker.get(key);
            delete(toGet);
            add(toGet);
            return toGet.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (tracker.containsKey(key)) {
            Node toPut = tracker.get(key);
            toPut.val = value;
            delete(toPut);
            add(toPut);
        } else {
            if (size == capacity) {
                evict();
            }
            Node toPut = new Node(key, value);
            add(toPut);
            size ++;
            tracker.put(key, toPut);
        }
    }

    public void delete(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        prev.next = next;
        next.prev = prev;

        node.next = null;
        node.prev = null;
    }

    public void add(Node node) {
        Node prev = right.prev;

        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }

    public void evict() {
        Node toRemove = left.next;

        Node next = toRemove.next;

        left.next = next;
        next.prev = left;

        toRemove.next = null;
        toRemove.prev = null;

        size --;
        tracker.remove(toRemove.key);
    }
}
