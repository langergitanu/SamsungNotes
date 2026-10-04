package com.samsung.android.kmxservice.sdk.e2ee.kmx;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.kmxservice.sdk.e2ee.KmxException;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxErrorHandler;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxSdk;
import com.samsung.android.kmxservice.sdk.e2ee.data.KMX_CMD;
import com.samsung.android.kmxservice.sdk.e2ee.data.KMX_CONSTANT;
import com.samsung.android.kmxservice.sdk.e2ee.manager.KeyHandler;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class KmxKeyHandlerImpl implements KeyHandler {
    private static final String TAG = "KmxKeyHandlerImpl";

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KeyHandler
    public boolean containsKey(String str) {
        Bundle bundleM2215f = AbstractC2821a.m2215f(KMX_CONSTANT.KMX_KEY_ID, str);
        bundleM2215f.putString(KMX_CONSTANT.KMX_FABRIC_ID, KmxSdk.getGuid());
        Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_METHOD_CONTAINS_KEY, (String) null, bundleM2215f);
        if (bundleCall == null) {
            return false;
        }
        Log.i(TAG, "[containsKey] " + str);
        return bundleCall.getInt(KMX_CONSTANT.KMX_ERROR_CODE) == 0;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KeyHandler
    public boolean deleteKeys() {
        Bundle bundle = new Bundle();
        bundle.putString(KMX_CONSTANT.KMX_FABRIC_ID, KmxSdk.getGuid());
        Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_DELETE_ALL_KEY, (String) null, bundle);
        if (bundleCall == null) {
            return false;
        }
        int i = bundleCall.getInt(KMX_CONSTANT.KMX_ERROR_CODE);
        boolean z = i == 0;
        Log.i(TAG, "[deleteKeys] request fabric : " + KmxSdk.getGuid() + " | All key removed ? " + z);
        if (!z) {
            AbstractC0541b.m758D(i, "[deleteKeys] error code :", TAG);
        }
        return z;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KeyHandler
    public boolean removeKey(String str, int i) throws KmxException {
        Bundle bundleCall;
        if (str == null || str.isEmpty()) {
            KmxErrorHandler.throwIfNotSuccess("30|Remove Key Error !! Key Id is Invalid. Key Type is" + i, 4);
            return false;
        }
        Bundle bundle = new Bundle();
        if (i == 1) {
            bundle.putString(KMX_CONSTANT.KMX_SERVICE_ID, str);
            bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_DELETE_SERVICE_KEY, (String) null, bundle);
            if (bundleCall == null) {
                Log.e(TAG, "[0|removeKeyInternal] Cannot remove service key.");
                return false;
            }
        } else {
            bundle.putString(KMX_CONSTANT.KMX_KEY_ID, str);
            bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_DELETE_KEY, (String) null, bundle);
            if (bundleCall == null) {
                Log.e(TAG, "[1|removeKeyInternal] Cannot remove key.");
                return false;
            }
        }
        int i2 = bundleCall.getInt(KMX_CONSTANT.KMX_ERROR_CODE);
        AbstractC0000a.m26w(AbstractC0541b.m780v("[RemoveKeyInternal] removeKeyId :", i, str, "/Key type :", "/ code :"), TAG, i2);
        if (i2 != 6) {
            return i2 == 0;
        }
        KmxErrorHandler.throwIfNotSuccess("30-1|Remove Key Error !! TA error" + i, 6);
        return false;
    }
}
