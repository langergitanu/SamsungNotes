package com.samsung.android.mcf.continuity.common;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.regex.Pattern;
import net.lingala.zip4j.crypto.PBKDF2.BinTools;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Utils {
    private static final char[] HEX_ARRAY = BinTools.hex.toCharArray();

    public static int bytesToInt(@NonNull byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i = (i << 8) | (bArr[i2] & 255);
        }
        return i;
    }

    public static long bytesToLong(@NonNull byte[] bArr) {
        long j = 0;
        for (int i = 0; i < 8; i++) {
            j = (j << 8) | (((long) bArr[i]) & 255);
        }
        return j;
    }

    @NonNull
    public static Bundle createBundle() {
        return new Bundle();
    }

    @NonNull
    public static Intent createIntent() {
        return new Intent();
    }

    @NonNull
    public static byte[] intToBytes(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 3; i2 >= 0; i2--) {
            bArr[i2] = (byte) (i & 255);
            i >>= 8;
        }
        return bArr;
    }

    public static boolean isMac(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return Pattern.compile("^([0-9a-fA-F][0-9a-fA-F]:){5}([0-9a-fA-F][0-9a-fA-F])$").matcher(str).find();
    }

    @NonNull
    public static byte[] longToBytes(long j) {
        byte[] bArr = new byte[8];
        for (int i = 7; i >= 0; i--) {
            bArr[i] = (byte) (255 & j);
            j >>= 8;
        }
        return bArr;
    }

    @NonNull
    public static String toHex(@Nullable byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }
}
