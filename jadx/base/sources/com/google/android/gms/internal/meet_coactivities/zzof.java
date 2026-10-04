package com.google.android.gms.internal.meet_coactivities;

import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzof implements zznx {
    private final String zza;
    private final Level zzb;
    private final Set zzc;
    private final zzna zzd;
    private final int zze;

    private zzof(String str, boolean z, int i, Level level, boolean z2, Set set, zzna zznaVar) {
        this.zza = "";
        this.zze = 2;
        this.zzb = level;
        this.zzc = set;
        this.zzd = zznaVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zznx
    public final zzmn zza(String str) {
        return new zzoi(this.zza, str, true, 2, this.zzb, this.zzc, this.zzd, null);
    }

    public final zzof zzb(boolean z) {
        Set set = this.zzc;
        zzna zznaVar = this.zzd;
        return new zzof(this.zza, true, 2, Level.OFF, false, set, zznaVar);
    }

    private zzof() {
        this("", true, 2, Level.ALL, false, zzoi.zza, zzoi.zzb);
    }
}
