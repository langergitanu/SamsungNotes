package org.apache.commons.beanutils;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BasicDynaClass implements DynaClass, Serializable {
    protected static Class<?>[] constructorTypes = {DynaClass.class};
    private static final long serialVersionUID = 1;
    protected transient Constructor<?> constructor;
    protected Object[] constructorValues;
    protected Class<?> dynaBeanClass;
    protected String name;
    protected DynaProperty[] properties;
    protected HashMap<String, DynaProperty> propertiesMap;

    public BasicDynaClass() {
        this(null, null, null);
    }

    public Class<?> getDynaBeanClass() {
        return this.dynaBeanClass;
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
        return this.name;
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaBean newInstance() throws InstantiationException {
        try {
            if (this.constructor == null) {
                setDynaBeanClass(this.dynaBeanClass);
            }
            return (DynaBean) this.constructor.newInstance(this.constructorValues);
        } catch (InvocationTargetException e) {
            throw new InstantiationException(e.getTargetException().getMessage());
        }
    }

    public void setDynaBeanClass(Class<?> cls) {
        if (cls.isInterface()) {
            throw new IllegalArgumentException(AbstractC2322a.m1618h(cls, new StringBuilder("Class "), " is an interface, not a class"));
        }
        if (!DynaBean.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException(AbstractC2322a.m1618h(cls, new StringBuilder("Class "), " does not implement DynaBean"));
        }
        try {
            this.constructor = cls.getConstructor(constructorTypes);
            this.dynaBeanClass = cls;
        } catch (NoSuchMethodException unused) {
            throw new IllegalArgumentException(AbstractC2322a.m1618h(cls, new StringBuilder("Class "), " does not have an appropriate constructor"));
        }
    }

    public void setProperties(DynaProperty[] dynaPropertyArr) {
        this.properties = dynaPropertyArr;
        this.propertiesMap.clear();
        for (DynaProperty dynaProperty : dynaPropertyArr) {
            this.propertiesMap.put(dynaProperty.getName(), dynaProperty);
        }
    }

    public BasicDynaClass(String str, Class<?> cls) {
        this(str, cls, null);
    }

    /* JADX WARN: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r4v0, types: [java.lang.Class<?>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BasicDynaClass(String str, Class cls, DynaProperty[] dynaPropertyArr) {
        this.constructorValues = new Object[]{this};
        this.dynaBeanClass = BasicDynaBean.class;
        this.name = getClass().getName();
        this.properties = new DynaProperty[0];
        this.propertiesMap = new HashMap<>();
        if (str != null) {
            this.name = str;
        }
        setDynaBeanClass(cls == null ? BasicDynaBean.class : cls);
        if (dynaPropertyArr != null) {
            setProperties(dynaPropertyArr);
        }
    }
}
