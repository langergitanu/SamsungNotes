package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzox extends zzoy {
    private final zzow zza;

    private zzox(zzmi zzmiVar, int i, zzow zzowVar) {
        super(zzmiVar, i);
        this.zza = zzowVar;
        StringBuilder sb = new StringBuilder("%");
        zzmiVar.zzh(sb);
        sb.append(true != zzmiVar.zzk() ? 't' : 'T');
        sb.append(zzowVar.zza());
    }

    public static zzoy zza(zzow zzowVar, zzmi zzmiVar, int i) {
        return new zzox(zzmiVar, i, zzowVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzoy
    public final void zzb(zzoz zzozVar, Object obj) {
        zzozVar.zze(obj, this.zza, zzd());
    }
}
