package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzano implements zzaeu {
    final zzanp zza;
    final /* synthetic */ zzanr zzb;

    public zzano(zzanr zzanrVar, zzanp zzanpVar) {
        this.zzb = zzanrVar;
        this.zza = zzanpVar;
    }

    @Nullable
    private static final Integer zza(zzzv zzzvVar) {
        String str = (String) zzzvVar.zzb(zzanr.zzf);
        if (str == null) {
            return null;
        }
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01de  */
    @Override // com.google.android.gms.internal.meet_coactivities.zzaeu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzd(zzabd zzabdVar, zzaet zzaetVar, zzzv zzzvVar) {
        boolean z;
        zzanb zzanbVar;
        synchronized (this.zzb.zzm) {
            try {
                zzanr zzanrVar = this.zzb;
                zzang zzangVar = zzanrVar.zzs;
                zzanp zzanpVar = this.zza;
                zzanpVar.zzb = true;
                if (zzangVar.zzc.contains(zzanpVar)) {
                    ArrayList arrayList = new ArrayList(zzangVar.zzc);
                    arrayList.remove(zzanpVar);
                    zzangVar = new zzang(zzangVar.zzb, Collections.unmodifiableCollection(arrayList), zzangVar.zzd, zzangVar.zzf, zzangVar.zzg, zzangVar.zza, zzangVar.zzh, zzangVar.zze);
                }
                zzanrVar.zzs = zzangVar;
                this.zzb.zzr.zza(zzabdVar.zza());
            } finally {
            }
        }
        if (this.zzb.zzv.decrementAndGet() == Integer.MIN_VALUE) {
            zzabl zzablVar = (zzabl) this.zzb.zzg;
            zzablVar.zzc(new zzank(this));
            zzablVar.zzb();
            return;
        }
        zzanp zzanpVar2 = this.zza;
        if (zzanpVar2.zzc) {
            zzanr.zzV(this.zzb, zzanpVar2);
            if (this.zzb.zzs.zzf == this.zza) {
                this.zzb.zzaj(zzabdVar, zzaetVar, zzzvVar);
                return;
            }
            return;
        }
        zzaet zzaetVar2 = zzaet.MISCARRIED;
        if (zzaetVar == zzaetVar2 && this.zzb.zzu.incrementAndGet() > 1000) {
            zzanr.zzV(this.zzb, this.zza);
            if (this.zzb.zzs.zzf == this.zza) {
                this.zzb.zzaj(zzabd.zzj.zze("Too many transparent retries. Might be a bug in gRPC").zzd(new zzabf(zzabdVar, null)), zzaetVar, zzzvVar);
                return;
            }
            return;
        }
        if (this.zzb.zzs.zzf == null) {
            if (zzaetVar == zzaetVar2 || (zzaetVar == zzaet.REFUSED && this.zzb.zzt.compareAndSet(false, true))) {
                zzanp zzanpVarZzae = this.zzb.zzae(this.zza.zzd, true);
                if (zzanpVarZzae != null) {
                    zzanr zzanrVar2 = this.zzb;
                    if (zzanrVar2.zzl) {
                        synchronized (zzanrVar2.zzm) {
                            zzanr zzanrVar3 = this.zzb;
                            zzang zzangVar2 = zzanrVar3.zzs;
                            zzanp zzanpVar3 = this.zza;
                            ArrayList arrayList2 = new ArrayList(zzangVar2.zzd);
                            arrayList2.remove(zzanpVar3);
                            arrayList2.add(zzanpVarZzae);
                            zzanrVar3.zzs = new zzang(zzangVar2.zzb, zzangVar2.zzc, Collections.unmodifiableCollection(arrayList2), zzangVar2.zzf, zzangVar2.zzg, zzangVar2.zza, zzangVar2.zzh, zzangVar2.zze);
                        }
                    }
                    this.zzb.zzd.execute(new zzanl(this, zzanpVarZzae));
                    return;
                }
                return;
            }
            if (zzaetVar == zzaet.DROPPED) {
                zzanr zzanrVar4 = this.zzb;
                if (zzanrVar4.zzl) {
                    zzanrVar4.zzai();
                }
            } else {
                this.zzb.zzt.set(true);
                zzanr zzanrVar5 = this.zzb;
                if (zzanrVar5.zzl) {
                    Integer numZza = zza(zzzvVar);
                    boolean zContains = this.zzb.zzk.zzc.contains(zzabdVar.zza());
                    boolean z2 = (this.zzb.zzq == null || (!zContains && (numZza == null || numZza.intValue() >= 0))) ? false : !this.zzb.zzq.zzb();
                    if (zContains && !z2 && !zzabdVar.zzj() && numZza != null && numZza.intValue() > 0) {
                        numZza = 0;
                    }
                    boolean z3 = zContains && !z2;
                    if (z3) {
                        zzanr.zzY(this.zzb, numZza);
                    }
                    synchronized (this.zzb.zzm) {
                        try {
                            zzanr zzanrVar6 = this.zzb;
                            zzang zzangVar3 = zzanrVar6.zzs;
                            zzanp zzanpVar4 = this.zza;
                            ArrayList arrayList3 = new ArrayList(zzangVar3.zzd);
                            arrayList3.remove(zzanpVar4);
                            zzanrVar6.zzs = new zzang(zzangVar3.zzb, zzangVar3.zzc, Collections.unmodifiableCollection(arrayList3), zzangVar3.zzf, zzangVar3.zzg, zzangVar3.zza, zzangVar3.zzh, zzangVar3.zze);
                            if (z3) {
                                zzanr zzanrVar7 = this.zzb;
                                if (!zzanrVar7.zzak(zzanrVar7.zzs)) {
                                    if (!this.zzb.zzs.zzd.isEmpty()) {
                                    }
                                }
                                return;
                            }
                        } finally {
                        }
                    }
                } else {
                    long nanos = 0;
                    if (zzanrVar5.zzj == null) {
                        z = false;
                        if (z) {
                            zzanp zzanpVarZzae2 = this.zzb.zzae(this.zza.zzd + 1, false);
                            if (zzanpVarZzae2 != null) {
                                synchronized (this.zzb.zzm) {
                                    zzanr zzanrVar8 = this.zzb;
                                    zzanbVar = new zzanb(zzanrVar8.zzm);
                                    zzanrVar8.zzz = zzanbVar;
                                }
                                zzanbVar.zzb(this.zzb.zzh.schedule(new zzanj(this, zzanbVar, zzanpVarZzae2), nanos, TimeUnit.NANOSECONDS));
                                return;
                            }
                            return;
                        }
                    } else {
                        boolean zContains2 = zzanrVar5.zzj.zzf.contains(zzabdVar.zza());
                        Integer numZza2 = zza(zzzvVar);
                        boolean z4 = (this.zzb.zzq == null || (!zContains2 && (numZza2 == null || numZza2.intValue() >= 0))) ? false : !this.zzb.zzq.zzb();
                        if (this.zzb.zzj.zza > this.zza.zzd + 1 && !z4) {
                            if (numZza2 == null) {
                                if (zContains2) {
                                    double dNextDouble = zzanr.zzb.nextDouble() * r11.zzB;
                                    zzanr zzanrVar9 = this.zzb;
                                    zzanrVar9.zzB = Math.min((long) (zzanrVar9.zzB * zzanrVar9.zzj.zzd), zzanrVar9.zzj.zzc);
                                    nanos = (long) dNextDouble;
                                    z = true;
                                }
                                z = false;
                            } else {
                                if (numZza2.intValue() >= 0) {
                                    nanos = TimeUnit.MILLISECONDS.toNanos(numZza2.intValue());
                                    zzanr zzanrVar10 = this.zzb;
                                    zzanrVar10.zzB = zzanrVar10.zzj.zzb;
                                    z = true;
                                }
                                z = false;
                            }
                            if (z) {
                            }
                        }
                    }
                }
            }
        }
        zzanr.zzV(this.zzb, this.zza);
        if (this.zzb.zzs.zzf == this.zza) {
            this.zzb.zzaj(zzabdVar, zzaetVar, zzzvVar);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaeu
    public final void zze(zzzv zzzvVar) {
        int i;
        int i2;
        if (this.zza.zzd > 0) {
            zzzq zzzqVar = zzanr.zze;
            zzzvVar.zzd(zzzqVar);
            zzzvVar.zzf(zzzqVar, String.valueOf(this.zza.zzd));
        }
        zzanr.zzV(this.zzb, this.zza);
        if (this.zzb.zzs.zzf == this.zza) {
            zzanr zzanrVar = this.zzb;
            if (zzanrVar.zzq != null) {
                zzanq zzanqVar = zzanrVar.zzq;
                do {
                    i = zzanqVar.zzd.get();
                    i2 = zzanqVar.zza;
                    if (i == i2) {
                        break;
                    }
                } while (!zzanqVar.zzd.compareAndSet(i, Math.min(zzanqVar.zzc + i, i2)));
            }
            zzabl zzablVar = (zzabl) this.zzb.zzg;
            zzablVar.zzc(new zzanh(this, zzzvVar));
            zzablVar.zzb();
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaou
    public final void zzf(zzaot zzaotVar) {
        zzang zzangVar = this.zzb.zzs;
        Preconditions.checkState(zzangVar.zzf != null, "Headers should be received prior to messages.");
        if (zzangVar.zzf != this.zza) {
            zzahv.zze(zzaotVar);
            return;
        }
        zzabl zzablVar = (zzabl) this.zzb.zzg;
        zzablVar.zzc(new zzanm(this, zzaotVar));
        zzablVar.zzb();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaou
    public final void zzg() {
        if (this.zzb.zzn()) {
            zzabl zzablVar = (zzabl) this.zzb.zzg;
            zzablVar.zzc(new zzann(this));
            zzablVar.zzb();
        }
    }
}
