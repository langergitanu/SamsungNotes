package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzaar extends zzwi {
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", zzf()).toString();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwi
    public void zza(@Nullable String str, @Nullable Throwable th) {
        throw null;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwi
    public final void zzb() {
        zzf().zzb();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwi
    public final void zzc(int i) {
        zzf().zzc(i);
    }

    public abstract zzwi zzf();
}
