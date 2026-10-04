package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.common.annotations.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@VisibleForTesting
public final class zzadu {
    final /* synthetic */ zzaec zza;
    private final zzyt zzb;
    private zzzd zzc;
    private zzzf zzd;

    public zzadu(zzaec zzaecVar, zzyt zzytVar) {
        this.zza = zzaecVar;
        this.zzb = zzytVar;
        zzzf zzzfVarZza = zzaecVar.zza.zza(zzaecVar.zzb);
        this.zzd = zzzfVarZza;
        if (zzzfVarZza == null) {
            throw new IllegalStateException(AbstractC0541b.m773o("Could not find policy '", zzaecVar.zzb, "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files."));
        }
        this.zzc = zzzfVarZza.zza(zzytVar);
    }

    @VisibleForTesting
    public final zzzd zza() {
        return this.zzc;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzabd zzb(zzyz zzyzVar) {
        zzaoj zzaojVar = (zzaoj) zzyzVar.zzd();
        zzadv zzadvVar = null;
        Object[] objArr = 0;
        if (zzaojVar == null) {
            try {
                zzaec zzaecVar = this.zza;
                zzaojVar = new zzaoj(zzaec.zza(zzaecVar, zzaecVar.zzb, "using default policy"), null);
            } catch (zzaeb e) {
                this.zzb.zze(zzwz.TRANSIENT_FAILURE, new zzadx(zzabd.zzj.zze(e.getMessage())));
                this.zzc.zze();
                this.zzd = null;
                this.zzc = new zzadz(objArr == true ? 1 : 0);
                return zzabd.zza;
            }
        }
        if (this.zzd == null || !zzaojVar.zza.zzd().equals(this.zzd.zzd())) {
            this.zzb.zze(zzwz.CONNECTING, new zzadw(zzadvVar));
            this.zzc.zze();
            zzzf zzzfVar = zzaojVar.zza;
            this.zzd = zzzfVar;
            zzzd zzzdVar = this.zzc;
            this.zzc = zzzfVar.zza(this.zzb);
            ((zzajt) this.zzb).zzb.zzU.zzb(2, "Load balancer changed from {0} to {1}", zzzdVar.getClass().getSimpleName(), this.zzc.getClass().getSimpleName());
        }
        Object obj = zzaojVar.zzb;
        if (obj != null) {
            ((zzajt) this.zzb).zzb.zzU.zzb(1, "Load-balancing config: {0}", obj);
        }
        zzzd zzzdVar2 = this.zzc;
        zzyx zzyxVarZzb = zzyz.zzb();
        zzyxVarZzb.zza(zzyzVar.zze());
        zzyxVarZzb.zzb(zzyzVar.zza());
        zzyxVarZzb.zzc(obj);
        return zzzdVar2.zza(zzyxVarZzb.zzd());
    }

    public final void zzc() {
        this.zzc.zze();
        this.zzc = null;
    }
}
