package com.google.android.gms.internal.meet_coactivities;

import android.content.ComponentName;
import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import android.os.UserHandle;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ThreadSafe
public final class zzacj extends zzacl implements zzaey, zzacc {
    private final zzale zzf;
    private final Executor zzg;
    private final zzabz zzh;
    private final zzacd zzi;
    private final AtomicInteger zzj;
    private final zzadi zzk;

    @Nullable
    private zzalb zzl;

    @GuardedBy("this")
    private int zzm;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object, java.util.concurrent.Executor] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.google.android.gms.internal.meet_coactivities.zzach] */
    public zzacj(Context context, zzabv zzabvVar, zzabn zzabnVar, @Nullable UserHandle userHandle, zzabr zzabrVar, Executor executor, zzale zzaleVar, zzale zzaleVar2, zzabz zzabzVar, zzabw zzabwVar, zzacy zzacyVar, zzvy zzvyVar) {
        zzvv zzvvVarZza = zzvy.zza();
        zzvvVarZza.zzb(zzahn.zza, zzaau.NONE);
        zzvvVarZza.zzb(zzahn.zzb, zzvyVar);
        zzvvVarZza.zzb(zzxq.zzb, zzabn.zzb(new ComponentName(context, context.getClass())));
        zzvvVarZza.zzb(zzxq.zza, zzabnVar);
        zzvvVarZza.zzb(zzacl.zzb, zzabwVar);
        super(zzaleVar, zzvvVarZza.zzc(), zzacyVar, zzyi.zzb(zzacj.class, context.getClass().getSimpleName() + "->" + String.valueOf(zzabnVar)), null);
        this.zzm = 1001;
        this.zzf = zzaleVar2;
        this.zzh = zzabzVar;
        this.zzg = zzaleVar2.zza();
        this.zzj = new AtomicInteger();
        this.zzk = new zzadi(Ticker.systemTicker(), new Object(this) { // from class: com.google.android.gms.internal.meet_coactivities.zzach
        });
        this.zzi = new zzadm(executor, context, zzabvVar, zzabnVar.zza(), null, zzabrVar.zza(), this);
    }

    private static zzaes zzA(zzabd zzabdVar, zzvy zzvyVar, zzzv zzzvVar, zzwq[] zzwqVarArr) {
        zzaor.zza(zzwqVarArr, zzvyVar, zzzvVar).zzd();
        return new zzahf(zzabdVar, zzaet.PROCESSED, zzwqVarArr);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzacc
    public final synchronized void zza(IBinder iBinder) {
        zzq(zzadc.zzb(iBinder, this.zzg));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzacc
    public final synchronized void zzb(zzabd zzabdVar) {
        zzs(zzabdVar, true);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaev
    public final synchronized zzaes zzd(zzaab zzaabVar, zzzv zzzvVar, zzwd zzwdVar, zzwq[] zzwqVarArr) throws Throwable {
        Throwable th;
        try {
            try {
                try {
                    if (!zzz(3)) {
                        return zzA(zzw() ? this.zze : zzabd.zzj.zze("newStream() before transportReady()"), this.zzd, zzzvVar, zzwqVarArr);
                    }
                    int i = this.zzm;
                    int i2 = i + 1;
                    this.zzm = i2;
                    if (i2 == 16777215) {
                        this.zzm = 1001;
                    }
                    zzaor zzaorVarZza = zzaor.zza(zzwqVarArr, this.zzd, zzzvVar);
                    zzacp zzacpVar = new zzacp(this, this.zzd, i, !Boolean.TRUE.equals(zzwdVar.zzl(zzahv.zzh)));
                    if (this.zzc.putIfAbsent(Integer.valueOf(i), zzacpVar) != null) {
                        zzabd zzabdVarZze = zzabd.zzj.zze("Clashing call IDs");
                        zzs(zzabdVarZze, true);
                        return zzA(zzabdVarZze, this.zzd, zzzvVar, zzwqVarArr);
                    }
                    if (zzacpVar.zze() && this.zzj.getAndIncrement() == 0) {
                        this.zzl.zzb(true);
                    }
                    zzadd zzaddVar = new zzadd(this, i, zzaabVar, zzzvVar, zzaorVarZza);
                    if (zzaabVar.zzb().zza()) {
                        return new zzadn(zzacpVar, zzaddVar, this.zzd);
                    }
                    return new zzacx(zzacpVar, zzaddVar, this.zzd);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        throw th;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzalc
    @CheckReturnValue
    public final synchronized Runnable zze(zzalb zzalbVar) {
        this.zzl = (zzalb) Preconditions.checkNotNull(zzalbVar);
        return new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzacg
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzi();
            }
        };
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzacl
    @GuardedBy("this")
    public final void zzf(Parcel parcel) {
        this.zzk.zza(parcel.readInt());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzacl
    @GuardedBy("this")
    public final void zzg(Parcel parcel) {
        zzvy zzvyVar = this.zzd;
        int callingUid = Binder.getCallingUid();
        zzvv zzvvVarZzb = zzvyVar.zzb();
        zzvvVarZzb.zzb(zzacl.zza, Integer.valueOf(callingUid));
        zzvvVarZzb.zzb(zzahn.zza, callingUid == Process.myUid() ? zzaau.PRIVACY_AND_INTEGRITY : zzaau.INTEGRITY);
        this.zzd = zzvvVarZzb.zzc();
        if (zzz(2)) {
            int i = parcel.readInt();
            final IBinder strongBinder = parcel.readStrongBinder();
            if (i != 1) {
                zzs(zzabd.zzk.zze("Wire format version mismatch"), true);
            } else if (strongBinder == null) {
                zzs(zzabd.zzk.zze("Malformed SETUP_TRANSPORT data"), true);
            } else {
                this.zzg.execute(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzaci
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzh(strongBinder);
                    }
                });
            }
        }
    }

    public final /* synthetic */ void zzh(IBinder iBinder) {
        Integer num;
        synchronized (this) {
            num = (Integer) this.zzd.zzc(zzacl.zza);
        }
        zzabd zzabdVarZze = num == null ? zzabd.zzf.zze("No remote UID available") : this.zzh.zza(num.intValue());
        synchronized (this) {
            try {
                if (zzz(2)) {
                    if (!zzabdVarZze.zzj()) {
                        zzs(zzabdVarZze, true);
                    } else if (!zzx(zzadc.zzb(iBinder, this.zzg))) {
                        zzs(zzabd.zzk.zze("Failed to observe outgoing binder"), true);
                    } else if (!zzw()) {
                        zzy(3);
                        zzalb zzalbVar = this.zzl;
                        zzvy zzvyVar = this.zzd;
                        zzalbVar.zza(zzvyVar);
                        this.zzd = zzvyVar;
                        this.zzl.zzc();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void zzi() {
        synchronized (this) {
            try {
                if (zzz(1)) {
                    zzy(2);
                    this.zzi.zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzacl
    @GuardedBy("this")
    public final void zzj(zzabd zzabdVar) {
        this.zzl.zzd(zzabdVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzacl
    @GuardedBy("this")
    public final void zzk() {
        if (this.zzj.getAndSet(0) > 0) {
            this.zzl.zzb(false);
        }
        ((zzadm) this.zzi).zzd(zzabd.zzb);
        this.zzl.zze();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzacl
    public final void zzl() {
        super.zzl();
        this.zzf.zzb(this.zzg);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzalc
    public final synchronized void zzm(zzabd zzabdVar) {
        Preconditions.checkNotNull(zzabdVar, "reason");
        zzs(zzabdVar, false);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzacl
    public final void zzn(zzact zzactVar) {
        if (zzactVar.zze() && this.zzj.decrementAndGet() == 0) {
            this.zzl.zzb(false);
        }
        zzt(zzactVar.zzc);
    }
}
