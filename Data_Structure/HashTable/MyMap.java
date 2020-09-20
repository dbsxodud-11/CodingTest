package Data_Structure.HashTable;

import java.util.Set;

public interface MyMap<K, V> {

    //return number of (key, value) pairs in Map
    public int size();

    //return true is map is empty
    public boolean isEmpty();

    //return value that associated with key K
    public V get(K key);

    //If map does not have entry with key equal to K, then adds (K, V)pairs to map
    //Else, replace V with the existing value of the entry with the key K
    public void put(K key, V value);

    //remove (K, V) from map
    public V remove(K key);

    //return set of keys in map
    public Set<K> keySet();
}
