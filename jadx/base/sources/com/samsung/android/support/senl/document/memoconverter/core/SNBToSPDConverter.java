package com.samsung.android.support.senl.document.memoconverter.core;

import android.content.Context;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SNBToSPDConverter {
    static {
        try {
            System.loadLibrary("SNBConverter");
            DocumentLogger.m7179e("SNBToSPDConverter", "Load SNBconverter lib");
        } catch (Exception e) {
            DocumentLogger.m7179e("SNBToSPDConverter", "Fail : System.loadLibrary(SNBConverter)" + e);
        }
    }

    private native String native_getNoteDoc(String str, String str2, String str3, String str4, Context context, int i, int i2);

    private native String native_getPassword(String str, String str2, String str3);

    private native boolean native_initSdk(String str, int i, int i2, int i4);

    private native boolean native_isLockedSnbFile(String str);

    private native boolean native_isRightSnbPassword(String str, String str2, String str3);

    public String getNoteDoc(String str, String str2, String str3, String str4, Context context, int i, int i2) {
        return native_getNoteDoc(str, str2, str3, str4, context, i, i2);
    }

    public String getPassword(String str, String str2, String str3) {
        return native_getPassword(str, str2, str3);
    }

    public void initSdk(String str, int i, int i2, int i4) {
        native_initSdk(str, i, i2, i4);
    }

    public boolean isLockedSnbFile(String str) {
        return native_isLockedSnbFile(str);
    }

    public boolean isRightSnbPassword(String str, String str2, String str3) {
        return native_isRightSnbPassword(str, str2, str3);
    }
}
