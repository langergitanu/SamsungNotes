package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@NotThreadSafe
final class zzafa {
    private ArrayList zza = new ArrayList();
    private volatile zzwz zzb = zzwz.IDLE;

    public final void zza(@Nonnull zzwz zzwzVar) {
        Preconditions.checkNotNull(zzwzVar, "newState");
        if (this.zzb == zzwzVar || this.zzb == zzwz.SHUTDOWN) {
            return;
        }
        this.zzb = zzwzVar;
        if (this.zza.isEmpty()) {
            return;
        }
        ArrayList arrayList = this.zza;
        this.zza = new ArrayList();
        if (arrayList.size() <= 0) {
            return;
        }
        throw null;
    }
}
