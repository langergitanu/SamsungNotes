package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zztu implements zzuc {
    private final zzuc[] zza;

    public zztu(zzuc... zzucVarArr) {
        this.zza = zzucVarArr;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzuc
    public final zzub zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzuc zzucVar = this.zza[i];
            if (zzucVar.zzc(cls)) {
                return zzucVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzuc
    public final boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
