package com.google.android.gms.internal.meet_coactivities;

import com.google.common.util.concurrent.MoreExecutors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzxo extends zzxn {
    @Override // com.google.android.gms.internal.meet_coactivities.zzxn
    @Deprecated
    public abstract zzzk zzb();

    public final zzxo zzc() {
        ((zzaku) zzb()).zzc(MoreExecutors.directExecutor());
        return this;
    }
}
