package datas.src;
import java.util.LinkedList;

public class hashMap<K, V> {
    @SuppressWarnings("hiding")
    private class Entry<K, V> {
        K key;
        V value;
        
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private LinkedList<Entry<K, V>>[] buckets;
    private static final int INITIAL_CAPACITY = 16; 
    
    @SuppressWarnings("unchecked")
    public hashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }
    
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];
        
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        
        bucket.add(new Entry<>(key, value));
    }
    
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];
        
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        
        return null; 
    }
    
    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];
        
        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                toRemove = entry;
                break;
            }
        }
        
        if (toRemove != null) {
            bucket.remove(toRemove);
        }
    }
    
  
    public static void main(String[] args) {
        hashMap<String, Integer> map = new hashMap<>();
        map.put("hello", 1);
        map.put("world", 2);
        
        System.out.println(map.get("hello")); 
        System.out.println(map.get("world")); 
        
        map.remove("hello");
        System.out.println(map.get("hello")); 
    }
}
