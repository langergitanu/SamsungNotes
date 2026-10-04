package org.apache.poi.java.awt;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
class VKCollection {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    Map code2name = new HashMap();
    Map name2code = new HashMap();

    public synchronized Integer findCode(String str) {
        return (Integer) this.name2code.get(str);
    }

    public synchronized String findName(Integer num) {
        return (String) this.code2name.get(num);
    }

    public synchronized void put(String str, Integer num) {
        this.code2name.put(num, str);
        this.name2code.put(str, num);
    }
}
