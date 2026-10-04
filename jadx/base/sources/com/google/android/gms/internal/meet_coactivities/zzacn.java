package com.google.android.gms.internal.meet_coactivities;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzacn {
    private static final int zza;
    private static final Queue zzb;

    static {
        int iMax = Math.max(16384, 8192);
        zza = iMax;
        zzb = new LinkedBlockingQueue(131072 / iMax);
    }

    public static void zza(byte[] bArr) {
        if (bArr.length == zza) {
            zzb.offer(bArr);
        }
    }

    public static byte[] zzb() {
        return zzc(zza);
    }

    public static byte[] zzc(int i) {
        byte[] bArr;
        return (i != zza || (bArr = (byte[]) zzb.poll()) == null) ? new byte[i] : bArr;
    }
}
