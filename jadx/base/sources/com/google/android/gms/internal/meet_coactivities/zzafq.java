package com.google.android.gms.internal.meet_coactivities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzafq extends zzwh {
    private final zzwh zza;
    private volatile boolean zzb;

    @GuardedBy("this")
    private List zzc = new ArrayList();

    public zzafq(zzwh zzwhVar) {
        this.zza = zzwhVar;
    }

    private final void zzg(Runnable runnable) {
        synchronized (this) {
            try {
                if (this.zzb) {
                    runnable.run();
                } else {
                    this.zzc.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwh
    public final void zza(zzabd zzabdVar, zzzv zzzvVar) {
        zzg(new zzafo(this, zzabdVar, zzzvVar));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwh
    public final void zzb(zzzv zzzvVar) {
        if (this.zzb) {
            this.zza.zzb(zzzvVar);
        } else {
            zzg(new zzafm(this, zzzvVar));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwh
    public final void zzc(Object obj) {
        if (this.zzb) {
            this.zza.zzc(obj);
        } else {
            zzg(new zzafn(this, obj));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwh
    public final void zzd() {
        if (this.zzb) {
            this.zza.zzd();
        } else {
            zzg(new zzafp(this));
        }
    }

    public final void zzf() {
        List list;
        List arrayList = new ArrayList();
        while (true) {
            synchronized (this) {
                try {
                    if (this.zzc.isEmpty()) {
                        this.zzc = null;
                        this.zzb = true;
                        return;
                    } else {
                        list = this.zzc;
                        this.zzc = arrayList;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            list.clear();
            arrayList = list;
        }
    }
}
