package com.google.android.play.core.internal;

import com.google.android.play.core.listener.StateUpdatedListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: com.google.android.play.core.internal.ae */
/* JADX INFO: loaded from: classes5.dex */
public final class C5156ae<StateT> {

    /* JADX INFO: renamed from: a */
    protected final Set<StateUpdatedListener<StateT>> f2932a = new HashSet();

    /* JADX INFO: renamed from: a */
    public final synchronized void m3870a(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f2932a.add(stateUpdatedListener);
    }

    /* JADX INFO: renamed from: b */
    public final synchronized void m3872b(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f2932a.remove(stateUpdatedListener);
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m3871a(StateT statet) {
        Iterator<StateUpdatedListener<StateT>> it = this.f2932a.iterator();
        while (it.hasNext()) {
            it.next().onStateUpdate(statet);
        }
    }
}
