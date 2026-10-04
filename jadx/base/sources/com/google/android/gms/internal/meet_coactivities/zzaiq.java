package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaiq implements zzalb {
    final zzaey zza;
    boolean zzb = false;
    final /* synthetic */ zzais zzc;

    public zzaiq(zzais zzaisVar, zzaey zzaeyVar) {
        this.zzc = zzaisVar;
        this.zza = zzaeyVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzalb
    public final zzvy zza(zzvy zzvyVar) {
        Iterator it = this.zzc.zzi.iterator();
        if (!it.hasNext()) {
            return zzvyVar;
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzalb
    public final void zzb(boolean z) {
        zzais.zzC(this.zzc, this.zza, z);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzalb
    public final void zzc() {
        this.zzc.zzh.zza(2, "READY");
        zzabl zzablVar = this.zzc.zzj;
        zzablVar.zzc(new zzain(this));
        zzablVar.zzb();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzalb
    public final void zzd(zzabd zzabdVar) {
        zzwg zzwgVar = this.zzc.zzh;
        zzyi zzyiVarZzc = this.zza.zzc();
        zzais zzaisVar = this.zzc;
        zzwgVar.zzb(2, "{0} SHUTDOWN with {1}", zzyiVarZzc, zzais.zzK(zzabdVar));
        this.zzb = true;
        zzabl zzablVar = this.zzc.zzj;
        zzablVar.zzc(new zzaio(this, zzabdVar));
        zzablVar.zzb();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzalb
    public final void zze() {
        Preconditions.checkState(this.zzb, "transportShutdown() must be called before transportTerminated().");
        this.zzc.zzh.zzb(2, "{0} Terminated", this.zza.zzc());
        this.zzc.zzf.zze(this.zza);
        zzais.zzC(this.zzc, this.zza, false);
        Iterator it = this.zzc.zzi.iterator();
        if (it.hasNext()) {
            this.zza.zzo();
            throw null;
        }
        zzabl zzablVar = this.zzc.zzj;
        zzablVar.zzc(new zzaip(this));
        zzablVar.zzb();
    }
}
