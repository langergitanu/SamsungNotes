package com.opencsv.bean;

import com.opencsv.bean.ComplexFieldMapEntry;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface FieldMap<I, K extends Comparable<K>, C extends ComplexFieldMapEntry<I, K, T>, T> {
    String[] generateHeader(T t);

    BeanField<T, K> get(K k);

    BeanField<T, K> put(K k, BeanField<T, K> beanField);

    void putComplex(I i, BeanField<T, K> beanField);

    void setErrorLocale(Locale locale);

    Collection<BeanField<T, K>> values();
}
