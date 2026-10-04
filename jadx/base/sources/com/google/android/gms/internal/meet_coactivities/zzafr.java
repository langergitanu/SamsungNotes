package com.google.android.gms.internal.meet_coactivities;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class zzafr extends zzwi {
    private static final zzwi zza;

    @Nullable
    private final ScheduledFuture zzb;
    private final Executor zzc;
    private final zzxe zzd;
    private volatile boolean zze;
    private zzwh zzf;
    private zzwi zzg;

    @GuardedBy("this")
    private zzabd zzh;

    @GuardedBy("this")
    private List zzi = new ArrayList();

    @GuardedBy("this")
    private zzafq zzj;

    static {
        Logger.getLogger(zzafr.class.getName());
        zza = new zzafk();
    }

    public zzafr(Executor executor, ScheduledExecutorService scheduledExecutorService, @Nullable zzxi zzxiVar) {
        ScheduledFuture<?> scheduledFutureSchedule;
        this.zzc = (Executor) Preconditions.checkNotNull(executor, "callExecutor");
        Preconditions.checkNotNull(scheduledExecutorService, "scheduler");
        this.zzd = zzxe.zzb();
        if (zzxiVar == null) {
            scheduledFutureSchedule = null;
        } else {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long jZzb = zzxiVar.zzb(timeUnit);
            long jAbs = Math.abs(jZzb);
            TimeUnit timeUnit2 = TimeUnit.SECONDS;
            long nanos = jAbs / timeUnit2.toNanos(1L);
            long jAbs2 = Math.abs(jZzb) % timeUnit2.toNanos(1L);
            StringBuilder sb = new StringBuilder();
            if (jZzb < 0) {
                sb.append("ClientCall started after CallOptions deadline was exceeded. Deadline has been exceeded for ");
            } else {
                sb.append("Deadline CallOptions will be exceeded in ");
            }
            sb.append(nanos);
            sb.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
            sb.append("s. ");
            scheduledFutureSchedule = scheduledExecutorService.schedule(new zzafd(this, sb), jZzb, timeUnit);
        }
        this.zzb = scheduledFutureSchedule;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl(zzabd zzabdVar, boolean z) {
        zzwh zzwhVar;
        boolean z2;
        synchronized (this) {
            try {
                if (this.zzg == null) {
                    zzo(zza);
                    zzwhVar = this.zzf;
                    this.zzh = zzabdVar;
                    z2 = false;
                } else {
                    if (z) {
                        return;
                    }
                    zzwhVar = null;
                    z2 = true;
                }
                if (z2) {
                    zzm(new zzafg(this, zzabdVar));
                } else {
                    if (zzwhVar != null) {
                        this.zzc.execute(new zzafl(this, zzwhVar, zzabdVar));
                    }
                    zzn();
                }
                zzk();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void zzm(Runnable runnable) {
        synchronized (this) {
            try {
                if (this.zze) {
                    runnable.run();
                } else {
                    this.zzi.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        if (r0.hasNext() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzn() {
        zzafq zzafqVar;
        List list;
        List arrayList = new ArrayList();
        while (true) {
            synchronized (this) {
                if (this.zzi.isEmpty()) {
                    break;
                }
                list = this.zzi;
                this.zzi = arrayList;
            }
            if (zzafqVar == null) {
                this.zzc.execute(new zzafe(this, zzafqVar));
                return;
            }
            return;
            list.clear();
            arrayList = list;
        }
        this.zzi = null;
        this.zze = true;
        zzafqVar = this.zzj;
        if (zzafqVar == null) {
        }
    }

    @GuardedBy("this")
    private final void zzo(zzwi zzwiVar) {
        zzwi zzwiVar2 = this.zzg;
        Preconditions.checkState(zzwiVar2 == null, "realCall already set to %s", zzwiVar2);
        ScheduledFuture scheduledFuture = this.zzb;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzg = zzwiVar;
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("realCall", this.zzg).toString();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwi
    public final void zza(@Nullable String str, @Nullable Throwable th) {
        zzabd zzabdVar = zzabd.zzb;
        zzabd zzabdVarZze = str != null ? zzabdVar.zze(str) : zzabdVar.zze("Call cancelled without message");
        if (th != null) {
            zzabdVarZze = zzabdVarZze.zzd(th);
        }
        zzl(zzabdVarZze, false);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwi
    public final void zzb() {
        zzm(new zzafj(this));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwi
    public final void zzc(int i) {
        if (this.zze) {
            this.zzg.zzc(i);
        } else {
            zzm(new zzafi(this, i));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwi
    public final void zzd(Object obj) {
        if (this.zze) {
            this.zzg.zzd(obj);
        } else {
            zzm(new zzafh(this, obj));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwi
    public final void zze(zzwh zzwhVar, zzzv zzzvVar) {
        zzabd zzabdVar;
        boolean z;
        Preconditions.checkState(this.zzf == null, "already started");
        synchronized (this) {
            try {
                this.zzf = (zzwh) Preconditions.checkNotNull(zzwhVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                zzabdVar = this.zzh;
                z = this.zze;
                if (!z) {
                    zzafq zzafqVar = new zzafq(zzwhVar);
                    this.zzj = zzafqVar;
                    zzwhVar = zzafqVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zzabdVar != null) {
            this.zzc.execute(new zzafl(this, zzwhVar, zzabdVar));
        } else if (z) {
            this.zzg.zze(zzwhVar, zzzvVar);
        } else {
            zzm(new zzaff(this, zzwhVar, zzzvVar));
        }
    }

    public final Runnable zzh(zzwi zzwiVar) {
        synchronized (this) {
            try {
                if (this.zzg != null) {
                    return null;
                }
                zzo((zzwi) Preconditions.checkNotNull(zzwiVar, NotificationCompat.CATEGORY_CALL));
                return new zzafc(this, this.zzd);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void zzk() {
    }
}
