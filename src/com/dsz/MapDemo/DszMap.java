package com.dsz.MapDemo;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class DszMap<K,V> extends AbstractMap implements Map,Cloneable{
    static final int DE_INI_CAP = 1 << 4;// 默认初始化容量
    static final int MAX_CAP = 1 << 30;//最大容量
    static final float DE_LO_FA = 0.75f;//默认负载因子
    static final int TREEIFY_THRESHOLD = 8;//链表转树的长度阈值
    static final int UNTREEIFY_THRESHOLD = 6;//resize后树转链表的阈值
    static final int MIN_TREEIFY_CAP = 64;//当容量不到64时默认不将链表转为树
    static class Node<K,V> implements Map.Entry<K,V>{
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public final String toString() {
            return key+"="+value;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key)^Objects.hashCode(value);
        }

        @Override
        public boolean equals(Object obj) {
           if(obj == this) return true;
           if(obj instanceof Map.Entry){
               Map.Entry<?,?> e = (Entry<?, ?>) obj;
               if(Objects.equals(this.key,e.getKey())&&Objects.equals(this.value,e.getValue())) return true;

           }
           return  false;
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
        public V setValue(V newvalue) {
            V oldvalue =this.value;
            this.value = newvalue;
            return oldvalue;
        }
    }

    /**
     *
     * @param key
     * @return
     */
    static final int hash(Object key){
        int h;
        return key==null?0:(h = key.hashCode())^(h >>> 16);//高十六位和低十六位异或？？？
    }
    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
