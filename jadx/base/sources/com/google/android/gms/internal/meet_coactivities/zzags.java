package com.google.android.gms.internal.meet_coactivities;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class zzags implements zzaes {
    private volatile boolean zza;
    private zzaeu zzb;
    private zzaes zzc;

    @GuardedBy("this")
    private zzabd zzd;

    @GuardedBy("this")
    private zzagr zzf;

    @GuardedBy("this")
    private long zzg;

    @GuardedBy("this")
    private long zzh;

    @GuardedBy("this")
    private List zze = new ArrayList();
    private List zzi = new ArrayList();

    private final void zzo(Runnable runnable) {
        Preconditions.checkState(this.zzb != null, "May only be called after start");
        synchronized (this) {
            try {
                if (this.zza) {
                    runnable.run();
                } else {
                    this.zze.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        if (r0.hasNext() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzp() {
        zzagr zzagrVar;
        List list;
        List arrayList = new ArrayList();
        while (true) {
            synchronized (this) {
                if (this.zze.isEmpty()) {
                    break;
                }
                list = this.zze;
                this.zze = arrayList;
            }
            if (zzagrVar == null) {
                zzagrVar.zzb();
                return;
            }
            return;
            list.clear();
            arrayList = list;
        }
        this.zze = null;
        this.zza = true;
        zzagrVar = this.zzf;
        if (zzagrVar == null) {
        }
    }

    private final void zzu(zzaeu zzaeuVar) {
        Iterator it = this.zzi.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.zzi = null;
        this.zzc.zzl(zzaeuVar);
    }

    @GuardedBy("this")
    private final void zzv(zzaes zzaesVar) {
        zzaes zzaesVar2 = this.zzc;
        Preconditions.checkState(zzaesVar2 == null, "realStream already set to %s", zzaesVar2);
        this.zzc = zzaesVar;
        this.zzh = System.nanoTime();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public void zza(zzahy zzahyVar) {
        synchronized (this) {
            try {
                if (this.zzb == null) {
                    return;
                }
                if (this.zzc != null) {
                    zzahyVar.zzb("buffered_nanos", Long.valueOf(this.zzh - this.zzg));
                    this.zzc.zza(zzahyVar);
                } else {
                    zzahyVar.zzb("buffered_nanos", Long.valueOf(System.nanoTime() - this.zzg));
                    zzahyVar.zza("waiting_for_connection");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public void zzb(zzabd zzabdVar) {
        boolean z = false;
        Preconditions.checkState(this.zzb != null, "May only be called after start");
        Preconditions.checkNotNull(zzabdVar, "reason");
        synchronized (this) {
            try {
                if (this.zzc == null) {
                    zzv(zzald.zza);
                    this.zzd = zzabdVar;
                } else {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            zzo(new zzagl(this, zzabdVar));
            return;
        }
        zzp();
        zzq(zzabdVar);
        this.zzb.zzd(zzabdVar, zzaet.PROCESSED, new zzzv());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zzc() {
        Preconditions.checkState(this.zzb != null, "May only be called after start");
        if (this.zza) {
            this.zzc.zzc();
        } else {
            zzo(new zzagk(this));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzd() {
        Preconditions.checkState(this.zzb != null, "May only be called after start");
        zzo(new zzagm(this));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zze() {
        Preconditions.checkState(this.zzb == null, "May only be called before start");
        this.zzi.add(new zzagc(this));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zzf(int i) {
        Preconditions.checkState(this.zzb != null, "May only be called after start");
        if (this.zza) {
            this.zzc.zzf(i);
        } else {
            zzo(new zzagb(this, i));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zzg(zzwv zzwvVar) {
        Preconditions.checkState(this.zzb == null, "May only be called before start");
        Preconditions.checkNotNull(zzwvVar, "compressor");
        this.zzi.add(new zzagd(this, zzwvVar));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzh(zzxi zzxiVar) {
        Preconditions.checkState(this.zzb == null, "May only be called before start");
        this.zzi.add(new zzagh(this, zzxiVar));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzi(zzxl zzxlVar) {
        Preconditions.checkState(this.zzb == null, "May only be called before start");
        Preconditions.checkNotNull(zzxlVar, "decompressorRegistry");
        this.zzi.add(new zzage(this, zzxlVar));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzj(int i) {
        Preconditions.checkState(this.zzb == null, "May only be called before start");
        this.zzi.add(new zzagf(this, i));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzk(int i) {
        Preconditions.checkState(this.zzb == null, "May only be called before start");
        this.zzi.add(new zzagg(this, i));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzl(zzaeu zzaeuVar) {
        zzabd zzabdVar;
        boolean z;
        Preconditions.checkNotNull(zzaeuVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Preconditions.checkState(this.zzb == null, "already started");
        synchronized (this) {
            try {
                zzabdVar = this.zzd;
                z = this.zza;
                if (!z) {
                    zzagr zzagrVar = new zzagr(zzaeuVar);
                    this.zzf = zzagrVar;
                    zzaeuVar = zzagrVar;
                }
                this.zzb = zzaeuVar;
                this.zzg = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zzabdVar != null) {
            zzaeuVar.zzd(zzabdVar, zzaet.PROCESSED, new zzzv());
        } else if (z) {
            zzu(zzaeuVar);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zzm(InputStream inputStream) {
        Preconditions.checkState(this.zzb != null, "May only be called after start");
        Preconditions.checkNotNull(inputStream, "message");
        if (this.zza) {
            this.zzc.zzm(inputStream);
        } else {
            zzo(new zzagj(this, inputStream));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final boolean zzn() {
        if (this.zza) {
            return this.zzc.zzn();
        }
        return false;
    }

    @CheckReturnValue
    public final Runnable zzs(zzaes zzaesVar) {
        synchronized (this) {
            try {
                if (this.zzc == null) {
                    zzv((zzaes) Preconditions.checkNotNull(zzaesVar, "stream"));
                    zzaeu zzaeuVar = this.zzb;
                    if (zzaeuVar == null) {
                        this.zze = null;
                        this.zza = true;
                    }
                    if (zzaeuVar != null) {
                        zzu(zzaeuVar);
                        return new zzagi(this);
                    }
                }
            } finally {
            }
        }
        return null;
    }

    public void zzq(zzabd zzabdVar) {
    }
}
