package com.google.android.gms.internal.meet_coactivities;

import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzabp {
    private int zza;

    public /* synthetic */ zzabp(int i, zzabo zzaboVar) {
        this.zza = i;
    }

    @RequiresApi(34)
    public final zzabp zza(boolean z) {
        this.zza |= 512;
        return this;
    }

    public final zzabp zzb(boolean z) {
        this.zza |= 1;
        return this;
    }

    public final zzabr zzc() {
        return new zzabr(this.zza, null);
    }
}
