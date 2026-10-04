package com.google.android.gms.internal.meet_coactivities;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzagj implements Runnable {
    final /* synthetic */ InputStream zza;
    final /* synthetic */ zzags zzb;

    public zzagj(zzags zzagsVar, InputStream inputStream) {
        this.zza = inputStream;
        this.zzb = zzagsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc.zzm(this.zza);
    }
}
