package com.google.android.gms.internal.auth;

import androidx.compose.runtime.AbstractC1974b;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzdl implements zzdj {

    @CheckForNull
    volatile zzdj zza;
    volatile boolean zzb;

    @CheckForNull
    Object zzc;

    public zzdl(zzdj zzdjVar) {
        zzdjVar.getClass();
        this.zza = zzdjVar;
    }

    public final String toString() {
        Object objM1320m = this.zza;
        StringBuilder sb = new StringBuilder("Suppliers.memoize(");
        if (objM1320m == null) {
            objM1320m = AbstractC1974b.m1320m(new StringBuilder("<supplier that returned "), this.zzc, ">");
        }
        return AbstractC1974b.m1320m(sb, objM1320m, ")");
    }

    @Override // com.google.android.gms.internal.auth.zzdj
    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                try {
                    if (!this.zzb) {
                        zzdj zzdjVar = this.zza;
                        zzdjVar.getClass();
                        Object objZza = zzdjVar.zza();
                        this.zzc = objZza;
                        this.zzb = true;
                        this.zza = null;
                        return objZza;
                    }
                } finally {
                }
            }
        }
        return this.zzc;
    }
}
