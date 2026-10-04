package com.samsung.android.kmxservice.sdk.e2ee.kmx;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.glance.AbstractC2821a;
import com.samsung.android.kmxservice.sdk.e2ee.KmxException;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxErrorHandler;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxSdk;
import com.samsung.android.kmxservice.sdk.e2ee.data.KMX_CMD;
import com.samsung.android.kmxservice.sdk.e2ee.data.KMX_CONSTANT;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class KmxFabricIdHandlerImpl implements KmxFabricIdHandler {
    private static final String TAG = "KmxFabricIdHandlerImpl";

    @Override // com.samsung.android.kmxservice.sdk.e2ee.kmx.KmxFabricIdHandler
    public int set() throws KmxException {
        String guid = KmxSdk.getGuid();
        KmxErrorHandler.throwIfEmpty(guid, "8-1|Invalid GUID(FabricId). GUID is NULL", 301);
        Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_GET_FABRIC_ID, (String) null, (Bundle) null);
        if (bundleCall == null) {
            Log.e(TAG, "8-2| KmxService return value is null");
            return 1;
        }
        String string = bundleCall.getInt(KMX_CONSTANT.KMX_ERROR_CODE) == 0 ? bundleCall.getString(KMX_CONSTANT.KMX_FABRIC_ID) : null;
        if (string != null && !guid.equals(string)) {
            Bundle bundle = new Bundle();
            bundle.putString(KMX_CONSTANT.KMX_FABRIC_ID, string);
            Log.i(TAG, "8-2| Perform clearing all key because fabric ID is changed");
            KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_CLEAR_ALL, (String) null, bundle);
        }
        KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_SET_FABRIC_ID, (String) null, AbstractC2821a.m2215f(KMX_CONSTANT.KMX_FABRIC_ID, guid));
        return 0;
    }
}
