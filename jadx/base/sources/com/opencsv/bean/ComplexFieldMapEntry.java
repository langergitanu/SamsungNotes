package com.opencsv.bean;

import java.lang.Comparable;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ComplexFieldMapEntry<I, K extends Comparable<K>, T> {
    boolean contains(K k);

    BeanField<T, K> getBeanField();

    I getInitializer();

    void setErrorLocale(Locale locale);
}
