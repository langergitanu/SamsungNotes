package com.google.android.play.core.splitinstall;

import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.o */
/* JADX INFO: loaded from: classes5.dex */
public final class C5314o {

    /* JADX INFO: renamed from: a */
    private static final AtomicReference<InterfaceC5313n> f3137a = new AtomicReference<>(null);

    @Nullable
    /* JADX INFO: renamed from: a */
    public static InterfaceC5313n m4142a() {
        return f3137a.get();
    }

    /* JADX INFO: renamed from: a */
    public static void m4143a(InterfaceC5313n interfaceC5313n) {
        AtomicReference<InterfaceC5313n> atomicReference = f3137a;
        while (!atomicReference.compareAndSet(null, interfaceC5313n) && atomicReference.get() == null) {
        }
    }
}
