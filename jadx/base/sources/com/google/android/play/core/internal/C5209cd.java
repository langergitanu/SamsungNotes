package com.google.android.play.core.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.google.android.play.core.internal.cd */
/* JADX INFO: loaded from: classes5.dex */
final class C5209cd extends WeakReference<Throwable> {

    /* JADX INFO: renamed from: a */
    private final int f2977a;

    public C5209cd(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.f2977a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == C5209cd.class) {
            if (this == obj) {
                return true;
            }
            C5209cd c5209cd = (C5209cd) obj;
            if (this.f2977a == c5209cd.f2977a && get() == c5209cd.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2977a;
    }
}
