package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzagy implements Runnable {
    final /* synthetic */ zzahb zza;
    private final zzaai zzb;

    public zzagy(zzahb zzahbVar, zzaai zzaaiVar) {
        this.zza = zzahbVar;
        this.zzb = (zzaai) Preconditions.checkNotNull(zzaaiVar, "savedListener");
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        zzagx zzagxVar;
        zzabl zzablVar;
        zzxm zzxmVarZzg;
        zzaaj zzaajVarZzc;
        Logger logger = zzahb.zzg;
        Level level = Level.FINER;
        if (logger.isLoggable(level)) {
            zzahb.zzg.logp(level, "io.grpc.internal.DnsNameResolver$Resolve", "run", "Attempting DNS resolution of ".concat(String.valueOf(this.zza.zzq)));
        }
        zzagv zzagvVarZzi = null;
        try {
            try {
                zzxmVarZzg = zzahb.zzg(this.zza);
                zzaajVarZzc = zzaak.zzc();
            } catch (IOException e) {
                this.zzb.zza(zzabd.zzk.zze("Unable to resolve host " + this.zza.zzq).zzd(e));
            }
            if (zzxmVarZzg != null) {
                if (zzahb.zzg.isLoggable(level)) {
                    zzahb.zzg.logp(level, "io.grpc.internal.DnsNameResolver$Resolve", "run", "Using proxy address " + zzxmVarZzg.toString());
                }
                zzaajVarZzc.zza(Collections.singletonList(zzxmVarZzg));
            } else {
                zzagvVarZzi = this.zza.zzi(false);
                if (zzagvVarZzi.zza != null) {
                    this.zzb.zza(zzagvVarZzi.zza);
                    z = zzagvVarZzi.zza == null;
                    zzablVar = this.zza.zzu;
                    zzagxVar = new zzagx(this, z);
                    zzablVar.zzc(zzagxVar);
                    zzablVar.zzb();
                }
                if (zzagvVarZzi.zzb != null) {
                    zzaajVarZzc.zza(zzagvVarZzi.zzb);
                }
                if (zzagvVarZzi.zzc != null) {
                    zzaajVarZzc.zzc(zzagvVarZzi.zzc);
                }
            }
            this.zzb.zzb(zzaajVarZzc.zzd());
            z = zzagvVarZzi != null && zzagvVarZzi.zza == null;
            zzablVar = this.zza.zzu;
            zzagxVar = new zzagx(this, z);
            zzablVar.zzc(zzagxVar);
            zzablVar.zzb();
        } catch (Throwable th) {
            z = 0 != 0 && null.zza == null;
            zzabl zzablVar2 = this.zza.zzu;
            zzablVar2.zzc(new zzagx(this, z));
            zzablVar2.zzb();
            throw th;
        }
    }
}
