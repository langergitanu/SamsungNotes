package com.google.android.gms.internal.drive;

import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import okio.Utf8;

/* JADX INFO: loaded from: classes5.dex */
final class zzng {
    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzd(byte b) {
        return b >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zze(byte b) {
        return b < -32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzf(byte b) {
        return b < -16;
    }

    private static boolean zzg(byte b) {
        return b > -65;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(byte b, byte b5, char[] cArr, int i) throws zzkq {
        if (b < -62 || zzg(b5)) {
            throw zzkq.zzdn();
        }
        cArr[i] = (char) (((b & 31) << 6) | (b5 & Utf8.REPLACEMENT_BYTE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(byte b, byte b5, byte b6, char[] cArr, int i) throws zzkq {
        if (!zzg(b5) && ((b != -32 || b5 >= -96) && ((b != -19 || b5 < -96) && !zzg(b6)))) {
            cArr[i] = (char) (((b & 15) << 12) | ((b5 & Utf8.REPLACEMENT_BYTE) << 6) | (b6 & Utf8.REPLACEMENT_BYTE));
            return;
        }
        throw zzkq.zzdn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(byte b, byte b5, byte b6, byte b7, char[] cArr, int i) throws zzkq {
        if (!zzg(b5)) {
            if ((((b5 + SprAttributeBase.TYPE_SHADOW) + (b << 28)) >> 30) == 0 && !zzg(b6) && !zzg(b7)) {
                int i2 = ((b & 7) << 18) | ((b5 & Utf8.REPLACEMENT_BYTE) << 12) | ((b6 & Utf8.REPLACEMENT_BYTE) << 6) | (b7 & Utf8.REPLACEMENT_BYTE);
                cArr[i] = (char) ((i2 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                cArr[i + 1] = (char) ((i2 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                return;
            }
        }
        throw zzkq.zzdn();
    }
}
