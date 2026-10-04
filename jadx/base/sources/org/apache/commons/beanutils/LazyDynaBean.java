package org.apache.commons.beanutils;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LazyDynaBean implements DynaBean, Serializable {
    private static final long serialVersionUID = 1;
    protected MutableDynaClass dynaClass;
    private transient Log logger;
    private transient Map<String, Object> mapDecorator;
    protected Map<String, Object> values;
    protected static final BigInteger BigInteger_ZERO = new BigInteger("0");
    protected static final BigDecimal BigDecimal_ZERO = new BigDecimal("0");
    protected static final Character Character_SPACE = ' ';
    protected static final Byte Byte_ZERO = (byte) 0;
    protected static final Short Short_ZERO = 0;
    protected static final Integer Integer_ZERO = 0;
    protected static final Long Long_ZERO = 0L;
    protected static final Float Float_ZERO = Float.valueOf(0.0f);
    protected static final Double Double_ZERO = Double.valueOf(0.0d);

    public LazyDynaBean() {
        this(new LazyDynaClass());
    }

    private Log logger() {
        if (this.logger == null) {
            this.logger = LogFactory.getLog((Class<?>) LazyDynaBean.class);
        }
        return this.logger;
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public boolean contains(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("No property name specified");
        }
        Object obj = this.values.get(str);
        if (obj != null && (obj instanceof Map)) {
            return ((Map) obj).containsKey(str2);
        }
        return false;
    }

    public Object createDynaBeanProperty(String str, Class<?> cls) {
        try {
            return cls.getConstructor(null).newInstance(null);
        } catch (Exception e) {
            if (logger().isWarnEnabled()) {
                logger().warn("Error instantiating DynaBean property of type '" + cls.getName() + "' for '" + str + "' " + e);
            }
            return null;
        }
    }

    public Object createIndexedProperty(String str, Class<?> cls) {
        if (cls == null) {
            return defaultIndexedProperty(str);
        }
        if (cls.isArray()) {
            return Array.newInstance(cls.getComponentType(), 0);
        }
        if (!List.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Non-indexed property of type '" + cls.getName() + "' for '" + str + "'");
        }
        if (cls.isInterface()) {
            return defaultIndexedProperty(str);
        }
        try {
            return cls.getConstructor(null).newInstance(null);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error instantiating indexed property of type '" + cls.getName() + "' for '" + str + "' " + e);
        }
    }

    public Object createMappedProperty(String str, Class<?> cls) {
        if (cls == null || cls.isInterface()) {
            return defaultMappedProperty(str);
        }
        if (!Map.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Non-mapped property of type '" + cls.getName() + "' for '" + str + "'");
        }
        try {
            return cls.getConstructor(null).newInstance(null);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error instantiating mapped property of type '" + cls.getName() + "' for '" + str + "' " + e);
        }
    }

    public Object createNumberProperty(String str, Class<?> cls) {
        return null;
    }

    public Object createOtherProperty(String str, Class<?> cls) {
        if (cls != Object.class && cls != String.class && cls != Boolean.class && cls != Character.class && !Date.class.isAssignableFrom(cls)) {
            try {
                return cls.getConstructor(null).newInstance(null);
            } catch (Exception e) {
                if (logger().isWarnEnabled()) {
                    logger().warn("Error instantiating property of type '" + cls.getName() + "' for '" + str + "' " + e);
                }
            }
        }
        return null;
    }

    public Object createPrimitiveProperty(String str, Class<?> cls) {
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (cls == Integer.TYPE) {
            return Integer_ZERO;
        }
        if (cls == Long.TYPE) {
            return Long_ZERO;
        }
        if (cls == Double.TYPE) {
            return Double_ZERO;
        }
        if (cls == Float.TYPE) {
            return Float_ZERO;
        }
        if (cls == Byte.TYPE) {
            return Byte_ZERO;
        }
        if (cls == Short.TYPE) {
            return Short_ZERO;
        }
        if (cls == Character.TYPE) {
            return Character_SPACE;
        }
        return null;
    }

    public Object createProperty(String str, Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return (cls.isArray() || List.class.isAssignableFrom(cls)) ? createIndexedProperty(str, cls) : Map.class.isAssignableFrom(cls) ? createMappedProperty(str, cls) : DynaBean.class.isAssignableFrom(cls) ? createDynaBeanProperty(str, cls) : cls.isPrimitive() ? createPrimitiveProperty(str, cls) : Number.class.isAssignableFrom(cls) ? createNumberProperty(str, cls) : createOtherProperty(str, cls);
    }

    public Object defaultIndexedProperty(String str) {
        return new ArrayList();
    }

    public Map<String, Object> defaultMappedProperty(String str) {
        return new HashMap();
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public Object get(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No property name specified");
        }
        Object obj = this.values.get(str);
        if (obj != null) {
            return obj;
        }
        if (!isDynaProperty(str)) {
            return null;
        }
        Object objCreateProperty = createProperty(str, this.dynaClass.getDynaProperty(str).getType());
        if (objCreateProperty != null) {
            set(str, objCreateProperty);
        }
        return objCreateProperty;
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public DynaClass getDynaClass() {
        return this.dynaClass;
    }

    public Map<String, Object> getMap() {
        if (this.mapDecorator == null) {
            this.mapDecorator = new DynaBeanPropertyMapDecorator(this);
        }
        return this.mapDecorator;
    }

    public Object growIndexedProperty(String str, Object obj, int i) {
        int length;
        Object objCreateProperty;
        if (obj instanceof List) {
            List list = (List) obj;
            while (i >= list.size()) {
                Class<?> contentType = getDynaClass().getDynaProperty(str).getContentType();
                if (contentType != null) {
                    StringBuilder sbM781w = AbstractC0541b.m781w(str, "[");
                    sbM781w.append(list.size());
                    sbM781w.append("]");
                    objCreateProperty = createProperty(sbM781w.toString(), contentType);
                } else {
                    objCreateProperty = null;
                }
                list.add(objCreateProperty);
            }
        }
        if (!obj.getClass().isArray() || i < (length = Array.getLength(obj))) {
            return obj;
        }
        Class<?> componentType = obj.getClass().getComponentType();
        Object objNewInstance = Array.newInstance(componentType, i + 1);
        System.arraycopy(obj, 0, objNewInstance, 0, length);
        set(str, objNewInstance);
        int length2 = Array.getLength(objNewInstance);
        while (length < length2) {
            Array.set(objNewInstance, length, createProperty(str + "[" + length + "]", componentType));
            length++;
        }
        return objNewInstance;
    }

    public boolean isAssignable(Class<?> cls, Class<?> cls2) {
        if (cls.isAssignableFrom(cls2)) {
            return true;
        }
        if (cls == Boolean.TYPE && cls2 == Boolean.class) {
            return true;
        }
        if (cls == Byte.TYPE && cls2 == Byte.class) {
            return true;
        }
        if (cls == Character.TYPE && cls2 == Character.class) {
            return true;
        }
        if (cls == Double.TYPE && cls2 == Double.class) {
            return true;
        }
        if (cls == Float.TYPE && cls2 == Float.class) {
            return true;
        }
        if (cls == Integer.TYPE && cls2 == Integer.class) {
            return true;
        }
        if (cls == Long.TYPE && cls2 == Long.class) {
            return true;
        }
        return cls == Short.TYPE && cls2 == Short.class;
    }

    public boolean isDynaProperty(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No property name specified");
        }
        MutableDynaClass mutableDynaClass = this.dynaClass;
        return mutableDynaClass instanceof LazyDynaClass ? ((LazyDynaClass) mutableDynaClass).isDynaProperty(str) : mutableDynaClass.getDynaProperty(str) != null;
    }

    public Map<String, Object> newMap() {
        return new HashMap();
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void remove(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("No property name specified");
        }
        Object obj = this.values.get(str);
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            ((Map) obj).remove(str2);
        } else {
            StringBuilder sbM16m = AbstractC0000a.m16m("Non-mapped property for '", str, "(", str2, ")'");
            sbM16m.append(obj.getClass().getName());
            throw new IllegalArgumentException(sbM16m.toString());
        }
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void set(String str, int i, Object obj) {
        if (!isDynaProperty(str)) {
            set(str, defaultIndexedProperty(str));
        }
        Object obj2 = get(str);
        if (!this.dynaClass.getDynaProperty(str).isIndexed()) {
            StringBuilder sbM780v = AbstractC0541b.m780v("Non-indexed property for '", i, str, "[", "]'");
            sbM780v.append(this.dynaClass.getDynaProperty(str).getType().getName());
            throw new IllegalArgumentException(sbM780v.toString());
        }
        Object objGrowIndexedProperty = growIndexedProperty(str, obj2, i);
        if (objGrowIndexedProperty.getClass().isArray()) {
            Array.set(objGrowIndexedProperty, i, obj);
        } else if (objGrowIndexedProperty instanceof List) {
            ((List) objGrowIndexedProperty).set(i, obj);
        } else {
            StringBuilder sbM780v2 = AbstractC0541b.m780v("Non-indexed property for '", i, str, "[", "]' ");
            sbM780v2.append(objGrowIndexedProperty.getClass().getName());
            throw new IllegalArgumentException(sbM780v2.toString());
        }
    }

    public int size(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No property name specified");
        }
        Object obj = this.values.get(str);
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Map) {
            return ((Map) obj).size();
        }
        if (obj instanceof List) {
            return ((List) obj).size();
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        return 0;
    }

    public LazyDynaBean(DynaClass dynaClass) {
        this.logger = LogFactory.getLog((Class<?>) LazyDynaBean.class);
        this.values = newMap();
        if (dynaClass instanceof MutableDynaClass) {
            this.dynaClass = (MutableDynaClass) dynaClass;
        } else {
            this.dynaClass = new LazyDynaClass(dynaClass.getName(), dynaClass.getDynaProperties());
        }
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public Object get(String str, int i) {
        if (!isDynaProperty(str)) {
            set(str, defaultIndexedProperty(str));
        }
        Object obj = get(str);
        if (this.dynaClass.getDynaProperty(str).isIndexed()) {
            Object objGrowIndexedProperty = growIndexedProperty(str, obj, i);
            if (objGrowIndexedProperty.getClass().isArray()) {
                return Array.get(objGrowIndexedProperty, i);
            }
            if (objGrowIndexedProperty instanceof List) {
                return ((List) objGrowIndexedProperty).get(i);
            }
            StringBuilder sbM780v = AbstractC0541b.m780v("Non-indexed property for '", i, str, "[", "]' ");
            sbM780v.append(objGrowIndexedProperty.getClass().getName());
            throw new IllegalArgumentException(sbM780v.toString());
        }
        StringBuilder sbM780v2 = AbstractC0541b.m780v("Non-indexed property for '", i, str, "[", "]' ");
        sbM780v2.append(this.dynaClass.getDynaProperty(str).getName());
        throw new IllegalArgumentException(sbM780v2.toString());
    }

    public LazyDynaBean(String str) {
        this(new LazyDynaClass(str));
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void set(String str, Object obj) {
        if (!isDynaProperty(str)) {
            if (this.dynaClass.isRestricted()) {
                throw new IllegalArgumentException(AbstractC0541b.m773o("Invalid property name '", str, "' (DynaClass is restricted)"));
            }
            if (obj == null) {
                this.dynaClass.add(str);
            } else {
                this.dynaClass.add(str, obj.getClass());
            }
        }
        DynaProperty dynaProperty = this.dynaClass.getDynaProperty(str);
        if (obj == null) {
            if (dynaProperty.getType().isPrimitive()) {
                throw new NullPointerException(AbstractC0541b.m773o("Primitive value for '", str, "'"));
            }
        } else if (!isAssignable(dynaProperty.getType(), obj.getClass())) {
            throw new ConversionException("Cannot assign value of type '" + obj.getClass().getName() + "' to property '" + str + "' of type '" + dynaProperty.getType().getName() + "'");
        }
        this.values.put(str, obj);
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public Object get(String str, String str2) {
        if (!isDynaProperty(str)) {
            set(str, defaultMappedProperty(str));
        }
        Object obj = get(str);
        if (this.dynaClass.getDynaProperty(str).isMapped()) {
            if (obj instanceof Map) {
                return ((Map) obj).get(str2);
            }
            StringBuilder sbM16m = AbstractC0000a.m16m("Non-mapped property for '", str, "(", str2, ")'");
            sbM16m.append(obj.getClass().getName());
            throw new IllegalArgumentException(sbM16m.toString());
        }
        StringBuilder sbM16m2 = AbstractC0000a.m16m("Non-mapped property for '", str, "(", str2, ")' ");
        sbM16m2.append(this.dynaClass.getDynaProperty(str).getType().getName());
        throw new IllegalArgumentException(sbM16m2.toString());
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void set(String str, String str2, Object obj) {
        if (!isDynaProperty(str)) {
            set(str, defaultMappedProperty(str));
        }
        Object obj2 = get(str);
        if (this.dynaClass.getDynaProperty(str).isMapped()) {
            ((Map) obj2).put(str2, obj);
        } else {
            StringBuilder sbM16m = AbstractC0000a.m16m("Non-mapped property for '", str, "(", str2, ")'");
            sbM16m.append(this.dynaClass.getDynaProperty(str).getType().getName());
            throw new IllegalArgumentException(sbM16m.toString());
        }
    }
}
