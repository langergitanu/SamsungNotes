package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaoq implements zzale {
    private final zzaoo zza;

    private zzaoq(zzaoo zzaooVar) {
        this.zza = zzaooVar;
    }

    public static zzaoq zzc(zzaoo zzaooVar) {
        return new zzaoq(zzaooVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzale
    public final Object zza() {
        return zzaop.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzale
    public final Object zzb(Object obj) {
        zzaop.zzc(this.zza, obj);
        return null;
    }
}
