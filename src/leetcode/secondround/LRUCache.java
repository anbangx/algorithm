package leetcode.secondround;

public class LRUCache {

	class DoublyListNode {
        int key;
        int val;
        DoublyListNode prev;
        DoublyListNode next;

        DoublyListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    
    DoublyListNode head = null;
    DoublyListNode tail = null;
    int size = 0;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        DoublyListNode node = findKey(key);
        if(node == null)
            return -1;
        if(node != head)
        	moveCurNodeToHead(node);
        return node.val;
    }
    
    public void set(int key, int value) {
        DoublyListNode node = findKey(key);
        if(node == null){
            node = new DoublyListNode(key, value);
            size++;
            node.next = head;
            if(head != null)
                head.prev = node;
            head = node;
            if(tail == null)    tail = head;
            if(size > capacity){
                tail = tail.prev;
                tail.next = null;
                size--;
            }
        } else{
            moveCurNodeToHead(node);
        }
    }
    
    public void moveCurNodeToHead(DoublyListNode node){
        if(node.prev != null)
            node.prev.next = node.next;
        if(node.next != null){
            node.next.prev = node.prev;
        } else{
            tail = node.prev;
        }
        node.next = head;
        head.prev = node;
        head = node;
        tail = tail == null ? head : tail;
    }
    
    public DoublyListNode findKey(int key){
        DoublyListNode cur = head;
        while(cur != null){
            if(cur.key == key)
                break;
            cur = cur.next;
        }
        return cur;
    }
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(1);
		lru.set(2,1);
		lru.get(2); 
		lru.set(3,2);
		lru.get(2);
		lru.get(3);
	}

}
