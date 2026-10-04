package com.opencsv.bean;

import java.lang.reflect.Field;
import java.util.Locale;
import org.apache.commons.collections4.MultiValuedMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BeanFieldJoinStringIndex<T> extends BeanFieldJoin<T, String> {
    public BeanFieldJoinStringIndex(Class<?> cls, Field field, boolean z, Locale locale, CsvConverter csvConverter, Class<? extends MultiValuedMap> cls2, String str, String str2) {
        super(cls, field, z, locale, csvConverter, cls2, str, str2);
    }

    @Override // com.opencsv.bean.BeanFieldJoin
    public Object putNewValue(MultiValuedMap<String, Object> multiValuedMap, String str, Object obj) {
        return Boolean.valueOf(multiValuedMap.put(str, obj));
    }
}
