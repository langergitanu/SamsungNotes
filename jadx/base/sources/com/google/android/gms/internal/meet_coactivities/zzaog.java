package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaog extends zzaoc {
    private zzaog() {
        throw null;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaoc
    public final void zza(zzaoh zzaohVar, int i) {
        synchronized (zzaohVar) {
            zzaohVar.zze = 0;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaoc
    public final boolean zzb(zzaoh zzaohVar, int i, int i2) {
        synchronized (zzaohVar) {
            try {
                if (zzaohVar.zze != 0) {
                    return false;
                }
                zzaohVar.zze = -1;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public /* synthetic */ zzaog(zzaof zzaofVar) {
        super(null);
    }
}
