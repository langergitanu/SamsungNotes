package com.google.android.gms.internal.meet_coactivities;

import android.content.Context;
import com.google.android.meet.addons.AddonSessionHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzfz extends zzik {
    private Context zza;
    private zzcf zzb;
    private String zzc;
    private zzp zzd;
    private AddonSessionHandler zze;

    @Override // com.google.android.gms.internal.meet_coactivities.zzik
    public final zzik zza(String str) {
        if (str == null) {
            throw new NullPointerException("Null activityName");
        }
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzik
    public final zzik zzb(AddonSessionHandler addonSessionHandler) {
        if (addonSessionHandler == null) {
            throw new NullPointerException("Null addonSessionHandler");
        }
        this.zze = addonSessionHandler;
        return this;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzik
    public final zzik zzc(Context context) {
        if (context == null) {
            throw new NullPointerException("Null appContext");
        }
        this.zza = context;
        return this;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzik
    public final zzik zzd(zzcf zzcfVar) {
        if (zzcfVar == null) {
            throw new NullPointerException("Null ipcManager");
        }
        this.zzb = zzcfVar;
        return this;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzik
    public final zzik zze(zzp zzpVar) {
        if (zzpVar == null) {
            throw new NullPointerException("Null startInfo");
        }
        this.zzd = zzpVar;
        return this;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzik
    public final zzil zzf() {
        zzcf zzcfVar;
        String str;
        zzp zzpVar;
        AddonSessionHandler addonSessionHandler;
        Context context = this.zza;
        if (context != null && (zzcfVar = this.zzb) != null && (str = this.zzc) != null && (zzpVar = this.zzd) != null && (addonSessionHandler = this.zze) != null) {
            return new zzgb(context, zzcfVar, str, zzpVar, addonSessionHandler, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" appContext");
        }
        if (this.zzb == null) {
            sb.append(" ipcManager");
        }
        if (this.zzc == null) {
            sb.append(" activityName");
        }
        if (this.zzd == null) {
            sb.append(" startInfo");
        }
        if (this.zze == null) {
            sb.append(" addonSessionHandler");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
