package com.google.android.meet.addons;

import com.google.android.meet.addons.ClientQueueEntry;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzl extends ClientQueueEntry.Builder {
    private String zza;
    private String zzb;

    @Override // com.google.android.meet.addons.ClientQueueEntry.Builder
    public final ClientQueueEntry.Builder zza(String str) {
        if (str == null) {
            throw new NullPointerException("Null entryId");
        }
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.meet.addons.ClientQueueEntry.Builder
    public final ClientQueueEntry.Builder zzb(String str) {
        if (str == null) {
            throw new NullPointerException("Null mediaId");
        }
        this.zza = str;
        return this;
    }

    @Override // com.google.android.meet.addons.ClientQueueEntry.Builder
    public final ClientQueueEntry zzc() {
        String str;
        String str2 = this.zza;
        if (str2 != null && (str = this.zzb) != null) {
            return new zzn(str2, str, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" mediaId");
        }
        if (this.zzb == null) {
            sb.append(" entryId");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
