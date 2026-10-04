package com.google.android.meet.addons;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzt extends CoWatchingQueue {

    @Nullable
    private final ClientQueue zza;

    @Nullable
    private final ServerQueueParams zzb;

    public /* synthetic */ zzt(ClientQueue clientQueue, ServerQueueParams serverQueueParams, zzs zzsVar) {
        this.zza = clientQueue;
        this.zzb = serverQueueParams;
    }

    @Override // com.google.android.meet.addons.CoWatchingQueue
    @Nullable
    public final ClientQueue clientQueue() {
        return this.zza;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CoWatchingQueue) {
            CoWatchingQueue coWatchingQueue = (CoWatchingQueue) obj;
            ClientQueue clientQueue = this.zza;
            if (clientQueue != null ? clientQueue.equals(coWatchingQueue.clientQueue()) : coWatchingQueue.clientQueue() == null) {
                ServerQueueParams serverQueueParams = this.zzb;
                if (serverQueueParams != null ? serverQueueParams.equals(coWatchingQueue.serverQueueParams()) : coWatchingQueue.serverQueueParams() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        ClientQueue clientQueue = this.zza;
        int iHashCode = clientQueue == null ? 0 : clientQueue.hashCode();
        ServerQueueParams serverQueueParams = this.zzb;
        return ((iHashCode ^ 1000003) * 1000003) ^ (serverQueueParams != null ? serverQueueParams.hashCode() : 0);
    }

    @Override // com.google.android.meet.addons.CoWatchingQueue
    @Nullable
    public final ServerQueueParams serverQueueParams() {
        return this.zzb;
    }

    public final String toString() {
        return AbstractC0541b.m775q("CoWatchingQueue{clientQueue=", String.valueOf(this.zza), ", serverQueueParams=", String.valueOf(this.zzb), "}");
    }
}
