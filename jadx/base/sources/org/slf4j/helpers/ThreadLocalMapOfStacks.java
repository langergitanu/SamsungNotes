package org.slf4j.helpers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class ThreadLocalMapOfStacks {
    final ThreadLocal<Map<String, Deque<String>>> tlMapOfStacks = new ThreadLocal<>();

    public void clearDequeByKey(String str) {
        Map<String, Deque<String>> map;
        Deque<String> deque;
        if (str == null || (map = this.tlMapOfStacks.get()) == null || (deque = map.get(str)) == null) {
            return;
        }
        deque.clear();
    }

    public Deque<String> getCopyOfDequeByKey(String str) {
        Map<String, Deque<String>> map;
        Deque<String> deque;
        if (str == null || (map = this.tlMapOfStacks.get()) == null || (deque = map.get(str)) == null) {
            return null;
        }
        return new ArrayDeque(deque);
    }

    public String popByKey(String str) {
        Map<String, Deque<String>> map;
        Deque<String> deque;
        if (str == null || (map = this.tlMapOfStacks.get()) == null || (deque = map.get(str)) == null) {
            return null;
        }
        return deque.pop();
    }

    public void pushByKey(String str, String str2) {
        if (str == null) {
            return;
        }
        Map<String, Deque<String>> map = this.tlMapOfStacks.get();
        if (map == null) {
            map = new HashMap<>();
            this.tlMapOfStacks.set(map);
        }
        Deque<String> arrayDeque = map.get(str);
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque<>();
        }
        arrayDeque.push(str2);
        map.put(str, arrayDeque);
    }
}
