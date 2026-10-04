package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzakf extends zzwe {
    final /* synthetic */ zzakn zza;
    private final String zzc;
    private final AtomicReference zzb = new AtomicReference(zzakn.zzg);
    private final zzwe zzd = new zzajx(this);

    public /* synthetic */ zzakf(zzakn zzaknVar, String str, zzake zzakeVar) {
        this.zza = zzaknVar;
        this.zzc = (String) Preconditions.checkNotNull(str, "authority");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzwi zzh(zzaab zzaabVar, zzwd zzwdVar) {
        zzye zzyeVar = (zzye) this.zzb.get();
        if (zzyeVar == null) {
            return this.zzd.zza(zzaabVar, zzwdVar);
        }
        if (!(zzyeVar instanceof zzakz)) {
            return new zzaji(zzyeVar, this.zzd, this.zza.zzr, zzaabVar, zzwdVar);
        }
        zzakx zzakxVarZzb = ((zzakz) zzyeVar).zzb.zzb(zzaabVar);
        if (zzakxVarZzb != null) {
            zzwdVar = zzwdVar.zze(zzakx.zza, zzakxVarZzb);
        }
        return this.zzd.zza(zzaabVar, zzwdVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwe
    public final zzwi zza(zzaab zzaabVar, zzwd zzwdVar) {
        if (this.zzb.get() != zzakn.zzg) {
            return zzh(zzaabVar, zzwdVar);
        }
        zzakn zzaknVar = this.zza;
        zzajy zzajyVar = new zzajy(this);
        zzabl zzablVar = zzaknVar.zzd;
        zzablVar.zzc(zzajyVar);
        zzablVar.zzb();
        if (this.zzb.get() != zzakn.zzg) {
            return zzh(zzaabVar, zzwdVar);
        }
        if (this.zza.zzN.get()) {
            return new zzajz(this);
        }
        zzakd zzakdVar = new zzakd(this, zzxe.zzb(), zzaabVar, zzwdVar);
        zzakn zzaknVar2 = this.zza;
        zzaka zzakaVar = new zzaka(this, zzakdVar);
        zzabl zzablVar2 = zzaknVar2.zzd;
        zzablVar2.zzc(zzakaVar);
        zzablVar2.zzb();
        return zzakdVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwe
    public final String zzb() {
        return this.zzc;
    }

    public final void zzf() {
        if (this.zzb.get() == zzakn.zzg) {
            zzg(null);
        }
    }

    public final void zzg(@Nullable zzye zzyeVar) {
        zzye zzyeVar2 = (zzye) this.zzb.get();
        this.zzb.set(zzyeVar);
        if (zzyeVar2 == zzakn.zzg) {
            zzakn zzaknVar = this.zza;
            if (zzaknVar.zzI != null) {
                Iterator it = zzaknVar.zzI.iterator();
                while (it.hasNext()) {
                    ((zzakd) it.next()).zzl();
                }
            }
        }
    }
}
