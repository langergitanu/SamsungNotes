package com.samsung.android.kmxservice.sdk.e2ee.manager;

import com.samsung.android.kmxservice.sdk.e2ee.data.RecoveryData;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface RecoveryDataManagement {
    RecoveryData getRecoveryData();

    default boolean setRecoveryData(RecoveryData recoveryData, String str) {
        return setRecoveryData(recoveryData.recoveryCode, recoveryData.escrowData, str);
    }

    boolean setRecoveryData(String str, byte[] bArr, String str2);

    default boolean validateRecoveryData(RecoveryData recoveryData, String str) {
        return validateRecoveryData(recoveryData.recoveryCode, recoveryData.escrowData, str);
    }

    boolean validateRecoveryData(String str, byte[] bArr, String str2);
}
