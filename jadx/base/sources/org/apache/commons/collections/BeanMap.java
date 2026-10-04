package org.apache.commons.collections;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.collections.keyvalue.AbstractMapEntry;
import org.apache.commons.collections.list.UnmodifiableList;
import org.apache.commons.collections.set.UnmodifiableSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BeanMap extends AbstractMap implements Cloneable {
    public static final Object[] NULL_ARGUMENTS = new Object[0];
    public static HashMap defaultTransformers;
    private transient Object bean;
    private transient HashMap readMethods = new HashMap();
    private transient HashMap writeMethods = new HashMap();
    private transient HashMap types = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MyMapEntry extends AbstractMapEntry {
        private BeanMap owner;

        public MyMapEntry(BeanMap beanMap, Object obj, Object obj2) {
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

    static {
        HashMap map = new HashMap();
        defaultTransformers = map;
        map.put(Boolean.TYPE, new Transformer() { // from class: org.apache.commons.collections.BeanMap.1
            @Override // org.apache.commons.collections.Transformer
            public Object transform(Object obj) {
                return Boolean.valueOf(obj.toString());
            }
        });
        defaultTransformers.put(Character.TYPE, new Transformer() { // from class: org.apache.commons.collections.BeanMap.2
            @Override // org.apache.commons.collections.Transformer
            public Object transform(Object obj) {
                return new Character(obj.toString().charAt(0));
            }
        });
        defaultTransformers.put(Byte.TYPE, new Transformer() { // from class: org.apache.commons.collections.BeanMap.3
            @Override // org.apache.commons.collections.Transformer
            public Object transform(Object obj) {
                return Byte.valueOf(obj.toString());
            }
        });
        defaultTransformers.put(Short.TYPE, new Transformer() { // from class: org.apache.commons.collections.BeanMap.4
            @Override // org.apache.commons.collections.Transformer
            public Object transform(Object obj) {
                return Short.valueOf(obj.toString());
            }
        });
        defaultTransformers.put(Integer.TYPE, new Transformer() { // from class: org.apache.commons.collections.BeanMap.5
            @Override // org.apache.commons.collections.Transformer
            public Object transform(Object obj) {
                return Integer.valueOf(obj.toString());
            }
        });
        defaultTransformers.put(Long.TYPE, new Transformer() { // from class: org.apache.commons.collections.BeanMap.6
            @Override // org.apache.commons.collections.Transformer
            public Object transform(Object obj) {
                return Long.valueOf(obj.toString());
            }
        });
        defaultTransformers.put(Float.TYPE, new Transformer() { // from class: org.apache.commons.collections.BeanMap.7
            @Override // org.apache.commons.collections.Transformer
            public Object transform(Object obj) {
                return Float.valueOf(obj.toString());
            }
        });
        defaultTransformers.put(Double.TYPE, new Transformer() { // from class: org.apache.commons.collections.BeanMap.8
            @Override // org.apache.commons.collections.Transformer
            public Object transform(Object obj) {
                return Double.valueOf(obj.toString());
            }
        });
    }

    public BeanMap() {
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
                        Class propertyType = propertyDescriptor.getPropertyType();
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

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Class<?> cls;
        Object obj = this.bean;
        if (obj == null) {
            return;
        }
        try {
            cls = obj.getClass();
        } catch (Exception unused) {
            cls = null;
        }
        try {
            this.bean = cls.newInstance();
        } catch (Exception unused2) {
            StringBuffer stringBuffer = new StringBuffer("Could not create new instance of class: ");
            stringBuffer.append(cls);
            throw new UnsupportedOperationException(stringBuffer.toString());
        }
    }

    @Override // java.util.AbstractMap
    public Object clone() throws CloneNotSupportedException {
        Class<?> cls;
        BeanMap beanMap = (BeanMap) super.clone();
        Object obj = this.bean;
        if (obj == null) {
            return beanMap;
        }
        try {
            cls = obj.getClass();
        } catch (Exception e) {
            e = e;
            cls = null;
        }
        try {
            try {
                beanMap.setBean(cls.newInstance());
                try {
                    for (Object obj2 : this.readMethods.keySet()) {
                        if (getWriteMethod(obj2) != null) {
                            beanMap.put(obj2, get(obj2));
                        }
                    }
                    return beanMap;
                } catch (Exception e2) {
                    StringBuffer stringBuffer = new StringBuffer("Unable to copy bean values to cloned bean map: ");
                    stringBuffer.append(e2);
                    throw new CloneNotSupportedException(stringBuffer.toString());
                }
            } catch (Exception e3) {
                StringBuffer stringBuffer2 = new StringBuffer("Unable to set bean in the cloned bean map: ");
                stringBuffer2.append(e3);
                throw new CloneNotSupportedException(stringBuffer2.toString());
            }
        } catch (Exception e5) {
            e = e5;
            StringBuffer stringBuffer3 = new StringBuffer("Unable to instantiate the underlying bean \"");
            stringBuffer3.append(cls.getName());
            stringBuffer3.append("\": ");
            stringBuffer3.append(e);
            throw new CloneNotSupportedException(stringBuffer3.toString());
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

    public Object convertType(Class cls, Object obj) {
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
                logInfo(e);
                throw new IllegalArgumentException(e.getMessage());
            } catch (InvocationTargetException e2) {
                logInfo(e2);
                throw new IllegalArgumentException(e2.getMessage());
            }
        }
        return new Object[]{obj};
    }

    public Iterator entryIterator() {
        final Iterator itKeyIterator = keyIterator();
        return new Iterator() { // from class: org.apache.commons.collections.BeanMap.11
            @Override // java.util.Iterator
            public boolean hasNext() {
                return itKeyIterator.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                Object next = itKeyIterator.next();
                return new MyMapEntry(BeanMap.this, next, BeanMap.this.get(next));
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("remove() not supported for BeanMap");
            }
        };
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        return UnmodifiableSet.decorate(new AbstractSet() { // from class: org.apache.commons.collections.BeanMap.9
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
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
        } catch (IllegalAccessException e) {
            logWarn(e);
            return null;
        } catch (IllegalArgumentException e2) {
            logWarn(e2);
            return null;
        } catch (NullPointerException e3) {
            logWarn(e3);
            return null;
        } catch (InvocationTargetException e5) {
            logWarn(e5);
            return null;
        }
    }

    public Object getBean() {
        return this.bean;
    }

    public Method getReadMethod(String str) {
        return (Method) this.readMethods.get(str);
    }

    public Class getType(String str) {
        return (Class) this.types.get(str);
    }

    public Transformer getTypeTransformer(Class cls) {
        return (Transformer) defaultTransformers.get(cls);
    }

    public Method getWriteMethod(String str) {
        return (Method) this.writeMethods.get(str);
    }

    public Iterator keyIterator() {
        return this.readMethods.keySet().iterator();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        return UnmodifiableSet.decorate(this.readMethods.keySet());
    }

    public void logInfo(Exception exc) {
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer("INFO: Exception: ");
        stringBuffer.append(exc);
        printStream.println(stringBuffer.toString());
    }

    public void logWarn(Exception exc) {
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer("WARN: Exception: ");
        stringBuffer.append(exc);
        printStream.println(stringBuffer.toString());
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
            StringBuffer stringBuffer = new StringBuffer("The bean of type: ");
            stringBuffer.append(this.bean.getClass().getName());
            stringBuffer.append(" has no property called: ");
            stringBuffer.append(obj);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        try {
            writeMethod.invoke(this.bean, createWriteMethodArguments(writeMethod, obj2));
            firePropertyChange(obj, obj3, get(obj));
            return obj3;
        } catch (IllegalAccessException e) {
            logInfo(e);
            throw new IllegalArgumentException(e.getMessage());
        } catch (InvocationTargetException e2) {
            logInfo(e2);
            throw new IllegalArgumentException(e2.getMessage());
        }
    }

    public void putAllWriteable(BeanMap beanMap) {
        for (Object obj : beanMap.readMethods.keySet()) {
            if (getWriteMethod(obj) != null) {
                put(obj, beanMap.get(obj));
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
        StringBuffer stringBuffer = new StringBuffer("BeanMap<");
        stringBuffer.append(String.valueOf(this.bean));
        stringBuffer.append(">");
        return stringBuffer.toString();
    }

    public Iterator valueIterator() {
        final Iterator itKeyIterator = keyIterator();
        return new Iterator() { // from class: org.apache.commons.collections.BeanMap.10
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
    public Collection values() {
        ArrayList arrayList = new ArrayList(this.readMethods.size());
        Iterator itValueIterator = valueIterator();
        while (itValueIterator.hasNext()) {
            arrayList.add(itValueIterator.next());
        }
        return UnmodifiableList.decorate(arrayList);
    }

    public Method getReadMethod(Object obj) {
        return (Method) this.readMethods.get(obj);
    }

    public Method getWriteMethod(Object obj) {
        return (Method) this.writeMethods.get(obj);
    }

    public BeanMap(Object obj) {
        this.bean = obj;
        initialise();
    }

    public void firePropertyChange(Object obj, Object obj2, Object obj3) {
    }
}
