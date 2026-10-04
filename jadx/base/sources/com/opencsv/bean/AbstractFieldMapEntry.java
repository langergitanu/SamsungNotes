package com.opencsv.bean;

import java.lang.Comparable;
import java.util.Locale;
import org.apache.commons.lang3.ObjectUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractFieldMapEntry<I, K extends Comparable<K>, T> implements ComplexFieldMapEntry<I, K, T> {
    protected Locale errorLocale;
    protected final BeanField<T, K> field;

    public AbstractFieldMapEntry(BeanField<T, K> beanField, Locale locale) {
        this.field = beanField;
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
    }

    @Override // com.opencsv.bean.ComplexFieldMapEntry
    public BeanField<T, K> getBeanField() {
        return this.field;
    }

    @Override // com.opencsv.bean.ComplexFieldMapEntry
    public void setErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
    }
}
