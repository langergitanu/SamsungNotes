package com.microsoft.identity.common.java.cache;

import com.microsoft.identity.common.java.util.ported.Predicate;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IMultiTypeNameValueStorage {
    void clear();

    boolean contains(String str);

    Map<String, String> getAll();

    Iterator<Map.Entry<String, String>> getAllFilteredByKey(Predicate<String> predicate);

    long getLong(String str);

    String getString(String str);

    void putLong(String str, long j);

    void putString(String str, String str2);

    void remove(String str);
}
