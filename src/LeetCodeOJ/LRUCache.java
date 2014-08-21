package LeetCodeOJ;

/*Design and implement a data structure for Least Recently Used (LRU) cache.
 *  It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key
 if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present.
 When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.*/
import java.util.*;

public class LRUCache {
	
	private LinkedHashMap<Integer, Integer> cacheMap = null;

	public LRUCache(final int capacity) {
		cacheMap = new LinkedHashMap<Integer, Integer>(capacity,0.75f,true) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected boolean removeEldestEntry(
					Map.Entry<Integer, Integer> eldest) {
				return size() > capacity;
			}
		};
	}

	public int get(int key) {
		if (cacheMap.containsKey(key)) {
			return cacheMap.get(key);
		}
		return -1;
	}

	public void set(int key, int value) {
		cacheMap.put(key, value);
	}
}
