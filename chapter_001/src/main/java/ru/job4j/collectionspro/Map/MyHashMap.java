package ru.job4j.collectionspro.Map;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyHashMap<K, V> implements Iterator<V> {
    private Object[] hashtbl = new Object[16];
    private int idx = 0;
    private int modCount = 0;
    private Node<K, V> curnode = (Node<K, V>)hashtbl[0];

    class Node<K,V>  {
        private final int hash;
        private final K key;
        private V value;
        private Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    boolean insert(K key, V value) {
        Node<K, V> node;
        int i;
        if (key == null) {
            throw new NullPointerException("Ключ должен быть не null");
        }
        modCount++;
        int hash = key.hashCode();
        if ((node = (Node<K, V>) hashtbl[i = (hashtbl.length - 1) & hash]) == null) {
            hashtbl[i] = new Node(hash, key, value, null);
            return true;
        }
        while ((node = node.next) != null) {
            if (node.hash == hash && (node.key == key || (key.equals(node.key)))) {
                return false;
            }
        }
        node = new Node<>(hash, key, value, null);
        return true;
    }
    
     V get(K key) {
         Node<K, V> node;
         if (key == null) {
             throw new NullPointerException("Ключ должен быть не null");
         }
         int hash = key.hashCode();
         node = (Node<K, V>) hashtbl[hashtbl.length - 1 & hash];
         while (node != null) {
             if (node.hash == hash && (node.key == key || (key.equals(node.key)))) {
                 return node.value;
             }
             node = node.next;
         }
         throw new NoSuchElementException("Не найден элемент");
     }

    boolean delete(K key) {
        Node<K, V> node1;
        Node<K, V> node2;
        if (key == null) {
            throw new NullPointerException("Ключ должен быть не null");
        }
        modCount++;
        int hash = key.hashCode();
        node1 = node2 = (Node<K, V>) hashtbl[hashtbl.length - 1 & hash];
        while (node1 != null) {
            if (node1.hash == hash && (node1.key == key || (key.equals(node1.key)))) {
                node2.next = node1.next;
                return true;
            }
            node2 = node1;
            node1 = node1.next;
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        while (curnode == null) {
            if (idx < hashtbl.length - 1) {
                break;
            }
            curnode = (Node<K, V>) hashtbl[++idx];
        }
        return false;
    }

    @Override
    public V next() {
        Node<K, V> result;
        if (!hasNext()) {
            throw  new NoSuchElementException("Не найден элемент");
        }
        result = curnode;
        curnode = curnode.next;
        return result.value;
    }
}
