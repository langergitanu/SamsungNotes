package com.google.android.gms.internal.meet_coactivities;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzsb extends zzrh {
    public static final /* synthetic */ int zzb = 0;
    private static final Logger zzc = Logger.getLogger(zzsb.class.getName());
    private static final boolean zzd = zzvl.zzx();
    zzsc zza;

    private zzsb() {
        throw null;
    }

    public static int zzA(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static zzsb zzB(byte[] bArr, int i, int i2) {
        return new zzry(bArr, i, i2);
    }

    @Deprecated
    public static int zzv(int i, zzue zzueVar, zzuq zzuqVar) {
        int iZzz = zzz(i << 3);
        return ((zzqz) zzueVar).zzv(zzuqVar) + iZzz + iZzz;
    }

    public static int zzw(zzue zzueVar) {
        int iZzz = zzueVar.zzz();
        return zzz(iZzz) + iZzz;
    }

    public static int zzx(zzue zzueVar, zzuq zzuqVar) {
        int iZzv = ((zzqz) zzueVar).zzv(zzuqVar);
        return zzz(iZzv) + iZzv;
    }

    public static int zzy(String str) {
        int length;
        try {
            length = zzvo.zzc(str);
        } catch (zzvn unused) {
            length = str.getBytes(zztg.zza).length;
        }
        return zzz(length) + length;
    }

    public static int zzz(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public final void zzC() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzD(String str, zzvn zzvnVar) throws zzrz {
        zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzvnVar);
        byte[] bytes = str.getBytes(zztg.zza);
        try {
            int length = bytes.length;
            zzs(length);
            zzm(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzrz(e);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b);

    public abstract void zzd(int i, boolean z);

    public abstract void zze(int i, zzrq zzrqVar);

    public abstract void zzf(zzrq zzrqVar);

    public abstract void zzg(int i, int i2);

    public abstract void zzh(int i);

    public abstract void zzi(int i, long j);

    public abstract void zzj(long j);

    public abstract void zzk(int i, int i2);

    public abstract void zzl(int i);

    public abstract void zzm(byte[] bArr, int i, int i2);

    public abstract void zzn(zzue zzueVar);

    public abstract void zzo(int i, String str);

    public abstract void zzp(String str);

    public abstract void zzq(int i, int i2);

    public abstract void zzr(int i, int i2);

    public abstract void zzs(int i);

    public abstract void zzt(int i, long j);

    public abstract void zzu(long j);

    public /* synthetic */ zzsb(zzsa zzsaVar) {
    }
}
