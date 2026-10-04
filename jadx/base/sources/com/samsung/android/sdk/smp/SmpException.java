package com.samsung.android.sdk.smp;

import com.samsung.android.sdk.smp.common.util.SmpLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpException {
    private static final String TAG = "SmpException";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class IllegalStateException extends Exception {
        public IllegalStateException(String str) {
            super(str);
            SmpLog.m6496he(SmpException.TAG, "IllegalStateException. " + str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NullArgumentException extends Exception {
        public NullArgumentException(String str) {
            super(str);
            SmpLog.m6496he(SmpException.TAG, "NullArgumentException. " + str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DBException extends Exception {
        public DBException() {
            SmpLog.m6496he(SmpException.TAG, "DBException");
        }

        public DBException(String str) {
            super(str);
            SmpLog.m6496he(SmpException.TAG, "DBException. " + str);
        }
    }
}
