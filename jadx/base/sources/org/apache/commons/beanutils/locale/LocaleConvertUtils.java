package org.apache.commons.beanutils.locale;

import java.util.Locale;
import org.apache.commons.collections.FastHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LocaleConvertUtils {
    @Deprecated
    public LocaleConvertUtils() {
    }

    public static String convert(Object obj) {
        return LocaleConvertUtilsBean.getInstance().convert(obj);
    }

    @Deprecated
    public static FastHashMap create(Locale locale) {
        return LocaleConvertUtilsBean.getInstance().create(locale);
    }

    public static void deregister() {
        LocaleConvertUtilsBean.getInstance().deregister();
    }

    public static boolean getApplyLocalized() {
        return LocaleConvertUtilsBean.getInstance().getApplyLocalized();
    }

    public static Locale getDefaultLocale() {
        return LocaleConvertUtilsBean.getInstance().getDefaultLocale();
    }

    public static LocaleConverter lookup(Class<?> cls, Locale locale) {
        return LocaleConvertUtilsBean.getInstance().lookup(cls, locale);
    }

    public static void register(LocaleConverter localeConverter, Class<?> cls, Locale locale) {
        LocaleConvertUtilsBean.getInstance().register(localeConverter, cls, locale);
    }

    public static void setApplyLocalized(boolean z) {
        LocaleConvertUtilsBean.getInstance().setApplyLocalized(z);
    }

    public static void setDefaultLocale(Locale locale) {
        LocaleConvertUtilsBean.getInstance().setDefaultLocale(locale);
    }

    public static String convert(Object obj, Locale locale, String str) {
        return LocaleConvertUtilsBean.getInstance().convert(obj, locale, str);
    }

    public static void deregister(Class<?> cls, Locale locale) {
        LocaleConvertUtilsBean.getInstance().deregister(cls, locale);
    }

    @Deprecated
    public static FastHashMap lookup(Locale locale) {
        return LocaleConvertUtilsBean.getInstance().lookup(locale);
    }

    public static String convert(Object obj, String str) {
        return LocaleConvertUtilsBean.getInstance().convert(obj, str);
    }

    public static void deregister(Locale locale) {
        LocaleConvertUtilsBean.getInstance().deregister(locale);
    }

    public static Object convert(String str, Class<?> cls) {
        return LocaleConvertUtilsBean.getInstance().convert(str, cls);
    }

    public static Object convert(String str, Class<?> cls, Locale locale, String str2) {
        return LocaleConvertUtilsBean.getInstance().convert(str, cls, locale, str2);
    }

    public static Object convert(String str, Class<?> cls, String str2) {
        return LocaleConvertUtilsBean.getInstance().convert(str, cls, str2);
    }

    public static Object convert(String[] strArr, Class<?> cls) {
        return LocaleConvertUtilsBean.getInstance().convert(strArr, cls);
    }

    public static Object convert(String[] strArr, Class<?> cls, Locale locale, String str) {
        return LocaleConvertUtilsBean.getInstance().convert(strArr, cls, locale, str);
    }

    public static Object convert(String[] strArr, Class<?> cls, String str) {
        return LocaleConvertUtilsBean.getInstance().convert(strArr, cls, str);
    }
}
