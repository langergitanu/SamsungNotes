package com.google.android.gms.internal.auth;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzfi extends zzfk {
    public /* synthetic */ zzfi(zzfh zzfhVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.auth.zzfk
    public final void zza(Object obj, long j) {
        ((zzey) zzhi.zzf(obj, j)).zzb();
    }

    @Override // com.google.android.gms.internal.auth.zzfk
    public final void zzb(Object obj, Object obj2, long j) {
        zzey zzeyVarZzd = (zzey) zzhi.zzf(obj, j);
        zzey zzeyVar = (zzey) zzhi.zzf(obj2, j);
        int size = zzeyVarZzd.size();
        int size2 = zzeyVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzeyVarZzd.zzc()) {
                zzeyVarZzd = zzeyVarZzd.zzd(size2 + size);
            }
            zzeyVarZzd.addAll(zzeyVar);
        }
        if (size > 0) {
            zzeyVar = zzeyVarZzd;
        }
        zzhi.zzp(obj, j, zzeyVar);
    }

    private zzfi() {
        super(null);
    }
}
