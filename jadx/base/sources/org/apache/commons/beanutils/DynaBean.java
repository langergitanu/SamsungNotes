package org.apache.commons.beanutils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface DynaBean {
    boolean contains(String str, String str2);

    Object get(String str);

    Object get(String str, int i);

    Object get(String str, String str2);

    DynaClass getDynaClass();

    void remove(String str, String str2);

    void set(String str, int i, Object obj);

    void set(String str, Object obj);

    void set(String str, String str2, Object obj);
}
