package org.apache.commons.beanutils;

import java.beans.PropertyDescriptor;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class WrapDynaClass implements DynaClass {
    private static final ContextClassLoaderLocal<Map<CacheKey, WrapDynaClass>> CLASSLOADER_CACHE = new ContextClassLoaderLocal<Map<CacheKey, WrapDynaClass>>() { // from class: org.apache.commons.beanutils.WrapDynaClass.1
        @Override // org.apache.commons.beanutils.ContextClassLoaderLocal
        public Map<CacheKey, WrapDynaClass> initialValue() {
            return new WeakHashMap();
        }
    };

    @Deprecated
    protected static HashMap<Object, Object> dynaClasses = new HashMap<Object, Object>() { // from class: org.apache.commons.beanutils.WrapDynaClass.2
        private static final long serialVersionUID = 1;

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            WrapDynaClass.getDynaClassesMap().clear();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return WrapDynaClass.getDynaClassesMap().containsKey(obj);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            return WrapDynaClass.getDynaClassesMap().containsValue(obj);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<Object, Object>> entrySet() {
            return WrapDynaClass.getDynaClassesMap().entrySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return WrapDynaClass.getDynaClassesMap().equals(obj);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            return WrapDynaClass.getDynaClassesMap().get(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return WrapDynaClass.getDynaClassesMap().hashCode();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return WrapDynaClass.getDynaClassesMap().isEmpty();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Set<Object> keySet() {
            HashSet hashSet = new HashSet();
            Iterator it = WrapDynaClass.getClassesCache().keySet().iterator();
            while (it.hasNext()) {
                hashSet.add(((CacheKey) it.next()).beanClass);
            }
            return hashSet;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            return WrapDynaClass.getClassesCache().put(new CacheKey((Class) obj, PropertyUtilsBean.getInstance()), (WrapDynaClass) obj2);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends Object, ? extends Object> map) {
            for (Map.Entry<? extends Object, ? extends Object> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            return WrapDynaClass.getDynaClassesMap().remove(obj);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return WrapDynaClass.getDynaClassesMap().size();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Collection<Object> values() {
            return WrapDynaClass.getDynaClassesMap().values();
        }
    };

    @Deprecated
    protected Class<?> beanClass;
    private final String beanClassName;
    private final Reference<Class<?>> beanClassRef;
    protected PropertyDescriptor[] descriptors;
    protected DynaProperty[] properties;
    private final PropertyUtilsBean propertyUtilsBean;
    protected HashMap<String, PropertyDescriptor> descriptorsMap = new HashMap<>();
    protected HashMap<String, DynaProperty> propertiesMap = new HashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CacheKey {
        private final Class<?> beanClass;
        private final PropertyUtilsBean propUtils;

        public CacheKey(Class<?> cls, PropertyUtilsBean propertyUtilsBean) {
            this.beanClass = cls;
            this.propUtils = propertyUtilsBean;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CacheKey)) {
                return false;
            }
            CacheKey cacheKey = (CacheKey) obj;
            return this.beanClass.equals(cacheKey.beanClass) && this.propUtils.equals(cacheKey.propUtils);
        }

        public int hashCode() {
            return (this.propUtils.hashCode() * 31) + (this.beanClass.hashCode() * 31) + 17;
        }
    }

    private WrapDynaClass(Class<?> cls, PropertyUtilsBean propertyUtilsBean) {
        this.beanClassRef = new SoftReference(cls);
        this.beanClassName = cls.getName();
        this.propertyUtilsBean = propertyUtilsBean;
        introspect();
    }

    public static void clear() {
        getClassesCache().clear();
    }

    public static WrapDynaClass createDynaClass(Class<?> cls) {
        return createDynaClass(cls, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<CacheKey, WrapDynaClass> getClassesCache() {
        return CLASSLOADER_CACHE.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<Object, Object> getDynaClassesMap() {
        return CLASSLOADER_CACHE.get();
    }

    public Class<?> getBeanClass() {
        return this.beanClassRef.get();
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaProperty[] getDynaProperties() {
        return this.properties;
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaProperty getDynaProperty(String str) {
        if (str != null) {
            return this.propertiesMap.get(str);
        }
        throw new IllegalArgumentException("No property name specified");
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public String getName() {
        return this.beanClassName;
    }

    public PropertyDescriptor getPropertyDescriptor(String str) {
        return this.descriptorsMap.get(str);
    }

    public PropertyUtilsBean getPropertyUtilsBean() {
        return this.propertyUtilsBean;
    }

    public void introspect() {
        Class<?> beanClass = getBeanClass();
        PropertyDescriptor[] propertyDescriptors = getPropertyUtilsBean().getPropertyDescriptors(beanClass);
        if (propertyDescriptors == null) {
            propertyDescriptors = new PropertyDescriptor[0];
        }
        Map mappedPropertyDescriptors = PropertyUtils.getMappedPropertyDescriptors(beanClass);
        if (mappedPropertyDescriptors == null) {
            mappedPropertyDescriptors = new HashMap();
        }
        this.properties = new DynaProperty[mappedPropertyDescriptors.size() + propertyDescriptors.length];
        for (int i = 0; i < propertyDescriptors.length; i++) {
            this.descriptorsMap.put(propertyDescriptors[i].getName(), propertyDescriptors[i]);
            this.properties[i] = new DynaProperty(propertyDescriptors[i].getName(), propertyDescriptors[i].getPropertyType());
            this.propertiesMap.put(this.properties[i].getName(), this.properties[i]);
        }
        int length = propertyDescriptors.length;
        Iterator it = mappedPropertyDescriptors.keySet().iterator();
        while (it.hasNext()) {
            this.properties[length] = new DynaProperty(((PropertyDescriptor) mappedPropertyDescriptors.get((String) it.next())).getName(), Map.class);
            this.propertiesMap.put(this.properties[length].getName(), this.properties[length]);
            length++;
        }
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaBean newInstance() {
        return new WrapDynaBean(getBeanClass().newInstance());
    }

    public static WrapDynaClass createDynaClass(Class<?> cls, PropertyUtilsBean propertyUtilsBean) {
        if (propertyUtilsBean == null) {
            propertyUtilsBean = PropertyUtilsBean.getInstance();
        }
        CacheKey cacheKey = new CacheKey(cls, propertyUtilsBean);
        WrapDynaClass wrapDynaClass = getClassesCache().get(cacheKey);
        if (wrapDynaClass != null) {
            return wrapDynaClass;
        }
        WrapDynaClass wrapDynaClass2 = new WrapDynaClass(cls, propertyUtilsBean);
        getClassesCache().put(cacheKey, wrapDynaClass2);
        return wrapDynaClass2;
    }
}
