package com.google.android.gms.internal.meet_coactivities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaga implements zzalc {
    private final Executor zzc;
    private final zzabl zzd;
    private Runnable zze;
    private Runnable zzf;
    private Runnable zzg;
    private zzalb zzh;
    private final zzyi zza = zzyi.zzb(zzaga.class, null);
    private final Object zzb = new Object();

    @Nonnull
    @GuardedBy("lock")
    private Collection zzi = new LinkedHashSet();
    private volatile zzafz zzj = new zzafz();

    public zzaga(Executor executor, zzabl zzablVar) {
        this.zzc = executor;
        this.zzd = zzablVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzym
    public final zzyi zzc() {
        return this.zza;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
    
        r3 = new com.google.android.gms.internal.meet_coactivities.zzafx(r2, r0, r6, null);
        r2.zzi.add(r3);
        r5 = r2.zzb;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
    
        monitor-enter(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
    
        r0 = r2.zzi.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
    
        monitor-exit(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
    
        if (r0 != 1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:
    
        r2.zzd.zzc(r2.zze);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        r5 = r6.length;
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
    
        if (r0 >= r5) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
    
        r1 = r6[r0];
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0070, code lost:
    
        r2.zzd.zzb();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0075, code lost:
    
        return r3;
     */
    @Override // com.google.android.gms.internal.meet_coactivities.zzaev
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzaes zzd(zzaab zzaabVar, zzzv zzzvVar, zzwd zzwdVar, zzwq[] zzwqVarArr) {
        zzaes zzahfVar;
        zzafz zzafzVar;
        zzaev zzaevVarZzb;
        try {
            zzaly zzalyVar = new zzaly(zzaabVar, zzzvVar, zzwdVar, new zzalf(zzwqVarArr));
            zzafz zzafzVar2 = this.zzj;
            while (true) {
                zzabd zzabdVar = zzafzVar2.zzb;
                if (zzabdVar == null) {
                    zzzb zzzbVar = zzafzVar2.zza;
                    if (zzzbVar != null && (zzaevVarZzb = zzahv.zzb(zzzbVar.zza(zzalyVar), zzwdVar.zzo())) != null) {
                        zzahfVar = zzaevVarZzb.zzd(zzalyVar.zzc(), zzalyVar.zzb(), zzalyVar.zza(), zzwqVarArr);
                        break;
                    }
                    synchronized (this.zzb) {
                        try {
                            zzafzVar = this.zzj;
                            if (zzafzVar2 == zzafzVar) {
                                break;
                            }
                        } finally {
                        }
                    }
                } else {
                    zzahfVar = new zzahf(zzabdVar, zzaet.PROCESSED, zzwqVarArr);
                    break;
                }
                zzafzVar2 = zzafzVar;
            }
        } catch (Throwable th) {
            this.zzd.zzb();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzalc
    public final Runnable zze(zzalb zzalbVar) {
        this.zzh = zzalbVar;
        this.zze = new zzafs(this, zzalbVar);
        this.zzf = new zzaft(this, zzalbVar);
        this.zzg = new zzafu(this, zzalbVar);
        return null;
    }

    public final void zzl(@Nullable zzzb zzzbVar) {
        Runnable runnable;
        synchronized (this.zzb) {
            this.zzj = this.zzj.zza(zzzbVar);
            if (zzzbVar != null && zzn()) {
                ArrayList arrayList = new ArrayList(this.zzi);
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    zzafx zzafxVar = (zzafx) arrayList.get(i);
                    zzyv zzyvVarZza = zzzbVar.zza(zzafxVar.zzb);
                    zzwd zzwdVarZza = zzafxVar.zzb.zza();
                    zzaev zzaevVarZzb = zzahv.zzb(zzyvVarZza, zzwdVarZza.zzo());
                    if (zzaevVarZzb != null) {
                        Executor executorZzn = this.zzc;
                        if (zzwdVarZza.zzn() != null) {
                            executorZzn = zzwdVarZza.zzn();
                        }
                        Runnable runnableZzp = zzafx.zzp(zzafxVar, zzaevVarZzb);
                        if (runnableZzp != null) {
                            executorZzn.execute(runnableZzp);
                        }
                        arrayList2.add(zzafxVar);
                    }
                }
                synchronized (this.zzb) {
                    try {
                        if (zzn()) {
                            this.zzi.removeAll(arrayList2);
                            if (this.zzi.isEmpty()) {
                                this.zzi = new LinkedHashSet();
                            }
                            if (!zzn()) {
                                this.zzd.zzc(this.zzf);
                                if (this.zzj.zzb != null && (runnable = this.zzg) != null) {
                                    this.zzd.zzc(runnable);
                                    this.zzg = null;
                                }
                            }
                            this.zzd.zzb();
                        }
                    } finally {
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzalc
    public final void zzm(zzabd zzabdVar) {
        Runnable runnable;
        synchronized (this.zzb) {
            try {
                if (this.zzj.zzb != null) {
                    return;
                }
                this.zzj = this.zzj.zzb(zzabdVar);
                this.zzd.zzc(new zzafv(this, zzabdVar));
                if (!zzn() && (runnable = this.zzg) != null) {
                    this.zzd.zzc(runnable);
                    this.zzg = null;
                }
                this.zzd.zzb();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzn() {
        boolean z;
        synchronized (this.zzb) {
            z = !this.zzi.isEmpty();
        }
        return z;
    }
}
