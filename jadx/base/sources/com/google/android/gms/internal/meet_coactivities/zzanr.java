package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzanr implements zzaes {
    private static final zzabd zza;
    private static final Random zzb;

    @VisibleForTesting
    static final zzzq zze;

    @VisibleForTesting
    static final zzzq zzf;

    @GuardedBy("lock")
    private zzanb zzA;
    private long zzB;
    private zzabd zzC;
    private boolean zzD;
    private final zzaab zzc;
    private final Executor zzd;
    private final ScheduledExecutorService zzh;
    private final zzzv zzi;

    @Nullable
    private final zzans zzj;

    @Nullable
    private final zzahw zzk;
    private final boolean zzl;
    private final zzana zzn;
    private final long zzo;
    private final long zzp;

    @Nullable
    private final zzanq zzq;
    private zzane zzw;

    @GuardedBy("lock")
    private long zzx;
    private zzaeu zzy;

    @GuardedBy("lock")
    private zzanb zzz;
    private final Executor zzg = new zzabl(new zzami(this));
    private final Object zzm = new Object();

    @GuardedBy("lock")
    private final zzahy zzr = new zzahy();
    private volatile zzang zzs = new zzang(new ArrayList(8), Collections.EMPTY_LIST, null, null, false, false, false, 0);
    private final AtomicBoolean zzt = new AtomicBoolean();
    private final AtomicInteger zzu = new AtomicInteger();
    private final AtomicInteger zzv = new AtomicInteger();

    static {
        zzzo zzzoVar = zzzv.zza;
        zze = zzzq.zzc("grpc-previous-rpc-attempts", zzzoVar);
        zzf = zzzq.zzc("grpc-retry-pushback-ms", zzzoVar);
        zza = zzabd.zzb.zze("Stream thrown away because RetriableStream committed");
        zzb = new Random();
    }

    public zzanr(zzaab zzaabVar, zzzv zzzvVar, zzana zzanaVar, long j, long j2, Executor executor, ScheduledExecutorService scheduledExecutorService, @Nullable zzans zzansVar, @Nullable zzahw zzahwVar, @Nullable zzanq zzanqVar) {
        this.zzc = zzaabVar;
        this.zzn = zzanaVar;
        this.zzo = j;
        this.zzp = j2;
        this.zzd = executor;
        this.zzh = scheduledExecutorService;
        this.zzi = zzzvVar;
        this.zzj = zzansVar;
        if (zzansVar != null) {
            this.zzB = zzansVar.zzb;
        }
        this.zzk = zzahwVar;
        Preconditions.checkArgument(zzansVar == null || zzahwVar == null, "Should not provide both retryPolicy and hedgingPolicy");
        this.zzl = zzahwVar != null;
        this.zzq = zzanqVar;
    }

    public static /* bridge */ /* synthetic */ void zzV(zzanr zzanrVar, zzanp zzanpVar) {
        Runnable runnableZzaf = zzanrVar.zzaf(zzanpVar);
        if (runnableZzaf != null) {
            zzanrVar.zzd.execute(runnableZzaf);
        }
    }

    public static /* bridge */ /* synthetic */ void zzY(zzanr zzanrVar, Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            zzanrVar.zzai();
            return;
        }
        synchronized (zzanrVar.zzm) {
            try {
                zzanb zzanbVar = zzanrVar.zzA;
                if (zzanbVar == null) {
                    return;
                }
                Future futureZza = zzanbVar.zza();
                zzanb zzanbVar2 = new zzanb(zzanrVar.zzm);
                zzanrVar.zzA = zzanbVar2;
                if (futureZza != null) {
                    futureZza.cancel(false);
                }
                zzanbVar2.zzb(zzanrVar.zzh.schedule(new zzand(zzanrVar, zzanbVar2), num.intValue(), TimeUnit.MILLISECONDS));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public final zzanp zzae(int i, boolean z) {
        int i2;
        do {
            i2 = this.zzv.get();
            if (i2 < 0) {
                return null;
            }
        } while (!this.zzv.compareAndSet(i2, i2 + 1));
        zzanp zzanpVar = new zzanp(i);
        zzamv zzamvVar = new zzamv(this, new zzamz(this, zzanpVar));
        zzzv zzzvVar = this.zzi;
        zzzv zzzvVar2 = new zzzv();
        zzzvVar2.zze(zzzvVar);
        if (i > 0) {
            zzzvVar2.zzf(zze, String.valueOf(i));
        }
        zzanpVar.zza = zzp(zzzvVar2, zzamvVar, i, z);
        return zzanpVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckReturnValue
    @Nullable
    public final Runnable zzaf(zzanp zzanpVar) {
        List list;
        Collection collectionSingleton;
        boolean z;
        Future future;
        Future future2;
        synchronized (this.zzm) {
            try {
                if (this.zzs.zzf != null) {
                    return null;
                }
                Collection collection = this.zzs.zzc;
                zzang zzangVar = this.zzs;
                Preconditions.checkState(zzangVar.zzf == null, "Already committed");
                List list2 = zzangVar.zzb;
                if (zzangVar.zzc.contains(zzanpVar)) {
                    list = null;
                    collectionSingleton = Collections.singleton(zzanpVar);
                    z = true;
                } else {
                    list = list2;
                    collectionSingleton = Collections.EMPTY_LIST;
                    z = false;
                }
                this.zzs = new zzang(list, collectionSingleton, zzangVar.zzd, zzanpVar, zzangVar.zzg, z, zzangVar.zzh, zzangVar.zze);
                this.zzn.zza(-this.zzx);
                zzanb zzanbVar = this.zzz;
                boolean z2 = zzanbVar != null ? zzanbVar.zzc : false;
                if (zzanbVar != null) {
                    Future futureZza = zzanbVar.zza();
                    this.zzz = null;
                    future = futureZza;
                } else {
                    future = null;
                }
                zzanb zzanbVar2 = this.zzA;
                if (zzanbVar2 != null) {
                    Future futureZza2 = zzanbVar2.zza();
                    this.zzA = null;
                    future2 = futureZza2;
                } else {
                    future2 = null;
                }
                return new zzamk(this, collection, zzanpVar, future, z2, future2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void zzag(zzamy zzamyVar) {
        Collection collection;
        synchronized (this.zzm) {
            try {
                if (!this.zzs.zza) {
                    this.zzs.zzb.add(zzamyVar);
                }
                collection = this.zzs.zzc;
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zzamyVar.zza((zzanp) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0037, code lost:
    
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0039, code lost:
    
        r10 = (com.google.android.gms.internal.meet_coactivities.zzabl) r9.zzg;
        r10.zzc(r1);
        r10.zzb();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
    
        if (r4 != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0046, code lost:
    
        r10.zza.zzl(new com.google.android.gms.internal.meet_coactivities.zzano(r9, r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
    
        r0 = r10.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
    
        if (r9.zzs.zzf != r10) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
    
        r10 = r9.zzC;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
    
        r10 = com.google.android.gms.internal.meet_coactivities.zzanr.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
    
        r0.zzb(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0060, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
    
        r2 = r3.size();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0093, code lost:
    
        if (r5 >= r2) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0095, code lost:
    
        r6 = (com.google.android.gms.internal.meet_coactivities.zzamy) r3.get(r5);
        r6.zza(r10);
        r4 = r4 | (r6 instanceof com.google.android.gms.internal.meet_coactivities.zzanf);
        r6 = r9.zzs;
        r8 = r6.zzf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a5, code lost:
    
        if (r8 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a7, code lost:
    
        if (r8 != r10) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a9, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ad, code lost:
    
        if (r6.zzg == false) goto L62;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzah(zzanp zzanpVar) {
        int iMin;
        zzamw zzamwVar = null;
        int i = 0;
        boolean z = false;
        ArrayList arrayList = null;
        while (true) {
            synchronized (this.zzm) {
                try {
                    zzang zzangVar = this.zzs;
                    zzanp zzanpVar2 = zzangVar.zzf;
                    if (zzanpVar2 == null || zzanpVar2 == zzanpVar) {
                        if (!zzangVar.zzg) {
                            if (i == zzangVar.zzb.size()) {
                                this.zzs = zzangVar.zzc(zzanpVar);
                                if (!zzn()) {
                                    return;
                                } else {
                                    zzamwVar = new zzamw(this);
                                }
                            } else {
                                if (zzanpVar.zzb) {
                                    return;
                                }
                                iMin = Math.min(i + 128, zzangVar.zzb.size());
                                if (arrayList == null) {
                                    arrayList = new ArrayList(zzangVar.zzb.subList(i, iMin));
                                } else {
                                    arrayList.clear();
                                    arrayList.addAll(zzangVar.zzb.subList(i, iMin));
                                }
                            }
                        }
                    }
                } finally {
                }
            }
            i = iMin;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzai() {
        Future future;
        synchronized (this.zzm) {
            try {
                zzanb zzanbVar = this.zzA;
                future = null;
                if (zzanbVar != null) {
                    Future futureZza = zzanbVar.zza();
                    this.zzA = null;
                    future = futureZza;
                }
                this.zzs = this.zzs.zzb();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaj(zzabd zzabdVar, zzaet zzaetVar, zzzv zzzvVar) {
        this.zzw = new zzane(zzabdVar, zzaetVar, zzzvVar);
        if (this.zzv.addAndGet(Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            zzabl zzablVar = (zzabl) this.zzg;
            zzablVar.zzc(new zzamx(this, zzabdVar, zzaetVar, zzzvVar));
            zzablVar.zzb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("lock")
    public final boolean zzak(zzang zzangVar) {
        return zzangVar.zzf == null && zzangVar.zze < this.zzk.zza && !zzangVar.zzh;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zza(zzahy zzahyVar) {
        zzang zzangVar;
        synchronized (this.zzm) {
            zzahyVar.zzb("closed", this.zzr);
            zzangVar = this.zzs;
        }
        if (zzangVar.zzf != null) {
            zzahy zzahyVar2 = new zzahy();
            zzangVar.zzf.zza.zza(zzahyVar2);
            zzahyVar.zzb("committed", zzahyVar2);
            return;
        }
        zzahy zzahyVar3 = new zzahy();
        for (zzanp zzanpVar : zzangVar.zzc) {
            zzahy zzahyVar4 = new zzahy();
            zzanpVar.zza.zza(zzahyVar4);
            zzahyVar3.zza(zzahyVar4);
        }
        zzahyVar.zzb(AbstractCircuitBreaker.PROPERTY_NAME, zzahyVar3);
    }

    public final void zzaa(Object obj) {
        zzang zzangVar = this.zzs;
        if (zzangVar.zza) {
            zzangVar.zzf.zza.zzm(this.zzc.zzc(obj));
        } else {
            zzag(new zzamu(this, obj));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzb(zzabd zzabdVar) {
        zzanp zzanpVar;
        zzanp zzanpVar2 = new zzanp(0);
        zzanpVar2.zza = new zzald();
        Runnable runnableZzaf = zzaf(zzanpVar2);
        if (runnableZzaf != null) {
            synchronized (this.zzm) {
                this.zzs = this.zzs.zzc(zzanpVar2);
            }
            runnableZzaf.run();
            zzaj(zzabdVar, zzaet.PROCESSED, new zzzv());
            return;
        }
        synchronized (this.zzm) {
            try {
                if (this.zzs.zzc.contains(this.zzs.zzf)) {
                    zzanpVar = this.zzs.zzf;
                } else {
                    this.zzC = zzabdVar;
                    zzanpVar = null;
                }
                zzang zzangVar = this.zzs;
                this.zzs = new zzang(zzangVar.zzb, zzangVar.zzc, zzangVar.zzd, zzangVar.zzf, true, zzangVar.zza, zzangVar.zzh, zzangVar.zze);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zzanpVar != null) {
            zzanpVar.zza.zzb(zzabdVar);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zzc() {
        zzang zzangVar = this.zzs;
        if (zzangVar.zza) {
            zzangVar.zzf.zza.zzc();
        } else {
            zzag(new zzamo(this));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzd() {
        zzag(new zzamp(this));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zze() {
        zzag(new zzams(this));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zzf(int i) {
        zzang zzangVar = this.zzs;
        if (zzangVar.zza) {
            zzangVar.zzf.zza.zzf(i);
        } else {
            zzag(new zzamt(this, i));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zzg(zzwv zzwvVar) {
        zzag(new zzaml(this, zzwvVar));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzh(zzxi zzxiVar) {
        zzag(new zzamm(this, zzxiVar));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzi(zzxl zzxlVar) {
        zzag(new zzamn(this, zzxlVar));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzj(int i) {
        zzag(new zzamq(this, i));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzk(int i) {
        zzag(new zzamr(this, i));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzl(zzaeu zzaeuVar) {
        zzanb zzanbVar;
        zzanq zzanqVar;
        this.zzy = zzaeuVar;
        zzabd zzabdVarZzo = zzo();
        if (zzabdVarZzo != null) {
            zzb(zzabdVarZzo);
            return;
        }
        synchronized (this.zzm) {
            this.zzs.zzb.add(new zzanf(this));
        }
        zzanp zzanpVarZzae = zzae(0, false);
        if (zzanpVarZzae == null) {
            return;
        }
        if (this.zzl) {
            synchronized (this.zzm) {
                try {
                    this.zzs = this.zzs.zza(zzanpVarZzae);
                    zzanbVar = null;
                    if (zzak(this.zzs) && ((zzanqVar = this.zzq) == null || zzanqVar.zza())) {
                        zzanbVar = new zzanb(this.zzm);
                        this.zzA = zzanbVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (zzanbVar != null) {
                zzanbVar.zzb(this.zzh.schedule(new zzand(this, zzanbVar), this.zzk.zzb, TimeUnit.NANOSECONDS));
            }
        }
        zzah(zzanpVarZzae);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zzm(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final boolean zzn() {
        Iterator it = this.zzs.zzc.iterator();
        while (it.hasNext()) {
            if (((zzanp) it.next()).zza.zzn()) {
                return true;
            }
        }
        return false;
    }

    @CheckReturnValue
    @Nullable
    public abstract zzabd zzo();

    public abstract zzaes zzp(zzzv zzzvVar, zzwn zzwnVar, int i, boolean z);

    public abstract void zzq();
}
