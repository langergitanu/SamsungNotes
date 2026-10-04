package org.apache.commons.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BeanUtils {

    @Deprecated
    private static int debug;

    @Deprecated
    public BeanUtils() {
    }

    public static Object cloneBean(Object obj) {
        return BeanUtilsBean.getInstance().cloneBean(obj);
    }

    public static void copyProperties(Object obj, Object obj2) throws InvocationTargetException {
        BeanUtilsBean.getInstance().copyProperties(obj, obj2);
    }

    public static void copyProperty(Object obj, String str, Object obj2) throws InvocationTargetException {
        BeanUtilsBean.getInstance().copyProperty(obj, str, obj2);
    }

    public static <K, V> Map<K, V> createCache() {
        return new WeakFastHashMap();
    }

    public static Map<String, String> describe(Object obj) {
        return BeanUtilsBean.getInstance().describe(obj);
    }

    public static String[] getArrayProperty(Object obj, String str) {
        return BeanUtilsBean.getInstance().getArrayProperty(obj, str);
    }

    public static boolean getCacheFast(Map<?, ?> map) {
        if (map instanceof WeakFastHashMap) {
            return ((WeakFastHashMap) map).getFast();
        }
        return false;
    }

    @Deprecated
    public static int getDebug() {
        return debug;
    }

    public static String getIndexedProperty(Object obj, String str) {
        return BeanUtilsBean.getInstance().getIndexedProperty(obj, str);
    }

    public static String getMappedProperty(Object obj, String str) {
        return BeanUtilsBean.getInstance().getMappedProperty(obj, str);
    }

    public static String getNestedProperty(Object obj, String str) {
        return BeanUtilsBean.getInstance().getNestedProperty(obj, str);
    }

    public static String getProperty(Object obj, String str) {
        return BeanUtilsBean.getInstance().getProperty(obj, str);
    }

    public static String getSimpleProperty(Object obj, String str) {
        return BeanUtilsBean.getInstance().getSimpleProperty(obj, str);
    }

    @Deprecated
    public static boolean initCause(Throwable th, Throwable th2) {
        th.initCause(th2);
        return true;
    }

    public static void populate(Object obj, Map<String, ? extends Object> map) throws InvocationTargetException {
        BeanUtilsBean.getInstance().populate(obj, map);
    }

    public static void setCacheFast(Map<?, ?> map, boolean z) {
        if (map instanceof WeakFastHashMap) {
            ((WeakFastHashMap) map).setFast(z);
        }
    }

    @Deprecated
    public static void setDebug(int i) {
        debug = i;
    }

    public static void setProperty(Object obj, String str, Object obj2) throws InvocationTargetException {
        BeanUtilsBean.getInstance().setProperty(obj, str, obj2);
    }

    public static String getIndexedProperty(Object obj, String str, int i) {
        return BeanUtilsBean.getInstance().getIndexedProperty(obj, str, i);
    }

    public static String getMappedProperty(Object obj, String str, String str2) {
        return BeanUtilsBean.getInstance().getMappedProperty(obj, str, str2);
    }
}
