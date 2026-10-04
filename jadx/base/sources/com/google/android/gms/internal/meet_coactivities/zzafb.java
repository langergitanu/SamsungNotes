package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzafb implements Runnable {
    private final zzxe zza;

    public zzafb(zzxe zzxeVar) {
        this.zza = zzxeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzxe zzxeVarZza = this.zza.zza();
        try {
            zza();
        } finally {
            this.zza.zze(zzxeVarZza);
        }
    }

    public abstract void zza();
}
