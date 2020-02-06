package ru.job4j.colspro.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyHashMap<K, V> implements Iterable<V> {
    private Object[] hashtbl = new Object[16];
    private int idx = 0;
    private int modCount = 0;


     class Node<K, V>  {
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
        Node<K, V> nodefirst, node;
        int hash = key.hashCode();
        int i =  (hashtbl.length - 1) & hash;
        node = (Node<K, V>) hashtbl[i];
        nodefirst = node;
        if (nodefirst == null) {
            modCount++;
            hashtbl[i] = new Node(hash, key, value, null);
            return true;
        }
        while (nodefirst != null) {
            if (nodefirst.hash == hash && ((Objects.equals(key, nodefirst.key)))) {
                return false;
            }
            node = nodefirst;
            nodefirst = nodefirst.next;
        }
        modCount++;
        node.next = new Node<>(hash, key, value, null);
        return true;
    }
    
     V get(K key) {
         Node<K, V> node;
         int hash = key.hashCode();
         node = (Node<K, V>) hashtbl[hashtbl.length - 1 & hash];
         while (node != null) {
             if (node.hash == hash && (Objects.equals(key, node.key))) {
                 return node.value;
             }
             node = node.next;
         }
         return null;
     }

    boolean delete(K key) {
        Node<K, V> node1;
        Node<K, V> node2;
        int hash = key.hashCode();
        int bucket = (hashtbl.length - 1) & hash;
        node1 = (Node<K, V>) hashtbl[bucket];
        if (node1.hash == hash && (Objects.equals(key, node1.key))) {
            modCount++;
            hashtbl[bucket] = node1.next == null ? null : node1.next;
            return true;
        }
        node2 = node1;
        node1 = node1.next;
        while (node1 != null) {
            if (node1.hash == hash && (Objects.equals(key, node1.key))) {
                modCount++;
                node2.next = node1.next;
                return true;
            }
            node2 = node1;
            node1 = node1.next;
        }
        return false;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {

            private int modcnt = modCount;
            private Node<K, V> curnode = (Node<K, V>) hashtbl[0];

            @Override
            public boolean hasNext() {
                if (modcnt != modCount) {
                    throw new ConcurrentModificationException("Объект был изменён");
                }
                while (curnode == null) {
                    if (idx == hashtbl.length - 1) {
                        return false;
                    }
                    curnode = (Node<K, V>) hashtbl[++idx];
                }
                return true;
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
        };
    }

}
