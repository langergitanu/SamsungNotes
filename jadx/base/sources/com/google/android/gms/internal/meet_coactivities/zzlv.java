package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzlv extends zzlz {
    final /* synthetic */ zzlz zza;
    final /* synthetic */ zzlz zzb;

    public zzlv(zzlz zzlzVar, zzlz zzlzVar2) {
        this.zza = zzlzVar;
        this.zzb = zzlzVar2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlz
    public final void zzb() {
        try {
            this.zza.zzb();
        } finally {
            this.zzb.zzb();
        }
    }
}
