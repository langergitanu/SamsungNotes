package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapr {
    final String[] zza;
    final int zzb;

    public zzapr(zzxm zzxmVar) {
        Preconditions.checkNotNull(zzxmVar, "eag");
        this.zza = new String[zzxmVar.zzb().size()];
        Iterator it = zzxmVar.zzb().iterator();
        int i = 0;
        while (it.hasNext()) {
            this.zza[i] = ((SocketAddress) it.next()).toString();
            i++;
        }
        Arrays.sort(this.zza);
        this.zzb = Arrays.hashCode(this.zza);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzapr)) {
            return false;
        }
        zzapr zzaprVar = (zzapr) obj;
        if (zzaprVar.zzb == this.zzb) {
            String[] strArr = zzaprVar.zza;
            String[] strArr2 = this.zza;
            if (strArr.length == strArr2.length) {
                return Arrays.equals(strArr, strArr2);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb;
    }

    public final String toString() {
        return Arrays.toString(this.zza);
    }
}
