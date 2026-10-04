package com.google.android.meet.addons;

import com.google.android.meet.addons.ClientQueue;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzi extends ClientQueue.Builder {
    private int zza;
    private ImmutableList zzb;
    private byte zzc;

    @Override // com.google.android.meet.addons.ClientQueue.Builder
    public final ClientQueue.Builder zza(int i) {
        this.zza = i;
        this.zzc = (byte) 1;
        return this;
    }

    @Override // com.google.android.meet.addons.ClientQueue.Builder
    public final ClientQueue.Builder zzb(List list) {
        this.zzb = ImmutableList.copyOf((Collection) list);
        return this;
    }

    @Override // com.google.android.meet.addons.ClientQueue.Builder
    public final ClientQueue zzc() {
        ImmutableList immutableList;
        if (this.zzc == 1 && (immutableList = this.zzb) != null) {
            return new zzk(this.zza, immutableList, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zzc == 0) {
            sb.append(" currentIndex");
        }
        if (this.zzb == null) {
            sb.append(" entries");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
