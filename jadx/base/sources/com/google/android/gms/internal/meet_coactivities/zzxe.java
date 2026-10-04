package com.google.android.gms.internal.meet_coactivities;

import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxe {
    static final Logger zza = Logger.getLogger(zzxe.class.getName());
    public static final zzxe zzb = new zzxe();

    private zzxe() {
    }

    public static zzxe zzb() {
        zzxe zzxeVarZza = zzxc.zza.zza();
        return zzxeVarZza == null ? zzb : zzxeVarZza;
    }

    public static Object zzc(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }

    public final zzxe zza() {
        zzxe zzxeVarZzb = zzxc.zza.zzb(this);
        return zzxeVarZzb == null ? zzb : zzxeVarZzb;
    }

    public final void zzd(zzxb zzxbVar, Executor executor) {
        zzc(executor, "executor");
    }

    public final void zze(zzxe zzxeVar) {
        zzc(zzxeVar, "toAttach");
        zzxc.zza.zzc(this, zzxeVar);
    }
}
