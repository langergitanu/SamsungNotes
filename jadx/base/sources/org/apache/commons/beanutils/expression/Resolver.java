package org.apache.commons.beanutils.expression;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface Resolver {
    int getIndex(String str);

    String getKey(String str);

    String getProperty(String str);

    boolean hasNested(String str);

    boolean isIndexed(String str);

    boolean isMapped(String str);

    String next(String str);

    String remove(String str);
}
