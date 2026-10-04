package org.apache.poi.javax.imageio.spi;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class SubRegistry {
    Class category;
    ServiceRegistry registry;
    final PartiallyOrderedSet poset = new PartiallyOrderedSet();
    final Map<Class<?>, Object> map = new HashMap();
    final Map<Class<?>, AccessControlContext> accMap = new HashMap();

    public SubRegistry(ServiceRegistry serviceRegistry, Class cls) {
        this.registry = serviceRegistry;
        this.category = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$clear$0(RegisterableService registerableService) {
        registerableService.onDeregistration(this.registry, this.category);
        return null;
    }

    public void clear() {
        Iterator<Object> it = this.map.values().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            it.remove();
            if (next instanceof RegisterableService) {
                final RegisterableService registerableService = (RegisterableService) next;
                AccessControlContext accessControlContext = this.accMap.get(next.getClass());
                if (accessControlContext != null || System.getSecurityManager() == null) {
                    AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.poi.javax.imageio.spi.a
                        @Override // java.security.PrivilegedAction
                        public final Object run() {
                            return this.f10158a.lambda$clear$0(registerableService);
                        }
                    }, accessControlContext);
                }
            }
        }
        this.poset.clear();
        this.accMap.clear();
    }

    public boolean contains(Object obj) {
        return this.map.get(obj.getClass()) == obj;
    }

    public boolean deregisterServiceProvider(Object obj) {
        if (obj != this.map.get(obj.getClass())) {
            return false;
        }
        this.map.remove(obj.getClass());
        this.accMap.remove(obj.getClass());
        this.poset.remove(obj);
        if (!(obj instanceof RegisterableService)) {
            return true;
        }
        ((RegisterableService) obj).onDeregistration(this.registry, this.category);
        return true;
    }

    public void finalize() {
        clear();
    }

    public <T> T getServiceProviderByClass(Class<T> cls) {
        return (T) this.map.get(cls);
    }

    public Iterator getServiceProviders(boolean z) {
        return z ? this.poset.iterator() : this.map.values().iterator();
    }

    public boolean registerServiceProvider(Object obj) {
        Object obj2 = this.map.get(obj.getClass());
        boolean z = obj2 != null;
        if (z) {
            deregisterServiceProvider(obj2);
        }
        this.map.put(obj.getClass(), obj);
        this.accMap.put(obj.getClass(), AccessController.getContext());
        this.poset.add(obj);
        if (obj instanceof RegisterableService) {
            ((RegisterableService) obj).onRegistration(this.registry, this.category);
        }
        return !z;
    }

    public boolean setOrdering(Object obj, Object obj2) {
        return this.poset.setOrdering(obj, obj2);
    }

    public boolean unsetOrdering(Object obj, Object obj2) {
        return this.poset.unsetOrdering(obj, obj2);
    }
}
