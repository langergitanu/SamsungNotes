package com.opencsv.bean;

import com.opencsv.bean.ComplexFieldMapEntry;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.lang3.ObjectUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractFieldMap<I, K extends Comparable<K>, C extends ComplexFieldMapEntry<I, K, T>, T> implements FieldMap<I, K, C, T> {
    protected Locale errorLocale;
    protected final SortedMap<K, BeanField<T, K>> simpleMap = new TreeMap();
    protected final List<C> complexMapList = new ArrayList();

    public AbstractFieldMap(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$get$0(Comparable comparable, ComplexFieldMapEntry complexFieldMapEntry) {
        return complexFieldMapEntry.contains(comparable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setErrorLocale$2(ComplexFieldMapEntry complexFieldMapEntry) {
        complexFieldMapEntry.setErrorLocale(this.errorLocale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$values$1(List list, ComplexFieldMapEntry complexFieldMapEntry) {
        list.add(complexFieldMapEntry.getBeanField());
    }

    @Override // com.opencsv.bean.FieldMap
    public BeanField<T, K> get(K k) {
        BeanField<T, K> beanField = this.simpleMap.get(k);
        return beanField == null ? (BeanField) this.complexMapList.stream().filter(new C6632o(k, 1)).map(new C6617b(0)).findAny().orElse(null) : beanField;
    }

    @Override // com.opencsv.bean.FieldMap
    public BeanField<T, K> put(K k, BeanField<T, K> beanField) {
        return this.simpleMap.put(k, beanField);
    }

    @Override // com.opencsv.bean.FieldMap
    public void setErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
        this.complexMapList.forEach(new C6616a(this, 0));
    }

    @Override // com.opencsv.bean.FieldMap
    public Collection<BeanField<T, K>> values() {
        ArrayList arrayList = new ArrayList(this.complexMapList.size() + this.simpleMap.size());
        arrayList.addAll(this.simpleMap.values());
        this.complexMapList.forEach(new C6616a(arrayList, 1));
        return arrayList;
    }
}
