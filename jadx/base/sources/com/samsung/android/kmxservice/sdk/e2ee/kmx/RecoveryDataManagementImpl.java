package com.samsung.android.kmxservice.sdk.e2ee.kmx;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.kmxservice.sdk.e2ee.KmxException;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxErrorHandler;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxSdk;
import com.samsung.android.kmxservice.sdk.e2ee.data.KMX_CMD;
import com.samsung.android.kmxservice.sdk.e2ee.data.KMX_CONSTANT;
import com.samsung.android.kmxservice.sdk.e2ee.data.RecoveryData;
import com.samsung.android.kmxservice.sdk.e2ee.manager.RecoveryDataManagement;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class RecoveryDataManagementImpl implements RecoveryDataManagement {
    private static final String TAG = "RecoveryDataManagementImpl";
    private final KmxFabricIdHandler kmxFabricIdHandler;

    public RecoveryDataManagementImpl(KmxFabricIdHandler kmxFabricIdHandler) {
        this.kmxFabricIdHandler = kmxFabricIdHandler;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.RecoveryDataManagement
    public RecoveryData getRecoveryData() throws KmxException {
        Log.i(TAG, "[getRecoveryData]");
        RecoveryData recoveryData = new RecoveryData();
        Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_GET_RECOVERY_DATA, (String) null, (Bundle) null);
        KmxErrorHandler.throwIfNull(bundleCall, "10| Fail to get recovery data", 1);
        if (bundleCall == null) {
            return null;
        }
        KmxErrorHandler.throwIfNotSuccess("10| Fail to get recovery data", bundleCall.getInt(KMX_CONSTANT.KMX_ERROR_CODE));
        String string = bundleCall.getString(KMX_CONSTANT.KMX_RECOVERY_CODE);
        byte[] byteArray = bundleCall.getByteArray(KMX_CONSTANT.KMX_ESCROW_DATA);
        recoveryData.recoveryCode = string;
        recoveryData.escrowData = byteArray;
        return recoveryData;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.RecoveryDataManagement
    public boolean setRecoveryData(String str, byte[] bArr, String str2) throws KmxException {
        KmxErrorHandler.throwIfEmpty(str2, "11-1|Fail to set RecoveryData", 302);
        this.kmxFabricIdHandler.set();
        Bundle bundle = new Bundle();
        bundle.putString(KMX_CONSTANT.KMX_RECOVERY_CODE, str);
        bundle.putByteArray(KMX_CONSTANT.KMX_ESCROW_DATA, bArr);
        AbstractC6670b.m4756q("[setRecoveryData] ", str, TAG);
        bundle.putString(KMX_CONSTANT.KMX_FABRIC_KEY_ID, str2);
        Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_SET_RECOVERY_DATA, (String) null, bundle);
        KmxErrorHandler.throwIfNull(bundleCall, "[setRecoveryData] Fail to get recovery data", 1);
        if (bundleCall == null) {
            return false;
        }
        KmxErrorHandler.throwIfNotSuccess("11-2|Fail to set RecoveryData", bundleCall.getInt(KMX_CONSTANT.KMX_ERROR_CODE));
        return true;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.RecoveryDataManagement
    public boolean validateRecoveryData(String str, byte[] bArr, String str2) throws KmxException {
        AbstractC6670b.m4756q("[validateRecoveryData] : ", str, TAG);
        KmxErrorHandler.throwIfEmpty(str2, "12-2|Fail to validate RecoveryData", 302);
        KmxErrorHandler.throwIfEmpty(str, "12-3|Input Error : recoveryCode is invalid", 4);
        KmxErrorHandler.throwIfEmpty(bArr, "12-4|Input Error : recoveryData is invalid", 4);
        Bundle bundle = new Bundle();
        bundle.putString(KMX_CONSTANT.KMX_RECOVERY_CODE, str);
        bundle.putByteArray(KMX_CONSTANT.KMX_ESCROW_DATA, bArr);
        bundle.putString(KMX_CONSTANT.KMX_FABRIC_ID, KmxSdk.getGuid());
        bundle.putString(KMX_CONSTANT.KMX_FABRIC_KEY_ID, str2);
        Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_VALIDATE_RECOVERY_DATA, (String) null, bundle);
        KmxErrorHandler.throwIfNull(bundleCall, "12-5|Fail to valid recovery data", 1);
        if (bundleCall != null) {
            int i = bundleCall.getInt(KMX_CONSTANT.KMX_ERROR_CODE);
            if (i == 6) {
                KmxErrorHandler.throwIfNotSuccess("12-5|TA Error :", 6);
            }
            if (i == 0) {
                return true;
            }
        }
        return false;
    }
}
