package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyq {
    private final List zza;
    private final zzvy zzb;
    private final Object[][] zzc;

    public /* synthetic */ zzyq(List list, zzvy zzvyVar, Object[][] objArr, zzyp zzypVar) {
        this.zza = (List) Preconditions.checkNotNull(list, "addresses are not set");
        this.zzb = (zzvy) Preconditions.checkNotNull(zzvyVar, "attrs");
        this.zzc = (Object[][]) Preconditions.checkNotNull(objArr, "customOptions");
    }

    public static zzyn zzb() {
        return new zzyn();
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("addrs", this.zza).add("attrs", this.zzb).add("customOptions", Arrays.deepToString(this.zzc)).toString();
    }

    public final zzvy zza() {
        return this.zzb;
    }

    public final List zzc() {
        return this.zza;
    }
}
