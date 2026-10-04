package com.google.android.play.core.listener;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.internal.C5173av;
import com.google.android.play.core.splitcompat.C5271p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: com.google.android.play.core.listener.b */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC5244b<StateT> {

    /* JADX INFO: renamed from: a */
    protected final C5157af f2996a;

    /* JADX INFO: renamed from: c */
    private final IntentFilter f2998c;

    /* JADX INFO: renamed from: d */
    private final Context f2999d;

    /* JADX INFO: renamed from: b */
    protected final Set<StateUpdatedListener<StateT>> f2997b = new HashSet();

    /* JADX INFO: renamed from: e */
    @Nullable
    private C5243a f3000e = null;

    /* JADX INFO: renamed from: f */
    private volatile boolean f3001f = false;

    public AbstractC5244b(C5157af c5157af, IntentFilter intentFilter, Context context) {
        this.f2996a = c5157af;
        this.f2998c = intentFilter;
        this.f2999d = C5271p.m4096a(context);
    }

    /* JADX INFO: renamed from: c */
    private final void m4031c() {
        C5243a c5243a;
        if ((this.f3001f || !this.f2997b.isEmpty()) && this.f3000e == null) {
            C5243a c5243a2 = new C5243a(this);
            this.f3000e = c5243a2;
            this.f2999d.registerReceiver(c5243a2, this.f2998c);
        }
        if (this.f3001f || !this.f2997b.isEmpty() || (c5243a = this.f3000e) == null) {
            return;
        }
        this.f2999d.unregisterReceiver(c5243a);
        this.f3000e = null;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m4032a() {
        this.f2996a.m3878c("clearListeners", new Object[0]);
        this.f2997b.clear();
        m4031c();
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo3590a(Context context, Intent intent);

    /* JADX INFO: renamed from: b */
    public final synchronized void m4036b(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f2996a.m3878c("unregisterListener", new Object[0]);
        C5173av.m3912a(stateUpdatedListener, "Unregistered Play Core listener should not be null.");
        this.f2997b.remove(stateUpdatedListener);
        m4031c();
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m4033a(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f2996a.m3878c("registerListener", new Object[0]);
        C5173av.m3912a(stateUpdatedListener, "Registered Play Core listener should not be null.");
        this.f2997b.add(stateUpdatedListener);
        m4031c();
    }

    /* JADX INFO: renamed from: b */
    public final synchronized boolean m4037b() {
        return this.f3000e != null;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m4034a(StateT statet) {
        Iterator it = new HashSet(this.f2997b).iterator();
        while (it.hasNext()) {
            ((StateUpdatedListener) it.next()).onStateUpdate(statet);
        }
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m4035a(boolean z) {
        this.f3001f = z;
        m4031c();
    }
}
