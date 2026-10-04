package org.slf4j.spi;

import java.util.Deque;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public interface MDCAdapter {
    void clear();

    void clearDequeByKey(String str);

    String get(String str);

    Map<String, String> getCopyOfContextMap();

    Deque<String> getCopyOfDequeByKey(String str);

    String popByKey(String str);

    void pushByKey(String str, String str2);

    void put(String str, String str2);

    void remove(String str);

    void setContextMap(Map<String, String> map);
}
