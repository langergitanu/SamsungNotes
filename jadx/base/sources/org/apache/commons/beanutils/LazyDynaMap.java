package org.apache.commons.beanutils;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LazyDynaMap extends LazyDynaBean implements MutableDynaClass {
    private static final long serialVersionUID = 1;
    protected String name;
    protected boolean restricted;
    protected boolean returnNull;

    public LazyDynaMap() {
        this((String) null, (Map<String, Object>) null);
    }

    public void add(DynaProperty dynaProperty) {
        add(dynaProperty.getName(), dynaProperty.getType());
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaProperty[] getDynaProperties() {
        DynaProperty[] dynaPropertyArr = new DynaProperty[this.values.size()];
        Iterator<Map.Entry<String, Object>> it = this.values.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            String key = it.next().getKey();
            Object obj = this.values.get(key);
            int i2 = i + 1;
            dynaPropertyArr[i] = new DynaProperty(key, obj == null ? null : obj.getClass());
            i = i2;
        }
        return dynaPropertyArr;
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaProperty getDynaProperty(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Property name is missing.");
        }
        if (!this.values.containsKey(str) && isReturnNull()) {
            return null;
        }
        Object obj = this.values.get(str);
        return obj == null ? new DynaProperty(str) : new DynaProperty(str, obj.getClass());
    }

    @Override // org.apache.commons.beanutils.LazyDynaBean
    public Map<String, Object> getMap() {
        return this.values;
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public String getName() {
        return this.name;
    }

    @Override // org.apache.commons.beanutils.LazyDynaBean
    public boolean isDynaProperty(String str) {
        if (str != null) {
            return this.values.containsKey(str);
        }
        throw new IllegalArgumentException("Property name is missing.");
    }

    @Override // org.apache.commons.beanutils.MutableDynaClass
    public boolean isRestricted() {
        return this.restricted;
    }

    public boolean isReturnNull() {
        return this.returnNull;
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaBean newInstance() {
        Map<String, Object> mapNewMap;
        try {
            mapNewMap = (Map) getMap().getClass().getConstructor(null).newInstance(null);
        } catch (Exception unused) {
            mapNewMap = newMap();
        }
        LazyDynaMap lazyDynaMap = new LazyDynaMap(mapNewMap);
        DynaProperty[] dynaProperties = getDynaProperties();
        if (dynaProperties != null) {
            for (DynaProperty dynaProperty : dynaProperties) {
                lazyDynaMap.add(dynaProperty);
            }
        }
        return lazyDynaMap;
    }

    @Override // org.apache.commons.beanutils.MutableDynaClass
    public void remove(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Property name is missing.");
        }
        if (isRestricted()) {
            throw new IllegalStateException("DynaClass is currently restricted. No properties can be removed.");
        }
        if (this.values.containsKey(str)) {
            this.values.remove(str);
        }
    }

    @Override // org.apache.commons.beanutils.LazyDynaBean, org.apache.commons.beanutils.DynaBean
    public void set(String str, Object obj) {
        if (isRestricted() && !this.values.containsKey(str)) {
            throw new IllegalArgumentException(AbstractC0541b.m773o("Invalid property name '", str, "' (DynaClass is restricted)"));
        }
        this.values.put(str, obj);
    }

    public void setMap(Map<String, Object> map) {
        this.values = map;
    }

    @Override // org.apache.commons.beanutils.MutableDynaClass
    public void setRestricted(boolean z) {
        this.restricted = z;
    }

    public void setReturnNull(boolean z) {
        this.returnNull = z;
    }

    public LazyDynaMap(DynaClass dynaClass) {
        this(dynaClass.getName(), dynaClass.getDynaProperties());
    }

    @Override // org.apache.commons.beanutils.MutableDynaClass
    public void add(String str) {
        add(str, null);
    }

    public LazyDynaMap(DynaProperty[] dynaPropertyArr) {
        this((String) null, dynaPropertyArr);
    }

    @Override // org.apache.commons.beanutils.MutableDynaClass
    public void add(String str, Class<?> cls) {
        if (str != null) {
            if (!isRestricted()) {
                if (this.values.get(str) == null) {
                    this.values.put(str, cls == null ? null : createProperty(str, cls));
                    return;
                }
                return;
            }
            throw new IllegalStateException("DynaClass is currently restricted. No new properties can be added.");
        }
        throw new IllegalArgumentException("Property name is missing.");
    }

    public LazyDynaMap(Map<String, Object> map) {
        this((String) null, map);
    }

    public LazyDynaMap(String str) {
        this(str, (Map<String, Object>) null);
    }

    public LazyDynaMap(String str, DynaProperty[] dynaPropertyArr) {
        this(str, (Map<String, Object>) null);
        if (dynaPropertyArr != null) {
            for (DynaProperty dynaProperty : dynaPropertyArr) {
                add(dynaProperty);
            }
        }
    }

    @Override // org.apache.commons.beanutils.MutableDynaClass
    public void add(String str, Class<?> cls, boolean z, boolean z2) {
        throw new UnsupportedOperationException("readable/writable properties not supported");
    }

    public LazyDynaMap(String str, Map<String, Object> map) {
        this.name = str == null ? "LazyDynaMap" : str;
        this.values = map == null ? newMap() : map;
        this.dynaClass = this;
    }
}
