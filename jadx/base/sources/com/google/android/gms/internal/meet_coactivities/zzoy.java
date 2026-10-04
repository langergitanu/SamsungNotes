package com.google.android.gms.internal.meet_coactivities;

import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzoy {
    private final int zza;
    private final zzmi zzb;

    public zzoy(zzmi zzmiVar, int i) {
        if (zzmiVar == null) {
            throw new IllegalArgumentException("format options cannot be null");
        }
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "invalid index: "));
        }
        this.zza = i;
        this.zzb = zzmiVar;
    }

    public abstract void zzb(zzoz zzozVar, Object obj);

    public final int zzc() {
        return this.zza;
    }

    public final zzmi zzd() {
        return this.zzb;
    }

    public final void zze(zzoz zzozVar, Object[] objArr) {
        int i = this.zza;
        if (i >= objArr.length) {
            zzozVar.zzf();
            return;
        }
        Object obj = objArr[i];
        if (obj != null) {
            zzb(zzozVar, obj);
        } else {
            zzozVar.zzg();
        }
    }
}
