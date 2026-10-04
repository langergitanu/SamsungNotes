package com.google.android.gms.internal.meet_coactivities;

import java.util.Arrays;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzlg implements zzlq, zzml {
    private static final String zza = new String();
    private final Level zzb;
    private final long zzc;
    private zzlf zzd;
    private zzlk zze;
    private zzlz zzf;
    private zznu zzg;
    private Object[] zzh;

    public zzlg(Level level, boolean z) {
        long jZzb = zznr.zzb();
        this.zzd = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = null;
        this.zzh = null;
        zzpi.zza(level, "level");
        this.zzb = level;
        this.zzc = jZzb;
    }

    private final void zzx(String str, Object... objArr) {
        this.zzh = objArr;
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj instanceof zzlb) {
                objArr[i] = ((zzlb) obj).zza();
            }
        }
        if (str != zza) {
            this.zzg = new zznu(zza(), str);
        }
        zzov zzovVarZzk = zznr.zzk();
        if (!zzovVarZzk.zze()) {
            zzmr zzmrVarZzi = zzi();
            zzlt zzltVar = zzle.zzh;
            zzov zzovVar = (zzov) zzmrVarZzi.zzc(zzltVar);
            if (zzovVar != null) {
                zzovVarZzk = zzovVarZzk.zzb(zzovVar);
            }
            zzm(zzltVar, zzovVarZzk);
        }
        zzc().zzg(this);
    }

    private final boolean zzy() {
        if (this.zze == null) {
            this.zze = zznr.zzg().zza(zzlg.class, 1);
        }
        zzll zzllVarZzb = this.zze;
        if (zzllVarZzb != zzlk.zza) {
            zzlf zzlfVar = this.zzd;
            if (zzlfVar != null && zzlfVar.zza() > 0) {
                zzpi.zza(zzllVarZzb, "logSiteKey");
                int iZza = zzlfVar.zza();
                for (int i = 0; i < iZza; i++) {
                    if (zzle.zzf.equals(zzlfVar.zzb(i))) {
                        Object objZzd = zzlfVar.zzd(i);
                        zzllVarZzb = objZzd instanceof zzlr ? ((zzlr) objZzd).zzb() : zzmd.zza(zzllVarZzb, objZzd);
                    }
                }
            }
        } else {
            zzllVarZzb = null;
        }
        boolean zZzb = zzb(zzllVarZzb);
        zzlz zzlzVar = this.zzf;
        if (zzlzVar == null) {
            return zZzb;
        }
        int iZza2 = zzly.zza(zzlzVar, zzllVarZzb, this.zzd);
        if (zZzb && iZza2 > 0) {
            this.zzd.zze(zzle.zze, Integer.valueOf(iZza2));
        }
        return zZzb & (iZza2 >= 0);
    }

    public abstract zzpe zza();

    public boolean zzb(zzll zzllVar) {
        zzlf zzlfVar = this.zzd;
        if (zzlfVar != null) {
            if (zzllVar != null) {
                zzlz zzlzVarZzc = zzlz.zzc(zzlz.zzc(zzkt.zza(zzlfVar, zzllVar, this.zzc), zzkq.zza(this.zzd, zzllVar)), zzmc.zza(this.zzd, zzllVar));
                this.zzf = zzlzVarZzc;
                if (zzlzVarZzc == zzlz.zzc) {
                    return false;
                }
            }
            zzlf zzlfVar2 = this.zzd;
            zzlt zzltVar = zzle.zzi;
            zzme zzmeVar = (zzme) zzlfVar2.zzc(zzltVar);
            if (zzmeVar != null) {
                zzlf zzlfVar3 = this.zzd;
                if (zzlfVar3 != null) {
                    zzlfVar3.zzf(zzltVar);
                }
                zzmr zzmrVarZzi = zzi();
                zzlt zzltVar2 = zzle.zza;
                zzm(zzltVar2, new zzlo((Throwable) zzmrVarZzi.zzc(zzltVar2), zzmeVar, zzph.zzb(zzlg.class, zzmeVar.zza(), 1)));
            }
        }
        return true;
    }

    public abstract zzko zzc();

    public abstract zzlq zzd();

    @Override // com.google.android.gms.internal.meet_coactivities.zzml
    public final long zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzml
    public final zzlk zzf() {
        zzlk zzlkVar = this.zze;
        if (zzlkVar != null) {
            return zzlkVar;
        }
        throw new IllegalStateException("cannot request log site information prior to postProcess()");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlq
    public final zzlq zzg(Throwable th) {
        zzlt zzltVar = zzle.zza;
        zzpi.zza(zzltVar, "metadata key");
        if (th != null) {
            zzm(zzltVar, th);
        }
        return zzd();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlq
    public final zzlq zzh(String str, String str2, int i, String str3) {
        zzlj zzljVar = new zzlj(str, str2, i, str3, null);
        if (this.zze == null) {
            this.zze = zzljVar;
        }
        return zzd();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzml
    public final zzmr zzi() {
        zzlf zzlfVar = this.zzd;
        return zzlfVar != null ? zzlfVar : zzmr.zzg();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzml
    public final zznu zzj() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzml
    public final Object zzk() {
        if (this.zzg == null) {
            return this.zzh[0];
        }
        throw new IllegalStateException("cannot get literal argument if a template context exists");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzml
    public final Level zzl() {
        return this.zzb;
    }

    public final void zzm(zzlt zzltVar, Object obj) {
        if (this.zzd == null) {
            this.zzd = new zzlf();
        }
        this.zzd.zze(zzltVar, obj);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlq
    public final void zzn() {
        if (zzy()) {
            zzx(zza, "");
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlq
    public final void zzo(String str) {
        if (zzy()) {
            zzx(zza, str);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlq
    public final void zzp(String str, Object obj) {
        if (zzy()) {
            zzx(str, obj);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlq
    public final void zzq(String str, long j, Object obj) {
        if (zzy()) {
            zzx(str, Long.valueOf(j), obj);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlq
    public final void zzr(String str, Object obj, long j) {
        if (zzy()) {
            zzx("%s long version code is: %s", obj, Long.valueOf(j));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlq
    public final void zzs(String str, Object obj, Object obj2) {
        if (zzy()) {
            zzx(str, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlq
    public final void zzt(String str, Object obj, Object obj2, Object obj3) {
        if (zzy()) {
            zzx(str, obj, obj2, obj3);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlq
    public final void zzu(String str, Object[] objArr) {
        if (zzy()) {
            zzx(str, Arrays.copyOf(objArr, 0));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzml
    public final boolean zzv() {
        zzlf zzlfVar = this.zzd;
        return zzlfVar != null && Boolean.TRUE.equals(zzlfVar.zzc(zzle.zzg));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzml
    public final Object[] zzw() {
        if (this.zzg != null) {
            return this.zzh;
        }
        throw new IllegalStateException("cannot get arguments unless a template context exists");
    }
}
