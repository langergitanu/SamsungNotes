package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzakk extends zzads {
    final zzyq zza;
    final zzyi zzb;
    final zzaej zzc;
    final zzaek zzd;
    List zze;
    zzais zzf;
    boolean zzg;
    boolean zzh;
    zzabk zzi;
    final /* synthetic */ zzakn zzj;

    public zzakk(zzakn zzaknVar, zzyq zzyqVar) {
        this.zzj = zzaknVar;
        Preconditions.checkNotNull(zzyqVar, "args");
        this.zze = zzyqVar.zzc();
        this.zza = zzyqVar;
        zzyi zzyiVarZzc = zzyi.zzc("Subchannel", zzaknVar.zzb());
        this.zzb = zzyiVarZzc;
        zzaek zzaekVar = new zzaek(zzyiVarZzc, 0, zzaknVar.zzv.zza(), "Subchannel for ".concat(String.valueOf(zzyqVar.zzc())));
        this.zzd = zzaekVar;
        this.zzc = new zzaej(zzaekVar, zzaknVar.zzv);
    }

    public final String toString() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzza
    public final Object zza() {
        Preconditions.checkState(this.zzg, "Subchannel is not started");
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzza
    public final void zzb() {
        this.zzj.zzd.zzd();
        Preconditions.checkState(this.zzg, "not started");
        this.zzf.zzh();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzza
    public final void zzc() {
        zzabk zzabkVar;
        this.zzj.zzd.zzd();
        if (this.zzf == null) {
            this.zzh = true;
            return;
        }
        if (!this.zzh) {
            this.zzh = true;
        } else {
            if (!this.zzj.zzO || (zzabkVar = this.zzi) == null) {
                return;
            }
            zzabkVar.zza();
            this.zzi = null;
        }
        zzakn zzaknVar = this.zzj;
        if (zzaknVar.zzO) {
            this.zzf.zzF(zzakn.zzb);
            return;
        }
        this.zzi = zzaknVar.zzd.zza(new zzaiv(new zzakj(this)), 5L, TimeUnit.SECONDS, this.zzj.zzp.zzb());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzza
    public final void zzd(zzzc zzzcVar) {
        this.zzj.zzd.zzd();
        Preconditions.checkState(!this.zzg, "already started");
        Preconditions.checkState(!this.zzh, "already shutdown");
        Preconditions.checkState(!this.zzj.zzO, "Channel is being terminated");
        this.zzg = true;
        zzakn zzaknVar = this.zzj;
        List listZzc = this.zza.zzc();
        String strZzb = zzaknVar.zzb();
        zzahd zzahdVar = zzaknVar.zzai;
        zzaex zzaexVar = zzaknVar.zzp;
        ScheduledExecutorService scheduledExecutorServiceZzb = zzaknVar.zzp.zzb();
        Supplier supplier = this.zzj.zzx;
        zzaki zzakiVar = new zzaki(this, zzzcVar);
        zzakn zzaknVar2 = this.zzj;
        zzxz zzxzVar = zzaknVar2.zzV;
        zzaei zzaeiVarZza = zzaknVar2.zzR.zza();
        zzaek zzaekVar = this.zzd;
        zzyi zzyiVar = this.zzb;
        zzaej zzaejVar = this.zzc;
        zzakn zzaknVar3 = this.zzj;
        zzais zzaisVar = new zzais(listZzc, strZzb, null, zzahdVar, zzaexVar, scheduledExecutorServiceZzb, supplier, zzaknVar3.zzd, zzakiVar, zzxzVar, zzaeiVarZza, zzaekVar, zzyiVar, zzaejVar, zzaknVar3.zzB);
        zzaek zzaekVar2 = this.zzj.zzT;
        zzxv zzxvVar = new zzxv();
        zzxvVar.zza("Child Subchannel started");
        zzxvVar.zzb(zzxw.CT_INFO);
        zzxvVar.zzd(this.zzj.zzv.zza());
        zzxvVar.zzc(zzaisVar);
        zzaekVar2.zzc(zzxvVar.zze());
        this.zzf = zzaisVar;
        this.zzj.zzV.zzd(zzaisVar);
        this.zzj.zzH.add(zzaisVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzza
    public final void zze(List list) {
        this.zzj.zzd.zzd();
        this.zze = list;
        this.zzf.zzG(list);
    }
}
