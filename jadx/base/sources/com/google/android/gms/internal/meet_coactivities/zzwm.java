package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzwm {
    public static zzwe zza(zzwe zzweVar, List list) {
        Preconditions.checkNotNull(zzweVar, NetworkConfig.CLIENTS_CHANNEL);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzweVar = new zzwl(zzweVar, (zzwj) it.next(), null);
        }
        return zzweVar;
    }
}
