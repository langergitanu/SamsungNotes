package com.google.android.gms.internal.auth;

import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzhl extends zzhk {
    @Override // com.google.android.gms.internal.auth.zzhk
    public final int zza(int i, byte[] bArr, int i2, int i4) {
        while (i2 < i4 && bArr[i2] >= 0) {
            i2++;
        }
        if (i2 >= i4) {
            return 0;
        }
        while (i2 < i4) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                i2 = i5;
            } else {
                if (b < -32) {
                    if (i5 >= i4) {
                        return b;
                    }
                    if (b >= -62) {
                        i2 += 2;
                        if (bArr[i5] > -65) {
                        }
                    }
                    return -1;
                }
                if (b >= -16) {
                    if (i5 >= i4 - 2) {
                        return zzhm.zza(bArr, i5, i4);
                    }
                    int i6 = i2 + 2;
                    byte b5 = bArr[i5];
                    if (b5 <= -65) {
                        if ((((b5 + SprAttributeBase.TYPE_SHADOW) + (b << 28)) >> 30) == 0) {
                            int i7 = i2 + 3;
                            if (bArr[i6] <= -65) {
                                i2 += 4;
                                if (bArr[i7] > -65) {
                                }
                            }
                        }
                    }
                    return -1;
                }
                if (i5 >= i4 - 1) {
                    return zzhm.zza(bArr, i5, i4);
                }
                int i8 = i2 + 2;
                byte b6 = bArr[i5];
                if (b6 > -65 || (b == -32 && b6 < -96)) {
                    return -1;
                }
                if (b == -19 && b6 >= -96) {
                    return -1;
                }
                i2 += 3;
                if (bArr[i8] > -65) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
