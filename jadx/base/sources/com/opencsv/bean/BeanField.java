package com.opencsv.bean;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface BeanField<T, I> {
    Locale getErrorLocale();

    Field getField();

    Object getFieldValue(Object obj);

    Class<?> getType();

    Object[] indexAndSplitMultivaluedField(Object obj, I i);

    boolean isRequired();

    void setErrorLocale(Locale locale);

    void setField(Field field);

    void setFieldValue(Object obj, String str, String str2);

    void setRequired(boolean z);

    void setType(Class<?> cls);

    String[] write(Object obj, I i);
}
