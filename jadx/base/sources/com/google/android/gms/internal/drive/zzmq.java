package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
final class zzmq implements Iterator {
    private int pos;
    private Iterator zzvj;
    private final /* synthetic */ zzmi zzvk;
    private boolean zzvo;

    private zzmq(zzmi zzmiVar) {
        this.zzvk = zzmiVar;
        this.pos = -1;
    }

    private final Iterator zzew() {
        if (this.zzvj == null) {
            this.zzvj = this.zzvk.zzvf.entrySet().iterator();
        }
        return this.zzvj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.pos + 1 < this.zzvk.zzve.size() || (!this.zzvk.zzvf.isEmpty() && zzew().hasNext());
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.zzvo = true;
        int i = this.pos + 1;
        this.pos = i;
        return i < this.zzvk.zzve.size() ? (Map.Entry) this.zzvk.zzve.get(this.pos) : (Map.Entry) zzew().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzvo) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzvo = false;
        this.zzvk.zzeu();
        if (this.pos >= this.zzvk.zzve.size()) {
            zzew().remove();
            return;
        }
        zzmi zzmiVar = this.zzvk;
        int i = this.pos;
        this.pos = i - 1;
        zzmiVar.zzax(i);
    }

    public /* synthetic */ zzmq(zzmi zzmiVar, zzmj zzmjVar) {
        this(zzmiVar);
    }
}
