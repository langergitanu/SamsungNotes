package com.google.android.gms.internal.meet_coactivities;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpk implements Closeable {
    private static final ThreadLocal zza = new zzpj();
    private int zzb = 0;

    public static int zza() {
        return ((zzpk) zza.get()).zzb;
    }

    public static zzpk zzc() {
        zzpk zzpkVar = (zzpk) zza.get();
        int i = zzpkVar.zzb + 1;
        zzpkVar.zzb = i;
        if (i != 0) {
            return zzpkVar;
        }
        throw new AssertionError("Overflow of RecursionDepth (possible error in core library)");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i = this.zzb;
        if (i <= 0) {
            throw new AssertionError("Mismatched calls to RecursionDepth (possible error in core library)");
        }
        this.zzb = i - 1;
    }

    public final int zzb() {
        return this.zzb;
    }
}
