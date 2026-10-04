package org.junit.internal.management;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.internal.Classes;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
final class ReflectiveThreadMXBean implements ThreadMXBean {
    private final Object threadMxBean;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Holder {
        private static final String FAILURE_MESSAGE = "Unable to access ThreadMXBean";
        static final Method getThreadCpuTimeMethod;
        static final Method isThreadCpuTimeSupportedMethod;

        static {
            Method method;
            Method method2 = null;
            try {
                Class<?> cls = Classes.getClass("java.lang.management.ThreadMXBean");
                method = cls.getMethod("getThreadCpuTime", Long.TYPE);
                try {
                    method2 = cls.getMethod("isThreadCpuTimeSupported", null);
                } catch (ClassNotFoundException | NoSuchMethodException | SecurityException unused) {
                }
            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException unused2) {
                method = null;
            }
            getThreadCpuTimeMethod = method;
            isThreadCpuTimeSupportedMethod = method2;
        }

        private Holder() {
        }
    }

    public ReflectiveThreadMXBean(Object obj) {
        this.threadMxBean = obj;
    }

    @Override // org.junit.internal.management.ThreadMXBean
    public long getThreadCpuTime(long j) {
        Method method = Holder.getThreadCpuTimeMethod;
        if (method == null) {
            throw new UnsupportedOperationException("Unable to access ThreadMXBean");
        }
        try {
            return ((Long) method.invoke(this.threadMxBean, Long.valueOf(j))).longValue();
        } catch (ClassCastException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new UnsupportedOperationException("Unable to access ThreadMXBean", e);
        }
    }

    @Override // org.junit.internal.management.ThreadMXBean
    public boolean isThreadCpuTimeSupported() {
        Method method = Holder.isThreadCpuTimeSupportedMethod;
        if (method == null) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(this.threadMxBean, null)).booleanValue();
        } catch (ClassCastException | IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            return false;
        }
    }
}
