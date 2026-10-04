package org.apache.commons.beanutils;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LazyDynaList extends ArrayList<Object> {
    private static final long serialVersionUID = 1;
    private Class<?> elementDynaBeanType;
    private DynaClass elementDynaClass;
    private Class<?> elementType;
    private transient WrapDynaClass wrapDynaClass;

    public LazyDynaList() {
    }

    private LazyDynaMap createDynaBeanForMapProperty(Object obj) {
        return new LazyDynaMap((Map<String, Object>) obj);
    }

    private DynaClass getDynaClass() {
        DynaClass dynaClass = this.elementDynaClass;
        return dynaClass == null ? this.wrapDynaClass : dynaClass;
    }

    private void growList(int i) {
        if (i < size()) {
            return;
        }
        ensureCapacity(i + 1);
        for (int size = size(); size < i; size++) {
            super.add(transform(null));
        }
    }

    private DynaBean transform(Object obj) {
        DynaBean dynaBeanCreateDynaBeanForMapProperty;
        Class<?> cls;
        if (obj == null) {
            if (this.elementType == null) {
                setElementDynaClass(new LazyDynaClass());
            }
            if (getDynaClass() == null) {
                setElementType(this.elementType);
            }
            try {
                dynaBeanCreateDynaBeanForMapProperty = getDynaClass().newInstance();
                cls = dynaBeanCreateDynaBeanForMapProperty.getClass();
            } catch (Exception e) {
                throw new IllegalArgumentException("Error creating DynaBean: " + getDynaClass().getClass().getName() + " - " + e);
            }
        } else {
            dynaBeanCreateDynaBeanForMapProperty = Map.class.isAssignableFrom(obj.getClass()) ? createDynaBeanForMapProperty(obj) : DynaBean.class.isAssignableFrom(obj.getClass()) ? (DynaBean) obj : new WrapDynaBean(obj);
            cls = dynaBeanCreateDynaBeanForMapProperty.getClass();
        }
        Class<?> cls2 = dynaBeanCreateDynaBeanForMapProperty.getClass();
        if (WrapDynaBean.class.isAssignableFrom(cls)) {
            cls2 = ((WrapDynaBean) dynaBeanCreateDynaBeanForMapProperty).getInstance().getClass();
        } else if (LazyDynaMap.class.isAssignableFrom(cls)) {
            cls2 = ((LazyDynaMap) dynaBeanCreateDynaBeanForMapProperty).getMap().getClass();
        }
        Class<?> cls3 = this.elementType;
        if (cls3 == null || cls2.equals(cls3)) {
            return dynaBeanCreateDynaBeanForMapProperty;
        }
        throw new IllegalArgumentException("Element Type " + cls2 + " doesn't match other elements " + this.elementType);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        DynaBean dynaBeanTransform = transform(obj);
        growList(i);
        super.add(i, dynaBeanTransform);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<?> collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        ensureCapacity(collection.size() + size());
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
        return true;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Object get(int i) {
        growList(i + 1);
        return super.get(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        DynaBean dynaBeanTransform = transform(obj);
        growList(i + 1);
        return super.set(i, dynaBeanTransform);
    }

    public void setElementDynaClass(DynaClass dynaClass) {
        if (dynaClass == null) {
            throw new IllegalArgumentException("Element DynaClass is missing");
        }
        if (size() > 0) {
            throw new IllegalStateException("Element DynaClass cannot be reset");
        }
        try {
            DynaBean dynaBeanNewInstance = dynaClass.newInstance();
            Class<?> cls = dynaBeanNewInstance.getClass();
            this.elementDynaBeanType = cls;
            if (WrapDynaBean.class.isAssignableFrom(cls)) {
                this.elementType = ((WrapDynaBean) dynaBeanNewInstance).getInstance().getClass();
                this.wrapDynaClass = (WrapDynaClass) dynaClass;
            } else {
                if (LazyDynaMap.class.isAssignableFrom(this.elementDynaBeanType)) {
                    this.elementType = ((LazyDynaMap) dynaBeanNewInstance).getMap().getClass();
                } else {
                    this.elementType = dynaBeanNewInstance.getClass();
                }
                this.elementDynaClass = dynaClass;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Error creating DynaBean from " + dynaClass.getClass().getName() + " - " + e);
        }
    }

    public void setElementType(Class<?> cls) {
        DynaBean wrapDynaBean;
        if (cls == null) {
            throw new IllegalArgumentException("Element Type is missing");
        }
        Class<?> cls2 = this.elementType;
        if (cls2 != null && !cls2.equals(cls) && size() > 0) {
            throw new IllegalStateException("Element Type cannot be reset");
        }
        this.elementType = cls;
        try {
            Object objNewInstance = cls.getConstructor(null).newInstance(null);
            if (Map.class.isAssignableFrom(cls)) {
                wrapDynaBean = createDynaBeanForMapProperty(objNewInstance);
                this.elementDynaClass = wrapDynaBean.getDynaClass();
            } else if (DynaBean.class.isAssignableFrom(cls)) {
                wrapDynaBean = (DynaBean) objNewInstance;
                this.elementDynaClass = wrapDynaBean.getDynaClass();
            } else {
                wrapDynaBean = new WrapDynaBean(objNewInstance);
                this.wrapDynaClass = (WrapDynaClass) wrapDynaBean.getDynaClass();
            }
            Class<?> cls3 = wrapDynaBean.getClass();
            this.elementDynaBeanType = cls3;
            if (WrapDynaBean.class.isAssignableFrom(cls3)) {
                this.elementType = ((WrapDynaBean) wrapDynaBean).getInstance().getClass();
            } else if (LazyDynaMap.class.isAssignableFrom(this.elementDynaBeanType)) {
                this.elementType = ((LazyDynaMap) wrapDynaBean).getMap().getClass();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Error creating type: " + cls.getName() + " - " + e);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        if (size() == 0 && this.elementType == null) {
            return new LazyDynaBean[0];
        }
        Object[] objArr = (Object[]) Array.newInstance(this.elementType, size());
        for (int i = 0; i < size(); i++) {
            if (Map.class.isAssignableFrom(this.elementType)) {
                objArr[i] = ((LazyDynaMap) get(i)).getMap();
            } else if (DynaBean.class.isAssignableFrom(this.elementType)) {
                objArr[i] = get(i);
            } else {
                objArr[i] = ((WrapDynaBean) get(i)).getInstance();
            }
        }
        return objArr;
    }

    public DynaBean[] toDynaBeanArray() {
        if (size() == 0 && this.elementDynaBeanType == null) {
            return new LazyDynaBean[0];
        }
        DynaBean[] dynaBeanArr = (DynaBean[]) Array.newInstance(this.elementDynaBeanType, size());
        for (int i = 0; i < size(); i++) {
            dynaBeanArr[i] = (DynaBean) get(i);
        }
        return dynaBeanArr;
    }

    public LazyDynaList(Class<?> cls) {
        setElementType(cls);
    }

    public LazyDynaList(Collection<?> collection) {
        super(collection.size());
        addAll(collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        return super.add(transform(obj));
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<?> collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        ensureCapacity(collection.size() + (i > size() ? i : size()));
        if (size() == 0) {
            transform(collection.iterator().next());
        }
        growList(i);
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            add(i, it.next());
            i++;
        }
        return true;
    }

    public LazyDynaList(DynaClass dynaClass) {
        setElementDynaClass(dynaClass);
    }

    public LazyDynaList(int i) {
        super(i);
    }

    public LazyDynaList(Object[] objArr) {
        super(objArr.length);
        for (Object obj : objArr) {
            add(obj);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        Object wrapDynaBean;
        Class<?> componentType = tArr.getClass().getComponentType();
        if (!DynaBean.class.isAssignableFrom(componentType) && (size() != 0 || this.elementType != null)) {
            if (componentType.isAssignableFrom(this.elementType)) {
                if (tArr.length < size()) {
                    tArr = (T[]) ((Object[]) Array.newInstance(componentType, size()));
                }
                for (int i = 0; i < size(); i++) {
                    if (!Map.class.isAssignableFrom(this.elementType)) {
                        if (DynaBean.class.isAssignableFrom(this.elementType)) {
                            wrapDynaBean = get(i);
                        } else {
                            wrapDynaBean = ((WrapDynaBean) get(i)).getInstance();
                        }
                    } else {
                        wrapDynaBean = ((LazyDynaMap) get(i)).getMap();
                    }
                    Array.set(tArr, i, wrapDynaBean);
                }
                return tArr;
            }
            StringBuilder sb = new StringBuilder("Invalid array type: ");
            AbstractC2322a.m1635y(componentType, sb, " - not compatible with '");
            sb.append(this.elementType.getName());
            throw new IllegalArgumentException(sb.toString());
        }
        return (T[]) super.toArray(tArr);
    }
}
