package org.apache.commons.beanutils;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BasicDynaBean implements DynaBean, Serializable {
    private static final long serialVersionUID = 1;
    protected DynaClass dynaClass;
    private transient Map<String, Object> mapDecorator;
    protected HashMap<String, Object> values = new HashMap<>();

    public BasicDynaBean(DynaClass dynaClass) {
        this.dynaClass = dynaClass;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ String m14513a(int i, String str) {
        return lambda$get$1(str, i);
    }

    /* JADX INFO: renamed from: f */
    public static /* synthetic */ String m14518f(int i, String str) {
        return lambda$set$4(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$contains$0(String str, String str2) {
        return AbstractC0541b.m775q("No mapped value for '", str, "(", str2, ")'");
    }

    private static /* synthetic */ String lambda$get$1(String str, int i) {
        return AbstractC1974b.m1319l("No indexed value for '", i, str, "[", "]'");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$get$2(String str, String str2) {
        return AbstractC0541b.m775q("No mapped value for '", str, "(", str2, ")'");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$remove$3(String str, String str2) {
        return AbstractC0541b.m775q("No mapped value for '", str, "(", str2, ")'");
    }

    private static /* synthetic */ String lambda$set$4(String str, int i) {
        return AbstractC1974b.m1319l("No indexed value for '", i, str, "[", "]'");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$set$5(String str, String str2) {
        return AbstractC0541b.m775q("No mapped value for '", str, "(", str2, ")'");
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public boolean contains(String str, String str2) {
        Object obj = this.values.get(str);
        Objects.requireNonNull(obj, new C13662b(str, str2, 0));
        if (obj instanceof Map) {
            return ((Map) obj).containsKey(str2);
        }
        throw new IllegalArgumentException(AbstractC0541b.m775q("Non-mapped property for '", str, "(", str2, ")'"));
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public Object get(String str) {
        Object obj = this.values.get(str);
        if (obj != null) {
            return obj;
        }
        Class<?> type = getDynaProperty(str).getType();
        if (!type.isPrimitive()) {
            return obj;
        }
        if (type == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (type == Byte.TYPE) {
            return (byte) 0;
        }
        if (type == Character.TYPE) {
            return (char) 0;
        }
        if (type == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (type == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (type == Integer.TYPE) {
            return 0;
        }
        if (type == Long.TYPE) {
            return 0L;
        }
        return type == Short.TYPE ? (short) 0 : null;
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public DynaClass getDynaClass() {
        return this.dynaClass;
    }

    public DynaProperty getDynaProperty(String str) {
        DynaProperty dynaProperty = getDynaClass().getDynaProperty(str);
        if (dynaProperty != null) {
            return dynaProperty;
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("Invalid property name '", str, "'"));
    }

    public Map<String, Object> getMap() {
        if (this.mapDecorator == null) {
            this.mapDecorator = new DynaBeanPropertyMapDecorator(this);
        }
        return this.mapDecorator;
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

    @Override // org.apache.commons.beanutils.DynaBean
    public void remove(String str, String str2) {
        Object obj = this.values.get(str);
        Objects.requireNonNull(obj, new C13662b(str, str2, 3));
        if (!(obj instanceof Map)) {
            throw new IllegalArgumentException(AbstractC0541b.m775q("Non-mapped property for '", str, "(", str2, ")'"));
        }
        ((Map) obj).remove(str2);
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void set(String str, int i, Object obj) {
        Object obj2 = this.values.get(str);
        Objects.requireNonNull(obj2, new C13661a(str, i, 1));
        if (obj2.getClass().isArray()) {
            Array.set(obj2, i, obj);
        } else {
            if (!(obj2 instanceof List)) {
                throw new IllegalArgumentException(AbstractC1974b.m1319l("Non-indexed property for '", i, str, "[", "]'"));
            }
            try {
                ((List) obj2).set(i, obj);
            } catch (ClassCastException e) {
                throw new ConversionException(e.getMessage());
            }
        }
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void set(String str, Object obj) {
        DynaProperty dynaProperty = getDynaProperty(str);
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
    public Object get(String str, int i) {
        Object obj = this.values.get(str);
        Objects.requireNonNull(obj, new C13661a(str, i, 0));
        if (obj.getClass().isArray()) {
            return Array.get(obj, i);
        }
        if (obj instanceof List) {
            return ((List) obj).get(i);
        }
        throw new IllegalArgumentException(AbstractC1974b.m1319l("Non-indexed property for '", i, str, "[", "]'"));
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void set(String str, String str2, Object obj) {
        Object obj2 = this.values.get(str);
        Objects.requireNonNull(obj2, new C13662b(str, str2, 2));
        if (obj2 instanceof Map) {
            ((Map) obj2).put(str2, obj);
            return;
        }
        throw new IllegalArgumentException(AbstractC0541b.m775q("Non-mapped property for '", str, "(", str2, ")'"));
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public Object get(String str, String str2) {
        Object obj = this.values.get(str);
        Objects.requireNonNull(obj, new C13662b(str, str2, 1));
        if (obj instanceof Map) {
            return ((Map) obj).get(str2);
        }
        throw new IllegalArgumentException(AbstractC0541b.m775q("Non-mapped property for '", str, "(", str2, ")'"));
    }
}
