package org.apache.commons.beanutils;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.keyvalue.AbstractMapEntry;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BeanMap extends AbstractMap<Object, Object> implements Cloneable {
    private transient Object bean;
    public static final Object[] NULL_ARGUMENTS = new Object[0];
    private static final Map<Class<? extends Object>, Transformer> typeTransformers = Collections.unmodifiableMap(createTypeTransformers());

    @Deprecated
    public static HashMap defaultTransformers = new HashMap() { // from class: org.apache.commons.beanutils.BeanMap.1
        private static final long serialVersionUID = 1;

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return BeanMap.typeTransformers.containsKey(obj);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            return BeanMap.typeTransformers.containsValue(obj);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Set entrySet() {
            return BeanMap.typeTransformers.entrySet();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            return BeanMap.typeTransformers.get(obj);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return BeanMap.typeTransformers.keySet();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void putAll(Map map) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return BeanMap.typeTransformers.size();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Collection values() {
            return BeanMap.typeTransformers.values();
        }
    };
    private transient HashMap<String, Method> readMethods = new HashMap<>();
    private transient HashMap<String, Method> writeMethods = new HashMap<>();
    private transient HashMap<String, Class<? extends Object>> types = new HashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Entry extends AbstractMapEntry {
        private final BeanMap owner;

        public Entry(BeanMap beanMap, Object obj, Object obj2) {
            super(obj, obj2);
            this.owner = beanMap;
        }

        @Override // org.apache.commons.collections.keyvalue.AbstractMapEntry, java.util.Map.Entry
        public Object setValue(Object obj) {
            Object key = getKey();
            Object obj2 = this.owner.get(key);
            this.owner.put(key, obj);
            super.setValue(this.owner.get(key));
            return obj2;
        }
    }

    public BeanMap() {
    }

    private static Map<Class<? extends Object>, Transformer> createTypeTransformers() {
        HashMap map = new HashMap();
        final int i = 0;
        map.put(Boolean.TYPE, new Transformer() { // from class: org.apache.commons.beanutils.c
            @Override // org.apache.commons.collections.Transformer
            public final Object transform(Object obj) {
                switch (i) {
                    case 0:
                        return BeanMap.lambda$createTypeTransformers$0(obj);
                    case 1:
                        return BeanMap.lambda$createTypeTransformers$1(obj);
                    case 2:
                        return BeanMap.lambda$createTypeTransformers$2(obj);
                    case 3:
                        return BeanMap.lambda$createTypeTransformers$3(obj);
                    case 4:
                        return BeanMap.lambda$createTypeTransformers$4(obj);
                    case 5:
                        return BeanMap.lambda$createTypeTransformers$5(obj);
                    case 6:
                        return BeanMap.lambda$createTypeTransformers$6(obj);
                    default:
                        return BeanMap.lambda$createTypeTransformers$7(obj);
                }
            }
        });
        final int i2 = 1;
        map.put(Character.TYPE, new Transformer() { // from class: org.apache.commons.beanutils.c
            @Override // org.apache.commons.collections.Transformer
            public final Object transform(Object obj) {
                switch (i2) {
                    case 0:
                        return BeanMap.lambda$createTypeTransformers$0(obj);
                    case 1:
                        return BeanMap.lambda$createTypeTransformers$1(obj);
                    case 2:
                        return BeanMap.lambda$createTypeTransformers$2(obj);
                    case 3:
                        return BeanMap.lambda$createTypeTransformers$3(obj);
                    case 4:
                        return BeanMap.lambda$createTypeTransformers$4(obj);
                    case 5:
                        return BeanMap.lambda$createTypeTransformers$5(obj);
                    case 6:
                        return BeanMap.lambda$createTypeTransformers$6(obj);
                    default:
                        return BeanMap.lambda$createTypeTransformers$7(obj);
                }
            }
        });
        final int i4 = 2;
        map.put(Byte.TYPE, new Transformer() { // from class: org.apache.commons.beanutils.c
            @Override // org.apache.commons.collections.Transformer
            public final Object transform(Object obj) {
                switch (i4) {
                    case 0:
                        return BeanMap.lambda$createTypeTransformers$0(obj);
                    case 1:
                        return BeanMap.lambda$createTypeTransformers$1(obj);
                    case 2:
                        return BeanMap.lambda$createTypeTransformers$2(obj);
                    case 3:
                        return BeanMap.lambda$createTypeTransformers$3(obj);
                    case 4:
                        return BeanMap.lambda$createTypeTransformers$4(obj);
                    case 5:
                        return BeanMap.lambda$createTypeTransformers$5(obj);
                    case 6:
                        return BeanMap.lambda$createTypeTransformers$6(obj);
                    default:
                        return BeanMap.lambda$createTypeTransformers$7(obj);
                }
            }
        });
        final int i5 = 3;
        map.put(Short.TYPE, new Transformer() { // from class: org.apache.commons.beanutils.c
            @Override // org.apache.commons.collections.Transformer
            public final Object transform(Object obj) {
                switch (i5) {
                    case 0:
                        return BeanMap.lambda$createTypeTransformers$0(obj);
                    case 1:
                        return BeanMap.lambda$createTypeTransformers$1(obj);
                    case 2:
                        return BeanMap.lambda$createTypeTransformers$2(obj);
                    case 3:
                        return BeanMap.lambda$createTypeTransformers$3(obj);
                    case 4:
                        return BeanMap.lambda$createTypeTransformers$4(obj);
                    case 5:
                        return BeanMap.lambda$createTypeTransformers$5(obj);
                    case 6:
                        return BeanMap.lambda$createTypeTransformers$6(obj);
                    default:
                        return BeanMap.lambda$createTypeTransformers$7(obj);
                }
            }
        });
        final int i6 = 4;
        map.put(Integer.TYPE, new Transformer() { // from class: org.apache.commons.beanutils.c
            @Override // org.apache.commons.collections.Transformer
            public final Object transform(Object obj) {
                switch (i6) {
                    case 0:
                        return BeanMap.lambda$createTypeTransformers$0(obj);
                    case 1:
                        return BeanMap.lambda$createTypeTransformers$1(obj);
                    case 2:
                        return BeanMap.lambda$createTypeTransformers$2(obj);
                    case 3:
                        return BeanMap.lambda$createTypeTransformers$3(obj);
                    case 4:
                        return BeanMap.lambda$createTypeTransformers$4(obj);
                    case 5:
                        return BeanMap.lambda$createTypeTransformers$5(obj);
                    case 6:
                        return BeanMap.lambda$createTypeTransformers$6(obj);
                    default:
                        return BeanMap.lambda$createTypeTransformers$7(obj);
                }
            }
        });
        final int i7 = 5;
        map.put(Long.TYPE, new Transformer() { // from class: org.apache.commons.beanutils.c
            @Override // org.apache.commons.collections.Transformer
            public final Object transform(Object obj) {
                switch (i7) {
                    case 0:
                        return BeanMap.lambda$createTypeTransformers$0(obj);
                    case 1:
                        return BeanMap.lambda$createTypeTransformers$1(obj);
                    case 2:
                        return BeanMap.lambda$createTypeTransformers$2(obj);
                    case 3:
                        return BeanMap.lambda$createTypeTransformers$3(obj);
                    case 4:
                        return BeanMap.lambda$createTypeTransformers$4(obj);
                    case 5:
                        return BeanMap.lambda$createTypeTransformers$5(obj);
                    case 6:
                        return BeanMap.lambda$createTypeTransformers$6(obj);
                    default:
                        return BeanMap.lambda$createTypeTransformers$7(obj);
                }
            }
        });
        final int i8 = 6;
        map.put(Float.TYPE, new Transformer() { // from class: org.apache.commons.beanutils.c
            @Override // org.apache.commons.collections.Transformer
            public final Object transform(Object obj) {
                switch (i8) {
                    case 0:
                        return BeanMap.lambda$createTypeTransformers$0(obj);
                    case 1:
                        return BeanMap.lambda$createTypeTransformers$1(obj);
                    case 2:
                        return BeanMap.lambda$createTypeTransformers$2(obj);
                    case 3:
                        return BeanMap.lambda$createTypeTransformers$3(obj);
                    case 4:
                        return BeanMap.lambda$createTypeTransformers$4(obj);
                    case 5:
                        return BeanMap.lambda$createTypeTransformers$5(obj);
                    case 6:
                        return BeanMap.lambda$createTypeTransformers$6(obj);
                    default:
                        return BeanMap.lambda$createTypeTransformers$7(obj);
                }
            }
        });
        final int i9 = 7;
        map.put(Double.TYPE, new Transformer() { // from class: org.apache.commons.beanutils.c
            @Override // org.apache.commons.collections.Transformer
            public final Object transform(Object obj) {
                switch (i9) {
                    case 0:
                        return BeanMap.lambda$createTypeTransformers$0(obj);
                    case 1:
                        return BeanMap.lambda$createTypeTransformers$1(obj);
                    case 2:
                        return BeanMap.lambda$createTypeTransformers$2(obj);
                    case 3:
                        return BeanMap.lambda$createTypeTransformers$3(obj);
                    case 4:
                        return BeanMap.lambda$createTypeTransformers$4(obj);
                    case 5:
                        return BeanMap.lambda$createTypeTransformers$5(obj);
                    case 6:
                        return BeanMap.lambda$createTypeTransformers$6(obj);
                    default:
                        return BeanMap.lambda$createTypeTransformers$7(obj);
                }
            }
        });
        return map;
    }

    private void initialise() {
        if (getBean() == null) {
            return;
        }
        try {
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(getBean().getClass()).getPropertyDescriptors();
            if (propertyDescriptors != null) {
                for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                    if (propertyDescriptor != null) {
                        String name = propertyDescriptor.getName();
                        Method readMethod = propertyDescriptor.getReadMethod();
                        Method writeMethod = propertyDescriptor.getWriteMethod();
                        Class<? extends Object> propertyType = propertyDescriptor.getPropertyType();
                        if (readMethod != null) {
                            this.readMethods.put(name, readMethod);
                        }
                        if (writeMethod != null) {
                            this.writeMethods.put(name, writeMethod);
                        }
                        this.types.put(name, propertyType);
                    }
                }
            }
        } catch (IntrospectionException e) {
            logWarn(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$createTypeTransformers$0(Object obj) {
        return Boolean.valueOf(obj.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$createTypeTransformers$1(Object obj) {
        return Character.valueOf(obj.toString().charAt(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$createTypeTransformers$2(Object obj) {
        return Byte.valueOf(obj.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$createTypeTransformers$3(Object obj) {
        return Short.valueOf(obj.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$createTypeTransformers$4(Object obj) {
        return Integer.valueOf(obj.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$createTypeTransformers$5(Object obj) {
        return Long.valueOf(obj.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$createTypeTransformers$6(Object obj) {
        return Float.valueOf(obj.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$createTypeTransformers$7(Object obj) {
        return Double.valueOf(obj.toString());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Exception e;
        Class<?> cls;
        Object obj = this.bean;
        if (obj == null) {
            return;
        }
        try {
            cls = obj.getClass();
        } catch (Exception e2) {
            e = e2;
            cls = null;
        }
        try {
            this.bean = cls.getConstructor(null).newInstance(null);
        } catch (Exception e3) {
            e = e3;
            throw new UnsupportedOperationException(AbstractC2322a.m1621k("Could not create new instance of class: ", cls), e);
        }
    }

    @Override // java.util.AbstractMap
    public Object clone() throws CloneNotSupportedException {
        BeanMap beanMap = (BeanMap) super.clone();
        Object obj = this.bean;
        if (obj == null) {
            return beanMap;
        }
        Class<?> cls = obj.getClass();
        try {
            try {
                beanMap.setBean(cls.getConstructor(null).newInstance(null));
                try {
                    for (String str : this.readMethods.keySet()) {
                        if (getWriteMethod((Object) str) != null) {
                            beanMap.put(str, get(str));
                        }
                    }
                    return beanMap;
                } catch (Exception e) {
                    CloneNotSupportedException cloneNotSupportedException = new CloneNotSupportedException("Unable to copy bean values to cloned bean map: " + e);
                    cloneNotSupportedException.initCause(e);
                    throw cloneNotSupportedException;
                }
            } catch (Exception e2) {
                CloneNotSupportedException cloneNotSupportedException2 = new CloneNotSupportedException("Unable to set bean in the cloned bean map: " + e2);
                cloneNotSupportedException2.initCause(e2);
                throw cloneNotSupportedException2;
            }
        } catch (Exception e3) {
            CloneNotSupportedException cloneNotSupportedException3 = new CloneNotSupportedException("Unable to instantiate the underlying bean \"" + cls.getName() + "\": " + e3);
            cloneNotSupportedException3.initCause(e3);
            throw cloneNotSupportedException3;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return getReadMethod(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    public Object convertType(Class<?> cls, Object obj) {
        try {
            return cls.getConstructor(obj.getClass()).newInstance(obj);
        } catch (NoSuchMethodException unused) {
            Transformer typeTransformer = getTypeTransformer(cls);
            return typeTransformer != null ? typeTransformer.transform(obj) : obj;
        }
    }

    public Object[] createWriteMethodArguments(Method method, Object obj) {
        if (obj != null) {
            try {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes != null && parameterTypes.length > 0) {
                    Class<?> cls = parameterTypes[0];
                    if (!cls.isAssignableFrom(obj.getClass())) {
                        obj = convertType(cls, obj);
                    }
                }
            } catch (InstantiationException e) {
                e = e;
                throw new IllegalArgumentException(e.getMessage(), e);
            } catch (InvocationTargetException e2) {
                e = e2;
                throw new IllegalArgumentException(e.getMessage(), e);
            }
        }
        return new Object[]{obj};
    }

    public Iterator<Map.Entry<Object, Object>> entryIterator() {
        final Iterator<String> itKeyIterator = keyIterator();
        return new Iterator<Map.Entry<Object, Object>>() { // from class: org.apache.commons.beanutils.BeanMap.2
            @Override // java.util.Iterator
            public boolean hasNext() {
                return itKeyIterator.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("remove() not supported for BeanMap");
            }

            @Override // java.util.Iterator
            public Map.Entry<Object, Object> next() {
                Object next = itKeyIterator.next();
                return new Entry(BeanMap.this, next, BeanMap.this.get(next));
            }
        };
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        return Collections.unmodifiableSet(new AbstractSet<Map.Entry<Object, Object>>() { // from class: org.apache.commons.beanutils.BeanMap.3
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<Object, Object>> iterator() {
                return BeanMap.this.entryIterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return BeanMap.this.readMethods.size();
            }
        });
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Method readMethod;
        if (this.bean == null || (readMethod = getReadMethod(obj)) == null) {
            return null;
        }
        try {
            return readMethod.invoke(this.bean, NULL_ARGUMENTS);
        } catch (IllegalAccessException | IllegalArgumentException | NullPointerException | InvocationTargetException e) {
            logWarn(e);
            return null;
        }
    }

    public Object getBean() {
        return this.bean;
    }

    public Method getReadMethod(Object obj) {
        return this.readMethods.get(obj);
    }

    public Class<?> getType(String str) {
        return this.types.get(str);
    }

    public Transformer getTypeTransformer(Class<?> cls) {
        return typeTransformers.get(cls);
    }

    public Method getWriteMethod(Object obj) {
        return this.writeMethods.get(obj);
    }

    public Iterator<String> keyIterator() {
        return this.readMethods.keySet().iterator();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Object> keySet() {
        return Collections.unmodifiableSet(this.readMethods.keySet());
    }

    public void logInfo(Exception exc) {
        System.out.println("INFO: Exception: " + exc);
    }

    public void logWarn(Exception exc) {
        System.out.println("WARN: Exception: " + exc);
        exc.printStackTrace();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (this.bean == null) {
            return null;
        }
        Object obj3 = get(obj);
        Method writeMethod = getWriteMethod(obj);
        if (writeMethod == null) {
            throw new IllegalArgumentException("The bean of type: " + this.bean.getClass().getName() + " has no property called: " + obj);
        }
        try {
            writeMethod.invoke(this.bean, createWriteMethodArguments(writeMethod, obj2));
            firePropertyChange(obj, obj3, get(obj));
            return obj3;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public void putAllWriteable(BeanMap beanMap) {
        for (String str : beanMap.readMethods.keySet()) {
            if (getWriteMethod((Object) str) != null) {
                put(str, beanMap.get(str));
            }
        }
    }

    public void reinitialise() {
        this.readMethods.clear();
        this.writeMethods.clear();
        this.types.clear();
        initialise();
    }

    public void setBean(Object obj) {
        this.bean = obj;
        reinitialise();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.readMethods.size();
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return "BeanMap<" + String.valueOf(this.bean) + ">";
    }

    public Iterator<Object> valueIterator() {
        final Iterator<String> itKeyIterator = keyIterator();
        return new Iterator<Object>() { // from class: org.apache.commons.beanutils.BeanMap.4
            @Override // java.util.Iterator
            public boolean hasNext() {
                return itKeyIterator.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                return BeanMap.this.get(itKeyIterator.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("remove() not supported for BeanMap");
            }
        };
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<Object> values() {
        ArrayList arrayList = new ArrayList(this.readMethods.size());
        Iterator<Object> itValueIterator = valueIterator();
        while (itValueIterator.hasNext()) {
            arrayList.add(itValueIterator.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Method getReadMethod(String str) {
        return this.readMethods.get(str);
    }

    public Method getWriteMethod(String str) {
        return this.writeMethods.get(str);
    }

    public BeanMap(Object obj) {
        this.bean = obj;
        initialise();
    }

    public void firePropertyChange(Object obj, Object obj2, Object obj3) {
    }
}
