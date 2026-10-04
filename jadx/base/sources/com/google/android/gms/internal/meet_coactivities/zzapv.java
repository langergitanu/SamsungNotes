package com.google.android.gms.internal.meet_coactivities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapv extends zzaps {
    protected zzzb zzh;
    private final AtomicInteger zzi;

    public zzapv(zzyt zzytVar) {
        super(zzytVar);
        this.zzi = new AtomicInteger(new Random().nextInt());
        this.zzh = new zzapt();
    }

    private final void zzm(zzwz zzwzVar, zzzb zzzbVar) {
        if (zzwzVar == this.zzg && zzzbVar.equals(this.zzh)) {
            return;
        }
        zzg().zze(zzwzVar, zzzbVar);
        this.zzg = zzwzVar;
        this.zzh = zzzbVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaps
    public final void zzk() {
        ArrayList arrayList = new ArrayList();
        for (zzapq zzapqVar : zzh()) {
            if (zzapqVar.zza() == zzwz.READY) {
                arrayList.add(zzapqVar);
            }
        }
        if (!arrayList.isEmpty()) {
            zzm(zzwz.READY, zzl(arrayList));
            return;
        }
        Iterator it = zzh().iterator();
        while (it.hasNext()) {
            zzwz zzwzVarZza = ((zzapq) it.next()).zza();
            zzwz zzwzVar = zzwz.CONNECTING;
            if (zzwzVarZza == zzwzVar || zzwzVarZza == zzwz.IDLE) {
                zzm(zzwzVar, new zzapt());
                return;
            }
        }
        zzm(zzwz.TRANSIENT_FAILURE, zzl(zzh()));
    }

    public final zzzb zzl(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzapq) it.next()).zzb());
        }
        return new zzapu(arrayList, this.zzi);
    }
}
