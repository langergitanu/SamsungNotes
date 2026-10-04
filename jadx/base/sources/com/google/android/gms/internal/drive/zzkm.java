package com.google.android.gms.internal.drive;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes5.dex */
public final class zzkm {
    public static final byte[] zzsn;
    private static final ByteBuffer zzso;
    private static final zzjo zzsp;
    static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    static {
        byte[] bArr = new byte[0];
        zzsn = bArr;
        zzso = ByteBuffer.wrap(bArr);
        zzsp = zzjo.zza(bArr, 0, bArr.length, false);
    }

    public static <T> T checkNotNull(T t) {
        t.getClass();
        return t;
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int iZza = zza(length, bArr, 0, length);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    public static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zzd(byte[] bArr) {
        return zznf.zzd(bArr);
    }

    public static int zze(boolean z) {
        return z ? 1231 : 1237;
    }

    public static boolean zzf(zzlq zzlqVar) {
        return false;
    }

    public static int zzu(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zza(int i, byte[] bArr, int i2, int i4) {
        for (int i5 = i2; i5 < i2 + i4; i5++) {
            i = (i * 31) + bArr[i5];
        }
        return i;
    }

    public static String zze(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static Object zza(Object obj, Object obj2) {
        return ((zzlq) obj).zzcy().zza((zzlq) obj2).zzde();
    }
}
