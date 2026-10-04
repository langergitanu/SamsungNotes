package org.junit.internal.management;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import org.junit.internal.Classes;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
final class ReflectiveRuntimeMXBean implements RuntimeMXBean {
    private final Object runtimeMxBean;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Holder {
        private static final Method getInputArgumentsMethod;

        static {
            Method method = null;
            try {
                method = Classes.getClass("java.lang.management.RuntimeMXBean").getMethod("getInputArguments", null);
            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException unused) {
            }
            getInputArgumentsMethod = method;
        }

        private Holder() {
        }
    }

    public ReflectiveRuntimeMXBean(Object obj) {
        this.runtimeMxBean = obj;
    }

    @Override // org.junit.internal.management.RuntimeMXBean
    public List<String> getInputArguments() {
        if (Holder.getInputArgumentsMethod != null) {
            try {
                return (List) Holder.getInputArgumentsMethod.invoke(this.runtimeMxBean, null);
            } catch (ClassCastException | IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
        return Collections.EMPTY_LIST;
    }
}
