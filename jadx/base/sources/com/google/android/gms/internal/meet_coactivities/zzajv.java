package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzajv implements Runnable {
    final /* synthetic */ zzaak zza;
    final /* synthetic */ zzajw zzb;

    public zzajv(zzajw zzajwVar, zzaak zzaakVar) {
        this.zza = zzaakVar;
        this.zzb = zzajwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzala zzalaVar;
        zzajw zzajwVar = this.zzb;
        zzakn zzaknVar = zzajwVar.zzc;
        if (zzaknVar.zzC != zzajwVar.zzb) {
            return;
        }
        zzaak zzaakVar = this.zza;
        List listZze = zzaakVar.zze();
        zzaknVar.zzU.zzb(1, "Resolved address: {0}, config={1}", listZze, zzaakVar.zza());
        zzakn zzaknVar2 = this.zzb.zzc;
        if (zzaknVar2.zzah != 2) {
            zzaknVar2.zzU.zzb(2, "Address resolved: {0}", listZze);
            this.zzb.zzc.zzah = 2;
        }
        zzaak zzaakVar2 = this.zza;
        zzaag zzaagVarZzb = zzaakVar2.zzb();
        zzanv zzanvVar = (zzanv) zzaakVar2.zza().zzc(zzany.zza);
        zzye zzyeVar = (zzye) this.zza.zza().zzc(zzye.zza);
        zzala zzalaVar2 = (zzaagVarZzb == null || zzaagVarZzb.zzd() == null) ? null : (zzala) zzaagVarZzb.zzd();
        zzabd zzabdVarZzc = zzaagVarZzb != null ? zzaagVarZzb.zzc() : null;
        zzakn zzaknVar3 = this.zzb.zzc;
        if (zzaknVar3.zzZ) {
            if (zzalaVar2 != null) {
                if (zzyeVar != null) {
                    zzaknVar3.zzW.zzg(zzyeVar);
                    if (zzalaVar2.zza() != null) {
                        this.zzb.zzc.zzU.zza(1, "Method configs in service config will be discarded due to presence ofconfig-selector");
                    }
                } else {
                    zzaknVar3.zzW.zzg(zzalaVar2.zza());
                }
            } else if (zzabdVarZzc == null) {
                zzalaVar2 = zzakn.zzf;
                zzaknVar3.zzW.zzg(null);
            } else {
                if (!zzaknVar3.zzY) {
                    zzaknVar3.zzU.zza(2, "Fallback to error due to invalid first service config without default config");
                    this.zzb.zza(zzaagVarZzb.zzc());
                    if (zzanvVar != null) {
                        zzanvVar.zza(zzaagVarZzb.zzc());
                        return;
                    }
                    return;
                }
                zzalaVar2 = zzaknVar3.zzX;
            }
            if (!zzalaVar2.equals(this.zzb.zzc.zzX)) {
                this.zzb.zzc.zzU.zzb(2, "Service config changed{0}", zzalaVar2 == zzakn.zzf ? " to empty" : "");
                this.zzb.zzc.zzX = zzalaVar2;
                this.zzb.zzc.zzaf.zza = zzalaVar2.zzc();
            }
            try {
                this.zzb.zzc.zzY = true;
            } catch (RuntimeException e) {
                zzakn.zza.logp(Level.WARNING, "io.grpc.internal.ManagedChannelImpl$NameResolverListener$1NamesResolved", "run", AbstractC0541b.m773o("[", String.valueOf(this.zzb.zzc.zzc()), "] Unexpected exception from parsing service config"), (Throwable) e);
            }
            zzalaVar = zzalaVar2;
        } else {
            if (zzalaVar2 != null) {
                zzaknVar3.zzU.zza(2, "Service config from name resolver discarded by channel settings");
            }
            zzajw zzajwVar2 = this.zzb;
            zzalaVar = zzakn.zzf;
            if (zzyeVar != null) {
                zzajwVar2.zzc.zzU.zza(2, "Config selector from name resolver discarded by channel settings");
            }
            this.zzb.zzc.zzW.zzg(zzalaVar.zza());
        }
        zzaak zzaakVar3 = this.zza;
        zzajw zzajwVar3 = this.zzb;
        zzakn zzaknVar4 = zzajwVar3.zzc;
        zzvy zzvyVarZza = zzaakVar3.zza();
        if (zzajwVar3.zza == zzaknVar4.zzE) {
            zzvv zzvvVarZzb = zzvyVarZza.zzb();
            zzvvVarZzb.zza(zzye.zza);
            Map mapZze = zzalaVar.zze();
            if (mapZze != null) {
                zzvvVarZzb.zzb(zzzd.zza, mapZze);
                zzvvVarZzb.zzc();
            }
            zzvy zzvyVarZzc = zzvvVarZzb.zzc();
            zzadu zzaduVar = this.zzb.zza.zza;
            zzyx zzyxVarZzb = zzyz.zzb();
            zzyxVarZzb.zza(listZze);
            zzyxVarZzb.zzb(zzvyVarZzc);
            zzyxVarZzb.zzc(zzalaVar.zzd());
            zzabd zzabdVarZzb = zzaduVar.zzb(zzyxVarZzb.zzd());
            if (zzanvVar != null) {
                zzanvVar.zza(zzabdVarZzb);
            }
        }
    }
}
