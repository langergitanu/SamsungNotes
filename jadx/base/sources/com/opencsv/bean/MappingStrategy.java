package com.opencsv.bean;

import com.opencsv.CSVReader;
import java.lang.reflect.Field;
import java.util.Locale;
import org.apache.commons.collections4.MultiValuedMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface MappingStrategy<T> {
    void captureHeader(CSVReader cSVReader);

    String[] generateHeader(T t);

    default void ignoreFields(MultiValuedMap<Class<?>, Field> multiValuedMap) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default boolean isAnnotationDriven() {
        return false;
    }

    T populateNewBean(String[] strArr);

    default void setProfile(String str) {
        throw new UnsupportedOperationException();
    }

    void setType(Class<? extends T> cls);

    String[] transmuteBean(T t);

    default void setErrorLocale(Locale locale) {
    }
}
