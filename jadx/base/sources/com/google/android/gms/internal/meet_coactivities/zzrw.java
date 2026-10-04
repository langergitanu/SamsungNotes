package com.google.android.gms.internal.meet_coactivities;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzrw {
    public static final /* synthetic */ int zze = 0;
    private static volatile int zzf = 100;
    int zza;
    final int zzb = zzf;
    int zzc = Integer.MAX_VALUE;
    zzrx zzd;

    public /* synthetic */ zzrw(zzrv zzrvVar) {
    }

    public static int zzF(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long zzH(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static zzrw zzI(InputStream inputStream, int i) {
        return new zzru(inputStream, 4096, null);
    }

    public static zzrw zzJ(byte[] bArr, int i, int i2) {
        return zzK(bArr, 0, i2, false);
    }

    public static zzrw zzK(byte[] bArr, int i, int i2, boolean z) {
        zzrs zzrsVar = new zzrs(bArr, 0, i2, false, null);
        try {
            zzrsVar.zze(i2);
            return zzrsVar;
        } catch (zzti e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract void zzA(int i);

    public abstract boolean zzC();

    public abstract boolean zzD();

    public abstract boolean zzE(int i);

    public final int zzG(int i) {
        int i2 = this.zzc;
        this.zzc = Integer.MAX_VALUE;
        return i2;
    }

    public abstract double zzb();

    public abstract float zzc();

    public abstract int zzd();

    public abstract int zze(int i);

    public abstract int zzf();

    public abstract int zzg();

    public abstract int zzh();

    public abstract int zzk();

    public abstract int zzl();

    public abstract int zzm();

    public abstract int zzn();

    public abstract long zzo();

    public abstract long zzp();

    public abstract long zzt();

    public abstract long zzu();

    public abstract long zzv();

    public abstract zzrq zzw();

    public abstract String zzx();

    public abstract String zzy();

    public abstract void zzz(int i);
}
