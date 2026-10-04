package com.google.android.gms.internal.meet_coactivities;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzabf extends RuntimeException {
    private final zzabd zza;

    public zzabf(zzabd zzabdVar, @Nullable zzzv zzzvVar) {
        super(zzabd.zzf(zzabdVar), zzabdVar.zzh(), true, true);
        this.zza = zzabdVar;
    }

    public final zzabd zza() {
        return this.zza;
    }
}
