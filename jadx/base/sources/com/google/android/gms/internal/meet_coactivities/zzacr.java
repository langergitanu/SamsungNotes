package com.google.android.gms.internal.meet_coactivities;

import java.io.InputStream;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzacr {

    @Nullable
    final InputStream zza = null;

    @Nullable
    final byte[] zzb;
    final int zzc;
    final boolean zzd;

    public zzacr(InputStream inputStream, byte[] bArr, int i, boolean z) {
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = z;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TransactionData[");
        sb.append(this.zzc);
        sb.append("b array");
        sb.append(true != this.zzd ? "]" : "(last)]");
        return sb.toString();
    }
}
