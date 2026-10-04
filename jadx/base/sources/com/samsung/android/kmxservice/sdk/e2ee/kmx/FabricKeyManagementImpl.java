package com.samsung.android.kmxservice.sdk.e2ee.kmx;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.kmxservice.sdk.e2ee.KmxException;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxErrorHandler;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxSdk;
import com.samsung.android.kmxservice.sdk.e2ee.data.FabricKeyInfoPQC;
import com.samsung.android.kmxservice.sdk.e2ee.data.KMX_CMD;
import com.samsung.android.kmxservice.sdk.e2ee.data.KMX_CONSTANT;
import com.samsung.android.kmxservice.sdk.e2ee.data.KmxCertChainData;
import com.samsung.android.kmxservice.sdk.e2ee.manager.DeviceInfoManagement;
import com.samsung.android.kmxservice.sdk.e2ee.manager.DeviceKeyManagement;
import com.samsung.android.kmxservice.sdk.e2ee.manager.FabricKeyManagement;
import com.samsung.android.kmxservice.sdk.e2ee.manager.KeyHandler;
import com.samsung.android.kmxservice.sdk.util.KmxLogger;
import com.samsung.android.kmxservice.sdk.util.SystemProperties;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Base64;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class FabricKeyManagementImpl implements FabricKeyManagement {
    private static final String TAG = "FabricKeyManagementImpl";
    private final DeviceInfoManagement deviceInfoManagement;
    private final DeviceKeyManagement deviceKeyManagement;
    private final KeyHandler keyHandler;
    private final KmxFabricIdHandler kmxFabricIdHandler;

    public FabricKeyManagementImpl(DeviceInfoManagement deviceInfoManagement, DeviceKeyManagement deviceKeyManagement, KmxFabricIdHandler kmxFabricIdHandler, KeyHandler keyHandler) {
        this.deviceInfoManagement = deviceInfoManagement;
        this.deviceKeyManagement = deviceKeyManagement;
        this.kmxFabricIdHandler = kmxFabricIdHandler;
        this.keyHandler = keyHandler;
    }

    private void createFabricKeyId(boolean z) {
        String sakUid = this.deviceInfoManagement.getSakUid();
        this.kmxFabricIdHandler.set();
        if (z) {
            byte[] bArr = new byte[20];
            new SecureRandom().nextBytes(bArr);
            Charset charset = StandardCharsets.UTF_8;
            String strEncodeToString = Base64.getUrlEncoder().encodeToString((KmxSdk.getGuid() + sakUid.substring(0, 10) + new String(bArr, charset) + "FABRIC_KEY").getBytes(charset));
            Bundle bundle = new Bundle();
            StringBuilder sb = new StringBuilder("[Create FabricKeyId] ");
            sb.append(strEncodeToString);
            KmxLogger.m5529i(TAG, sb.toString());
            bundle.putString(KMX_CONSTANT.KMX_FABRIC_KEY_ID, strEncodeToString);
            KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_SET_FABRIC_KEY_ID, (String) null, bundle);
        }
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.FabricKeyManagement
    public String createFabricKey() throws KmxException {
        KmxLogger.m5529i(TAG, "[createFabricKey]");
        KmxErrorHandler.throwIfNotSuccess("26-1|FabricKey generation failure :", this.kmxFabricIdHandler.set());
        createFabricKeyId(true);
        Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_CREATE_FABRIC_KEY, (String) null, (Bundle) null);
        KmxErrorHandler.throwIfNull(bundleCall, "26-2", 103);
        if (bundleCall == null) {
            return null;
        }
        KmxErrorHandler.throwIfNotSuccess("26-3|FabricKey generation failure :", bundleCall.getInt(KMX_CONSTANT.KMX_ERROR_CODE));
        KmxLogger.m5529i(TAG, "[Create fabricKey] SUCCESS");
        return bundleCall.getString(KMX_CONSTANT.KMX_FABRIC_KEY_ID);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.FabricKeyManagement
    public byte[] exportFabricKey(String str, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr) throws KmxException {
        KmxLogger.m5529i(TAG, "[exportFabricKey] : " + str);
        Bundle bundle = new Bundle();
        bundle.putString(KMX_CONSTANT.KMX_SAK_UID, str);
        bundle.putByteArray(KMX_CONSTANT.KMX_MEMBER_KEY, bArr);
        bundle.putByteArray(KMX_CONSTANT.KMX_TARGET_SIGNATURE, bArr2);
        bundle.putSerializable(KMX_CONSTANT.KMX_TARGET_CERT_CHAIN, new KmxCertChainData(x509CertificateArr));
        Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_EXPORT_FABRIC_KEY, (String) null, bundle);
        KmxErrorHandler.throwIfNull(bundleCall, "25-1|Fail to export fabricKey", 102);
        if (bundleCall == null) {
            return null;
        }
        KmxErrorHandler.throwIfNotSuccess("25-2|Fail to export fabricKey", bundleCall.getInt(KMX_CONSTANT.KMX_ERROR_CODE));
        return bundleCall.getByteArray(KMX_CONSTANT.KMX_WRAPPED_FABRIC_KEY);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.FabricKeyManagement
    public String getFabricKeyId() {
        Bundle bundle = new Bundle();
        bundle.putString(KMX_CONSTANT.KMX_FABRIC_ID, KmxSdk.getGuid());
        Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_GET_FABRIC_KEY_ID, (String) null, bundle);
        String string = bundleCall != null ? bundleCall.getString(KMX_CONSTANT.KMX_FABRIC_KEY_ID) : "";
        KmxLogger.m5529i(TAG, "[getFabricKeyId] KMX DEVICE : " + string);
        return string;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.FabricKeyManagement
    public String importFabricKey(String str, String str2, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, byte[] bArr3) throws KmxException {
        String deviceKeyId = this.deviceKeyManagement.getDeviceKeyId();
        if (deviceKeyId == null) {
            KmxLogger.m5528e(TAG, "[importFabricKey] deviceKeyId is null");
            return null;
        }
        KmxErrorHandler.throwIfNull(bArr2, "24|Invalid signature. Signature is null ", 402);
        StringBuilder sb = new StringBuilder("[importFabricKey] ");
        sb.append(str2);
        KmxLogger.m5529i(TAG, AbstractC0541b.m776r(sb, "| ", str, "| deviceKeyId", deviceKeyId));
        Bundle bundle = new Bundle();
        bundle.putString(KMX_CONSTANT.KMX_FABRIC_KEY_ID, str2);
        bundle.putString(KMX_CONSTANT.KMX_SAK_UID, str);
        bundle.putByteArray(KMX_CONSTANT.KMX_MEMBER_KEY, bArr);
        bundle.putByteArray(KMX_CONSTANT.KMX_SIGNATURE, bArr2);
        bundle.putByteArray(KMX_CONSTANT.KMX_WRAPPED_FABRIC_KEY, bArr3);
        bundle.putSerializable(KMX_CONSTANT.KMX_TARGET_CERT_CHAIN, new KmxCertChainData(x509CertificateArr));
        Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_IMPORT_FABRIC_KEY, (String) null, bundle);
        if (bundleCall == null) {
            KmxLogger.m5528e(TAG, "[importFabricKey] Fail to import FabricKey");
            return null;
        }
        int i = bundleCall.getInt(KMX_CONSTANT.KMX_ERROR_CODE);
        if (i == 0) {
            return bundleCall.getString(KMX_CONSTANT.KMX_FABRIC_KEY_ID);
        }
        this.keyHandler.removeKey(getFabricKeyId(), 0);
        KmxErrorHandler.throwIfNotSuccess("24|Fail to import fabricKey ", i);
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.FabricKeyManagement
    public boolean removeFabricKey(String str) throws KmxException {
        KmxLogger.m5529i(TAG, "[removeFabricKey] : " + str);
        KmxErrorHandler.throwIfNull(str, "27|Input Error : FabricKeyId cannot be null when remove key ", 4);
        return this.keyHandler.removeKey(str, 0);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.FabricKeyManagement
    public FabricKeyInfoPQC exportFabricKey(String str, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, @Nullable byte[] bArr3, @Nullable byte[] bArr4) throws KmxException {
        KmxLogger.m5529i(TAG, "[exportFabricKeyPQC] : " + str);
        if (SystemProperties.isMoreThanOneUI71() && bArr3 != null && bArr4 != null) {
            Bundle bundle = new Bundle();
            bundle.putString(KMX_CONSTANT.KMX_SAK_UID, str);
            bundle.putByteArray(KMX_CONSTANT.KMX_MEMBER_KEY, bArr);
            bundle.putByteArray(KMX_CONSTANT.KMX_TARGET_SIGNATURE, bArr2);
            bundle.putSerializable(KMX_CONSTANT.KMX_TARGET_CERT_CHAIN, new KmxCertChainData(x509CertificateArr));
            bundle.putByteArray(KMX_CONSTANT.KMX_ENCAP_KEY, bArr3);
            bundle.putByteArray(KMX_CONSTANT.KMX_ENCAP_SIGNATURE, bArr4);
            Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_EXPORT_FABRIC_KEY_PQC, (String) null, bundle);
            KmxErrorHandler.throwIfNull(bundleCall, "25-1|Fail to export fabricKey", 102);
            if (bundleCall == null) {
                return null;
            }
            KmxErrorHandler.throwIfNotSuccess("25-2|Fail to export fabricKey", bundleCall.getInt(KMX_CONSTANT.KMX_ERROR_CODE));
            return new FabricKeyInfoPQC(bundleCall.getByteArray(KMX_CONSTANT.KMX_WRAPPED_FABRIC_KEY), bundleCall.getByteArray(KMX_CONSTANT.KMX_PQC_CIPHER));
        }
        byte[] bArrExportFabricKey = exportFabricKey(str, bArr, bArr2, x509CertificateArr);
        Log.i(TAG, "[FMI] exportFabricKey : This device or another device is not support PQC > ".concat(bArrExportFabricKey != null ? new String(bArrExportFabricKey, StandardCharsets.UTF_8) : "null"));
        return new FabricKeyInfoPQC(bArrExportFabricKey, null);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.FabricKeyManagement
    public String importFabricKey(String str, String str2, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, byte[] bArr3, @Nullable byte[] bArr4) throws KmxException {
        if (SystemProperties.isMoreThanOneUI71() && bArr4 != null && bArr4.length != 0) {
            String deviceKeyId = this.deviceKeyManagement.getDeviceKeyId();
            if (deviceKeyId == null) {
                KmxLogger.m5528e(TAG, "[importFabricKeyPQC] deviceKeyId is null");
                return null;
            }
            KmxErrorHandler.throwIfNull(bArr2, "24-PQC|Invalid signature. Signature is null ", 402);
            StringBuilder sb = new StringBuilder("[importFabricKeyPQC] ");
            sb.append(str2);
            KmxLogger.m5529i(TAG, AbstractC0541b.m776r(sb, "| ", str, "| deviceKeyId", deviceKeyId));
            Bundle bundle = new Bundle();
            bundle.putString(KMX_CONSTANT.KMX_FABRIC_KEY_ID, str2);
            bundle.putString(KMX_CONSTANT.KMX_SAK_UID, str);
            bundle.putByteArray(KMX_CONSTANT.KMX_MEMBER_KEY, bArr);
            bundle.putByteArray(KMX_CONSTANT.KMX_SIGNATURE, bArr2);
            bundle.putByteArray(KMX_CONSTANT.KMX_WRAPPED_FABRIC_KEY, bArr3);
            bundle.putSerializable(KMX_CONSTANT.KMX_TARGET_CERT_CHAIN, new KmxCertChainData(x509CertificateArr));
            bundle.putByteArray(KMX_CONSTANT.KMX_PQC_CIPHER, bArr4);
            Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_IMPORT_FABRIC_KEY_PQC, (String) null, bundle);
            if (bundleCall == null) {
                KmxLogger.m5528e(TAG, "[importFabricKeyPQC] Fail to import FabricKey");
                return null;
            }
            int i = bundleCall.getInt(KMX_CONSTANT.KMX_ERROR_CODE);
            if (i == 0) {
                return bundleCall.getString(KMX_CONSTANT.KMX_FABRIC_KEY_ID);
            }
            this.keyHandler.removeKey(getFabricKeyId(), 0);
            KmxErrorHandler.throwIfNotSuccess("24-PQC|Fail to import fabricKey ", i);
            return null;
        }
        return importFabricKey(str, str2, bArr, bArr2, x509CertificateArr, bArr3);
    }
}
