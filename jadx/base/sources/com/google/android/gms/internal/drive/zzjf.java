package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes5.dex */
abstract class zzjf implements zzjj {
    @Override // java.util.Iterator
    public /* synthetic */ Byte next() {
        return Byte.valueOf(nextByte());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
