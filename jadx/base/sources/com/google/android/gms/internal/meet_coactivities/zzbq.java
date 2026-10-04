package com.google.android.gms.internal.meet_coactivities;

import com.google.common.util.concurrent.ListeningExecutorService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzbq extends zzby {
    private final ListeningExecutorService zza;
    private final ListeningExecutorService zzb;

    public /* synthetic */ zzbq(ListeningExecutorService listeningExecutorService, ListeningExecutorService listeningExecutorService2, zzbo zzboVar) {
        this.zza = listeningExecutorService;
        this.zzb = listeningExecutorService2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzby) {
            zzby zzbyVar = (zzby) obj;
            if (this.zza.equals(zzbyVar.zzb()) && this.zzb.equals(zzbyVar.zza())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
    }

    public final String toString() {
        return "IpcExecutors{outgoingIpcExecutor=" + this.zza + ", incomingIpcExecutor=" + this.zzb + "}";
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzby
    public final ListeningExecutorService zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzby
    public final ListeningExecutorService zzb() {
        return this.zza;
    }
}
