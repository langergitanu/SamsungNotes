package com.google.android.gms.internal.meet_coactivities;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzui implements zzuq {
    private final zzue zza;
    private final zzve zzb;
    private final boolean zzc;
    private final zzsk zzd;

    private zzui(zzve zzveVar, zzsk zzskVar, zzue zzueVar) {
        this.zzb = zzveVar;
        this.zzc = zzueVar instanceof zzsu;
        this.zzd = zzskVar;
        this.zza = zzueVar;
    }

    public static zzui zzc(zzve zzveVar, zzsk zzskVar, zzue zzueVar) {
        return new zzui(zzveVar, zzskVar, zzueVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzuq
    public final int zza(Object obj) {
        int iZzb = ((zzsy) obj).zzc.zzb();
        return this.zzc ? iZzb + ((zzsu) obj).zzb.zzd() : iZzb;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzuq
    public final int zzb(Object obj) {
        int iHashCode = ((zzsy) obj).zzc.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzsu) obj).zzb.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzuq
    public final Object zze() {
        zzue zzueVar = this.zza;
        return zzueVar instanceof zzsy ? ((zzsy) zzueVar).zzD() : zzueVar.zzR().zzm();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzuq
    public final void zzf(Object obj) {
        this.zzb.zzi(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzuq
    public final void zzg(Object obj, Object obj2) {
        zzus.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzus.zzp(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzuq
    public final void zzh(Object obj, zzup zzupVar, zzsj zzsjVar) {
        this.zzb.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzuq
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzre zzreVar) {
        zzsy zzsyVar = (zzsy) obj;
        if (zzsyVar.zzc == zzvf.zzc()) {
            zzsyVar.zzc = zzvf.zzf();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzuq
    public final void zzj(Object obj, zzvr zzvrVar) {
        Iterator itZzf = ((zzsu) obj).zzb.zzf();
        while (itZzf.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzf.next();
            zzsn zzsnVar = (zzsn) entry.getKey();
            if (zzsnVar.zzc() != zzvq.MESSAGE || zzsnVar.zze() || zzsnVar.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zztl) {
                zzvrVar.zzx(zzsnVar.zza(), ((zztl) entry).zza().zzb());
            } else {
                zzvrVar.zzx(zzsnVar.zza(), entry.getValue());
            }
        }
        ((zzsy) obj).zzc.zzk(zzvrVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzuq
    public final boolean zzk(Object obj, Object obj2) {
        if (!((zzsy) obj).zzc.equals(((zzsy) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzsu) obj).zzb.equals(((zzsu) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzuq
    public final boolean zzl(Object obj) {
        return ((zzsu) obj).zzb.zzj();
    }
}
