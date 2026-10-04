package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.VisibleForTesting;
import java.net.SocketAddress;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@VisibleForTesting
final class zzaim {
    private List zza;
    private int zzb;
    private int zzc;

    public zzaim(List list) {
        this.zza = list;
    }

    public final zzvy zza() {
        return ((zzxm) this.zza.get(this.zzb)).zza();
    }

    public final SocketAddress zzb() {
        return (SocketAddress) ((zzxm) this.zza.get(this.zzb)).zzb().get(this.zzc);
    }

    public final void zzc() {
        zzxm zzxmVar = (zzxm) this.zza.get(this.zzb);
        int i = this.zzc + 1;
        this.zzc = i;
        if (i >= zzxmVar.zzb().size()) {
            this.zzb++;
            this.zzc = 0;
        }
    }

    public final void zzd() {
        this.zzb = 0;
        this.zzc = 0;
    }

    public final void zze(List list) {
        this.zza = list;
        zzd();
    }

    public final boolean zzf() {
        return this.zzb == 0 && this.zzc == 0;
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
