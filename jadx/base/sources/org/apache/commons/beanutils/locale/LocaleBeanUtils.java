package org.apache.commons.beanutils.locale;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.locale.LocaleBeanUtilsBean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LocaleBeanUtils extends BeanUtils {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated
    public static class Descriptor {
        private int index = -1;
        private String key;
        private String name;
        private String propName;
        private Object target;

        public Descriptor(Object obj, String str, String str2, String str3, int i) {
            setTarget(obj);
            setName(str);
            setPropName(str2);
            setKey(str3);
            setIndex(i);
        }

        public int getIndex() {
            return this.index;
        }

        public String getKey() {
            return this.key;
        }

        public String getName() {
            return this.name;
        }

        public String getPropName() {
            return this.propName;
        }

        public Object getTarget() {
            return this.target;
        }

        public void setIndex(int i) {
            this.index = i;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPropName(String str) {
            this.propName = str;
        }

        public void setTarget(Object obj) {
            this.target = obj;
        }
    }

    @Deprecated
    public LocaleBeanUtils() {
    }

    @Deprecated
    public static Descriptor calculate(Object obj, String str) {
        LocaleBeanUtilsBean.Descriptor descriptorCalculate = LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().calculate(obj, str);
        return new Descriptor(descriptorCalculate.getTarget(), descriptorCalculate.getName(), descriptorCalculate.getPropName(), descriptorCalculate.getKey(), descriptorCalculate.getIndex());
    }

    public static Object convert(Class<?> cls, int i, Object obj) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().convert(cls, i, obj);
    }

    public static Class<?> definePropertyType(Object obj, String str, String str2) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().definePropertyType(obj, str, str2);
    }

    public static boolean getApplyLocalized() {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getApplyLocalized();
    }

    public static Locale getDefaultLocale() {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getDefaultLocale();
    }

    public static String getIndexedProperty(Object obj, String str) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getIndexedProperty(obj, str);
    }

    public static String getMappedProperty(Object obj, String str) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getMappedProperty(obj, str);
    }

    public static String getMappedPropertyLocale(Object obj, String str, String str2) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getMappedPropertyLocale(obj, str, str2);
    }

    public static String getNestedProperty(Object obj, String str) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getNestedProperty(obj, str);
    }

    public static String getProperty(Object obj, String str) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getProperty(obj, str);
    }

    public static String getSimpleProperty(Object obj, String str) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getSimpleProperty(obj, str);
    }

    public static void invokeSetter(Object obj, String str, String str2, int i, Object obj2) throws InvocationTargetException {
        LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().invokeSetter(obj, str, str2, i, obj2);
    }

    public static void setApplyLocalized(boolean z) {
        LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().setApplyLocalized(z);
    }

    public static void setDefaultLocale(Locale locale) {
        LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().setDefaultLocale(locale);
    }

    public static void setProperty(Object obj, String str, Object obj2) throws InvocationTargetException {
        LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().setProperty(obj, str, obj2);
    }

    public static Object convert(Class<?> cls, int i, Object obj, String str) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().convert(cls, i, obj, str);
    }

    public static String getIndexedProperty(Object obj, String str, int i) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getIndexedProperty(obj, str, i);
    }

    public static String getMappedProperty(Object obj, String str, String str2) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getMappedProperty(obj, str, str2);
    }

    public static String getNestedProperty(Object obj, String str, String str2) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getNestedProperty(obj, str, str2);
    }

    public static String getProperty(Object obj, String str, String str2) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getProperty(obj, str, str2);
    }

    public static String getSimpleProperty(Object obj, String str, String str2) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getSimpleProperty(obj, str, str2);
    }

    public static void setProperty(Object obj, String str, Object obj2, String str2) throws InvocationTargetException {
        LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().setProperty(obj, str, obj2, str2);
    }

    public static String getIndexedProperty(Object obj, String str, int i, String str2) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getIndexedProperty(obj, str, i, str2);
    }

    public static String getMappedProperty(Object obj, String str, String str2, String str3) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getMappedProperty(obj, str, str2, str3);
    }

    public static String getIndexedProperty(Object obj, String str, String str2) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getIndexedProperty(obj, str, str2);
    }
}
