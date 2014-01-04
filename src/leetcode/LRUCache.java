package leetcode;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {

    final class MyEntry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }

    int capacity;
    int num;
    Queue<MyEntry<Integer, Integer>> q;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.num = 0;
        q = new LinkedList<MyEntry<Integer, Integer>>();
    }

    public int get(int key) {
        MyEntry<Integer, Integer> mostRecentEntry = null;
        for (MyEntry<Integer, Integer> entry : q) {
            if (entry.getKey() == key){
                mostRecentEntry = entry;
            }
        }
        if(mostRecentEntry != null){
            q.remove(mostRecentEntry);
            q.add(mostRecentEntry);
            return mostRecentEntry.getValue();
        }else
            return -1;
    }

    public void set(int key, int value) {
        for (MyEntry<Integer, Integer> entry : q) {
            if (entry.getKey() == key) {
                entry.setValue(value);
                return;
            }
        }
        // insert
        MyEntry<Integer, Integer> entry = new MyEntry<Integer, Integer>(key, value);
        if (num < capacity) {
            q.add(entry);
            num++;
        } else{
            q.poll();
            q.add(entry);
        }
    }

}
