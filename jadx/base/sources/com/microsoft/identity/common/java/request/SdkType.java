package com.microsoft.identity.common.java.request;

import com.microsoft.identity.common.java.AuthenticationConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum SdkType {
    ADAL,
    MSAL,
    MSAL_CPP,
    MSAL_XPLAT_LINUX,
    UNKNOWN;

    public String getProductName() {
        return (ADAL == this || MSAL == this) ? AuthenticationConstants.SdkPlatformFields.PRODUCT_NAME_MSAL : MSAL_CPP == this ? AuthenticationConstants.SdkPlatformFields.PRODUCT_NAME_MSAL_CPP : MSAL_XPLAT_LINUX == this ? AuthenticationConstants.SdkPlatformFields.PRODUCT_NAME_MSAL_XPLAT_LINUX : "";
    }

    public boolean isCapableOfMSA() {
        return this == MSAL || this == MSAL_CPP || this == MSAL_XPLAT_LINUX;
    }
}
