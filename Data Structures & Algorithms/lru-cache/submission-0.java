class Node{
    int val, key;
    Node next, prev;

    Node(int key, int val){
        this.key= key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
class LRUCache {
    Map<Integer, Node> map;
    Node head; //most recently used
    Node tail;  //least recently used
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void addFirst(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    public int get(int key) {
        Node temp = map.get(key);
        if(temp == null) return -1;
        remove(temp);
        addFirst(temp);
        return temp.val;
    }
    
    public void put(int key, int value) {
        Node existing = map.get(key);
        if(existing != null){
            existing.val = value;
            remove(existing);
            addFirst(existing);
            return;
        }

        if(capacity == map.size()){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
        Node temp = new Node(key, value);
        map.put(key, temp);
        addFirst(temp);
    }
}
