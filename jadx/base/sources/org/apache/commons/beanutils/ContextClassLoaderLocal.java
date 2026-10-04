package org.apache.commons.beanutils;

import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ContextClassLoaderLocal<T> {
    private T globalValue;
    private boolean globalValueInitialized;
    private final Map<ClassLoader, T> valueByClassLoader = new WeakHashMap();

    public synchronized T get() {
        this.valueByClassLoader.isEmpty();
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                T tInitialValue = this.valueByClassLoader.get(contextClassLoader);
                if (tInitialValue == null && !this.valueByClassLoader.containsKey(contextClassLoader)) {
                    tInitialValue = initialValue();
                    this.valueByClassLoader.put(contextClassLoader, tInitialValue);
                }
                return tInitialValue;
            }
        } catch (SecurityException unused) {
        }
        if (!this.globalValueInitialized) {
            this.globalValue = initialValue();
            this.globalValueInitialized = true;
        }
        return this.globalValue;
    }

    public T initialValue() {
        return null;
    }

    public synchronized void set(T t) {
        this.valueByClassLoader.isEmpty();
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                this.valueByClassLoader.put(contextClassLoader, t);
                return;
            }
        } catch (SecurityException unused) {
        }
        this.globalValue = t;
        this.globalValueInitialized = true;
    }

    public synchronized void unset() {
        try {
            unset(Thread.currentThread().getContextClassLoader());
        } catch (SecurityException unused) {
        }
    }

    public synchronized void unset(ClassLoader classLoader) {
        this.valueByClassLoader.remove(classLoader);
    }
}
