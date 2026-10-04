package com.google.android.gms.internal.meet_coactivities;

import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ThreadSafe
public abstract class zzacl implements IBinder.DeathRecipient, zzacu {

    @GuardedBy("this")
    protected zzvy zzd;

    @GuardedBy("this")
    @Nullable
    protected zzabd zze;
    private final zzale zzg;
    private final ScheduledExecutorService zzh;
    private final zzyi zzi;

    @Nullable
    private zzadc zzl;
    private long zzo;
    private static final Logger zzf = Logger.getLogger(zzacl.class.getName());
    public static final zzvw zza = zzvw.zza("internal:remote-uid");
    public static final zzvw zzb = zzvw.zza("internal:inbound-parcelable-policy");

    @GuardedBy("this")
    private final LinkedHashSet zzk = new LinkedHashSet();

    @GuardedBy("this")
    private int zzp = 1;
    private final zzacv zzj = new zzacv(this);
    protected final ConcurrentHashMap zzc = new ConcurrentHashMap();
    private final zzaco zzm = new zzaco(131072);
    private final AtomicLong zzn = new AtomicLong();

    public /* synthetic */ zzacl(zzale zzaleVar, zzvy zzvyVar, zzacy zzacyVar, zzyi zzyiVar, zzack zzackVar) {
        this.zzg = zzaleVar;
        this.zzd = zzvyVar;
        this.zzi = zzyiVar;
        this.zzh = (ScheduledExecutorService) zzaleVar.zza();
    }

    private static zzabd zza(RemoteException remoteException) {
        return ((remoteException instanceof DeadObjectException) || (remoteException instanceof TransactionTooLargeException)) ? zzabd.zzk.zzd(remoteException) : zzabd.zzj.zzd(remoteException);
    }

    @GuardedBy("this")
    private final void zzb() {
        zzadc zzadcVar = this.zzl;
        if (zzadcVar != null) {
            try {
                zzadcVar.zza.unlinkToDeath(this, 0);
            } catch (NoSuchElementException unused) {
            }
            try {
                zzadg zzadgVarZzc = zzadg.zzc();
                try {
                    zzadgVarZzc.zza().writeInt(0);
                    this.zzl.zza(2, zzadgVarZzc);
                    zzadgVarZzc.close();
                } finally {
                }
            } catch (RemoteException unused2) {
            }
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public final synchronized void binderDied() {
        zzs(zzabd.zzk.zze("binderDied"), true);
    }

    public final zzyi zzc() {
        return this.zzi;
    }

    public abstract void zzj(zzabd zzabdVar);

    public abstract void zzk();

    public void zzl() {
        this.zzg.zzb(this.zzh);
    }

    public void zzn(zzact zzactVar) {
        throw null;
    }

    public final synchronized zzvy zzo() {
        return this.zzd;
    }

    public final void zzp(int i, zzabd zzabdVar) {
        try {
            zzadg zzadgVarZzc = zzadg.zzc();
            try {
                zzadgVarZzc.zza().writeInt(0);
                Parcel parcelZza = zzadgVarZzc.zza();
                int iZza = zzabdVar.zza().zza() << 16;
                String strZzg = zzabdVar.zzg();
                if (strZzg != null && strZzg.length() > 1000) {
                    strZzg = strZzg.substring(0, 1000);
                }
                if (strZzg != null) {
                    iZza |= 32;
                    parcelZza.writeString(strZzg);
                }
                zzado.zzb(zzadgVarZzc.zza(), iZza | 8);
                zzr(i, zzadgVarZzc);
                zzadgVarZzc.close();
            } finally {
            }
        } catch (zzabe e) {
            zzf.logp(Level.FINER, "io.grpc.binder.internal.BinderTransport", "sendOutOfBandClose", "Failed sending oob close transaction", (Throwable) e);
        }
    }

    @GuardedBy("this")
    public final void zzq(zzadc zzadcVar) {
        try {
            zzadg zzadgVarZzc = zzadg.zzc();
            try {
                zzadgVarZzc.zza().writeInt(1);
                zzadgVarZzc.zza().writeStrongBinder(this.zzj);
                zzadcVar.zza(1, zzadgVarZzc);
                zzadgVarZzc.close();
            } finally {
            }
        } catch (RemoteException e) {
            zzs(zza(e), true);
        }
    }

    public final void zzr(int i, zzadg zzadgVar) throws zzabe {
        int iDataSize = zzadgVar.zza().dataSize();
        try {
            this.zzl.zza(i, zzadgVar);
            if (this.zzm.zzc(iDataSize)) {
                zzf.logp(Level.FINE, "io.grpc.binder.internal.BinderTransport", "sendTransaction", "transmit window now full ".concat(toString()));
            }
        } catch (RemoteException e) {
            throw new zzabe(zza(e), null);
        }
    }

    @GuardedBy("this")
    public final void zzs(final zzabd zzabdVar, boolean z) {
        if (!zzw()) {
            this.zze = zzabdVar;
            zzy(4);
            zzj(zzabdVar);
        }
        if (zzz(5)) {
            return;
        }
        if (z || this.zzc.isEmpty()) {
            this.zzj.zza();
            zzy(5);
            zzb();
            final ArrayList arrayList = new ArrayList(this.zzc.values());
            this.zzc.clear();
            this.zzh.execute(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzacf
                @Override // java.lang.Runnable
                public final void run() {
                    zzabd zzabdVar2 = zzabdVar;
                    ArrayList arrayList2 = arrayList;
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        zzact zzactVar = (zzact) arrayList2.get(i);
                        synchronized (zzactVar) {
                            zzactVar.zzg(zzabdVar2);
                        }
                    }
                    zzacl zzaclVar = this.zza;
                    zzaclVar.zzk();
                    zzaclVar.zzl();
                }
            });
        }
    }

    public final void zzt(int i) {
        if (this.zzc.remove(Integer.valueOf(i)) == null || !this.zzc.isEmpty()) {
            return;
        }
        this.zzh.execute(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzace
            @Override // java.lang.Runnable
            public final void run() {
                zzacl zzaclVar = this.zza;
                synchronized (zzaclVar) {
                    try {
                        if (zzaclVar.zzz(4)) {
                            zzaclVar.zzs(zzaclVar.zze, true);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzacu
    public final boolean zzu(int i, Parcel parcel) {
        zzadg zzadgVarZzc;
        try {
            if (i < 1001) {
                synchronized (this) {
                    try {
                        if (i == 1) {
                            zzg(parcel);
                        } else if (i == 2) {
                            zzs(zzabd.zzk.zze("transport shutdown by peer"), true);
                        } else if (i == 3) {
                            if (this.zzm.zza(parcel.readLong())) {
                                zzf.logp(Level.FINE, "io.grpc.binder.internal.BinderTransport", "handleAcknowledgedBytes", "handleAcknowledgedBytes: Transmit Window No-Longer Full. Unblock calls: ".concat(toString()));
                                this.zzk.addAll(this.zzc.keySet());
                                Iterator it = this.zzk.iterator();
                                while (zzv() && it.hasNext()) {
                                    zzact zzactVar = (zzact) this.zzc.get(it.next());
                                    it.remove();
                                    if (zzactVar != null) {
                                        zzactVar.zzm();
                                    }
                                }
                            }
                        } else if (i == 4) {
                            int i2 = parcel.readInt();
                            if (this.zzp == 3) {
                                try {
                                    zzadgVarZzc = zzadg.zzc();
                                    try {
                                        zzadgVarZzc.zza().writeInt(i2);
                                        this.zzl.zza(5, zzadgVarZzc);
                                        zzadgVarZzc.close();
                                    } finally {
                                    }
                                } catch (RemoteException unused) {
                                }
                            }
                        } else {
                            if (i != 5) {
                                return false;
                            }
                            zzf(parcel);
                        }
                    } finally {
                    }
                }
            } else {
                int iDataSize = parcel.dataSize();
                zzact zzactVar2 = (zzact) this.zzc.get(Integer.valueOf(i));
                if (zzactVar2 == null) {
                    synchronized (this) {
                    }
                    zzactVar2 = null;
                }
                if (zzactVar2 != null) {
                    zzactVar2.zzj(parcel);
                }
                if (this.zzn.addAndGet(iDataSize) - this.zzo <= 16384) {
                    return true;
                }
                synchronized (this) {
                    zzadc zzadcVar = (zzadc) Preconditions.checkNotNull(this.zzl);
                    long j = this.zzn.get();
                    this.zzo = j;
                    try {
                        zzadgVarZzc = zzadg.zzc();
                    } catch (RemoteException e) {
                        zzs(zza(e), true);
                    }
                    try {
                        zzadgVarZzc.zza().writeLong(j);
                        zzadcVar.zza(3, zzadgVarZzc);
                        zzadgVarZzc.close();
                    } finally {
                    }
                }
            }
            return true;
        } catch (RuntimeException e2) {
            zzf.logp(Level.SEVERE, "io.grpc.binder.internal.BinderTransport", "handleTransaction", AbstractC0000a.m11h(i, "Terminating transport for uncaught Exception in transaction "), (Throwable) e2);
            synchronized (this) {
                zzs(zzabd.zzj.zzd(e2), true);
                return false;
            }
        }
    }

    public final boolean zzv() {
        return !this.zzm.zzb();
    }

    @GuardedBy("this")
    public final boolean zzw() {
        return zzz(4) || zzz(5);
    }

    @GuardedBy("this")
    public final boolean zzx(zzadc zzadcVar) {
        this.zzl = zzadcVar;
        try {
            zzadcVar.zza.linkToDeath(this, 0);
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    @GuardedBy("this")
    public final void zzy(int i) {
        int i2 = this.zzp;
        int i4 = i - 1;
        if (i4 == 1) {
            Preconditions.checkState(i2 == 1);
        } else if (i4 == 2) {
            Preconditions.checkState(i2 == 1 || i2 == 2);
        } else if (i4 != 3) {
            Preconditions.checkState(i2 == 4);
        } else {
            Preconditions.checkState(i2 == 1 || i2 == 2 || i2 == 3);
        }
        this.zzp = i;
    }

    @GuardedBy("this")
    public final boolean zzz(int i) {
        return this.zzp == i;
    }

    @GuardedBy("this")
    public void zzf(Parcel parcel) {
    }

    @GuardedBy("this")
    public void zzg(Parcel parcel) {
    }
}
