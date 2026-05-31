class Node {
    int key;
    int val;
    int freq;
    Node next;
    Node prev;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}
class LRUCache {
    Node left;
    Node right;
    int size;
    public LRUCache() {
        this.left = new Node(-1, -1);
        this.right = new Node(-1, -1);
        left.next = right;
        right.prev = left;
        this.size = 0;
    }
}
class LFUCache {

    Map<Integer, LRUCache> freqToLRUCache;
    Map<Integer, Node> keyToNode;
    int size;
    int capacity;
    int minFreq;
    public LFUCache(int capacity) {
        this.freqToLRUCache = new HashMap<>();
        this.keyToNode = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
        this.minFreq = 0;
    }
    
    public int get(int key) {
        if (keyToNode.containsKey(key)) {
            Node toGet = keyToNode.get(key);
            update(toGet);
            return toGet.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (keyToNode.containsKey(key)) {
            Node toPut = keyToNode.get(key);
            toPut.val = value;
            update(toPut);
        } else {
            if (size == capacity) {
                evict();
            }
            Node toPut = new Node(key, value);
            add(toPut);
            size ++;
            minFreq = 1;
            keyToNode.put(key, toPut);
        }
    }

    public void update(Node node) {
        delete(node);

        if (node.freq == minFreq && freqToLRUCache.get(node.freq).size == 0) {
            minFreq ++;
        }

        add(node);
    }

    public void delete(Node node) {
        LRUCache lruCache = freqToLRUCache.get(node.freq);

        Node prev = node.prev;
        Node next = node.next;
        
        prev.next = next;
        next.prev = prev;

        node.next = null;
        node.prev = null;
        
        lruCache.size --;
    }

    public void add(Node node) {
        LRUCache lruCache = freqToLRUCache.getOrDefault(node.freq, new LRUCache());
        freqToLRUCache.put(node.freq, lruCache);

        Node prev = lruCache.right.prev;

        prev.next = node;
        node.prev = prev;

        node.next = lruCache.right;
        lruCache.right.prev = node;

        lruCache.size ++;
    }

    public void evict() {
        LRUCache lruCache = freqToLRUCache.get(minFreq);
        Node toRemove = lruCache.left.next;
        delete(toRemove);
        size --;
        keyToNode.remove(toRemove.key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */