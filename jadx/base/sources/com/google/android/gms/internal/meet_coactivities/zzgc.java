package com.google.android.gms.internal.meet_coactivities;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzgc extends zzim {
    private ListeningExecutorService zza;
    private ListeningScheduledExecutorService zzb;
    private ListeningExecutorService zzc;
    private ListeningExecutorService zzd;
    private ListeningExecutorService zze;
    private ListeningExecutorService zzf;

    @Override // com.google.android.gms.internal.meet_coactivities.zzim
    public final zzim zza(ListeningExecutorService listeningExecutorService) {
        if (listeningExecutorService == null) {
            throw new NullPointerException("Null coDoingHandlerExecutor");
        }
        this.zzd = listeningExecutorService;
        return this;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzim
    public final zzim zzb(ListeningExecutorService listeningExecutorService) {
        if (listeningExecutorService == null) {
            throw new NullPointerException("Null coWatchingHandlerExecutor");
        }
        this.zzc = listeningExecutorService;
        return this;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzim
    public final zzim zzc(ListeningScheduledExecutorService listeningScheduledExecutorService) {
        if (listeningScheduledExecutorService == null) {
            throw new NullPointerException("Null heartbeatExecutor");
        }
        this.zzb = listeningScheduledExecutorService;
        return this;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzim
    public final zzim zzd(ListeningExecutorService listeningExecutorService) {
        if (listeningExecutorService == null) {
            throw new NullPointerException("Null incomingIpcExecutor");
        }
        this.zzf = listeningExecutorService;
        return this;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzim
    public final zzim zze(ListeningExecutorService listeningExecutorService) {
        if (listeningExecutorService == null) {
            throw new NullPointerException("Null internalExecutor");
        }
        this.zza = listeningExecutorService;
        return this;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzim
    public final zzim zzf(ListeningExecutorService listeningExecutorService) {
        if (listeningExecutorService == null) {
            throw new NullPointerException("Null outgoingIpcExecutor");
        }
        this.zze = listeningExecutorService;
        return this;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzim
    public final zzin zzg() {
        ListeningScheduledExecutorService listeningScheduledExecutorService;
        ListeningExecutorService listeningExecutorService;
        ListeningExecutorService listeningExecutorService2;
        ListeningExecutorService listeningExecutorService3;
        ListeningExecutorService listeningExecutorService4;
        ListeningExecutorService listeningExecutorService5 = this.zza;
        if (listeningExecutorService5 != null && (listeningScheduledExecutorService = this.zzb) != null && (listeningExecutorService = this.zzc) != null && (listeningExecutorService2 = this.zzd) != null && (listeningExecutorService3 = this.zze) != null && (listeningExecutorService4 = this.zzf) != null) {
            return new zzge(listeningExecutorService5, listeningScheduledExecutorService, listeningExecutorService, listeningExecutorService2, listeningExecutorService3, listeningExecutorService4, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" internalExecutor");
        }
        if (this.zzb == null) {
            sb.append(" heartbeatExecutor");
        }
        if (this.zzc == null) {
            sb.append(" coWatchingHandlerExecutor");
        }
        if (this.zzd == null) {
            sb.append(" coDoingHandlerExecutor");
        }
        if (this.zze == null) {
            sb.append(" outgoingIpcExecutor");
        }
        if (this.zzf == null) {
            sb.append(" incomingIpcExecutor");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
