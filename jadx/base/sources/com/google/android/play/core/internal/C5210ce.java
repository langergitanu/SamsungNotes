package com.google.android.play.core.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.google.android.play.core.internal.ce */
/* JADX INFO: loaded from: classes5.dex */
final class C5210ce {

    /* JADX INFO: renamed from: a */
    private final ConcurrentHashMap<C5209cd, List<Throwable>> f2978a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* JADX INFO: renamed from: b */
    private final ReferenceQueue<Throwable> f2979b = new ReferenceQueue<>();

    /* JADX INFO: renamed from: a */
    public final List<Throwable> m3977a(Throwable th) {
        while (true) {
            Reference<? extends Throwable> referencePoll = this.f2979b.poll();
            if (referencePoll == null) {
                break;
            }
            this.f2978a.remove(referencePoll);
        }
        List<Throwable> list = this.f2978a.get(new C5209cd(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> listPutIfAbsent = this.f2978a.putIfAbsent(new C5209cd(th, this.f2979b), vector);
        return listPutIfAbsent == null ? vector : listPutIfAbsent;
    }
}
