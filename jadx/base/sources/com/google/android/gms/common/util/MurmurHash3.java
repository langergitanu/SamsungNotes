package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.collection.ScatterMapKt;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@KeepForSdk
public class MurmurHash3 {
    private MurmurHash3() {
    }

    @KeepForSdk
    public static int murmurhash3_x86_32(@NonNull byte[] bArr, int i, int i2, int i4) {
        int i5;
        int i6 = i;
        while (true) {
            i5 = (i2 & (-4)) + i;
            if (i6 >= i5) {
                break;
            }
            int i7 = ((bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16) | (bArr[i6 + 3] << 24)) * ScatterMapKt.MurmurHashC1;
            int i8 = i4 ^ (((i7 >>> 17) | (i7 << 15)) * 461845907);
            i4 = (((i8 >>> 19) | (i8 << 13)) * 5) - 430675100;
            i6 += 4;
        }
        int i9 = i2 & 3;
        if (i9 == 1) {
            int i10 = ((bArr[i5] & 255) | i) * ScatterMapKt.MurmurHashC1;
            i4 ^= ((i10 >>> 17) | (i10 << 15)) * 461845907;
        } else {
            if (i9 != 2) {
                i = i9 == 3 ? (bArr[i5 + 2] & 255) << 16 : 0;
            }
            i |= (bArr[i5 + 1] & 255) << 8;
            int i102 = ((bArr[i5] & 255) | i) * ScatterMapKt.MurmurHashC1;
            i4 ^= ((i102 >>> 17) | (i102 << 15)) * 461845907;
        }
        int i11 = i4 ^ i2;
        int i12 = (i11 ^ (i11 >>> 16)) * (-2048144789);
        int i13 = (i12 ^ (i12 >>> 13)) * (-1028477387);
        return i13 ^ (i13 >>> 16);
    }
}
