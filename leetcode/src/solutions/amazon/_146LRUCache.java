package solutions.amazon;

import java.util.LinkedHashMap;

/**
 * NO.146 LRU Cache
 * Keywords: LinkedHashMap classic
 * Difficulty: Medium
 * Company: Amazon
 */
public class _146LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        int val = cache.get(1);
        System.out.println(val);
        val = cache.get(2);
        System.out.println(val);
    }
}

/**
 * 用java的LinkedHashMap实现
 */
class LRUCache {
    private final LinkedHashMap<Integer, Integer> cache;
    private final int capacity;
    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }
    public int get(int key) {
        Integer val = cache.get(key);
        if (val != null) {
            cache.remove(key);
            cache.put(key, val);
        }
        return val == null ? -1 : val;
    }
    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        } else if (cache.size() == capacity) {
            //remove the 1st key from cache
            Integer firstKey = cache.keySet().iterator().next();
            cache.remove(firstKey);
        }
        cache.put(key, val);
    }
}