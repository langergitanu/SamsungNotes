package com.google.android.meet.addons;

import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzk extends ClientQueue {
    private final int zza;
    private final ImmutableList zzb;

    public /* synthetic */ zzk(int i, ImmutableList immutableList, zzj zzjVar) {
        this.zza = i;
        this.zzb = immutableList;
    }

    @Override // com.google.android.meet.addons.ClientQueue
    public final int currentIndex() {
        return this.zza;
    }

    @Override // com.google.android.meet.addons.ClientQueue
    public final ImmutableList<ClientQueueEntry> entries() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ClientQueue) {
            ClientQueue clientQueue = (ClientQueue) obj;
            if (this.zza == clientQueue.currentIndex() && this.zzb.equals(clientQueue.entries())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza ^ 1000003) * 1000003) ^ this.zzb.hashCode();
    }

    public final String toString() {
        return "ClientQueue{currentIndex=" + this.zza + ", entries=" + this.zzb.toString() + "}";
    }
}
