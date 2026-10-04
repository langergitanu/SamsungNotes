package com.google.android.gms.internal.drive;

import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
final class zznc implements Iterator<String> {
    private final /* synthetic */ zzna zzvw;
    private Iterator<String> zzvx;

    public zznc(zzna zznaVar) {
        this.zzvw = zznaVar;
        this.zzvx = zznaVar.zzvt.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzvx.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzvx.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
