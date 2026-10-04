package com.google.android.meet.addons;

import com.google.android.meet.addons.CoWatchingQueue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzr extends CoWatchingQueue.Builder {
    private ClientQueue zza;
    private ServerQueueParams zzb;

    @Override // com.google.android.meet.addons.CoWatchingQueue.Builder
    public final CoWatchingQueue.Builder zza(ClientQueue clientQueue) {
        this.zza = clientQueue;
        return this;
    }

    @Override // com.google.android.meet.addons.CoWatchingQueue.Builder
    public final CoWatchingQueue.Builder zzb(ServerQueueParams serverQueueParams) {
        this.zzb = serverQueueParams;
        return this;
    }

    @Override // com.google.android.meet.addons.CoWatchingQueue.Builder
    public final CoWatchingQueue zzc() {
        return new zzt(this.zza, this.zzb, null);
    }
}
