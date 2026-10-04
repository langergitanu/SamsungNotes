package com.google.android.meet.addons;

import androidx.collection.AbstractC0622a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzn extends ClientQueueEntry {
    private final String zza;
    private final String zzb;

    public /* synthetic */ zzn(String str, String str2, zzm zzmVar) {
        this.zza = str;
        this.zzb = str2;
    }

    @Override // com.google.android.meet.addons.ClientQueueEntry
    public final String entryId() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ClientQueueEntry) {
            ClientQueueEntry clientQueueEntry = (ClientQueueEntry) obj;
            if (this.zza.equals(clientQueueEntry.mediaId()) && this.zzb.equals(clientQueueEntry.entryId())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
    }

    @Override // com.google.android.meet.addons.ClientQueueEntry
    public final String mediaId() {
        return this.zza;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ClientQueueEntry{mediaId=");
        sb.append(this.zza);
        sb.append(", entryId=");
        return AbstractC0622a.m1170p(this.zzb, "}", sb);
    }
}
