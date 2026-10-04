package com.google.android.meet.addons;

import androidx.glance.AbstractC2821a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzai extends ServerQueueParams {
    private final String zza;
    private final long zzb;

    public /* synthetic */ zzai(String str, long j, zzah zzahVar) {
        this.zza = str;
        this.zzb = j;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ServerQueueParams) {
            ServerQueueParams serverQueueParams = (ServerQueueParams) obj;
            if (this.zza.equals(serverQueueParams.queueId()) && this.zzb == serverQueueParams.queueVersion()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        long j = this.zzb;
        return (iHashCode * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    @Override // com.google.android.meet.addons.ServerQueueParams
    public final String queueId() {
        return this.zza;
    }

    @Override // com.google.android.meet.addons.ServerQueueParams
    public final long queueVersion() {
        return this.zzb;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ServerQueueParams{queueId=");
        sb.append(this.zza);
        sb.append(", queueVersion=");
        return AbstractC2821a.m2224o(sb, "}", this.zzb);
    }
}
