package com.google.android.gms.internal.meet_coactivities;

import javax.annotation.CheckReturnValue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzx {
    private zzzy zza;
    private zzzy zzb;
    private zzzz zzc;
    private String zzd;
    private boolean zze;

    private zzzx() {
        throw null;
    }

    public final zzzx zza(String str) {
        this.zzd = str;
        return this;
    }

    public final zzzx zzb(zzzy zzzyVar) {
        this.zza = zzzyVar;
        return this;
    }

    public final zzzx zzc(zzzy zzzyVar) {
        this.zzb = zzzyVar;
        return this;
    }

    public final zzzx zzd(boolean z) {
        this.zze = true;
        return this;
    }

    public final zzzx zze(zzzz zzzzVar) {
        this.zzc = zzzzVar;
        return this;
    }

    @CheckReturnValue
    public final zzaab zzf() {
        return new zzaab(this.zzc, this.zzd, this.zza, this.zzb, null, false, false, this.zze, null);
    }

    public /* synthetic */ zzzx(zzzw zzzwVar) {
    }
}
