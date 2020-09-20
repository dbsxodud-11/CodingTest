package Data_Structure.HashTable;

import java.util.Set;
import java.util.HashSet;

public class MyHashMap<K, V> implements MyMap<K, V> {
    
    //1. Seperate Chaining Method
    private Node[] st; //array of chains
    private int M;
    private int size;

    private static class Node{
        private Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap(int M){
        st = new Node[M];
        this.M = M;
        size = 0;
    }

    //Hash Table
    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public V get(K key){
        int i = hash(key);
        for(Node x = st[i]; x != null; x = x.next){
            if(key.equals(x.key)) return (V)x.value;
        }
        return null;
    }

    public void put(K key, V value){
        int i = hash(key);
        for(Node x = st[i]; x != null; x = x.next){
            //Already in map
            if(key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        st[i] = new Node(key, value, st[i]);
        size++;
    }

    public V remove(K key){
        int i = hash(key);
        //1. head
        if(key.equals(st[i].key)){
            V val = (V)st[i].value;
            st[i] = st[i].next;
            size--;
            return val;
        }else{
            for(Node x = st[i]; x.next != null; x = x.next){
                if(key.equals(x.next.key)){
                    V val = (V)x.next.value;
                    Node newNext = x.next.next;
                    x.next = newNext;
                    size--;
                    return val;
                }
            }
            return null;
        }
    }

    public Set<K> keySet(){
        Set<K> keyset = new HashSet<>();
        for(int i=0; i<M; i++){
            for(Node x=st[i]; x != null; x = x.next){
                keyset.add((K)x.key);
            }
        }
        return keyset; 
    }
}
