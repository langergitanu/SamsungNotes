package com.samsung.android.kmxservice.sdk.e2ee.sks;

import android.util.Log;
import com.samsung.android.kmxservice.sdk.e2ee.manager.KeyHandler;
import com.samsung.android.kmxservice.sdk.util.AndroidKeystoreHelper;
import com.samsung.android.kmxservice.sdk.util.KmxLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SksKeyHandlerImpl implements KeyHandler {
    private static final String TAG = "KmxKeyHandlerImpl";

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KeyHandler
    public boolean containsKey(String str) {
        if (AndroidKeystoreHelper.getKey(str) != null) {
            return true;
        }
        Log.e(TAG, "32-1|Fail to get serviceKeyId. Key does not exist in keystore");
        return false;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KeyHandler
    public boolean deleteKeys() {
        KmxLogger.m5529i(TAG, "NotSupport, deleteKeys. SKS");
        return false;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KeyHandler
    public boolean removeKey(String str, int i) {
        KmxLogger.m5529i(TAG, "NotSupport, removeKey. SKS");
        return false;
    }
}
