package com.samsung.android.kmxservice.sdk.e2ee.common;

import android.util.Log;
import com.samsung.android.kmxservice.sdk.e2ee.KmxException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class KmxErrorHandler {
    private static final String TAG = "KmxError";

    private static boolean checkAllCauses(Exception exc, String str) {
        while (exc != null) {
            if (exc.getMessage() != null && exc.getMessage().contains(str)) {
                Log.e(TAG, "Message: " + exc.getMessage());
                return true;
            }
            if (exc.getCause() != null) {
                Log.d(TAG, "Message: " + exc.getMessage());
                Log.d(TAG, "\tCause class: ".concat(exc.getCause().getClass().getName()));
                checkAllCauses((Exception) exc.getCause(), str);
            }
            exc = (Exception) exc.getCause();
        }
        return false;
    }

    public static void throwIfContain(Exception exc, String str, String str2, int i) throws KmxException {
        if (checkAllCauses(exc, str)) {
            throw new KmxException(str2, i);
        }
    }

    public static void throwIfEmpty(String str, String str2, int i) throws KmxException {
        if (str != null && !str.isEmpty()) {
            int length = str.length();
            int iCharCount = 0;
            while (iCharCount < length) {
                int iCodePointAt = str.codePointAt(iCharCount);
                if (!Character.isWhitespace(iCodePointAt)) {
                    return;
                } else {
                    iCharCount += Character.charCount(iCodePointAt);
                }
            }
        }
        throwIfNotSuccess(str2, i);
    }

    public static void throwIfNotSuccess(String str, int i) throws KmxException {
        if (i != 0) {
            throw new KmxException(KmxExceptionMessageFactory.get(str, i), i);
        }
    }

    public static void throwIfNull(Object obj, String str, int i) throws KmxException {
        if (obj == null) {
            throwIfNotSuccess(str, i);
        }
    }

    public static void throwIfEmpty(byte[] bArr, String str, int i) throws KmxException {
        if (bArr == null || bArr.length == 0) {
            throwIfNotSuccess(str, i);
        }
    }
}
