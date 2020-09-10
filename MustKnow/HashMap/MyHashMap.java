package MustKnow.HashMap;

import java.util.Map;

public class MyHashMap<K, V> {
    private int CAPACITY = 16;
    private int size = 0;
    private MyEntry[] table;

    public MyHashMap(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        this.table = new MyEntry[CAPACITY];
    }

    public MyHashMap() {
        this.table = new MyEntry[CAPACITY];
    }

    public V put(K key, V value) {
        if (key == null)
            return putForNullKey(value);
        int hash = myHash(key);
        int i = indexForTable(hash, CAPACITY);

        for (MyEntry<K, V> e = table[i]; e != null; e = e.next) {
            if (e.hash == hash && (e.key == key || e.key.equals(key))) {
                V old = e.value;
                e.value = value;
                return old;
            }
        }

        addEntry(hash, key, value, i);

        return null;
    }

    public V get(K key) {
        if (key == null)
            return getForNullKey();

        int hash = myHash(key);
        int i = indexForTable(hash, CAPACITY);

        for (MyEntry<K, V> e = table[i]; e != null; e = e.next) {
            if (e.hash == hash && (e.key == key || e.key.equals(key)))
                return e.value;
        }

        return null;
    }

    private V getForNullKey() {
        for (MyEntry<K, V> e = table[0]; e != null; e = e.next) {
            if (e.key == null)
                return e.value;
        }
        return null;
    }

    private void addEntry(int hash, K key, V value, int i) {
        MyEntry<K, V> e = table[i];
        table[i] = new MyEntry<K, V>(hash, key, value, e);
        if (size == CAPACITY)
            resize();

        size++;
    }

    private void resize() {
        CAPACITY= CAPACITY* 2;
        MyEntry[] newtable = new MyEntry[CAPACITY];
        for (Map.Entry<K, V> entry : table) {
            MyEntry<K, V> e = (MyEntry<K, V>) entry; // 取得旧Entry数组的每个元素
            if (e != null) {
                entry = null;// 释放旧Entry数组的对象引用（循环后，旧的Entry数组不再引用任何对象）
                do {
                    MyEntry<K, V> next = e.next;
                    int i = indexForTable(e.hash, CAPACITY); // 重新计算每个元素在数组中的位置
                    e.next = newtable[i];
                    newtable[i] = e; // 将元素放在数组上
                    e = next; // 访问下一个Entry链上的元素
                } while (e != null);
            }
        }
        table = newtable;
    }

    private int indexForTable(int hash, int CAPACITY) {
        return hash & (CAPACITY - 1);
    }

    private int myHash(K key) {
        if (key == null)
            return 0;

        int h = key.hashCode();
        h = h ^ (h >>> 16);

        return h;
    }

    private V putForNullKey(V value) {
        for (MyEntry<K, V> e = table[0]; e != null; e = e.next) {
            if (e.key == null) {
                V old = e.value;
                e.value = value;
                return old;
            }
        }

        addEntry(0, null, value, 0);

        return null;
    }

}

class MyEntry<K, V> implements Map.Entry<K, V> {
    public int hash;
    public K key;
    public V value;
    public MyEntry<K, V> next;

    public MyEntry(int hash, K key, V value, MyEntry<K, V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public K getKey() {
        return null;
    }

    @Override
    public V getValue() {
        return null;
    }

    @Override
    public V setValue(V value) {
        return null;
    }
}

