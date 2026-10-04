package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@VisibleForTesting
final class zzalk {
    private List zza;
    private int zzb;
    private int zzc;

    public zzalk(List list) {
        this.zza = list == null ? Collections.EMPTY_LIST : list;
    }

    public final int zza() {
        List list = this.zza;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final zzvy zzb() {
        if (zzg()) {
            return ((zzxm) this.zza.get(this.zzb)).zza();
        }
        throw new IllegalStateException("Index is off the end of the address group list");
    }

    public final SocketAddress zzc() {
        if (zzg()) {
            return (SocketAddress) ((zzxm) this.zza.get(this.zzb)).zzb().get(this.zzc);
        }
        throw new IllegalStateException("Index is past the end of the address group list");
    }

    public final void zzd() {
        this.zzb = 0;
        this.zzc = 0;
    }

    public final void zze(ImmutableList immutableList) {
        List list = immutableList;
        if (immutableList == null) {
            list = Collections.EMPTY_LIST;
        }
        this.zza = list;
        zzd();
    }

    public final boolean zzf() {
        if (!zzg()) {
            return false;
        }
        zzxm zzxmVar = (zzxm) this.zza.get(this.zzb);
        int i = this.zzc + 1;
        this.zzc = i;
        if (i < zzxmVar.zzb().size()) {
            return true;
        }
        int i2 = this.zzb + 1;
        this.zzb = i2;
        this.zzc = 0;
        return i2 < this.zza.size();
    }

    public final boolean zzg() {
        return this.zzb < this.zza.size();
    }

    public final boolean zzh(SocketAddress socketAddress) {
        for (int i = 0; i < this.zza.size(); i++) {
            int iIndexOf = ((zzxm) this.zza.get(i)).zzb().indexOf(socketAddress);
            if (iIndexOf != -1) {
                this.zzb = i;
                this.zzc = iIndexOf;
                return true;
            }
        }
        return false;
    }
}
