package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import javax.annotation.CheckReturnValue;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ThreadSafe
@CheckReturnValue
public class zzapd {
    private final zzwe zza;
    private final zzwd zzb;

    public zzapd(zzwe zzweVar, zzwd zzwdVar) {
        this.zza = (zzwe) Preconditions.checkNotNull(zzweVar, NetworkConfig.CLIENTS_CHANNEL);
        this.zzb = (zzwd) Preconditions.checkNotNull(zzwdVar, "callOptions");
    }

    public final zzwd zzb() {
        return this.zzb;
    }

    public final zzwe zzc() {
        return this.zza;
    }
}
