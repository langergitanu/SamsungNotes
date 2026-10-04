package com.google.android.gms.internal.meet_coactivities;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@NotThreadSafe
public abstract class zzahx {
    private final Set zza = Collections.newSetFromMap(new IdentityHashMap());

    public abstract void zza();

    public abstract void zzb();

    public final void zzc(Object obj, boolean z) {
        int size = this.zza.size();
        if (z) {
            this.zza.add(obj);
            if (size == 0) {
                zza();
                return;
            }
            return;
        }
        if (this.zza.remove(obj) && size == 1) {
            zzb();
        }
    }

    public final boolean zzd(Object... objArr) {
        for (int i = 0; i < 2; i++) {
            if (this.zza.contains(objArr[i])) {
                return true;
            }
        }
        return false;
    }

    public final boolean zze() {
        return !this.zza.isEmpty();
    }
}
