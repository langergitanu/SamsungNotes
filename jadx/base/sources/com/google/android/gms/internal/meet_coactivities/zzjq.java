package com.google.android.gms.internal.meet_coactivities;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.time.Duration;
import java.util.Map;
import java.util.function.UnaryOperator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjq extends zzjs {
    private final zzgg zzf;
    private zzji zzg;

    private zzjq(String str, long j, zzgg zzggVar) {
        super(str, j, zzqj.zze(), new zzjf(ImmutableMap.m4321of()));
        this.zzf = zzggVar;
    }

    public static zzjq zza(String str, long j, zzpq zzpqVar, zzgg zzggVar) {
        zzjq zzjqVar = new zzjq(str, j, zzggVar);
        synchronized (zzjqVar.zza) {
            zzjqVar.zzg = new zzji(zzpqVar);
        }
        return zzjqVar;
    }

    private final zzpx zzl() {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        UnmodifiableIterator it = ((zzjp) this.zze).zza().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.put(Integer.valueOf(((zzql) entry.getKey()).zza()), (zzqo) entry.getValue());
        }
        String str = this.zzb;
        zzpw zzpwVarZzc = zzpx.zzc();
        zzpwVarZzc.zzb(str);
        zzpwVarZzc.zzd(this.zzc);
        zzqk zzqkVarZzb = zzqp.zzb();
        zzqkVarZzb.zzd((zzqj) this.zzd);
        zzqkVarZzb.zza(builder.buildOrThrow());
        zzpwVarZzc.zzf(zzqkVarZzb);
        zzpwVarZzc.zzc(zzi());
        return (zzpx) zzpwVarZzc.zzk();
    }

    public final zzju zzb(UnaryOperator unaryOperator, zzql zzqlVar) {
        int iZzk;
        zzpx zzpxVarZzl;
        synchronized (this.zza) {
            iZzk = zzk((zzqj) unaryOperator.apply((zzqj) this.zzd), 1);
            zzpxVarZzl = zzl();
        }
        zzqk zzqkVarZzb = zzqp.zzb();
        zzqkVarZzb.zzb(zzqlVar);
        zzqp zzqpVar = (zzqp) zzqkVarZzb.zzm();
        zzpw zzpwVar = (zzpw) zzpxVarZzl.zzB();
        zzpwVar.zza(zzqpVar);
        return new zzjh(iZzk, (zzpx) zzpwVar.zzk());
    }

    public final zzpx zzc(Duration duration) {
        zzpx zzpxVarZzl;
        zzsg zzsgVarZza;
        synchronized (this.zza) {
            zzpxVarZzl = zzl();
            zzsgVarZza = zzvt.zza(this.zzg.zza((zzqj) zzg().zzb()));
        }
        zzsg zzsgVarZza2 = zzvt.zza(duration);
        zzqk zzqkVarZzb = zzqp.zzb();
        zzqi zzqiVarZzc = zzqj.zzc();
        zzqiVarZzc.zze(zzsgVarZza);
        zzqiVarZzc.zzb(zzsgVarZza2);
        zzqkVarZzb.zzc(zzqiVarZzc);
        zzqp zzqpVar = (zzqp) zzqkVarZzb.zzm();
        zzpw zzpwVar = (zzpw) zzpxVarZzl.zzB();
        zzpwVar.zzg(true);
        zzpwVar.zza(zzqpVar);
        return (zzpx) zzpwVar.zzk();
    }

    public final zzsg zzd() {
        zzsg zzsgVarZza;
        synchronized (this.zza) {
            zzsgVarZza = zzvt.zza(this.zzg.zza((zzqj) zzg().zzb()));
        }
        return zzsgVarZza;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzjs
    public final /* bridge */ /* synthetic */ void zze(Object obj) {
        this.zzg.zzb(zzvt.zzb(((zzqj) obj).zzf()));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzjs
    public final /* bridge */ /* synthetic */ int zzf(Object obj, Object obj2) {
        zzqj zzqjVar = (zzqj) obj;
        zzqj zzqjVar2 = (zzqj) obj2;
        if (zzqjVar != null) {
            zzqi zzqiVar = (zzqi) zzqjVar.zzB();
            zzqiVar.zza();
            zzqj zzqjVar3 = (zzqj) zzqiVar.zzk();
            zzqi zzqiVar2 = (zzqi) zzqjVar2.zzB();
            zzqiVar2.zza();
            return (zzqjVar3.equals(zzqiVar2.zzk()) && zzvt.zzb(zzqjVar.zzf()).minus(zzvt.zzb(zzqjVar2.zzf())).abs().compareTo(this.zzf.zzb()) <= 0) ? 1 : 2;
        }
        return 2;
    }
}
