package org.apache.commons.beanutils;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.beans.IndexedPropertyDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.beanutils.expression.DefaultResolver;
import org.apache.commons.beanutils.expression.Resolver;
import org.apache.commons.collections.FastHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PropertyUtilsBean {
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    private final WeakFastHashMap<Class<?>, BeanIntrospectionData> descriptorsCache;
    private final List<BeanIntrospector> introspectors;
    private final WeakFastHashMap<Class<?>, FastHashMap> mappedDescriptorsCache;
    private Resolver resolver = new DefaultResolver();
    private final Log log = LogFactory.getLog((Class<?>) PropertyUtils.class);

    public PropertyUtilsBean() {
        WeakFastHashMap<Class<?>, BeanIntrospectionData> weakFastHashMap = new WeakFastHashMap<>();
        this.descriptorsCache = weakFastHashMap;
        weakFastHashMap.setFast(true);
        WeakFastHashMap<Class<?>, FastHashMap> weakFastHashMap2 = new WeakFastHashMap<>();
        this.mappedDescriptorsCache = weakFastHashMap2;
        weakFastHashMap2.setFast(true);
        this.introspectors = new CopyOnWriteArrayList();
        resetBeanIntrospectors();
    }

    private BeanIntrospectionData fetchIntrospectionData(Class<?> cls) {
        DefaultIntrospectionContext defaultIntrospectionContext = new DefaultIntrospectionContext(cls);
        Iterator<BeanIntrospector> it = this.introspectors.iterator();
        while (it.hasNext()) {
            try {
                it.next().introspect(defaultIntrospectionContext);
            } catch (IntrospectionException e) {
                this.log.error("Exception during introspection", e);
            }
        }
        return new BeanIntrospectionData(defaultIntrospectionContext.getPropertyDescriptors());
    }

    public static PropertyUtilsBean getInstance() {
        return BeanUtilsBean.getInstance().getPropertyUtils();
    }

    private BeanIntrospectionData getIntrospectionData(Class<?> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("No bean class specified");
        }
        BeanIntrospectionData beanIntrospectionData = this.descriptorsCache.get(cls);
        if (beanIntrospectionData != null) {
            return beanIntrospectionData;
        }
        BeanIntrospectionData beanIntrospectionDataFetchIntrospectionData = fetchIntrospectionData(cls);
        this.descriptorsCache.put(cls, beanIntrospectionDataFetchIntrospectionData);
        return beanIntrospectionDataFetchIntrospectionData;
    }

    private Object invokeMethod(Method method, Object obj, Object[] objArr) {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified - this should have been checked before reaching this method");
        }
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalArgumentException | NullPointerException e) {
            StringBuilder sb = new StringBuilder();
            if (objArr != null) {
                for (int i = 0; i < objArr.length; i++) {
                    if (i > 0) {
                        sb.append(SQLKeyword.COMMA);
                    }
                    Object obj2 = objArr[i];
                    if (obj2 == null) {
                        sb.append("<null>");
                    } else {
                        sb.append(obj2.getClass().getName());
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes != null) {
                for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                    if (i2 > 0) {
                        sb2.append(SQLKeyword.COMMA);
                    }
                    sb2.append(parameterTypes[i2].getName());
                }
            }
            StringBuilder sb3 = new StringBuilder("Cannot invoke ");
            sb3.append(method.getDeclaringClass().getName());
            sb3.append(Extension.DOT);
            sb3.append(method.getName());
            sb3.append(" on bean class '");
            sb3.append(obj.getClass());
            sb3.append("' - ");
            sb3.append(e.getMessage());
            sb3.append(" - had objects of type \"");
            sb.append("\" but expected signature \"");
            sb.append(sb2.toString());
            sb.append("\"");
            sb3.append(sb.toString());
            throw new IllegalArgumentException(sb3.toString(), e);
        }
    }

    private static List<Object> toObjectList(Object obj) {
        return (List) obj;
    }

    private static Map<String, Object> toPropertyMap(Object obj) {
        return (Map) obj;
    }

    public void addBeanIntrospector(BeanIntrospector beanIntrospector) {
        if (beanIntrospector == null) {
            throw new IllegalArgumentException("BeanIntrospector must not be null!");
        }
        this.introspectors.add(beanIntrospector);
    }

    public void clearDescriptors() {
        this.descriptorsCache.clear();
        this.mappedDescriptorsCache.clear();
        Introspector.flushCaches();
    }

    public void copyProperties(Object obj, Object obj2) {
        if (obj == null) {
            throw new IllegalArgumentException("No destination bean specified");
        }
        if (obj2 == null) {
            throw new IllegalArgumentException("No origin bean specified");
        }
        int i = 0;
        if (obj2 instanceof DynaBean) {
            DynaProperty[] dynaProperties = ((DynaBean) obj2).getDynaClass().getDynaProperties();
            int length = dynaProperties.length;
            while (i < length) {
                String name = dynaProperties[i].getName();
                if (isReadable(obj2, name) && isWriteable(obj, name)) {
                    try {
                        Object obj3 = ((DynaBean) obj2).get(name);
                        if (obj instanceof DynaBean) {
                            ((DynaBean) obj).set(name, obj3);
                        } else {
                            setSimpleProperty(obj, name, obj3);
                        }
                    } catch (NoSuchMethodException e) {
                        if (this.log.isDebugEnabled()) {
                            Log log = this.log;
                            StringBuilder sbM15l = AbstractC0000a.m15l("Error writing to '", name, "' on class '");
                            sbM15l.append(obj.getClass());
                            sbM15l.append("'");
                            log.debug(sbM15l.toString(), e);
                        }
                    }
                }
                i++;
            }
            return;
        }
        if (obj2 instanceof Map) {
            for (Map.Entry entry : ((Map) obj2).entrySet()) {
                String str = (String) entry.getKey();
                if (isWriteable(obj, str)) {
                    try {
                        if (obj instanceof DynaBean) {
                            ((DynaBean) obj).set(str, entry.getValue());
                        } else {
                            setSimpleProperty(obj, str, entry.getValue());
                        }
                    } catch (NoSuchMethodException e2) {
                        if (this.log.isDebugEnabled()) {
                            Log log2 = this.log;
                            StringBuilder sbM15l2 = AbstractC0000a.m15l("Error writing to '", str, "' on class '");
                            sbM15l2.append(obj.getClass());
                            sbM15l2.append("'");
                            log2.debug(sbM15l2.toString(), e2);
                        }
                    }
                }
            }
            return;
        }
        PropertyDescriptor[] propertyDescriptors = getPropertyDescriptors(obj2);
        int length2 = propertyDescriptors.length;
        while (i < length2) {
            String name2 = propertyDescriptors[i].getName();
            if (isReadable(obj2, name2) && isWriteable(obj, name2)) {
                try {
                    Object simpleProperty = getSimpleProperty(obj2, name2);
                    if (obj instanceof DynaBean) {
                        ((DynaBean) obj).set(name2, simpleProperty);
                    } else {
                        setSimpleProperty(obj, name2, simpleProperty);
                    }
                } catch (NoSuchMethodException e3) {
                    if (this.log.isDebugEnabled()) {
                        Log log3 = this.log;
                        StringBuilder sbM15l3 = AbstractC0000a.m15l("Error writing to '", name2, "' on class '");
                        sbM15l3.append(obj.getClass());
                        sbM15l3.append("'");
                        log3.debug(sbM15l3.toString(), e3);
                    }
                }
            }
            i++;
        }
    }

    public Map<String, Object> describe(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        HashMap map = new HashMap();
        int i = 0;
        if (obj instanceof DynaBean) {
            DynaProperty[] dynaProperties = ((DynaBean) obj).getDynaClass().getDynaProperties();
            int length = dynaProperties.length;
            while (i < length) {
                String name = dynaProperties[i].getName();
                map.put(name, getProperty(obj, name));
                i++;
            }
        } else {
            PropertyDescriptor[] propertyDescriptors = getPropertyDescriptors(obj);
            int length2 = propertyDescriptors.length;
            while (i < length2) {
                PropertyDescriptor propertyDescriptor = propertyDescriptors[i];
                String name2 = propertyDescriptor.getName();
                if (propertyDescriptor.getReadMethod() != null) {
                    map.put(name2, getProperty(obj, name2));
                }
                i++;
            }
        }
        return map;
    }

    public Object getIndexedProperty(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(new StringBuilder("No name specified for bean class '"), obj, "'"));
        }
        try {
            int index = this.resolver.getIndex(str);
            if (index >= 0) {
                return getIndexedProperty(obj, this.resolver.getProperty(str), index);
            }
            throw new IllegalArgumentException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Invalid indexed property '", str, "' on bean class '"), obj, "'"));
        } catch (IllegalArgumentException e) {
            StringBuilder sbM15l = AbstractC0000a.m15l("Invalid indexed property '", str, "' on bean class '");
            sbM15l.append(obj.getClass());
            sbM15l.append("' ");
            sbM15l.append(e.getMessage());
            throw new IllegalArgumentException(sbM15l.toString());
        }
    }

    public Object getMappedProperty(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(new StringBuilder("No name specified for bean class '"), obj, "'"));
        }
        try {
            String key = this.resolver.getKey(str);
            if (key != null) {
                return getMappedProperty(obj, this.resolver.getProperty(str), key);
            }
            throw new IllegalArgumentException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Invalid mapped property '", str, "' on bean class '"), obj, "'"));
        } catch (IllegalArgumentException e) {
            StringBuilder sbM15l = AbstractC0000a.m15l("Invalid mapped property '", str, "' on bean class '");
            sbM15l.append(obj.getClass());
            sbM15l.append("' ");
            sbM15l.append(e.getMessage());
            throw new IllegalArgumentException(sbM15l.toString());
        }
    }

    @Deprecated
    public FastHashMap getMappedPropertyDescriptors(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return this.mappedDescriptorsCache.get(cls);
    }

    public Object getNestedProperty(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(new StringBuilder("No name specified for bean class '"), obj, "'"));
        }
        while (this.resolver.hasNested(str)) {
            String next = this.resolver.next(str);
            Object propertyOfMapBean = obj instanceof Map ? getPropertyOfMapBean((Map) obj, next) : this.resolver.isMapped(next) ? getMappedProperty(obj, next) : this.resolver.isIndexed(next) ? getIndexedProperty(obj, next) : getSimpleProperty(obj, next);
            if (propertyOfMapBean == null) {
                throw new NestedNullException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Null property value for '", str, "' on bean class '"), obj, "'"));
            }
            str = this.resolver.remove(str);
            obj = propertyOfMapBean;
        }
        return obj instanceof Map ? getPropertyOfMapBean((Map) obj, str) : this.resolver.isMapped(str) ? getMappedProperty(obj, str) : this.resolver.isIndexed(str) ? getIndexedProperty(obj, str) : getSimpleProperty(obj, str);
    }

    public Object getProperty(Object obj, String str) {
        return getNestedProperty(obj, str);
    }

    public PropertyDescriptor getPropertyDescriptor(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(new StringBuilder("No name specified for bean class '"), obj, "'"));
        }
        while (this.resolver.hasNested(str)) {
            String next = this.resolver.next(str);
            Object property = getProperty(obj, next);
            if (property == null) {
                throw new NestedNullException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Null property value for '", next, "' on bean class '"), obj, "'"));
            }
            str = this.resolver.remove(str);
            obj = property;
        }
        String property2 = this.resolver.getProperty(str);
        if (property2 == null) {
            return null;
        }
        PropertyDescriptor descriptor = getIntrospectionData(obj.getClass()).getDescriptor(property2);
        if (descriptor != null) {
            return descriptor;
        }
        FastHashMap mappedPropertyDescriptors = getMappedPropertyDescriptors(obj);
        if (mappedPropertyDescriptors == null) {
            mappedPropertyDescriptors = new FastHashMap();
            mappedPropertyDescriptors.setFast(true);
            this.mappedDescriptorsCache.put(obj.getClass(), mappedPropertyDescriptors);
        }
        PropertyDescriptor mappedPropertyDescriptor = (PropertyDescriptor) mappedPropertyDescriptors.get(property2);
        if (mappedPropertyDescriptor == null) {
            try {
                mappedPropertyDescriptor = new MappedPropertyDescriptor(property2, obj.getClass());
            } catch (IntrospectionException unused) {
            }
            if (mappedPropertyDescriptor != null) {
                mappedPropertyDescriptors.put(property2, mappedPropertyDescriptor);
            }
        }
        return mappedPropertyDescriptor;
    }

    public PropertyDescriptor[] getPropertyDescriptors(Class<?> cls) {
        return getIntrospectionData(cls).getDescriptors();
    }

    public Class<?> getPropertyEditorClass(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(new StringBuilder("No name specified for bean class '"), obj, "'"));
        }
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
        if (propertyDescriptor != null) {
            return propertyDescriptor.getPropertyEditorClass();
        }
        return null;
    }

    public Object getPropertyOfMapBean(Map<?, ?> map, String str) {
        String property;
        if (this.resolver.isMapped(str) && ((property = this.resolver.getProperty(str)) == null || property.length() == 0)) {
            str = this.resolver.getKey(str);
        }
        if (this.resolver.isIndexed(str) || this.resolver.isMapped(str)) {
            throw new IllegalArgumentException(AbstractC0541b.m772n("Indexed or mapped properties are not supported on objects of type Map: ", str));
        }
        return map.get(str);
    }

    public Class<?> getPropertyType(Object obj, String str) {
        Class<?> type;
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(new StringBuilder("No name specified for bean class '"), obj, "'"));
        }
        while (this.resolver.hasNested(str)) {
            String next = this.resolver.next(str);
            Object property = getProperty(obj, next);
            if (property == null) {
                throw new NestedNullException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Null property value for '", next, "' on bean class '"), obj, "'"));
            }
            str = this.resolver.remove(str);
            obj = property;
        }
        String property2 = this.resolver.getProperty(str);
        if (!(obj instanceof DynaBean)) {
            IndexedPropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, property2);
            if (propertyDescriptor == null) {
                return null;
            }
            return propertyDescriptor instanceof IndexedPropertyDescriptor ? propertyDescriptor.getIndexedPropertyType() : propertyDescriptor instanceof MappedPropertyDescriptor ? ((MappedPropertyDescriptor) propertyDescriptor).getMappedPropertyType() : propertyDescriptor.getPropertyType();
        }
        DynaProperty dynaProperty = ((DynaBean) obj).getDynaClass().getDynaProperty(property2);
        if (dynaProperty == null || (type = dynaProperty.getType()) == null) {
            return null;
        }
        return type.isArray() ? type.getComponentType() : type;
    }

    public Method getReadMethod(Class<?> cls, PropertyDescriptor propertyDescriptor) {
        return MethodUtils.getAccessibleMethod(cls, propertyDescriptor.getReadMethod());
    }

    public Resolver getResolver() {
        return this.resolver;
    }

    public Object getSimpleProperty(Object obj, String str) throws NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(new StringBuilder("No name specified for bean class '"), obj, "'"));
        }
        if (this.resolver.hasNested(str)) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Nested property names are not allowed: Property '", str, "' on bean class '"), obj, "'"));
        }
        if (this.resolver.isIndexed(str)) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Indexed property names are not allowed: Property '", str, "' on bean class '"), obj, "'"));
        }
        if (this.resolver.isMapped(str)) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Mapped property names are not allowed: Property '", str, "' on bean class '"), obj, "'"));
        }
        if (obj instanceof DynaBean) {
            DynaBean dynaBean = (DynaBean) obj;
            if (dynaBean.getDynaClass().getDynaProperty(str) != null) {
                return dynaBean.get(str);
            }
            StringBuilder sbM15l = AbstractC0000a.m15l("Unknown property '", str, "' on dynaclass '");
            sbM15l.append(dynaBean.getDynaClass());
            sbM15l.append("'");
            throw new NoSuchMethodException(sbM15l.toString());
        }
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
        if (propertyDescriptor == null) {
            throw new NoSuchMethodException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Unknown property '", str, "' on class '"), obj, "'"));
        }
        Method readMethod = getReadMethod(obj.getClass(), propertyDescriptor);
        if (readMethod != null) {
            return invokeMethod(readMethod, obj, EMPTY_OBJECT_ARRAY);
        }
        throw new NoSuchMethodException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Property '", str, "' has no getter method in class '"), obj, "'"));
    }

    public Method getWriteMethod(Class<?> cls, PropertyDescriptor propertyDescriptor) {
        return MethodUtils.getAccessibleMethod(cls, getIntrospectionData(cls).getWriteMethod(cls, propertyDescriptor));
    }

    public boolean isReadable(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(new StringBuilder("No name specified for bean class '"), obj, "'"));
        }
        while (this.resolver.hasNested(str)) {
            String next = this.resolver.next(str);
            try {
                Object property = getProperty(obj, next);
                if (property == null) {
                    throw new NestedNullException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Null property value for '", next, "' on bean class '"), obj, "'"));
                }
                str = this.resolver.remove(str);
                obj = property;
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return false;
            }
        }
        String property2 = this.resolver.getProperty(str);
        if (obj instanceof WrapDynaBean) {
            obj = ((WrapDynaBean) obj).getInstance();
        }
        if (obj instanceof DynaBean) {
            return ((DynaBean) obj).getDynaClass().getDynaProperty(property2) != null;
        }
        try {
            IndexedPropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, property2);
            if (propertyDescriptor == null) {
                return false;
            }
            Method readMethod = getReadMethod(obj.getClass(), propertyDescriptor);
            if (readMethod == null) {
                if (propertyDescriptor instanceof IndexedPropertyDescriptor) {
                    readMethod = propertyDescriptor.getIndexedReadMethod();
                } else if (propertyDescriptor instanceof MappedPropertyDescriptor) {
                    readMethod = ((MappedPropertyDescriptor) propertyDescriptor).getMappedReadMethod();
                }
                readMethod = MethodUtils.getAccessibleMethod(obj.getClass(), readMethod);
            }
            if (readMethod != null) {
                return true;
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
        }
        return false;
    }

    public boolean isWriteable(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(new StringBuilder("No name specified for bean class '"), obj, "'"));
        }
        while (this.resolver.hasNested(str)) {
            String next = this.resolver.next(str);
            try {
                Object property = getProperty(obj, next);
                if (property == null) {
                    throw new NestedNullException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Null property value for '", next, "' on bean class '"), obj, "'"));
                }
                str = this.resolver.remove(str);
                obj = property;
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return false;
            }
        }
        String property2 = this.resolver.getProperty(str);
        if (obj instanceof WrapDynaBean) {
            obj = ((WrapDynaBean) obj).getInstance();
        }
        if (obj instanceof DynaBean) {
            return ((DynaBean) obj).getDynaClass().getDynaProperty(property2) != null;
        }
        try {
            IndexedPropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, property2);
            if (propertyDescriptor == null) {
                return false;
            }
            Method writeMethod = getWriteMethod(obj.getClass(), propertyDescriptor);
            if (writeMethod == null) {
                if (propertyDescriptor instanceof IndexedPropertyDescriptor) {
                    writeMethod = propertyDescriptor.getIndexedWriteMethod();
                } else if (propertyDescriptor instanceof MappedPropertyDescriptor) {
                    writeMethod = ((MappedPropertyDescriptor) propertyDescriptor).getMappedWriteMethod();
                }
                writeMethod = MethodUtils.getAccessibleMethod(obj.getClass(), writeMethod);
            }
            if (writeMethod != null) {
                return true;
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
        }
        return false;
    }

    public boolean removeBeanIntrospector(BeanIntrospector beanIntrospector) {
        return this.introspectors.remove(beanIntrospector);
    }

    public final void resetBeanIntrospectors() {
        this.introspectors.clear();
        this.introspectors.add(DefaultBeanIntrospector.INSTANCE);
        this.introspectors.add(SuppressPropertiesBeanIntrospector.SUPPRESS_CLASS);
        this.introspectors.add(SuppressPropertiesBeanIntrospector.SUPPRESS_DECLARING_CLASS);
    }

    public void setIndexedProperty(Object obj, String str, int i, Object obj2) throws NoSuchMethodException, InvocationTargetException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null || str.length() == 0) {
            if (obj.getClass().isArray()) {
                Array.set(obj, i, obj2);
                return;
            } else if (obj instanceof List) {
                toObjectList(obj).set(i, obj2);
                return;
            }
        }
        if (str == null) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(new StringBuilder("No name specified for bean class '"), obj, "'"));
        }
        if (obj instanceof DynaBean) {
            DynaBean dynaBean = (DynaBean) obj;
            if (dynaBean.getDynaClass().getDynaProperty(str) == null) {
                throw new NoSuchMethodException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Unknown property '", str, "' on bean class '"), obj, "'"));
            }
            dynaBean.set(str, i, obj2);
            return;
        }
        IndexedPropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
        if (propertyDescriptor == null) {
            throw new NoSuchMethodException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Unknown property '", str, "' on bean class '"), obj, "'"));
        }
        if (propertyDescriptor instanceof IndexedPropertyDescriptor) {
            Method accessibleMethod = MethodUtils.getAccessibleMethod(obj.getClass(), propertyDescriptor.getIndexedWriteMethod());
            if (accessibleMethod != null) {
                Object[] objArr = {Integer.valueOf(i), obj2};
                try {
                    if (this.log.isTraceEnabled()) {
                        String name = obj2 == null ? "<null>" : obj2.getClass().getName();
                        this.log.trace("setSimpleProperty: Invoking method " + accessibleMethod + " with index=" + i + ", value=" + obj2 + " (class " + name + ")");
                    }
                    invokeMethod(accessibleMethod, obj, objArr);
                    return;
                } catch (InvocationTargetException e) {
                    if (!(e.getTargetException() instanceof IndexOutOfBoundsException)) {
                        throw e;
                    }
                    throw ((IndexOutOfBoundsException) e.getTargetException());
                }
            }
        }
        Method readMethod = getReadMethod(obj.getClass(), propertyDescriptor);
        if (readMethod == null) {
            throw new NoSuchMethodException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Property '", str, "' has no getter method on bean class '"), obj, "'"));
        }
        Object objInvokeMethod = invokeMethod(readMethod, obj, EMPTY_OBJECT_ARRAY);
        if (objInvokeMethod.getClass().isArray()) {
            Array.set(objInvokeMethod, i, obj2);
        } else {
            if (!(objInvokeMethod instanceof List)) {
                throw new IllegalArgumentException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Property '", str, "' is not indexed on bean class '"), obj, "'"));
            }
            toObjectList(objInvokeMethod).set(i, obj2);
        }
    }

    public void setMappedProperty(Object obj, String str, Object obj2) throws NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(new StringBuilder("No name specified for bean class '"), obj, "'"));
        }
        try {
            String key = this.resolver.getKey(str);
            if (key == null) {
                throw new IllegalArgumentException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Invalid mapped property '", str, "' on bean class '"), obj, "'"));
            }
            setMappedProperty(obj, this.resolver.getProperty(str), key, obj2);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Invalid mapped property '", str, "' on bean class '"), obj, "'"));
        }
    }

    public void setNestedProperty(Object obj, String str, Object obj2) throws NoSuchMethodException, InvocationTargetException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(new StringBuilder("No name specified for bean class '"), obj, "'"));
        }
        while (this.resolver.hasNested(str)) {
            String next = this.resolver.next(str);
            Object propertyOfMapBean = obj instanceof Map ? getPropertyOfMapBean((Map) obj, next) : this.resolver.isMapped(next) ? getMappedProperty(obj, next) : this.resolver.isIndexed(next) ? getIndexedProperty(obj, next) : getSimpleProperty(obj, next);
            if (propertyOfMapBean == null) {
                throw new NestedNullException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Null property value for '", str, "' on bean class '"), obj, "'"));
            }
            str = this.resolver.remove(str);
            obj = propertyOfMapBean;
        }
        if (obj instanceof Map) {
            setPropertyOfMapBean(toPropertyMap(obj), str, obj2);
            return;
        }
        if (this.resolver.isMapped(str)) {
            setMappedProperty(obj, str, obj2);
        } else if (this.resolver.isIndexed(str)) {
            setIndexedProperty(obj, str, obj2);
        } else {
            setSimpleProperty(obj, str, obj2);
        }
    }

    public void setProperty(Object obj, String str, Object obj2) throws NoSuchMethodException, InvocationTargetException {
        setNestedProperty(obj, str, obj2);
    }

    public void setPropertyOfMapBean(Map<String, Object> map, String str, Object obj) {
        String property;
        if (this.resolver.isMapped(str) && ((property = this.resolver.getProperty(str)) == null || property.length() == 0)) {
            str = this.resolver.getKey(str);
        }
        if (this.resolver.isIndexed(str) || this.resolver.isMapped(str)) {
            throw new IllegalArgumentException(AbstractC0541b.m772n("Indexed or mapped properties are not supported on objects of type Map: ", str));
        }
        map.put(str, obj);
    }

    public void setResolver(Resolver resolver) {
        if (resolver == null) {
            this.resolver = new DefaultResolver();
        } else {
            this.resolver = resolver;
        }
    }

    public void setSimpleProperty(Object obj, String str, Object obj2) throws NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(new StringBuilder("No name specified for bean class '"), obj, "'"));
        }
        if (this.resolver.hasNested(str)) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Nested property names are not allowed: Property '", str, "' on bean class '"), obj, "'"));
        }
        if (this.resolver.isIndexed(str)) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Indexed property names are not allowed: Property '", str, "' on bean class '"), obj, "'"));
        }
        if (this.resolver.isMapped(str)) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Mapped property names are not allowed: Property '", str, "' on bean class '"), obj, "'"));
        }
        if (obj instanceof DynaBean) {
            DynaBean dynaBean = (DynaBean) obj;
            if (dynaBean.getDynaClass().getDynaProperty(str) != null) {
                dynaBean.set(str, obj2);
                return;
            }
            StringBuilder sbM15l = AbstractC0000a.m15l("Unknown property '", str, "' on dynaclass '");
            sbM15l.append(dynaBean.getDynaClass());
            sbM15l.append("'");
            throw new NoSuchMethodException(sbM15l.toString());
        }
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
        if (propertyDescriptor == null) {
            throw new NoSuchMethodException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Unknown property '", str, "' on class '"), obj, "'"));
        }
        Method writeMethod = getWriteMethod(obj.getClass(), propertyDescriptor);
        if (writeMethod == null) {
            throw new NoSuchMethodException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Property '", str, "' has no setter method in class '"), obj, "'"));
        }
        Object[] objArr = {obj2};
        if (this.log.isTraceEnabled()) {
            String name = obj2 == null ? "<null>" : obj2.getClass().getName();
            this.log.trace("setSimpleProperty: Invoking method " + writeMethod + " with value " + obj2 + " (class " + name + ")");
        }
        invokeMethod(writeMethod, obj, objArr);
    }

    @Deprecated
    public FastHashMap getMappedPropertyDescriptors(Object obj) {
        if (obj == null) {
            return null;
        }
        return getMappedPropertyDescriptors(obj.getClass());
    }

    public PropertyDescriptor[] getPropertyDescriptors(Object obj) {
        if (obj != null) {
            return getPropertyDescriptors(obj.getClass());
        }
        throw new IllegalArgumentException("No bean specified");
    }

    public Method getReadMethod(PropertyDescriptor propertyDescriptor) {
        return MethodUtils.getAccessibleMethod(propertyDescriptor.getReadMethod());
    }

    public Method getWriteMethod(PropertyDescriptor propertyDescriptor) {
        return MethodUtils.getAccessibleMethod(propertyDescriptor.getWriteMethod());
    }

    public Object getMappedProperty(Object obj, String str, String str2) throws NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(new StringBuilder("No name specified for bean class '"), obj, "'"));
        }
        if (str2 != null) {
            if (obj instanceof DynaBean) {
                DynaBean dynaBean = (DynaBean) obj;
                if (dynaBean.getDynaClass().getDynaProperty(str) != null) {
                    return dynaBean.get(str, str2);
                }
                throw new NoSuchMethodException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Unknown property '", str, "'+ on bean class '"), obj, "'"));
            }
            PropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
            if (propertyDescriptor != null) {
                if (propertyDescriptor instanceof MappedPropertyDescriptor) {
                    Method accessibleMethod = MethodUtils.getAccessibleMethod(obj.getClass(), ((MappedPropertyDescriptor) propertyDescriptor).getMappedReadMethod());
                    if (accessibleMethod != null) {
                        return invokeMethod(accessibleMethod, obj, new Object[]{str2});
                    }
                    throw new NoSuchMethodException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Property '", str, "' has no mapped getter method on bean class '"), obj, "'"));
                }
                Method readMethod = getReadMethod(obj.getClass(), propertyDescriptor);
                if (readMethod != null) {
                    Object objInvokeMethod = invokeMethod(readMethod, obj, EMPTY_OBJECT_ARRAY);
                    if (objInvokeMethod instanceof Map) {
                        return ((Map) objInvokeMethod).get(str2);
                    }
                    return null;
                }
                throw new NoSuchMethodException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Property '", str, "' has no mapped getter method on bean class '"), obj, "'"));
            }
            throw new NoSuchMethodException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Unknown property '", str, "'+ on bean class '"), obj, "'"));
        }
        throw new IllegalArgumentException(AbstractC2821a.m2222m(AbstractC0000a.m15l("No key specified for property '", str, "' on bean class "), obj, "'"));
    }

    public Object getIndexedProperty(Object obj, String str, int i) throws NoSuchMethodException, InvocationTargetException {
        if (obj != null) {
            if (str == null || str.length() == 0) {
                if (obj.getClass().isArray()) {
                    return Array.get(obj, i);
                }
                if (obj instanceof List) {
                    return ((List) obj).get(i);
                }
            }
            if (str != null) {
                if (obj instanceof DynaBean) {
                    DynaBean dynaBean = (DynaBean) obj;
                    if (dynaBean.getDynaClass().getDynaProperty(str) != null) {
                        return dynaBean.get(str, i);
                    }
                    throw new NoSuchMethodException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Unknown property '", str, "' on bean class '"), obj, "'"));
                }
                IndexedPropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
                if (propertyDescriptor != null) {
                    if (propertyDescriptor instanceof IndexedPropertyDescriptor) {
                        Method accessibleMethod = MethodUtils.getAccessibleMethod(obj.getClass(), propertyDescriptor.getIndexedReadMethod());
                        if (accessibleMethod != null) {
                            try {
                                return invokeMethod(accessibleMethod, obj, new Object[]{Integer.valueOf(i)});
                            } catch (InvocationTargetException e) {
                                if (e.getTargetException() instanceof IndexOutOfBoundsException) {
                                    throw ((IndexOutOfBoundsException) e.getTargetException());
                                }
                                throw e;
                            }
                        }
                    }
                    Method readMethod = getReadMethod(obj.getClass(), propertyDescriptor);
                    if (readMethod != null) {
                        Object objInvokeMethod = invokeMethod(readMethod, obj, EMPTY_OBJECT_ARRAY);
                        if (!objInvokeMethod.getClass().isArray()) {
                            if (objInvokeMethod instanceof List) {
                                return ((List) objInvokeMethod).get(i);
                            }
                            throw new IllegalArgumentException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Property '", str, "' is not indexed on bean class '"), obj, "'"));
                        }
                        try {
                            return Array.get(objInvokeMethod, i);
                        } catch (ArrayIndexOutOfBoundsException unused) {
                            StringBuilder sbM778t = AbstractC0541b.m778t(i, "Index: ", ", Size: ");
                            sbM778t.append(Array.getLength(objInvokeMethod));
                            sbM778t.append(" for property '");
                            sbM778t.append(str);
                            sbM778t.append("'");
                            throw new ArrayIndexOutOfBoundsException(sbM778t.toString());
                        }
                    }
                    throw new NoSuchMethodException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Property '", str, "' has no getter method on bean class '"), obj, "'"));
                }
                throw new NoSuchMethodException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Unknown property '", str, "' on bean class '"), obj, "'"));
            }
            throw new IllegalArgumentException(AbstractC2821a.m2222m(new StringBuilder("No name specified for bean class '"), obj, "'"));
        }
        throw new IllegalArgumentException("No bean specified");
    }

    public void setMappedProperty(Object obj, String str, String str2, Object obj2) throws NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException(AbstractC2821a.m2222m(new StringBuilder("No name specified for bean class '"), obj, "'"));
        }
        if (str2 != null) {
            if (obj instanceof DynaBean) {
                DynaBean dynaBean = (DynaBean) obj;
                if (dynaBean.getDynaClass().getDynaProperty(str) != null) {
                    dynaBean.set(str, str2, obj2);
                    return;
                }
                throw new NoSuchMethodException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Unknown property '", str, "' on bean class '"), obj, "'"));
            }
            PropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
            if (propertyDescriptor != null) {
                if (propertyDescriptor instanceof MappedPropertyDescriptor) {
                    Method accessibleMethod = MethodUtils.getAccessibleMethod(obj.getClass(), ((MappedPropertyDescriptor) propertyDescriptor).getMappedWriteMethod());
                    if (accessibleMethod != null) {
                        Object[] objArr = {str2, obj2};
                        if (this.log.isTraceEnabled()) {
                            String name = obj2 == null ? "<null>" : obj2.getClass().getName();
                            this.log.trace("setSimpleProperty: Invoking method " + accessibleMethod + " with key=" + str2 + ", value=" + obj2 + " (class " + name + ")");
                        }
                        invokeMethod(accessibleMethod, obj, objArr);
                        return;
                    }
                    throw new NoSuchMethodException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Property '", str, "' has no mapped setter methodon bean class '"), obj, "'"));
                }
                Method readMethod = getReadMethod(obj.getClass(), propertyDescriptor);
                if (readMethod != null) {
                    Object objInvokeMethod = invokeMethod(readMethod, obj, EMPTY_OBJECT_ARRAY);
                    if (objInvokeMethod instanceof Map) {
                        toPropertyMap(objInvokeMethod).put(str2, obj2);
                        return;
                    }
                    return;
                }
                throw new NoSuchMethodException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Property '", str, "' has no mapped getter method on bean class '"), obj, "'"));
            }
            throw new NoSuchMethodException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Unknown property '", str, "' on bean class '"), obj, "'"));
        }
        throw new IllegalArgumentException(AbstractC2821a.m2222m(AbstractC0000a.m15l("No key specified for property '", str, "' on bean class '"), obj, "'"));
    }

    public void setIndexedProperty(Object obj, String str, Object obj2) throws NoSuchMethodException, InvocationTargetException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str != null) {
            try {
                int index = this.resolver.getIndex(str);
                if (index >= 0) {
                    setIndexedProperty(obj, this.resolver.getProperty(str), index, obj2);
                    return;
                }
                throw new IllegalArgumentException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Invalid indexed property '", str, "' on bean class '"), obj, "'"));
            } catch (IllegalArgumentException unused) {
                throw new IllegalArgumentException(AbstractC2821a.m2222m(AbstractC0000a.m15l("Invalid indexed property '", str, "' on bean class '"), obj, "'"));
            }
        }
        throw new IllegalArgumentException(AbstractC2821a.m2222m(new StringBuilder("No name specified for bean class '"), obj, "'"));
    }
}
