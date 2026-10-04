package org.apache.poi.javax.imageio.spi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ServiceRegistry {
    private Map categoryMap = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Filter {
        boolean filter(Object obj);
    }

    public ServiceRegistry(Iterator<Class<?>> it) {
        if (it == null) {
            throw new IllegalArgumentException("categories == null!");
        }
        while (it.hasNext()) {
            Class<?> next = it.next();
            this.categoryMap.put(next, new SubRegistry(this, next));
        }
    }

    private Iterator getSubRegistries(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Class cls : this.categoryMap.keySet()) {
            if (cls.isAssignableFrom(obj.getClass())) {
                arrayList.add((SubRegistry) this.categoryMap.get(cls));
            }
        }
        return arrayList.iterator();
    }

    public static <T> Iterator<T> lookupProviders(Class<T> cls, ClassLoader classLoader) {
        if (cls != null) {
            return ServiceLoader.load(cls, classLoader).iterator();
        }
        throw new IllegalArgumentException("providerClass == null!");
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("provider == null!");
        }
        Iterator subRegistries = getSubRegistries(obj);
        while (subRegistries.hasNext()) {
            if (((SubRegistry) subRegistries.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public void deregisterAll(Class<?> cls) {
        SubRegistry subRegistry = (SubRegistry) this.categoryMap.get(cls);
        if (subRegistry == null) {
            throw new IllegalArgumentException("category unknown!");
        }
        subRegistry.clear();
    }

    public <T> boolean deregisterServiceProvider(T t, Class<T> cls) {
        if (t == null) {
            throw new IllegalArgumentException("provider == null!");
        }
        SubRegistry subRegistry = (SubRegistry) this.categoryMap.get(cls);
        if (subRegistry == null) {
            throw new IllegalArgumentException("category unknown!");
        }
        if (cls.isAssignableFrom(t.getClass())) {
            return subRegistry.deregisterServiceProvider(t);
        }
        throw new ClassCastException();
    }

    public void finalize() throws Throwable {
        deregisterAll();
        super.finalize();
    }

    public Iterator<Class<?>> getCategories() {
        return this.categoryMap.keySet().iterator();
    }

    public <T> T getServiceProviderByClass(Class<T> cls) {
        T t;
        if (cls == null) {
            throw new IllegalArgumentException("providerClass == null!");
        }
        for (Class cls2 : this.categoryMap.keySet()) {
            if (cls2.isAssignableFrom(cls) && (t = (T) ((SubRegistry) this.categoryMap.get(cls2)).getServiceProviderByClass(cls)) != null) {
                return t;
            }
        }
        return null;
    }

    public <T> Iterator<T> getServiceProviders(Class<T> cls, boolean z) {
        SubRegistry subRegistry = (SubRegistry) this.categoryMap.get(cls);
        if (subRegistry != null) {
            return subRegistry.getServiceProviders(z);
        }
        throw new IllegalArgumentException("category unknown!");
    }

    public <T> boolean registerServiceProvider(T t, Class<T> cls) {
        if (t == null) {
            throw new IllegalArgumentException("provider == null!");
        }
        SubRegistry subRegistry = (SubRegistry) this.categoryMap.get(cls);
        if (subRegistry == null) {
            throw new IllegalArgumentException("category unknown!");
        }
        if (cls.isAssignableFrom(t.getClass())) {
            return subRegistry.registerServiceProvider(t);
        }
        throw new ClassCastException();
    }

    public void registerServiceProviders(Iterator<?> it) {
        if (it == null) {
            throw new IllegalArgumentException("provider == null!");
        }
        while (it.hasNext()) {
            registerServiceProvider(it.next());
        }
    }

    public <T> boolean setOrdering(Class<T> cls, T t, T t2) {
        if (t == null || t2 == null) {
            throw new IllegalArgumentException("provider is null!");
        }
        if (t == t2) {
            throw new IllegalArgumentException("providers are the same!");
        }
        SubRegistry subRegistry = (SubRegistry) this.categoryMap.get(cls);
        if (subRegistry == null) {
            throw new IllegalArgumentException("category unknown!");
        }
        if (subRegistry.contains(t) && subRegistry.contains(t2)) {
            return subRegistry.setOrdering(t, t2);
        }
        return false;
    }

    public <T> boolean unsetOrdering(Class<T> cls, T t, T t2) {
        if (t == null || t2 == null) {
            throw new IllegalArgumentException("provider is null!");
        }
        if (t == t2) {
            throw new IllegalArgumentException("providers are the same!");
        }
        SubRegistry subRegistry = (SubRegistry) this.categoryMap.get(cls);
        if (subRegistry == null) {
            throw new IllegalArgumentException("category unknown!");
        }
        if (subRegistry.contains(t) && subRegistry.contains(t2)) {
            return subRegistry.unsetOrdering(t, t2);
        }
        return false;
    }

    public static <T> Iterator<T> lookupProviders(Class<T> cls) {
        if (cls != null) {
            return ServiceLoader.load(cls).iterator();
        }
        throw new IllegalArgumentException("providerClass == null!");
    }

    public void deregisterAll() {
        Iterator it = this.categoryMap.values().iterator();
        while (it.hasNext()) {
            ((SubRegistry) it.next()).clear();
        }
    }

    public <T> Iterator<T> getServiceProviders(Class<T> cls, Filter filter, boolean z) {
        if (((SubRegistry) this.categoryMap.get(cls)) != null) {
            return new FilterIterator(getServiceProviders(cls, z), filter);
        }
        throw new IllegalArgumentException("category unknown!");
    }

    public void deregisterServiceProvider(Object obj) {
        if (obj != null) {
            Iterator subRegistries = getSubRegistries(obj);
            while (subRegistries.hasNext()) {
                ((SubRegistry) subRegistries.next()).deregisterServiceProvider(obj);
            }
            return;
        }
        throw new IllegalArgumentException("provider == null!");
    }

    public void registerServiceProvider(Object obj) {
        if (obj != null) {
            Iterator subRegistries = getSubRegistries(obj);
            while (subRegistries.hasNext()) {
                ((SubRegistry) subRegistries.next()).registerServiceProvider(obj);
            }
            return;
        }
        throw new IllegalArgumentException("provider == null!");
    }
}
