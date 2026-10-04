package org.apache.commons.beanutils;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.vladsch.flexmark.util.html.Attribute;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.expression.Resolver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BeanUtilsBean {
    private static final ContextClassLoaderLocal<BeanUtilsBean> BEANS_BY_CLASSLOADER = new ContextClassLoaderLocal<BeanUtilsBean>() { // from class: org.apache.commons.beanutils.BeanUtilsBean.1
        @Override // org.apache.commons.beanutils.ContextClassLoaderLocal
        public BeanUtilsBean initialValue() {
            return new BeanUtilsBean();
        }
    };
    private final ConvertUtilsBean convertUtilsBean;
    private final Log log;
    private final PropertyUtilsBean propertyUtilsBean;

    public BeanUtilsBean() {
        this(new ConvertUtilsBean(), new PropertyUtilsBean());
    }

    private Object convertForCopy(Object obj, Class<?> cls) {
        return obj != null ? convert(obj, cls) : obj;
    }

    private static Class<?> dynaPropertyType(DynaProperty dynaProperty, Object obj) {
        return !dynaProperty.isMapped() ? dynaProperty.getType() : obj == null ? String.class : obj.getClass();
    }

    public static BeanUtilsBean getInstance() {
        return BEANS_BY_CLASSLOADER.get();
    }

    public static void setInstance(BeanUtilsBean beanUtilsBean) {
        BEANS_BY_CLASSLOADER.set(beanUtilsBean);
    }

    public Object cloneBean(Object obj) {
        if (this.log.isDebugEnabled()) {
            this.log.debug("Cloning bean: ".concat(obj.getClass().getName()));
        }
        Object objNewInstance = obj instanceof DynaBean ? ((DynaBean) obj).getDynaClass().newInstance() : obj.getClass().getConstructor(null).newInstance(null);
        getPropertyUtils().copyProperties(objNewInstance, obj);
        return objNewInstance;
    }

    public Object convert(Object obj, Class<?> cls) {
        Converter converterLookup = getConvertUtils().lookup(cls);
        if (converterLookup == null) {
            return obj;
        }
        this.log.trace("        USING CONVERTER " + converterLookup);
        return converterLookup.convert(cls, obj);
    }

    public void copyProperties(Object obj, Object obj2) throws InvocationTargetException {
        if (obj == null) {
            throw new IllegalArgumentException("No destination bean specified");
        }
        if (obj2 == null) {
            throw new IllegalArgumentException("No origin bean specified");
        }
        if (this.log.isDebugEnabled()) {
            this.log.debug("BeanUtils.copyProperties(" + obj + SQLKeyword.COMMA + obj2 + ")");
        }
        int i = 0;
        if (obj2 instanceof DynaBean) {
            DynaBean dynaBean = (DynaBean) obj2;
            DynaProperty[] dynaProperties = dynaBean.getDynaClass().getDynaProperties();
            int length = dynaProperties.length;
            while (i < length) {
                String name = dynaProperties[i].getName();
                if (getPropertyUtils().isReadable(obj2, name) && getPropertyUtils().isWriteable(obj, name)) {
                    copyProperty(obj, name, dynaBean.get(name));
                }
                i++;
            }
            return;
        }
        if (obj2 instanceof Map) {
            for (Map.Entry entry : ((Map) obj2).entrySet()) {
                String str = (String) entry.getKey();
                if (getPropertyUtils().isWriteable(obj, str)) {
                    copyProperty(obj, str, entry.getValue());
                }
            }
            return;
        }
        PropertyDescriptor[] propertyDescriptors = getPropertyUtils().getPropertyDescriptors(obj2);
        int length2 = propertyDescriptors.length;
        while (i < length2) {
            String name2 = propertyDescriptors[i].getName();
            if (!Attribute.CLASS_ATTR.equals(name2) && getPropertyUtils().isReadable(obj2, name2) && getPropertyUtils().isWriteable(obj, name2)) {
                try {
                    copyProperty(obj, name2, getPropertyUtils().getSimpleProperty(obj2, name2));
                } catch (NoSuchMethodException unused) {
                }
            }
            i++;
        }
    }

    public void copyProperty(Object obj, String str, Object obj2) throws InvocationTargetException {
        Class<?> propertyType;
        if (this.log.isTraceEnabled()) {
            StringBuilder sb = new StringBuilder("  copyProperty(");
            sb.append(obj);
            sb.append(SQLKeyword.COMMA);
            sb.append(str);
            sb.append(SQLKeyword.COMMA);
            if (obj2 == null) {
                sb.append("<NULL>");
            } else if (obj2 instanceof String) {
                sb.append((String) obj2);
            } else if (obj2 instanceof String[]) {
                String[] strArr = (String[]) obj2;
                sb.append(PropertyUtils.INDEXED_DELIM);
                for (int i = 0; i < strArr.length; i++) {
                    if (i > 0) {
                        sb.append(',');
                    }
                    sb.append(strArr[i]);
                }
                sb.append(PropertyUtils.INDEXED_DELIM2);
            } else {
                sb.append(obj2.toString());
            }
            sb.append(PropertyUtils.MAPPED_DELIM2);
            this.log.trace(sb.toString());
        }
        Resolver resolver = getPropertyUtils().getResolver();
        while (resolver.hasNested(str)) {
            try {
                obj = getPropertyUtils().getProperty(obj, resolver.next(str));
                str = resolver.remove(str);
            } catch (NoSuchMethodException unused) {
                return;
            }
        }
        if (this.log.isTraceEnabled()) {
            this.log.trace("    Target bean = " + obj);
            this.log.trace("    Target name = " + str);
        }
        String property = resolver.getProperty(str);
        int index = resolver.getIndex(str);
        String key = resolver.getKey(str);
        if (obj instanceof DynaBean) {
            DynaProperty dynaProperty = ((DynaBean) obj).getDynaClass().getDynaProperty(property);
            if (dynaProperty == null) {
                return;
            } else {
                propertyType = dynaPropertyType(dynaProperty, obj2);
            }
        } else {
            PropertyDescriptor propertyDescriptor = getPropertyUtils().getPropertyDescriptor(obj, str);
            if (propertyDescriptor == null) {
                return;
            }
            propertyType = propertyDescriptor.getPropertyType();
            if (propertyType == null) {
                if (this.log.isTraceEnabled()) {
                    this.log.trace("    target type for property '" + property + "' is null, so skipping the setter");
                    return;
                }
                return;
            }
        }
        if (this.log.isTraceEnabled()) {
            this.log.trace("    target propName=" + property + ", type=" + propertyType + ", index=" + index + ", key=" + key);
        }
        if (index >= 0) {
            try {
                getPropertyUtils().setIndexedProperty(obj, property, index, convertForCopy(obj2, propertyType.getComponentType()));
                return;
            } catch (NoSuchMethodException e) {
                throw new InvocationTargetException(e, AbstractC0541b.m772n("Cannot set ", property));
            }
        }
        if (key != null) {
            try {
                getPropertyUtils().setMappedProperty(obj, property, key, obj2);
            } catch (NoSuchMethodException e2) {
                throw new InvocationTargetException(e2, AbstractC0541b.m772n("Cannot set ", property));
            }
        } else {
            try {
                getPropertyUtils().setSimpleProperty(obj, property, convertForCopy(obj2, propertyType));
            } catch (NoSuchMethodException e3) {
                throw new InvocationTargetException(e3, AbstractC0541b.m772n("Cannot set ", property));
            }
        }
    }

    public Map<String, String> describe(Object obj) {
        if (obj == null) {
            return new HashMap();
        }
        if (this.log.isDebugEnabled()) {
            this.log.debug("Describing bean: ".concat(obj.getClass().getName()));
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
            PropertyDescriptor[] propertyDescriptors = getPropertyUtils().getPropertyDescriptors(obj);
            Class<?> cls = obj.getClass();
            int length2 = propertyDescriptors.length;
            while (i < length2) {
                PropertyDescriptor propertyDescriptor = propertyDescriptors[i];
                String name2 = propertyDescriptor.getName();
                if (getPropertyUtils().getReadMethod(cls, propertyDescriptor) != null) {
                    map.put(name2, getProperty(obj, name2));
                }
                i++;
            }
        }
        return map;
    }

    public String[] getArrayProperty(Object obj, String str) {
        Object property = getPropertyUtils().getProperty(obj, str);
        if (property == null) {
            return null;
        }
        if (property instanceof Collection) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : (Collection) property) {
                if (obj2 == null) {
                    arrayList.add(null);
                } else {
                    arrayList.add(getConvertUtils().convert(obj2));
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        if (!property.getClass().isArray()) {
            return new String[]{getConvertUtils().convert(property)};
        }
        int length = Array.getLength(property);
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            Object obj3 = Array.get(property, i);
            if (obj3 == null) {
                strArr[i] = null;
            } else {
                strArr[i] = getConvertUtils().convert(obj3);
            }
        }
        return strArr;
    }

    public ConvertUtilsBean getConvertUtils() {
        return this.convertUtilsBean;
    }

    public String getIndexedProperty(Object obj, String str) {
        return getConvertUtils().convert(getPropertyUtils().getIndexedProperty(obj, str));
    }

    public String getMappedProperty(Object obj, String str) {
        return getConvertUtils().convert(getPropertyUtils().getMappedProperty(obj, str));
    }

    public String getNestedProperty(Object obj, String str) {
        return getConvertUtils().convert(getPropertyUtils().getNestedProperty(obj, str));
    }

    public String getProperty(Object obj, String str) {
        return getNestedProperty(obj, str);
    }

    public PropertyUtilsBean getPropertyUtils() {
        return this.propertyUtilsBean;
    }

    public String getSimpleProperty(Object obj, String str) throws NoSuchMethodException {
        return getConvertUtils().convert(getPropertyUtils().getSimpleProperty(obj, str));
    }

    @Deprecated
    public boolean initCause(Throwable th, Throwable th2) {
        th.initCause(th2);
        return true;
    }

    public void populate(Object obj, Map<String, ? extends Object> map) throws InvocationTargetException {
        if (obj == null || map == null) {
            return;
        }
        if (this.log.isDebugEnabled()) {
            this.log.debug("BeanUtils.populate(" + obj + SQLKeyword.COMMA + map + ")");
        }
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                setProperty(obj, key, entry.getValue());
            }
        }
    }

    public void setProperty(Object obj, String str, Object obj2) throws InvocationTargetException {
        if (this.log.isTraceEnabled()) {
            StringBuilder sb = new StringBuilder("  setProperty(");
            sb.append(obj);
            sb.append(SQLKeyword.COMMA);
            sb.append(str);
            sb.append(SQLKeyword.COMMA);
            if (obj2 == null) {
                sb.append("<NULL>");
            } else if (obj2 instanceof String) {
                sb.append((String) obj2);
            } else if (obj2 instanceof String[]) {
                String[] strArr = (String[]) obj2;
                sb.append(PropertyUtils.INDEXED_DELIM);
                for (int i = 0; i < strArr.length; i++) {
                    if (i > 0) {
                        sb.append(',');
                    }
                    sb.append(strArr[i]);
                }
                sb.append(PropertyUtils.INDEXED_DELIM2);
            } else {
                sb.append(obj2.toString());
            }
            sb.append(PropertyUtils.MAPPED_DELIM2);
            this.log.trace(sb.toString());
        }
        Resolver resolver = getPropertyUtils().getResolver();
        while (resolver.hasNested(str)) {
            try {
                obj = getPropertyUtils().getProperty(obj, resolver.next(str));
                if (obj == null) {
                    return;
                } else {
                    str = resolver.remove(str);
                }
            } catch (NoSuchMethodException unused) {
                return;
            }
        }
        if (this.log.isTraceEnabled()) {
            this.log.trace("    Target bean = " + obj);
            this.log.trace("    Target name = " + str);
        }
        String property = resolver.getProperty(str);
        int index = resolver.getIndex(str);
        String key = resolver.getKey(str);
        Class<?> propertyType = Object.class;
        if (obj instanceof DynaBean) {
            DynaProperty dynaProperty = ((DynaBean) obj).getDynaClass().getDynaProperty(property);
            if (dynaProperty == null) {
                return;
            }
            Class<?> clsDynaPropertyType = dynaPropertyType(dynaProperty, obj2);
            if (index < 0 || !List.class.isAssignableFrom(clsDynaPropertyType)) {
                propertyType = clsDynaPropertyType;
            }
        } else if (!(obj instanceof Map)) {
            if (obj == null || !obj.getClass().isArray() || index < 0) {
                IndexedPropertyDescriptor propertyDescriptor = getPropertyUtils().getPropertyDescriptor(obj, str);
                if (propertyDescriptor == null) {
                    return;
                }
                if (propertyDescriptor instanceof MappedPropertyDescriptor) {
                    MappedPropertyDescriptor mappedPropertyDescriptor = (MappedPropertyDescriptor) propertyDescriptor;
                    if (mappedPropertyDescriptor.getMappedWriteMethod() == null) {
                        if (this.log.isDebugEnabled()) {
                            this.log.debug("Skipping read-only property");
                            return;
                        }
                        return;
                    }
                    propertyType = mappedPropertyDescriptor.getMappedPropertyType();
                } else if (index >= 0 && (propertyDescriptor instanceof IndexedPropertyDescriptor)) {
                    IndexedPropertyDescriptor indexedPropertyDescriptor = propertyDescriptor;
                    if (indexedPropertyDescriptor.getIndexedWriteMethod() == null) {
                        if (this.log.isDebugEnabled()) {
                            this.log.debug("Skipping read-only property");
                            return;
                        }
                        return;
                    }
                    propertyType = indexedPropertyDescriptor.getIndexedPropertyType();
                } else if (index < 0 || !List.class.isAssignableFrom(propertyDescriptor.getPropertyType())) {
                    if (key == null) {
                        if (propertyDescriptor.getWriteMethod() == null) {
                            if (this.log.isDebugEnabled()) {
                                this.log.debug("Skipping read-only property");
                                return;
                            }
                            return;
                        }
                        propertyType = propertyDescriptor.getPropertyType();
                    } else if (propertyDescriptor.getReadMethod() == null) {
                        if (this.log.isDebugEnabled()) {
                            this.log.debug("Skipping read-only property");
                            return;
                        }
                        return;
                    } else if (obj2 != null) {
                        propertyType = obj2.getClass();
                    }
                }
            } else {
                propertyType = Array.get(obj, index).getClass();
            }
        }
        try {
            getPropertyUtils().setProperty(obj, str, (!propertyType.isArray() || index >= 0) ? propertyType.isArray() ? ((obj2 instanceof String) || obj2 == null) ? getConvertUtils().convert((String) obj2, propertyType.getComponentType()) : obj2 instanceof String[] ? getConvertUtils().convert(((String[]) obj2)[0], propertyType.getComponentType()) : convert(obj2, propertyType.getComponentType()) : obj2 instanceof String ? getConvertUtils().convert((String) obj2, propertyType) : obj2 instanceof String[] ? getConvertUtils().convert(((String[]) obj2)[0], propertyType) : convert(obj2, propertyType) : obj2 == null ? getConvertUtils().convert(new String[]{null}, propertyType) : obj2 instanceof String ? getConvertUtils().convert(obj2, propertyType) : obj2 instanceof String[] ? getConvertUtils().convert((String[]) obj2, propertyType) : convert(obj2, propertyType));
        } catch (NoSuchMethodException e) {
            throw new InvocationTargetException(e, AbstractC0541b.m772n("Cannot set ", property));
        }
    }

    public BeanUtilsBean(ConvertUtilsBean convertUtilsBean) {
        this(convertUtilsBean, new PropertyUtilsBean());
    }

    public BeanUtilsBean(ConvertUtilsBean convertUtilsBean, PropertyUtilsBean propertyUtilsBean) {
        this.log = LogFactory.getLog((Class<?>) BeanUtils.class);
        this.convertUtilsBean = convertUtilsBean;
        this.propertyUtilsBean = propertyUtilsBean;
    }

    public String getIndexedProperty(Object obj, String str, int i) throws NoSuchMethodException, InvocationTargetException {
        return getConvertUtils().convert(getPropertyUtils().getIndexedProperty(obj, str, i));
    }

    public String getMappedProperty(Object obj, String str, String str2) throws NoSuchMethodException {
        return getConvertUtils().convert(getPropertyUtils().getMappedProperty(obj, str, str2));
    }
}
