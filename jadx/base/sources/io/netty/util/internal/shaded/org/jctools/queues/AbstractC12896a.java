package io.netty.util.internal.shaded.org.jctools.queues;

import sun.misc.Unsafe;

/* JADX INFO: renamed from: io.netty.util.internal.shaded.org.jctools.queues.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract /* synthetic */ class AbstractC12896a {
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ boolean m13779a(Unsafe unsafe, Object obj, long j, Object obj2, Object obj3) {
        while (!unsafe.compareAndSwapObject(obj, j, obj2, obj3)) {
            if (unsafe.getObject(obj, j) != obj2) {
                return false;
            }
        }
        return true;
    }
}
