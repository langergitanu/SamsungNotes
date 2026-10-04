package com.google.android.gms.internal.meet_coactivities;

import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaco {

    @GuardedBy("this")
    private long zza;

    @GuardedBy("this")
    private long zzb;
    private volatile boolean zzc;

    public zzaco(int i) {
    }

    public final synchronized boolean zza(long j) {
        long j2 = this.zzb;
        if (j2 - j >= 0) {
            j = j2;
        }
        this.zzb = j;
        if (this.zza - j >= 131072 || !this.zzc) {
            return false;
        }
        this.zzc = false;
        return true;
    }

    public final boolean zzb() {
        return this.zzc;
    }

    public final synchronized boolean zzc(long j) {
        long j2 = this.zza + j;
        this.zza = j2;
        if (j2 - this.zzb < 131072 || this.zzc) {
            return false;
        }
        this.zzc = true;
        return true;
    }
}
