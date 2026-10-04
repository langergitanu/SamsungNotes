package com.samsung.android.kmxservice.sdk.e2ee.kmx;

import android.net.Uri;
import android.os.Bundle;
import com.samsung.android.kmxservice.sdk.e2ee.KmxException;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxErrorHandler;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxSdk;
import com.samsung.android.kmxservice.sdk.e2ee.data.KMX_CMD;
import com.samsung.android.kmxservice.sdk.e2ee.data.KMX_CONSTANT;
import com.samsung.android.kmxservice.sdk.e2ee.data.KmxCertChainData;
import com.samsung.android.kmxservice.sdk.e2ee.data.MemberKeyInfo;
import com.samsung.android.kmxservice.sdk.e2ee.manager.DeviceInfoManagement;
import com.samsung.android.kmxservice.sdk.e2ee.manager.DeviceKeyManagement;
import com.samsung.android.kmxservice.sdk.e2ee.manager.KeyHandler;
import com.samsung.android.kmxservice.sdk.util.KmxLogger;
import com.samsung.android.kmxservice.sdk.util.SystemProperties;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.Base64;
import kotlin.Triple;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class DeviceKeyManagementImpl implements DeviceKeyManagement {
    private static final String TAG = "DeviceKeyManagementImpl";
    private final DeviceInfoManagement deviceInfoManagement;
    private final KeyHandler keyHandler;
    private final KmxFabricIdHandler kmxFabricIdHandler;

    public DeviceKeyManagementImpl(DeviceInfoManagement deviceInfoManagement, KmxFabricIdHandler kmxFabricIdHandler, KeyHandler keyHandler) {
        this.kmxFabricIdHandler = kmxFabricIdHandler;
        this.deviceInfoManagement = deviceInfoManagement;
        this.keyHandler = keyHandler;
    }

    private String createDeviceKeyId() {
        String sakUid = this.deviceInfoManagement.getSakUid();
        Bundle bundle = new Bundle();
        String strEncodeToString = Base64.getEncoder().encodeToString((sakUid.substring(0, 10) + KmxSdk.getGuid() + "DEVICE_KEY").getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder("[Create DeviceKeyId] ");
        sb.append(strEncodeToString);
        KmxLogger.m5529i(TAG, sb.toString());
        bundle.putString(KMX_CONSTANT.KMX_DEVICE_KEY_ID, strEncodeToString);
        KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_SET_DEVICE_KEY_ID, (String) null, bundle);
        return strEncodeToString;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.DeviceKeyManagement
    public Triple<byte[], byte[], X509Certificate[]> getDeviceKey() throws KmxException {
        this.kmxFabricIdHandler.set();
        KmxLogger.m5529i(TAG, "[DeviceKey] : " + createDeviceKeyId());
        Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_GET_DEVICE_KEY, (String) null, (Bundle) null);
        KmxErrorHandler.throwIfNull(bundleCall, "9|Fail to get device key", 103);
        if (bundleCall == null) {
            return null;
        }
        KmxErrorHandler.throwIfNotSuccess("9-1|Fail to get device key", bundleCall.getInt(KMX_CONSTANT.KMX_ERROR_CODE));
        byte[] byteArray = bundleCall.getByteArray(KMX_CONSTANT.KMX_MEMBER_KEY);
        byte[] byteArray2 = bundleCall.getByteArray(KMX_CONSTANT.KMX_SIGNATURE);
        Serializable serializable = bundleCall.getSerializable(KMX_CONSTANT.KMX_CERT_CHAIN);
        X509Certificate[] x509CertificateArr = serializable instanceof KmxCertChainData ? ((KmxCertChainData) serializable).mCertChain : null;
        KmxErrorHandler.throwIfNull(byteArray, "9-2|Fail to get device key | memKey is NULL", 103);
        KmxErrorHandler.throwIfNull(byteArray2, "9-2|Fail to get device key | signature is NULL", 103);
        KmxErrorHandler.throwIfNull(x509CertificateArr, "9-2|Fail to get device key | certificates is NULL", 103);
        return new Triple<>(byteArray, byteArray2, x509CertificateArr);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.DeviceKeyManagement
    public String getDeviceKeyId() {
        Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_GET_DEVICE_KEY_ID, (String) null, (Bundle) null);
        if (bundleCall != null) {
            return bundleCall.getString(KMX_CONSTANT.KMX_DEVICE_KEY_ID);
        }
        KmxLogger.m5529i(TAG, "Cannot get device key id");
        return "";
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.DeviceKeyManagement
    public MemberKeyInfo getDeviceKeyPQC() throws KmxException {
        this.kmxFabricIdHandler.set();
        KmxLogger.m5529i(TAG, "[DeviceKeyPQC] : " + createDeviceKeyId());
        if (!SystemProperties.isMoreThanOneUI71()) {
            Triple<byte[], byte[], X509Certificate[]> deviceKey = getDeviceKey();
            return new MemberKeyInfo(deviceKey.getFirst(), deviceKey.getSecond(), deviceKey.getThird(), null, null);
        }
        Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_GET_DEVICE_KEY_PQC, (String) null, (Bundle) null);
        KmxErrorHandler.throwIfNull(bundleCall, "9-PQC|Fail to get device key", 103);
        if (bundleCall == null) {
            return null;
        }
        KmxErrorHandler.throwIfNotSuccess("9-1-PQC|Fail to get device key", bundleCall.getInt(KMX_CONSTANT.KMX_ERROR_CODE));
        byte[] byteArray = bundleCall.getByteArray(KMX_CONSTANT.KMX_MEMBER_KEY);
        byte[] byteArray2 = bundleCall.getByteArray(KMX_CONSTANT.KMX_SIGNATURE);
        Serializable serializable = bundleCall.getSerializable(KMX_CONSTANT.KMX_CERT_CHAIN);
        X509Certificate[] x509CertificateArr = serializable instanceof KmxCertChainData ? ((KmxCertChainData) serializable).mCertChain : null;
        byte[] byteArray3 = bundleCall.getByteArray(KMX_CONSTANT.KMX_ENCAP_KEY);
        byte[] byteArray4 = bundleCall.getByteArray(KMX_CONSTANT.KMX_ENCAP_SIGNATURE);
        KmxErrorHandler.throwIfNull(byteArray, "9-2-PQC|Fail to get device key | memKey is NULL", 103);
        KmxErrorHandler.throwIfNull(byteArray2, "9-2-PQC|Fail to get device key | signature is NULL", 103);
        KmxErrorHandler.throwIfNull(x509CertificateArr, "9-2-PQC|Fail to get device key | certificates is NULL", 103);
        KmxErrorHandler.throwIfNull(byteArray3, "9-2-PQC|Fail to get device key | pqcPubKey is NULL", 103);
        KmxErrorHandler.throwIfNull(byteArray4, "9-2-PQC|Fail to get device key | pqcPubKeySign is NULL", 103);
        return new MemberKeyInfo(byteArray, byteArray2, x509CertificateArr, byteArray3, byteArray4);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.DeviceKeyManagement
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean removeDeviceKey(String str) throws KmxException {
        KmxLogger.m5529i(TAG, "[removeDeviceKey] : " + str);
        KmxErrorHandler.throwIfNull(str, "29|Input Error : deviceId cannot be null", 4);
        String sakUid = this.deviceInfoManagement.getSakUid();
        if (sakUid == null || sakUid.isEmpty()) {
            sakUid = this.deviceInfoManagement.getSakUid();
            if (sakUid != null || sakUid.isEmpty()) {
                KmxLogger.m5528e(TAG, "29-1| Fail to get SAK UID");
            } else {
                int length = sakUid.length();
                int iCharCount = 0;
                while (iCharCount < length) {
                    int iCodePointAt = sakUid.codePointAt(iCharCount);
                    if (!Character.isWhitespace(iCodePointAt)) {
                        break;
                    }
                    iCharCount += Character.charCount(iCodePointAt);
                }
                KmxLogger.m5528e(TAG, "29-1| Fail to get SAK UID");
            }
        } else {
            int length2 = sakUid.length();
            int iCharCount2 = 0;
            while (iCharCount2 < length2) {
                int iCodePointAt2 = sakUid.codePointAt(iCharCount2);
                if (!Character.isWhitespace(iCodePointAt2)) {
                    break;
                }
                iCharCount2 += Character.charCount(iCodePointAt2);
            }
            sakUid = this.deviceInfoManagement.getSakUid();
            if (sakUid != null) {
                KmxLogger.m5528e(TAG, "29-1| Fail to get SAK UID");
            }
        }
        String deviceKeyId = getDeviceKeyId();
        if (str.equals(sakUid)) {
            if (deviceKeyId == null || deviceKeyId.isEmpty()) {
                deviceKeyId = getDeviceKeyId();
            }
            if (deviceKeyId != null && !deviceKeyId.isEmpty()) {
                return this.keyHandler.removeKey(deviceKeyId, 2);
            }
        }
        return false;
    }
}
