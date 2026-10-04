package com.google.android.meet.addons;

import com.google.android.meet.addons.ServerQueueParams;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzag extends ServerQueueParams.Builder {
    private String zza;
    private long zzb;
    private byte zzc;

    @Override // com.google.android.meet.addons.ServerQueueParams.Builder
    public final ServerQueueParams.Builder zza(String str) {
        if (str == null) {
            throw new NullPointerException("Null queueId");
        }
        this.zza = str;
        return this;
    }

    @Override // com.google.android.meet.addons.ServerQueueParams.Builder
    public final ServerQueueParams.Builder zzb(long j) {
        this.zzb = j;
        this.zzc = (byte) 1;
        return this;
    }

    @Override // com.google.android.meet.addons.ServerQueueParams.Builder
    public final ServerQueueParams zzc() {
        String str;
        if (this.zzc == 1 && (str = this.zza) != null) {
            return new zzai(str, this.zzb, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" queueId");
        }
        if (this.zzc == 0) {
            sb.append(" queueVersion");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
