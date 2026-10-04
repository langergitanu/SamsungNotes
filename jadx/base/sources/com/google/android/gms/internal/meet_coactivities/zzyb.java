package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyb {
    private Object zza;

    private zzyb() {
        throw null;
    }

    public final zzyb zza(Object obj) {
        this.zza = Preconditions.checkNotNull(obj, ExternalDataConstants.EmbeddingConfig.KEY);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzyd zzb() {
        Preconditions.checkState(this.zza != null, "config is not set");
        return new zzyd(zzabd.zza, this.zza, null, 0 == true ? 1 : 0);
    }

    public /* synthetic */ zzyb(zzya zzyaVar) {
    }
}
