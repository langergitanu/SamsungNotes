package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzanq {
    final int zza;
    final int zzb;
    final int zzc;
    final AtomicInteger zzd;

    public zzanq(float f, float f4) {
        AtomicInteger atomicInteger = new AtomicInteger();
        this.zzd = atomicInteger;
        this.zzc = (int) (f4 * 1000.0f);
        int i = (int) (f * 1000.0f);
        this.zza = i;
        this.zzb = i / 2;
        atomicInteger.set(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzanq)) {
            return false;
        }
        zzanq zzanqVar = (zzanq) obj;
        return this.zza == zzanqVar.zza && this.zzc == zzanqVar.zzc;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzc));
    }

    @VisibleForTesting
    public final boolean zza() {
        return this.zzd.get() > this.zzb;
    }

    @VisibleForTesting
    public final boolean zzb() {
        int i;
        int i2;
        do {
            i = this.zzd.get();
            if (i == 0) {
                return false;
            }
            i2 = i - 1000;
        } while (!this.zzd.compareAndSet(i, Math.max(i2, 0)));
        return i2 > this.zzb;
    }
}
