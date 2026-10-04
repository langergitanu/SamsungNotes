package com.google.common.util.concurrent;

import sun.misc.Unsafe;

/* JADX INFO: renamed from: com.google.common.util.concurrent.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract /* synthetic */ class AbstractC5920d {
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ boolean m4514a(Unsafe unsafe, AbstractFuture abstractFuture, long j, Object obj, Object obj2) {
        while (!unsafe.compareAndSwapObject(abstractFuture, j, obj, obj2)) {
            if (unsafe.getObject(abstractFuture, j) != obj) {
                return false;
            }
        }
        return true;
    }
}
