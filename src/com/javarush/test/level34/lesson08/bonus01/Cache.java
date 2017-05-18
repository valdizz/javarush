package com.javarush.test.level34.lesson08.bonus01;

import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private WeakHashMap<K, V> cache = null;   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        if (cache.isEmpty())
            cache.put(key, clazz.newInstance());
        return cache.get(key);
    }

    public boolean put(V obj) {
        //TODO add your code here
        return false;
    }

    public int size() {
        return cache.size();
    }
}
