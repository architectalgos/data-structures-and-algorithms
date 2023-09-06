package com.architectalgos.list.application;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Created On : 8/25/23.
 *
 * @author : madstuff
 */
public class LFUCache {
    private int capacity;
    private int minFreq;
    private HashMap<Integer, Integer> keyToValMap; // Key to Value
    private HashMap<Integer, Integer> keyToCountMap; // Key to Count
    private HashMap<Integer, LinkedHashSet<Integer>> freqToNodesMap; // Frequency to Key List

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 1;
        keyToValMap = new HashMap<>();
        keyToCountMap = new HashMap<>();
        freqToNodesMap = new HashMap<>();
        freqToNodesMap.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!keyToValMap.containsKey(key)) return -1;

        int count = keyToCountMap.get(key);
        keyToCountMap.put(key, count + 1);
        freqToNodesMap.get(count).remove(key);
        freqToNodesMap.computeIfAbsent(count + 1, ignore -> new LinkedHashSet<>()).add(key);

        if (freqToNodesMap.get(minFreq).isEmpty()) minFreq++;

        return keyToValMap.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;

        if (keyToValMap.containsKey(key)) {
            keyToValMap.put(key, value);
            get(key); // Using the get function updates the count and rearranges the priorities
            return;
        }

        if (keyToValMap.size() >= capacity) {
            int evict = freqToNodesMap.get(minFreq).iterator().next();
            freqToNodesMap.get(minFreq).remove(evict);
            keyToValMap.remove(evict);
            keyToCountMap.remove(evict);
        }

        keyToValMap.put(key, value);
        keyToCountMap.put(key, 1);
        freqToNodesMap.get(1).add(key);
        minFreq = 1;
    }
}