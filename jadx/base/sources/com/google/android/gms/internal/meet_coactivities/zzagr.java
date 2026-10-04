package com.google.android.gms.internal.meet_coactivities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzagr implements zzaeu {
    private final zzaeu zza;
    private volatile boolean zzb;

    @GuardedBy("this")
    private List zzc = new ArrayList();

    public zzagr(zzaeu zzaeuVar) {
        this.zza = zzaeuVar;
    }

    private final void zzc(Runnable runnable) {
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

    public final void zzb() {
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

    @Override // com.google.android.gms.internal.meet_coactivities.zzaeu
    public final void zzd(zzabd zzabdVar, zzaet zzaetVar, zzzv zzzvVar) {
        zzc(new zzagq(this, zzabdVar, zzaetVar, zzzvVar));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaeu
    public final void zze(zzzv zzzvVar) {
        zzc(new zzagp(this, zzzvVar));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaou
    public final void zzf(zzaot zzaotVar) {
        if (this.zzb) {
            this.zza.zzf(zzaotVar);
        } else {
            zzc(new zzagn(this, zzaotVar));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaou
    public final void zzg() {
        if (this.zzb) {
            this.zza.zzg();
        } else {
            zzc(new zzago(this));
        }
    }
}
