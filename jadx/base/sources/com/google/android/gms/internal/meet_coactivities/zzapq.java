package com.google.android.gms.internal.meet_coactivities;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import java.util.logging.Level;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapq {
    final /* synthetic */ zzaps zza;
    private final Object zzb;
    private final zzzd zzc;
    private zzwz zzd = zzwz.CONNECTING;
    private zzzb zze;

    public zzapq(zzaps zzapsVar, Object obj, zzyr zzyrVar, Object obj2, zzzb zzzbVar) {
        this.zza = zzapsVar;
        this.zzb = obj;
        this.zze = zzzbVar;
        this.zzc = zzyrVar.zza(new zzapp(this));
    }

    public final String toString() {
        String string = Arrays.toString(((zzapr) this.zzb).zza);
        String strValueOf = String.valueOf(this.zzd);
        return AbstractC2322a.m1626p(AbstractC0000a.m16m("Address = ", string, ", state = ", strValueOf, ", picker type: "), String.valueOf(this.zze.getClass()), ", lb: ", String.valueOf(this.zzc));
    }

    public final zzwz zza() {
        return this.zzd;
    }

    @VisibleForTesting
    public final zzzb zzb() {
        return this.zze;
    }

    public final void zzg() {
        this.zzc.zze();
        this.zzd = zzwz.SHUTDOWN;
        zzaps.zzh.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer$ChildLbState", "shutdown", "Child balancer {0} deleted", this.zzb);
    }
}
