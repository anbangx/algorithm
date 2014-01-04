package leetcode;

public class LRUCache2 {

    class DoublyListNode {
        int key;
        int value;
        DoublyListNode prev;
        DoublyListNode next;

        DoublyListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    int capacity;
    int num;
    DoublyListNode safeGuard;
    DoublyListNode head;
    DoublyListNode tail;

    //    HashMap<Integer, DoublyListNode> map;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.num = 0;
        this.safeGuard = new DoublyListNode(-1, -1);
        head = null;
        tail = null;
        //        map = new HashMap<Integer, DoublyListNode>();
    }

    public int get(int key) {
        DoublyListNode cursor = findNode(key);//map.get(key);
        if (cursor != null) {
            if(head != tail){
                moveCursorToHead(cursor);
            }
            return cursor.value;
        } else
            return -1;
    }

    public void set(int key, int value) {
        DoublyListNode cursor = findNode(key); //map.get(key);
        if (cursor != null) {
            // exist, so set
            cursor.value = value;
            if (cursor != head) { // move cursor to head
                moveCursorToHead(cursor);
            }
        } else {
            // not exist, so insert
            cursor = new DoublyListNode(key, value);
            if (safeGuard.next == null) {
                head = cursor;
                tail = head;
                safeGuard.next = head;
                head.prev = safeGuard;
                num++;
            } else {
                moveCursorToHead(cursor);
                if (num + 1 > capacity) {
                    // remove the least recent used item
                    //                    map.remove(tail.item.getKey());
                    tail = tail.prev;
                    tail.next = null;
                } else
                    num++;
            }
            //            map.put(key, cursor);
        }
    }

    public void moveCursorToHead(DoublyListNode cursor) {
        if(cursor == tail)
            tail = tail.prev;
        if(cursor.prev != null)
            cursor.prev.next = cursor.next;
        if (cursor.next != null)
            cursor.next.prev = cursor.prev;
        head.prev = cursor;
        cursor.next = head;
        cursor.prev = safeGuard;
        safeGuard.next = cursor;
        head = cursor;
    }

    public DoublyListNode findNode(int key) {
        DoublyListNode cursor = head;
        while (cursor != null) {
            if (cursor.key == key)
                break;
            cursor = cursor.next;
        }
        return cursor;
    }

    public void printCache(DoublyListNode head) {
        while (head != null) {
            System.out.println(head.key + " " + head.value);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(1);
//        cache.set(2, 1);
//        cache.set(1, 1);
//        //        cache.printCache(cache.head);
//        System.out.println(cache.get(2));
//        cache.set(4, 1);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
        cache.set(2,1);
        cache.get(2);
        cache.set(3,2);
        cache.get(2);
        cache.get(3);

    }

}
