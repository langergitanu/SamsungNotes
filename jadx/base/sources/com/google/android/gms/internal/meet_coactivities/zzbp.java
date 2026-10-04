package com.google.android.gms.internal.meet_coactivities;

import com.google.common.util.concurrent.ListeningExecutorService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzbp extends zzbx {
    private ListeningExecutorService zza;
    private ListeningExecutorService zzb;

    @Override // com.google.android.gms.internal.meet_coactivities.zzbx
    public final zzbx zza(ListeningExecutorService listeningExecutorService) {
        this.zzb = listeningExecutorService;
        return this;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzbx
    public final zzbx zzb(ListeningExecutorService listeningExecutorService) {
        this.zza = listeningExecutorService;
        return this;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzbx
    public final zzby zzc() {
        ListeningExecutorService listeningExecutorService;
        ListeningExecutorService listeningExecutorService2 = this.zza;
        if (listeningExecutorService2 != null && (listeningExecutorService = this.zzb) != null) {
            return new zzbq(listeningExecutorService2, listeningExecutorService, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" outgoingIpcExecutor");
        }
        if (this.zzb == null) {
            sb.append(" incomingIpcExecutor");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
