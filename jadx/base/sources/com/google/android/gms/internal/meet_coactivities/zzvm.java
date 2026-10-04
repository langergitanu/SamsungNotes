package com.google.android.gms.internal.meet_coactivities;

import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import okio.Utf8;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzvm {
    public static /* bridge */ /* synthetic */ void zza(byte b, byte b5, byte b6, byte b7, char[] cArr, int i) throws zzti {
        if (!zze(b5)) {
            if ((((b5 + SprAttributeBase.TYPE_SHADOW) + (b << 28)) >> 30) == 0 && !zze(b6) && !zze(b7)) {
                int i2 = ((b & 7) << 18) | ((b5 & Utf8.REPLACEMENT_BYTE) << 12) | ((b6 & Utf8.REPLACEMENT_BYTE) << 6) | (b7 & Utf8.REPLACEMENT_BYTE);
                cArr[i] = (char) ((i2 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                cArr[i + 1] = (char) ((i2 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                return;
            }
        }
        throw zzti.zzd();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0016 A[PHI: r2
      0x0016: PHI (r2v3 byte) = (r2v2 byte), (r2v9 byte) binds: [B:9:0x0011, B:11:0x0015] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* bridge */ /* synthetic */ void zzb(byte b, byte b5, byte b6, char[] cArr, int i) throws zzti {
        if (!zze(b5)) {
            if (b != -32) {
                if (b != -19) {
                    if (!zze(b6)) {
                        cArr[i] = (char) (((b & 15) << 12) | ((b5 & Utf8.REPLACEMENT_BYTE) << 6) | (b6 & Utf8.REPLACEMENT_BYTE));
                        return;
                    }
                } else if (b5 < -96) {
                    b = -19;
                    if (!zze(b6)) {
                    }
                }
            } else if (b5 >= -96) {
                b = -32;
                if (b != -19) {
                }
            }
        }
        throw zzti.zzd();
    }

    public static /* bridge */ /* synthetic */ void zzc(byte b, byte b5, char[] cArr, int i) throws zzti {
        if (b < -62 || zze(b5)) {
            throw zzti.zzd();
        }
        cArr[i] = (char) (((b & 31) << 6) | (b5 & Utf8.REPLACEMENT_BYTE));
    }

    public static /* bridge */ /* synthetic */ boolean zzd(byte b) {
        return b >= 0;
    }

    private static boolean zze(byte b) {
        return b > -65;
    }
}
